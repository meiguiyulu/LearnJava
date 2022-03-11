import Vue from "vue"
import Vuex from 'vuex'
import {resolve} from "../../build/webpack.base.conf";

// 1. 安装插件
Vue.use(Vuex)

// 2. 创建对象

const moduleA = {
  state: {
    name: 'lyj',
  },
  mutations: {
    mupdateName(state, payload) {
      state.name = '刘云杰';
    }
  },
  actions: {},
  getters: {
    fullName(state) {
      return state.name + '111';
    }
  },
}

const store = new Vuex.Store({
  /*一共有以下5个参数，每个参数都是对象*/
  state: {
    // 状态
    counter: 1000,
    student: [
      {id: 110, name: 'lyj0', age: 18},
      {id: 111, name: 'lyj1', age: 19},
      {id: 112, name: 'lyj2', age: 20},
      {id: 113, name: 'lyj3', age: 21},
    ],
    info: {
      name: 'lyj',
      age: 18,
      height: 188,
    }
  },
  mutations: {
    // 方法  默认有一个参数state
    increment(state) {
      state.counter++;
    },
    decrement(state) {
      state.counter--;
    },
    incCount(state, count) {
      state.counter += count;
    },
    addStudent(state, stu) {
      console.log(stu);
      state.student.push(stu);
    },
    updateInfo(state) {
      state.info.name = '刘云杰';
    },
  },
  actions: {
    aUpdateInfo(context, payload) {
      // return new Promise((resolve, reject) => {
      //   setTimeout(() => {
      //     console.log(payload.message);
      //     context.commit('updateInfo');
      //     payload.success();
      //     resolve('index.js执行完成');
      //   }, 1000)
      // })
          console.log(payload.message);
          context.commit('updateInfo');
          payload.success();
    }
  },
  getters: {
    powerCount(state) {
      return state.counter * state.counter;
    },
    more20Stu(state) {
      return state.student.filter(s => s.age >= 20);
    },
    more20StuLength(state, getters) {
      return getters.more20Stu.length;
    },
    moreAgeStu(state) {
      return function (age) {
        return state.student.filter(s => s.age >= age);
      }
    },
  },
  modules: {
    a: moduleA
  },
})

// 3.导出
export default store
