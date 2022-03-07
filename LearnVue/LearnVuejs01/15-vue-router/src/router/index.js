/*配置路由的相关信息*/
import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
// import about from "../components/about";
// import User from "../components/User";

const HelloWorld = () => import('@/components/HelloWorld');
const about = () => import('../components/about');
const user = () => import('../components/User');
const HomeNews = () =>import('../components/HomeNews')
const HomeMessage = () =>import('../components/HomeMessage')

// 1.通过Vue.use(插件) 安装插件
Vue.use(Router)

// 2. new Router({}) 创建 VueRouter对象 3. export 导出路由
export default new Router({
  // 配置路由和组件之间的应用关系
  routes: [
    /*一个映射关系一个对象*/
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld,
      children: [
        {
          path: '',
          redirect: 'news',
        },
        {
          path: 'news',
          component: HomeNews,
        },
        {
          path: 'message',
          component: HomeMessage,
        },
      ],
    },
    {
      path: '/about',
      name: 'about',
      component: about,
    },
    {
      path: '/user/:userId',
      name: 'user',
      component: user,
    }
  ],
  mode: 'history'
})
