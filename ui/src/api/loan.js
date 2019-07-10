import axios from 'axios';
import momentTz from 'moment-timezone';

export default {
  async calculateEMI(callback, param) {
    try {
      const response = await axios.get(`loan?amount=${param.amount}&period=${param.period}`);
      if (response.status === 200) {
        callback(response.data);
      } else if (response.status === 204) {
        callback(false);
      }
    } catch (e) {
      callback(false);
    }
  },  
};
