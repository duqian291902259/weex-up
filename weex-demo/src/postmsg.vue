<template>
  <div class="wrapper" @longpress="onlongpress">
    <text class="title" @click="onlongpress"  @appear="onappear('B')"
        @disappear="ondisappear('B')">点我，page2,  {{test}}</text>
    <button class="btn" @click="testEvent">测试调用同一个modal</button>
  </div>
</template>

<script>
const myMoudle = weex.requireModule("MyModule");
var modal = weex.requireModule("modal");

var globalEvent = weex.requireModule("globalEvent");
globalEvent.addEventListener("eventB", function(e) {
  console.log("get eventB"+e.data);
  modal.toast({
    message: "globalEvent收到了eventB " + e.data,
    duration: 1
  });
  //this.test = e.data;
  //+",user="+JSON.stringify(event.user) +event.user.name+","+event.user.age
});

module.exports = {
  data: {
    test: "duqian2010@gmail.com"
  },
  mounted() {
    console.log("mounted", "mounted");
    const bc = new BroadcastChannel("DuQian");
    var that = this;
    bc.onmessage = function(event) {
      //bc.onmessage = event => {
      console.log(event.data); // send message from weex pageA
      that.test = "pageB received ="+event.data;
      //this.test = "pageB received ="+event.data;
      modal.toast({
        message: "onmessage received =" + event.data+",user="+event.user.name+","+event.user.age,
        duration: 1
      });
    };
  },
  created() {
    console.log("created", "created");
    this.test = "pageB created";
  },
  methods: {
    testEvent: function() {
      //myMoudle.sendMessage("pageB调用了native方法");
      this.test = "pageB clicked";      
      myMoudle.printLog("myMoudle from B");
    },
    onlongpress (event) {
        console.log('onlongpress:', event)
        myMoudle.fireNativeGlobalEvent("eventB",function (event) {
           console.log("received From Natvie "+event.data)
           modal.toast({
             message: 'native callback.invoke = '+event.result +",user="+event.user.name+","+event.user.age,
             duration: 2
           });
        });
      },
      onappear (char) {
        console.log(char, 'appear')
        modal.toast({ message: char + ' appear' })
        //this.test = "pageB change text";
      },
      ondisappear (char) {
        console.log(char, 'disappear')
        modal.toast({ message: char + ' disappear' })
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
  background-color: antiquewhite;
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
