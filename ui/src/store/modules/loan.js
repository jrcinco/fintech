import api from '../../api/loan';

const actions = {
  calculateEMI({
    commit,
  }, param) {    
    return api.calculateEMI(
      (response) => {        
        if (response === false) {
          commit('setEMIStatus', false);
        } else {
          commit('setEMI', response);
          commit('setEMIStatus', true);
        }
      },
      param,
    ).catch(error => commit('setError', error));
  },
};

const mutations = {
  setEMI(state, response) {
    state.emi = response;
  },
  setEMIStatus(state, response) {
    state.emiStatus = response;
  },
};

const state = {
  emi: {
    emi: null,
    interest: null,
  },
  emiStatus: false,
};

export default {
  state,
  actions,
  mutations,
};
