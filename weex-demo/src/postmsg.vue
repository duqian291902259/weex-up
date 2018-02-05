<template>
  <div class="wrapper" >
    <text class="title" @click="testToast">weex page 2,  {{test}}</text>
    <button class="btn" @appear="ondisappear">测试appear</button>
  </div>
</template>

<script>
var modal = weex.requireModule("modal");
module.exports = {
  data: {
    test: "duqian2010@gmail.com"
  },
  methods: {
    testToast: function() {
      modal.toast({
        message: "test click",
        duration: 1
      });
    },
    onappear(event) {
      console.log("onappear:", event);
      modal.toast({
        message: "onappear",
        duration: 0.8
      });
    },
    ondisappear(event) {
      console.log("ondisappear:", event);
      modal.toast({
        message: "ondisappear",
        duration: 0.8
      });
    },
    // created: function() {
    //   const bc = new BroadcastChannel("DuQian");
    //   bc.onmessage = function(event) {
    //     console.log(event.data); // test BroadcastChannel!
    //     self.test = event.data;
    //     bc.postMessage("I am DuQian.");
    //   };
    // }
  }
};
</script>

<style>
.wrapper {
  align-items: center;
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
