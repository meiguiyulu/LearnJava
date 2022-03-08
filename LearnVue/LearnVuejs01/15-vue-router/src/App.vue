<template>
  <div id="app">
    <router-link to="/HelloWorld">HelloWorld</router-link>
    <router-link to="/about">about</router-link>
    <router-link :to="'/user/'+userId">user</router-link>
    <router-link :to="{
                       path: '/profile',
                       query: {name: '刘云杰', age: 18, height: 188}}">
      档案</router-link>
    <!-- <router-view> 作用是占位 页面要渲染在哪个位置 -->
    <keep-alive>
      <router-view></router-view>
    </keep-alive>
<!--    <router-view></router-view>-->
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      userId: 'lyj',
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
