<template>
  <div class="wrapper">
    <text class="title"  @click="closeDialog">Hello DuQian, {{target}} Up!</text>
    <button class="btn" @click="openDialog">测试nono api</button>
  </div>
</template>

<script>
const modal = weex.requireModule("modal");
const myMoudle = weex.requireModule("MyModule");
const weexDialog = weex.requireModule("WeexDialogModule");
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
        message: "clicked,打开新窗口 ",
        duration: 1
      });
      this.target = "Nono";
      this.sendMessage();
      this.testSupports();

      this.testEvent();
    },
    openDialog: function() {
       weexDialog.newWeexDialog("{\"data\":\"\",\"height\":0.3,\"show\":1,\"uiLevel\":1,\"url\":\"http://192.168.0.112:8081/dist/index.js\",\"width\":0.4,\"x\":0.1,\"y\":0.5}");
    },

    closeDialog: function() {
       weexDialog.close("{\"data\":\"\",\"height\":0.3,\"show\":1,\"uiLevel\":1,\"url\":\"http://192.168.0.112:8081/dist/home.js\",\"width\":0.4,\"x\":0.1,\"y\":0.5}");
    },

    //测试weex是否支持某些模块和功能
    testSupports: function() {
        var net = weex.supports('@module/stream')  // true
        var my = weex.supports('@module/MyMoudle')  // true
        var dialog = weex.supports('@module/WeexDialogModule')  
        var duqian = weex.supports('@module/MyMoudle.duqian')  // false
        var mytest = weex.supports('@module/duqian')  // false
        console.log("net", net);
        modal.toast({
          message:"是否有MyMoudle="+my+",dialog="+dialog+",是否支持stream= "+net+",mytest="+mytest,
          duration: 10
        });
    },
  }
};
</script>

<style>
.wrapper {
  align-items: center;
  padding-top: 20px;
  background-color:darkgrey;
  justify-content: center;
}
.title {
  line-height: 60px;
  font-size: 28px;
  align-items: center;
  text-align: center;
  color: blue;
  text-align: center;
  margin:15px auto;
}
.btn {
  width: 350px;
  background-color: antiquewhite;
  align-items: center;
  text-align: center;
  font-size: 28px;
  padding: 10px;
  margin:15px auto;
}
</style>
