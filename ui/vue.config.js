const path = require('path');

module.exports = {
  baseUrl: '.',
  assetsDir: './assets',
  lintOnSave: false,
  devServer: {
    proxy: {
      '/*': {
        target: 'http://localhost:8080',
        ws: false,
        changeOrigin: true,
      },
    },
    port: 8070
  },
  pluginOptions: {
    'style-resources-loader': {
      preProcessor: 'scss',
      patterns: [
        path.resolve(__dirname, 'src/assets/scss/*.scss'),
      ],
    },
  },
  productionSourceMap: true,
};
