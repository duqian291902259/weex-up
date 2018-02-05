<template>
  <div class="wrapper">
    <button class="btn" @click="testToast">Hello weex</button>
    <text class="title">Hello DuQian, {{target}} Up!</text>
    <button class="btn" @click="testEvent">测试js和Native交互</button>
  </div>
</template>

<script>
const modal = weex.requireModule("modal");
const myMoudle = weex.requireModule("MyMoudle");
module.exports = {
  data() {
    return {
      logo: "https://gw.alicdn.com/tfs/TB1yopEdgoQMeJjy1XaXXcSsFXa-640-302.png",
      target: "Weex"
    };
  },
  methods: {
    testToast: function() {
      modal.toast({
        message: "clicked,testToast",
        duration: 1
      });
      this.target = "Nono";

      //const bc = new BroadcastChannel("DuQian");
      //bc.postMessage("test BroadcastChannel!");
    },
    testEvent: function() {
      myMoudle.printLog("myMoudle duqian");
    }
  }
};
</script>

<style>
.wrapper {
  align-items: center;
  padding-top: 20px;
  background-color: azure;
}
.title {
  line-height: 60px;
  font-size: 28px;
  align-items: center;
  text-align: center;
  color: blue;
  text-align: center;
}
.btn {
  width: 350px;
  background-color: antiquewhite;
  align-items: center;
  text-align: center;
  font-size: 28px;
  padding: 10px;
}
</style>
