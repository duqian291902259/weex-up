<template>
  <div class="wrapper" >
    <text class="title" @click="testToast">weex page 2,  {{test}}</text>
    <button class="btn" @appear="onappear">测试appear</button>
  </div>
</template>

<script>
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
  
  methods: {
    testToast: function() {
      modal.toast({
        message: "test click",
        duration: 1
      });
    },
    onappear() {
    console.log("onappear:", event);
    modal.toast({
      message: "onappear",
      duration: 0.8
    });
  },
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
