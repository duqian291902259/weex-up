<template>
  <div class="wrapper" @load="update">
    <image :src="logoUrl" class="logo"></image>
    <text class="title"  @click="update">Hello DuQian, {{target}} Up!</text>
    <text class="desc">Now, let's use vue to build weex app.</text>
    <button class="btn" @click="update">点我测试toast</button>
    <button class="btn" @click="sendMsg">发消息，更新页面</button>
    <button class="btn" @click="jump">测试页面跳转</button>

    <textarea class="inputText" value="测试输入法弹出" />

    <!-- <a href="http://duqian.site" target="blank">
       <text>a链接</text>
    </a>  -->
    <div>
       <web class="webview" src="http://duqian.site" ></web> 
    </div>
  </div>
</template>

<script>
const myMoudle = weex.requireModule("MyMoudle");
const modal = weex.requireModule("modal");
var navigator = weex.requireModule("navigator");

var globalEvent = weex.requireModule("globalEvent");
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
          //http://192.168.0.68:8081/dist/hello.js
          url:
            "http://dotwe.org/raw/dist/6fe11640e8d25f2f98176e9643c08687.bundle.js", //web用 http://192.168.0.68:8081/web/index.html?page=/dist/hello.js
          animated: "false"
        },
        event => {
          modal.toast({ message: "callback: " + event });
        }
      );
    },
    sendMsg() {
      console.log("sendMsg");

      myMoudle.sendMessage("weex发送指令给native");
      myMoudle.openPageByUrl(
        "http://dotwe.org/raw/dist/6fe11640e8d25f2f98176e9643c08687.bundle.js"
      );
      modal.toast({
        message: "sendMsg 2 native",
        duration: 1
      });
    }
  }
};
</script>
<style>
.wrapper {
  align-items: center;
  min-height: 1000px;
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
  height: 60px;
  background-color: antiquewhite;
  margin-top: 10px;
  margin-bottom: 10px;
  align-items: center;
  text-align: center;
  padding: 10px;
}

.inputText {
  width: 450px;
  height: 100px;
  text-align: left;
  background-color: beige;
  margin-top: 10px;
  margin-bottom: 10px;
  align-items: center;
  text-align: center;
}

.webview {
  width: 520px;
  height: 800px;
}
</style>
