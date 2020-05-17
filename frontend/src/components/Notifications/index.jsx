import React, { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import { Stomp } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { NotificationContainer, NotificationManager } from 'react-notifications';
import 'react-notifications/lib/notifications.css';

const Notifications = ({ user, applyPost }) => {

  const initSocket = () => new Promise((resolve, reject) => {
    const socket = new SockJS("/ws");
    const stompClient = Stomp.over(socket);
    stompClient.debug = () => { };
    stompClient.connect({}, () => {
      console.log('connected');
      resolve(stompClient);
    });
  });


  useEffect(async () => {
    if (!user) {
      return undefined;
    }

    let stompClient = await initSocket();

    const { id } = user;

    stompClient.subscribe('/topic/like', () => {
      NotificationManager.info('Your post was liked!');
    });

    stompClient.subscribe('/topic/new_post', (message) => {
      let post = JSON.parse(message.body);
      console.log('message from server2: ' + post);
      if (post.userId !== id) {
        applyPost(post.id);
      }
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
