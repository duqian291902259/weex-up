<template>
  <div class="wrapper" >
    <text class="title" @click="testToast">weex page 2,  {{test}}</text>
    <button class="btn" @click="testEvent">测试调用同一个modal</button>
  </div>
</template>

<script>
const myMoudle = weex.requireModule("MyMoudle");
var modal = weex.requireModule("modal");
module.exports = {
  data: {
    test: "duqian2010@gmail.com"
  },
  mounted() {
    console.log("mounted", "mounted");
    const bc = new BroadcastChannel("DuQian");
    bc.onmessage = function(event) {
      console.log(event.data); // send message from weex pageA
      modal.toast({
        message: "pageB received =" + event.data,
        duration: 0.8
      });
      self.test = event.data;
      bc.postMessage("I am DuQian.");
    };
  },
  // created() {//在native执行报错？
  //   modal.toast({
  //     message: "created",
  //     duration: 0.8
  //   });
  // },
  methods: {
    testToast: function() {
      modal.toast({
        message: "test click",
        duration: 1
      });
    },
    testEvent: function() {
      //myMoudle.sendMessage("pageB调用了native方法");
      myMoudle.printLog("myMoudle from B");
    }
  }
};
</script>

<style>
.wrapper {
  align-items: center;
  justify-content: center;
  padding-top: 0px;
  color: antiquewhite;
}
.title {
  padding-top: 20px;
  padding-bottom: 20px;
  font-size: 28px;
  align-items: center;
  color: red;
  line-height: 80px;
  text-align: center;
}
.btn {
  width: 300px;
  background-color: bisque;
  font-size: 40px;
  align-items: center;
  text-align: center;
  padding: 10px;
}
</style>
