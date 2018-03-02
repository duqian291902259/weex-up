<template>
  <div class="wrapper">
    <image class="img" :src="img"  />
    <button class="btn" @click="getOptions">Hello, DuQian</button>
    <text class="title"  @click="testToast">result: {{__la}}, {{target}} </text>
    <button class="btn" @click="testEvent">Native方法调用</button>
    <!-- <button class="btn" @click="showDialog">显示weex窗口</button> -->
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
      __la:"",//直接这样获取不到？
      __sp:"",
      ch_1:"",
    };
  },

  mounted() {
      console.log("mounted", "mounted");
      this.__la = weex.config.__la;
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
      this.target = "获取render传递的参数 "+weex.config.url_p+",__la="+weex.config.__la;
    },
    openDialog: function() {
       weexDialog.newWeexDialog("{\"data\":\"\",\"height\":0.3,\"show\":1,\"uiLevel\":1,\"url\":\"http://192.168.0.112:8081/dist/nono-weex.js\",\"width\":0.5,\"x\":0.1,\"y\":0.5}");
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
    resizeDialog: function() {
       logModule.log("weex-dq","resizeDialog");
       weexDialog.resize("{\"data\":\"\",\"height\":0.2,\"show\":1,\"uiLevel\":1,\"url\":\"http://192.168.0.112:8081/dist/nono-weex.js\",\"width\":0.5,\"x\":0.1,\"y\":0.1}");
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

        this.openDialog();

        var supports = weex.supports('@module/RoomModule');
        logModule.log("weex-dq","native是否支持 getLoginUserInfo "+supports);
        if(supports){
            this.getUserInfo();
        }
        
    },
    getUserInfo: function() {
       var that = this;//注释掉测试页面存在bug时，native怎么处理
       logModule.log("weex-dq","getLoginUserInfo");
       roomModule.getLoginUserInfo(function(event) { 
          var object = JSON.stringify(event);
          logModule.log("weex-dq","callback:"+object);
          var obj =JSON.parse(event);
          that.target  = that.target +",UserInfo="+obj.loginname+",my_id"+obj.my_id;
          modal.toast({
             message: 'native '+that.target,
             duration: 3
           });
        });
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
  padding: 20px;
  background-color: azure;
  min-height: 500px;  
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
