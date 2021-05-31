const { createProxyMiddleware } = require('http-proxy-middleware');

const { API_SERVER_HOST } = process.env;

module.exports = app => {
  app.use(createProxyMiddleware('/ws', { target: API_SERVER_HOST, ws: true }));
  app.use(createProxyMiddleware('/api', { target: API_SERVER_HOST }));
};
