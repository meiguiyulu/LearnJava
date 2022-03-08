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
const profile = () => import('../components/Profile')

// 1.通过Vue.use(插件) 安装插件
Vue.use(Router)

// 2. new Router({}) 创建 VueRouter对象
const router = new Router({
  // 配置路由和组件之间的应用关系
  routes: [
    /*一个映射关系一个对象*/
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld,
      meta: {
        title: '首页',
      },
      children: [
        {
          path: '',
          redirect: 'news',
        },
        {
          path: 'news',
          component: HomeNews,
          meta: {
            title: '新闻',
          },
        },
        {
          path: 'message',
          component: HomeMessage,
          meta: {
            title: '信息',
          },
        },
      ],
    },
    {
      path: '/about',
      name: 'about',
      component: about,
      meta: {
        title: '关于',
      },
    },
    {
      path: '/user/:userId',
      name: 'user',
      component: user,
      meta: {
        title: '用户',
      },
    },
    {
      path: '/profile',
      component: profile,
      meta: {
        title: '档案',
      },
    }
  ],
  mode: 'history',
})
// 前置守卫
router.beforeEach((to, from, next) => {
  // 从from跳转到to
  document.title = to.meta.title;
  next()
})

// 3. export 导出路由
export default router
