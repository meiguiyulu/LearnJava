import Vue from 'vue'
import App from './App'
// import router from './router'
import axios from 'axios'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  // router,
  // axios,
  render: h => h(App)
})

/* 1基本使用*/
// axios({
//   url: 'http://123.207.32.32:8000/home/multidata',
//   // methods: 'post', 请求方式
// }).then(res => {
//   console.log(res);
// })

// 公共配置
/*axios.defaults.baseURL = 'http://123.207.32.32:8000',
axios.defaults.timeout = 1000

/!*2 并发请求*!/
axios.all([axios({
  url: '/home/multidata',
}), axios({
  url: '/home/data',
  params: {
    type: 'sell',
    page: 2,
  }
})]).then(axios.spread((res1, res2)=>{
  console.log(res1);
  console.log(res2);
}))*/

// 封装 request 模块
import {request} from "./network/request";
request({
  url: '/home/multidata',
}).then(res=>{
  console.log(res);
}).catch(err=>{
  console.log(err);
})
