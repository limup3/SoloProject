import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home'
import Music from "../components/Music";
import Login from "../components/Login";
import PL from "../components/PL";

Vue.use(VueRouter)
const router = new VueRouter({
  mode: 'history',
  routes : [
      {path: '/', component: Home},
      {path: '/Music', component: Music},
      {path: '/Login', component: Login},
      {path: '/PL', component: PL},
  ]
})

export default router
