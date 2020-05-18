import React, { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import { Stomp } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { NotificationContainer, NotificationManager } from 'react-notifications';
import 'react-notifications/lib/notifications.css';

const Notifications = ({ user, applyPost }) => {
  const [stompClient] = useState(Stomp.over(new SockJS('/ws')));

  useEffect(() => {
    if (!user) {
      return undefined;
    }

    stompClient.debug = () => { };
    stompClient.connect({}, () => {
      console.log('connected');

      const { id } = user;

      stompClient.subscribe('/topic/like', () => {
        NotificationManager.info('Your post was liked!');
      });

      stompClient.subscribe('/topic/new_post', message => {
        const post = JSON.parse(message.body);
        if (post.userId !== id) {
          applyPost(post.id);
        }
      });
    });

    return () => {
      stompClient.disconnect();
    };
  });

  return <NotificationContainer />;
};

Notifications.defaultProps = {
  user: undefined
};

Notifications.propTypes = {
  user: PropTypes.objectOf(PropTypes.any),
  applyPost: PropTypes.func.isRequired
};

export default Notifications;
