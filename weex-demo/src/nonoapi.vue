<template>
  <div class="wrapper">
    <image class="img" :src="img"  />
    <button class="btn" @click="getOptions">Hello, Nono Weex</button>
    <text class="title"  @click="testToast">result: {{ch_1}}, {{target}} </text>
    <button class="btn" @click="testEvent">Native方法调用</button>
    <button class="btn" @click="showDialog">显示weex窗口</button>
    <button class="btn" @click="hideDialog">隐藏weex窗口</button>
    <button class="btn" @click="closeDialog">关闭weex窗口</button>
  </div>
</template>

<script>
const modal = weex.requireModule("modal");
const weexDialog = weex.requireModule("WeexDialogModule");
const logModule = weex.requireModule("LogModule");
const roomModule = weex.requireModule("RoomModule");


module.exports = {
  data() {
    return {
      img: "http://img1.vued.vanthink.cn/vued08aa73a9ab65dcbd360ec54659ada97c.png",
      target: "Weex",
      __la:"",
      __sp:"",
      ch_1:"",
    };
  },
  methods: {
    getOptions: function() {
      var object = weex.config;
      this.target = object;
      modal.toast({
        message: "clicked "+object.bundleUrl,//获取当前页面的url
        duration: 1
      });
     
    },
    testToast: function() {
      modal.toast({
        message: "clicked2 "+weex.config.__la,//获取render方法传递的options参数值
        duration: 1
      });
      this.target = "ch_1 "+weex.config.ch_1;
    },
    closeDialog: function() {
       logModule.log("weex-dq","closeDialog");
       weexDialog.close();
    },
    showDialog: function() {
       logModule.log("weex-dq","showDialog");
       weexDialog.show();
    },
    hideDialog: function() {
       logModule.log("weex-dq","hideDialog");
       weexDialog.hide();
    },
    testEvent: function() {
      logModule.log("weex-dq","logModule dq test log");
      var that = this;
      logModule.isLogEnable(function (event) { 
          var object = JSON.stringify(event);
          logModule.log("weex-dq","callback:"+object);
          var obj =JSON.parse(event);
          that.target  = "logEnable="+obj.logEnable;
          modal.toast({
             message: 'native '+that.target,
             duration: 3
           });
          
        });

        roomModule.getLoginUserInfo(function (event) { 
          var object = JSON.stringify(event);
          logModule.log("weex-dq","callback:"+object);
          var obj =JSON.parse(event);
          that.target  = that.target +",UserInfo="+obj.accessToken+",anchor_intro"+obj.anchor_intro;
          modal.toast({
             message: 'native '+that.target,
             duration: 3
           });
          
        });
        
        weexDialog.resize("{\"data\":\"\",\"height\":0.2,\"show\":1,\"uiLevel\":1,\"url\":\"http://192.168.0.112:8081/dist/nono-weex.js\",\"width\":0.5,\"x\":0.1,\"y\":0.1}");
    },

    //测试weex是否支持某些模块和功能
    testSupports: function() {
        var net = weex.supports('@module/stream')  // true
        var dialog = weex.supports('@module/WeexDialogModule')  // true
 
        modal.toast({
          message: "是否有 WeexDialogModule="+dialog+",net="+net,
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
  background-color: azure;
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
