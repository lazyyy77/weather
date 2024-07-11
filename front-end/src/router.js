import { createRouter, createWebHistory } from 'vue-router'
import Page1 from './components/Page1.vue';
import Page2 from './components/Page2.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            redirect: '/page1'
        },
        {

            path: '/page1',
            component: Page1
        },
        {
            path: '/page2',
            component: Page2
        }
    ]
})

export default router;
