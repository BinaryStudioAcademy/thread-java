import React from 'react';
import PropTypes from 'prop-types';
import { Stomp } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { NotificationContainer, NotificationManager } from 'react-notifications';

import 'react-notifications/lib/notifications.css';

class Notifications extends React.Component {
    socket = undefined;
    stompClient = undefined;

    componentDidMount() {
        this.initSocket();
    }

    componentDidUpdate(prevProps) {
        this.initSocket();
        this.checkLoggedInUser(prevProps);
    }

    checkLoggedInUser = (prevProps) => {
        if (this.socket && !this.props.user && this.props.user !== prevProps.user) {
            // this.socket.emit('leaveRoom', prevProps.user.id);
            this.stompClient.disconnect()
        }
    }

    addSocketHandlers = (userId) => {
        // this.socket.emit('createRoom', userId);
        this.stompClient.subscribe('/topic/like', () => {
            NotificationManager.info('Your post was liked!');
        });
        this.stompClient.subscribe('/topic/new_post', (message) => {
            let post = JSON.parse(message.body);
            console.log('message from server2: ' + post);
            if (post.userId !== userId) {
                this.props.applyPost(post.id);
            }
        });
    }

    initSocket() {
        const { user } = this.props;
        if (!this.socket && user && user.id) {
            this.socket = new SockJS("/ws");
            this.stompClient = Stomp.over(this.socket);
            this.stompClient.debug = () => { };
            this.stompClient.connect({}, () => {
                this.addSocketHandlers(user.id);
            });
        }
    }

    render() {
        return <NotificationContainer>

        </NotificationContainer>;
    }
}

Notifications.defaultProps = {
    user: {}
};

Notifications.propTypes = {
    user: PropTypes.objectOf(PropTypes.any),
    applyPost: PropTypes.func.isRequired,
};

export default Notifications;
