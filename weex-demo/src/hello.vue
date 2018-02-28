<template>
  <div class="wrapper">
    <button class="btn" @click="testToast">Hello weex</button>
    <text class="title"  @click="testToast">Hello DuQian, {{target}} Up!</text>
    <button class="btn" @click="testEvent">测试nono api</button>
  </div>
</template>

<script>
const modal = weex.requireModule("modal");
const myMoudle = weex.requireModule("MyModule");
const phoneModule = weex.requireModule("PhoneModule");
const logModule = weex.requireModule("LogModule");
module.exports = {
  data() {
    return {
      logo: "https://gw.alicdn.com/tfs/TB1yopEdgoQMeJjy1XaXXcSsFXa-640-302.png",
      target: "Weex"
    };
  },
  mounted() {
      console.log("mounted", "mounted");
      this.testSupports();
    },
  methods: {
    sendMessage() {
      console.log("sendMessage", "sendMessage");
      const bc = new BroadcastChannel("DuQian");
      bc.postMessage('message from weex pageA')
    },
    testToast: function() {
      modal.toast({
        message: "clicked,A send message to B ",
        duration: 1
      });
      this.target = "Nono";
      this.sendMessage();
      this.testSupports();
    },
    testEvent: function() {
      myMoudle.printLog("myModule from A");
      var that = this;
      phoneModule.getPhoneInfo(function (event) { 
          var object = JSON.stringify(event);
          logModule.log("weex-dq","getPhoneInfo:"+object);
          var obj =JSON.parse(event);
          that.target  = "getPhoneInfo="+event;
          modal.toast({
             message: 'getPhoneInfo '+that.target,
             duration: 3
           });
          
        });
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
