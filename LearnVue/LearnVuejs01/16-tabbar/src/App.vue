<template>
  <div id="app">
    <router-view></router-view>
    <TabBar>
      <TabBarItem path="/home" activeColor="pink">
        <img slot="item-icon" src="./assets/img/tabbar/home.svg" alt="首页">
        <img slot="item-icon-active" src="./assets/img/tabbar/home_active.svg" alt="首页">
        <div slot="item-text">首页</div>
      </TabBarItem>
      <TabBarItem path="/category" activeColor="pink">
        <img slot="item-icon" src="./assets/img/tabbar/category.svg" alt="分类">
        <img slot="item-icon-active" src="./assets/img/tabbar/category_active.svg" alt="分类">
        <div slot="item-text">分类</div>
      </TabBarItem>
      <TabBarItem path="/card" activeColor="pink">
        <img slot="item-icon" src="./assets/img/tabbar/shopcart.svg" alt="购物车">
        <img slot="item-icon-active" src="./assets/img/tabbar/shopcart_active.svg" alt="购物车">
        <div slot="item-text">购物车</div>
      </TabBarItem>
      <TabBarItem path="/profile" activeColor="pink">
        <img slot="item-icon" src="./assets/img/tabbar/profile.svg" alt="我的">
        <img slot="item-icon-active" src="./assets/img/tabbar/profile_active.svg" alt="我的">
        <div slot="item-text">我的</div>
      </TabBarItem>
    </TabBar>
  </div>
</template>

<script>
  import TabBar from "./components/tabbar/TabBar";
  import TabBarItem from "./components/tabbar/TabBarItem";

  export default {
    name: 'App',
    components: {
      TabBar,
      TabBarItem,
    }
  }
</script>

<style>
  @import "assets/css/base.css";
</style>
