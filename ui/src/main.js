import 'typeface-montserrat/index.css';
import 'typeface-open-sans/index.css';
import 'typeface-roboto/index.css';
import Vue from 'vue';
import VueSVGIcon from 'vue-svgicon';
import VueCookies from 'vue-cookies';
import VueJWT from 'vuejs-jwt';
import VeeValidate from 'vee-validate';
import './plugins/vuetify';
import './assets/iconfont/material-icons.css';
import App from './App';
import router from './router';
import store from './store/store';
import './compiled-icons';
import './filters';

Vue.use(require('vue-moment'));

Vue.use(VueSVGIcon);
Vue.use(VueCookies);
Vue.use(VueJWT);
Vue.use(VeeValidate);
Vue.config.productionTip = false;
Vue.config.devtools = true;

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');
