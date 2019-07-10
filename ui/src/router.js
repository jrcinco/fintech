import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home';
import Fba from './views/Fba';

Vue.use(Router);

let cookieName = 'auth';
if (process.env.VUE_APP_COOKIE) {
  cookieName = process.env.VUE_APP_COOKIE;
}

const router = new Router({
  routes: [{
    path: '/',
    redirect: '/home',
  },
  {
    path: '/',
    component: Fba,
    children: [
      {
        path: '/home',
        name: 'home',
        component: Home,
      },
    ],
  },
  ],
});

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresRole)) {
    const cookie = window.$cookies.get(cookieName);
    if (cookie === null) {
      window.location.assign(`${window.location.origin}${window.location.pathname}login`);
    } else {
      const user = Vue.$jwt.decode(cookie);
      if (user.roles.indexOf(to.meta.requiresRole) > -1) {
        next();
      } else {
        next('/home');
      }
    }
  } else {
    next();
  }
});

export default router;
