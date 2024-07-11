<template>
    <div>
      <h1>Messages from the Last Hour</h1>
      this is page 1; time is {{ messages }}; this is time {{time}};<br>
      <el-button type="primary" @click="fetchMessages">get time</el-button>
      
      <!-- <ul>
        <li v-for=
        "message in messages" :key="message.id">
          [{{ message.timestamp }}] {{ message.content }}
        </li>
      </ul> -->
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'Page1',
    data() {
      return {
        messages: 'null',
        time: 0
      }
    },
    methods: {
      async fetchMessages() {
        this.time+=1;
        
        try {
          const response = await axios.get('/page1'); //await
          console.log("get!" + response.data);
          this.messages = response.data;
          this.time+=1;
        } catch (error) {
          this.time = -1;
          console.error('Error fetching messages', error);
        }
      }
    }
  };
  </script>
  
  <style scoped>
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    background-color: #f4f4f4;
    margin: 5px 0;
    padding: 10px;
    border-radius: 5px;
  }
  </style>
  