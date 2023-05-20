

import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  //{
  //  path: '/',
  //  name: 'home',
  //  component: HomeView
  //},
  //{
  //  path: '/about',
  //  name: 'about',
  //  component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  //}
]
const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
