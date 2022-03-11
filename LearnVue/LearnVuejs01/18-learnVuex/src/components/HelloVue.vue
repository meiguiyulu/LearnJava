<template>
<div>
  <h2>{{$store.state.counter}}</h2>
  <h3>{{$store.getters.more20Stu}}</h3>
</div>
</template>

<script>
export default {
  name: "HelloVue",
}
</script>

<style scoped>

</style>
