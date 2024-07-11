<template>
    <div id="app">
      <nav>
        <router-link to="/page1">Page 1</router-link>
        <br>
        <router-link to="/page2">Page 2</router-link>
      </nav>
      hello
      <RouterView style="height: 90vh; max-height: 100%; background-color: white; color: black;" />
    </div>
</template>
  
<script>
  import { RouterView } from 'vue-router'
  
  export default {
  };
</script>
  
<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
  