import axios from "axios";

export function request(config) {

  // 1. 创建 axios 实例
  const instance = axios.create({
    baseURL: 'http://123.207.32.32:8000',
    timeout: 5000
  })

  // 2. axios 的拦截器
  /*拦截请求*/
  /*请求拦截的作用：
  * 1. config中的一些信息不符合服务器的要求
  * 2. 每次发送网络请求时，希望在界面中显示一个请求的图标
  * 3. 某些网络请求(比如登录 token)必须携带一些特殊的信息
  * */
  axios.interceptors.request.use(config=>{
    console.log('axios拦截请求成功');
  }, error => {
    console.log('axios拦截请求失败');
  });
  /*拦截响应*/

  axios.interceptors.response.use(result=>{
    console.log('axios拦截响应成功');
  }, error => {
    console.log('axios拦截响应失败');
  });

  // 3. 发送真正的网络请求
  return instance(config)

/*
return new Promise(((resolve, reject) => {
    // 1. 创建 axios 实例
    const instance = axios.create({
      baseURL: 'http://123.207.32.32:8000',
      timeout: 5000
    })

    // 发送网络请求
    instance(config)
      .then(res=>{
        resolve(res)
      })
      .catch(err=>{
        reject(err)
      })
  }))*/
}

