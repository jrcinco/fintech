<template>
  <v-app class="app" app>
    <router-view />
  </v-app>
</template>

<script>

export default {
  name: 'App',
};
</script>

<style lang="scss">
  .app {
    background-color: white !important;
    color: $black !important;
    font-family: 'Open Sans';
    font-size: 15.8px;
  }

  .fill-all {
    height: 100%;
    width: 100%;
  }

  .fee-btn__block--blue {
    background-color: $primary !important;
    color: white !important;
    font-family: Montserrat;
    font-size: 14.09px;
    letter-spacing: 1.25px;
    line-height: 36px;
    text-align: center;
    border-radius: 4px;
  }

  .fee-btn__block--outline-blue {
    background-color: white !important;
    color: $primary !important;
    border: 1px solid $primary;
    font-family: Montserrat;
    font-size: 14.09px;
    letter-spacing: 1.25px;
    line-height: 16px;
    text-align: center;
    border-radius: 4px;
  }

  .fee-btn__block--transparent {
    background-color: transparent !important;
    color: #039be5 !important;
    font-family: Montserrat;
    font-size: 14.09px;
    letter-spacing: 1.25px;
    line-height: 16px;
    text-align: center;
    border: 0;
    background: none !important;
    box-shadow: none !important;
    border-radius: 4px;
  }

  .overlay-item {
    z-index: 101 !important;
    position: relative;
    background-color: $silver;
  }

  .noselect {
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -khtml-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }

  .no-wrap {
    white-space: nowrap;
  }

  .silver {
    background-color: $silver;
  }

  .icon__cursor-pointer {
    cursor: pointer;
  }

  .truncate {
    margin-top: 14%;
    width: 110px;
    padding: 0px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }

  .audit-logo--small {
    width: 15px;
    height: 15px;
  }

  @-webkit-keyframes rotating {
    from {
      -webkit-transform: rotate(360deg);
      -o-transform: rotate(360deg);
      transform: rotate(360deg);
    }
    to {
      -webkit-transform: rotate(0deg);
      -o-transform: rotate(0deg);
      transform: rotate(0deg);
    }
  }

  @keyframes rotating {
    from {
      -ms-transform: rotate(360deg);
      -moz-transform: rotate(360deg);
      -webkit-transform: rotate(360deg);
      -o-transform: rotate(360deg);
      transform: rotate(360deg);
    }
    to {
      -ms-transform: rotate(0deg);
      -moz-transform: rotate(0deg);
      -webkit-transform: rotate(0deg);
      -o-transform: rotate(0deg);
      transform: rotate(0deg);
    }
  }

  .rotate {
    -webkit-animation: rotating 2s linear infinite;
    -moz-animation: rotating 2s linear infinite;
    -ms-animation: rotating 2s linear infinite;
    -o-animation: rotating 2s linear infinite;
    animation: rotating 2s linear infinite;
  }
</style>
