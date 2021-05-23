import Vue from "vue";
import App from "./App.vue";
import router from "./router";

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

// Import Bootstrap an BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)

Vue.config.productionTip = false;

new Vue({
  router,
  render: function (h) {
    return h(App);
  },
}).$mount("#app");

// new Vue({
//   el: '#home',
//   data: {
//     appName: 'My App',
//     items: [
//       { name: 'Apple', qty: 5 },
//       { name: 'Banana', qty: 10 },
//     ],
//     fields: [
//       {
//         key: 'index',
//         label: '#',
//       },
//       {
//         key: 'name',
//         label: 'fruit',
//       },
//       {
//         key: 'qty',
//         label: 'quantity',
//         thClass: 'red',
//       },
//       {
//         key: 'action',
//       },
//     ],
//   },
//   methods: {
//     saveFruit (fruit) {
//       console.log(`Saving fruit: ${fruit}`);
//     },
//   },
//   mounted () {
    
//   }
// });
