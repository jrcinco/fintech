import Vue from 'vue';
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';
import '../assets/css/custom.css';

Vue.use(Vuetify, {
  theme: {
    primary: '#039BE5',
    secondary: '#0288D1',
    accent: '#4DB6AC',
    error: '#F44336',
    warning: '#FDD835',
    info: '#81D4FA',
    success: '#4CAF50',
  },
});
