import PropTypes from 'prop-types';
import { imageType } from './image';

const userType = PropTypes.exact({
  id: PropTypes.string.isRequired,
  email: PropTypes.string.isRequired,
  image: imageType,
  imageId: PropTypes.string,
  username: PropTypes.string.isRequired,
  createdAt: PropTypes.string,
  updatedAt: PropTypes.string
});

export { userType };
