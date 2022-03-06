<template>
  <div>
    <h2 class="title">{{ message }}</h2>
    <button @click="btnClick">按钮</button>
    <h2>{{ name }}</h2>
    <cpn></cpn>
  </div>
</template>

<script>
import cpn from './cpn'
components: {
  cpn
}
export default {
  name: "App",
  data() {
    return {
      message: 'Hello webpack',
      name: '刘云杰',
    }
  },
  methods: {
    btnClick() {
    }
  }
}
</script>

<style scoped>
.title {
  color: aquamarine;
}
</style>