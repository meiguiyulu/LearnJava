// 1.使用commonjs的模块化规范
const {add, mul} = require('./js/mathUtil.js')

console.log(add(20, 30));
console.log(mul(20, 30));

// 2. 使用ES6的模块化规范
import {
    name, age, height
} from "./js/info";

console.log(name);
console.log(age);
console.log(height);

// 3. 依赖css文件
require('./css/normal.css')

// 4. 依赖less文件
require('./css/special.less')

// 5. 使用Vue进行开发
import Vue from 'vue'
// import App from './vue/app'
import App from './vue/App.vue'

const app = new Vue({
    el: '#app',
    template: `<App/>`,
    data: {
    },
    components: {
        App
    }
})

