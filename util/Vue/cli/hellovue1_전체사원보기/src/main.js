import Vue from "vue";//<script src="vue.js">
import App from "./App.vue";
import router from './router'

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
/*
html의 app영역을 찾아서 그 부분을 vue 템플릿으로 관리하도록 마운트한다.
render 에서 h함수로 App를지정하면 그쪽에서 일을 진행하도록 연결된다--> 여기서 뷰가 호출된다.
*/