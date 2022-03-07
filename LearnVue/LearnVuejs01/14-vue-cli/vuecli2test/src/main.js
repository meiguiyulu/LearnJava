// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

const cpn = {
  template: `<div>{{message}}</div>`,
  data() {
    return {
      message : '我是组件',
    }
  }
}

/* eslint-disable no-new */
new Vue({
  el: '#app',
  /*render函数*/
  render: function (createElement) {
    // 1. createElement('标签', {标签的属性}, ['标签的内容'])
    // return createElement('h2',
    //   {class: 'box'},
    //   ['Hello World', createElement('button', ['按钮'])]);
    // 2. 传入组件
    return createElement(App);
  }
  // components: { App },
  // template: '<App/>'
})
