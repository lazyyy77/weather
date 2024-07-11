<template>
  <div>
    <h1>Messages from the Last Hour</h1>
    this is page 2; time is {{ messages }}
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
  name: 'Page2',
  data() {
    return {
      messages: 'null'
    }
  },
  methods: {
      async fetchMessages() {
        try {
          const response = await axios.get('/page2'); //await
          console.log("get!" + response.data);
          this.messages = response.data;
        } catch (error) {
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
