<template>
  <v-container ma-0 pa-0 class="finance-card">
    <v-layout row>
      <v-flex offset-md3 md6 offset-xl4 xl4 xs12>
        <v-layout row mb-2 pl-2 pr-2>
          <div class="finance-card-title">EMI Calculator</div>
          <div class="finance-card-helper">
            <v-tooltip right>
              <v-icon color="primary" slot="activator" small>
                help
              </v-icon>
              <span>EMI Calculator</span>
            </v-tooltip>
          </div>
        </v-layout>        
        <v-layout column pl-2 pr-2>
          <v-flex class="finance-card__input" xs10 md10 v-bind:class="styleError">
            <v-text-field v-model="amount" label="Amount..." solo/>            
          </v-flex>
          <v-flex class="finance-card__input" xs10 md10 v-bind:class="styleError">
            <v-text-field v-model="period" label="Period..." solo/>            
          </v-flex>
          <v-flex class="finance-card__input-btn" xs2 md2>
            <v-btn class="fee-btn__block--blue" @click="submit()" block>
              <div class="hidden-xs-only"> CALCULATE </div>
              <v-icon class="hidden-sm-and-up">finance</v-icon>
            </v-btn>
          </v-flex>
        </v-layout>
        <v-layout row pl-2 pr-2>
          <v-flex class="finance-card__input" xs10 md10 v-bind:class="styleError">
            <v-text-field v-model="emi" label="EMI..." solo/>            
          </v-flex>
          <v-flex class="finance-card__input" xs10 md10 v-bind:class="styleError">
            <v-text-field v-model="interest" label="Interest..." solo/>            
          </v-flex>
        </v-layout>
        <v-layout row pl-2 pr-2>
          <v-flex class="finance-card-error">
            {{ error }}
          </v-flex>
        </v-layout>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'FinanceCard',
  props: {
    term: {
      type: String,
    },
  },
  computed: {
    ...mapState(['loan']),
    styleError() {
      return {
        'finance-card__input--error': this.error !== null,
      };
    },
  },
  data() {
    return {
      amount: 0,
      period: 0,            
      emi: '',
      interest: '',
      error: null,
    };
  },
  methods: {
    submit() {
      this.error = null;      
      this.$store.dispatch('calculateEMI', 
        {amount: this.amount, period: this.period}).then(() => {
        this.emi = this.loan.emi.emi;
        this.interest = this.loan.emi.interest;
      });      
    },
  },
};
</script>

<style  lang="scss" scoped>
  .finance-card {
    position: relative;
    min-width: 100% !important;
    background-size: cover;
  }

  .finance-card-title {
    color: rgba(0, 0, 0, 0.6);
    font-family: Montserrat;
    font-size: 14.3px;
    letter-spacing: 0.18px;
  }

  .finance-card__input {
    padding-left: 2px;
    position: relative;
    height: 48px;
  }

  .finance-card__input-icon {
    position: absolute;
    top: 14px;
    left: 14px;
  }

  /deep/ .input-group__prepend-icon {
    visibility: hidden;
  }

  .finance-card__input-btn {
    padding-right: 2px;
  }

  .finance-card__input-btn button {
    height: 46px;
    margin-top: 1px;
  }

  .finance-card__input--error {
    border-bottom: 2px solid $error;
  }

  .finance-card-error {
    color: $error;
    font-family: 'Open Sans';
    font-size: 11.85px;
    letter-spacing: 0.4px;
    line-height: 16px;
    margin-top: 5px;
    margin-bottom: 5px;
  }

  .finance-card-helper {
    margin-top: -3px;
    margin-left: 5px;
    cursor: default;
  }

  /deep/ .input-group:not(.input-group--error) label {
    font-size: 18px;
  }

  @media screen and (max-width: 600px) {
    /deep/ .input-group:not(.input-group--error) label {
      font-size: 10px;
      padding: 0;
    }
  }

  .finance-card__input-btn .btn {
    min-width: 0;
  }
</style>
