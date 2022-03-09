import Vue from "vue";
import VueRouter from "vue-router";

const home = ()=>import('../views/home/Home')
const category = ()=>import('../views/category/Category')
const profile = ()=>import('../views/profile/Profile')
const card = ()=>import('../views/shopcard/ShopCard')

/*1 安装插件*/
Vue.use(VueRouter)

/*2 创建路由对象*/
const routes = [
  {
    path: '',
    redirect: '/home',
  },
  {
    path: '/home',
    component: home,
  },
  {
    path: '/category',
    component: category,
  },
  {
    path: '/profile',
    component: profile,
  },
  {
    path: '/card',
    component: card,
  },
]
const router = new VueRouter({
  routes,
  mode: 'history',
})

/*3 导出router*/
export default router
