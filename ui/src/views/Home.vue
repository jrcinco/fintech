<template>
  <div class="home">
    <div class="home__container fill-all">
      <v-layout column fill-height justify-start align-center>
        <v-flex xs1 text-xs-center mt-4>
          <v-layout row>
            <v-flex xs2 offset-md3 md1>
              <v-layout row fill-height align-center>
                <v-flex text-xs-right>
                  <v-icon :class="styleHomeIcon">check_circle_outline</v-icon>
                </v-flex>
              </v-layout>
            </v-flex>            
          </v-layout>
        </v-flex>
        <v-flex class="home__title" text-xs-center xs1 mt-3>
          <p v-bind:class="styleTitle">Let's get started!</p>
        </v-flex>
        <v-flex class="home__search" xs1>
          <finance-card :term="term" />
        </v-flex>
      </v-layout>
    </div>
  </div>
</template>

<script>
import FinanceCard from '@/components/FinanceCard';
import { mapState } from 'vuex';

export default {
  name: 'Home',
  data() {
    return {
      term: null,
      search: false,
    };
  },
  components: {
    FinanceCard,
  },
  computed: {
    ...mapState(['product']),
    styleHomeIcon() {
      return {
        'home__icon--font-mobile': this.$vuetify.breakpoint.smAndDown,
        'home__icon--font': this.$vuetify.breakpoint.smAndUp,
      };
    },
    styleTitle() {
      return {
        'home__welcome-mobile': this.$vuetify.breakpoint.smAndDown,
        home__welcome: this.$vuetify.breakpoint.mdAndUp,
      };
    },
  },
  mounted() {
    if (sessionStorage.getItem('pendingSave') === 'true') {
      if (sessionStorage.getItem('pageReturn') === 'calculate') {
        this.$router.push({ name: 'calculator' });
      } else if (sessionStorage.getItem('pageReturn') === 'product') {
        this.$router.push({ name: 'product' });
      }
    } else {
      sessionStorage.removeItem('product');
      sessionStorage.removeItem('calculator');
    }
    this.$store.dispatch('resetOverlayTimer');
    this.$store.dispatch('setNavigationVisibility', false);
    this.$store.dispatch('setLoadingStatus', false);
    this.$store.dispatch('setSyncButton', false);
  },
};
</script>

<style lang="scss" scoped>
  .home {
    background-color: white;
  }

  .home__icon--font {
    padding: 25px;
    font-size: 55px;
    color: $skyblue;
  }

  .home__icon--font-mobile {
    font-size: 40px;
    color: $skyblue;
  }

  .home__search {
    padding: 0 !important;
    min-width: 100%;
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
  }

  .home__description {
    text-align: left;
    color: #646464;
    font-family: 'Open Sans';
    font-size: 12.8px;
  }

  .home__title {
    color: $darkGray;
    font-family: Montserrat;
    font-weight: 600;
  }

  .home__welcome {
    font-size: 67px !important;
  }

  .home__welcome-mobile {
    font-size: 35px !important;
  }

  .home__btn-description {
    font-size: 12px;
    text-align: center;
    padding: 5px;
    padding-top: 15px;
    color: #646464;
    font-family: 'Open Sans';
  }

  .home__buttons {
    .fee-btn {
      /deep/ .fee-btn__text--active {
        font-size: 12px;
        font-family: 'Open Sans', serif;
      }

      /deep/ .fee-btn__text {
        letter-spacing: normal;
      }
    }
  }
</style>
