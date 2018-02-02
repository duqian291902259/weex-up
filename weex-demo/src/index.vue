<template>
  <div class="wrapper" @load="update">
    <image :src="logoUrl" class="logo"></image>
    <text class="title"  @click="update">Hello DuQian, {{target}} Up!</text>
    <text class="desc">Now, let's use vue to build weex app.</text>
    <button class="btn" @click="update">点我测试toast</button>
    <a href="http://192.168.0.68:8081/dist/hello.js">
       <button class="btn">a链接</button>
    </a> 
    <button class="btn" @click="jump">测试页面跳转</button>
  </div>
</template>

<script>
const modal = weex.requireModule("modal");
var globalEvent = weex.requireModule("globalEvent");
var navigator = weex.requireModule("navigator");

globalEvent.addEventListener("testEvent", function(e) {
  console.log("get testEvent");
  modal.toast({
    message: "weex js收到了Native的 " + e.key,
    duration: 1
  });
});
export default {
  data: {
    logoUrl:
      "http://img1.vued.vanthink.cn/vued08aa73a9ab65dcbd360ec54659ada97c.png",
    target: "Weex"
  },
  methods: {
    update() {
      console.log("update");
      this.target = "Nono";
      console.log("target:", this.target);

      modal.toast({
        message: "update weex 2 nono",
        duration: 1
      });
    },
    jump(event) {
      console.log("will jump");
      navigator.push(
        {
          url: "http://192.168.0.68:8081/dist/hello.js", //web用 http://192.168.0.68:8081/web/index.html?page=/dist/hello.js
          animated: "false"
        },
        event => {
          modal.toast({ message: "callback: " + event });
        }
      );
    }
  }
};
</script>
<style>
.wrapper {
  align-items: center;
  height: 1000px;
  background-color: #888;
  padding-top: 50px;
}
.title {
  padding-top: 20px;
  padding-bottom: 20px;
  font-size: 35px;
  color: antiquewhite;
}
.logo {
  width: 360px;
  height: 156px;
  margin-top: 50px;
}
.desc {
  padding-top: 20px;
  color: azure;
  font-size: 24px;
}

.btn {
  width: 350px;
  background-color: antiquewhite;
  margin-top: 10px;
  margin-bottom: 10px;
  align-items: center;
  text-align: center;
  padding: 10px;
}
</style>
