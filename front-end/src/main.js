import axios from 'axios'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

const app = createApp(App)

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(ElementPlus)
// 图标组件注册，组件库使用
axios.defaults.baseURL = 'http://bsr1-service:80';

import { createPinia } from 'pinia'
app.use(createPinia())
//pinia用途不确定

app.use(router)
app.mount('#app')