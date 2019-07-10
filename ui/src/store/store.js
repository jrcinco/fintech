import Vue from 'vue';
import Vuex from 'vuex';
import loan from './modules/loan';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    loan,
  },
});
