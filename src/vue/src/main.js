import Vue from 'vue'
import App from './App.vue'
import router from './router'
import {store} from './store'
import vuex from 'vuex'
import vuetify from './plugins/vuetify';
import axios from 'axios'

Vue.use(vuex)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  vuex,
  axios,
  render: h => h(App)
}).$mount('#app')
