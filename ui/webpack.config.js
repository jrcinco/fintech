module.exports = {
  css: {
    loaderOptions: {
      sass: {
        data: `
          @import "@/scss/_abstracts.scss";
          @import "@/scss/_generic.scss";
          @import "@/scss/_variables.scss";`
      }
    }
  }
};
