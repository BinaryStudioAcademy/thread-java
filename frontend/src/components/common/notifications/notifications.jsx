import * as React from 'react';
import PropTypes from 'prop-types';
import { Stomp } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import {
  NotificationContainer,
  NotificationManager
} from 'react-notifications';
import { userType } from 'src/common/prop-types/prop-types';

import 'react-notifications/lib/notifications.css';

const Notifications = ({ user, onPostApply }) => {
  const [stompClient] = React.useState(Stomp.over(new SockJS('/ws')));
  React.useEffect(() => {
    if (!user) {
      return undefined;
    }

    stompClient.debug = () => { };
    stompClient.connect({}, () => {
      const { id } = user;

      stompClient.subscribe(`/user/${id}/like`, () => {
        NotificationManager.info('Your post was liked!');
      });

      stompClient.subscribe('/topic/new_post', message => {
        const post = JSON.parse(message.body);
        if (post.userId !== id) {
          onPostApply(post.id);
        }
      });
    });

    return () => {
      stompClient.onDisconnect(() => {});
    };
  });

  return <NotificationContainer />;
};

Notifications.defaultProps = {
  user: undefined
};

Notifications.propTypes = {
  user: userType,
  onPostApply: PropTypes.func.isRequired
};

export default Notifications;
