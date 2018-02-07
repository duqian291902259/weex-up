<template>
  <div class="wrapper" @longpress="onlongpress">
    <text class="title" @click="onlongpress"  @appear="onappear('B')"
        @disappear="ondisappear('B')">点击我，page 2,  {{test}}</text>
    <button class="btn" @click="testEvent">测试调用同一个modal</button>
  </div>
</template>

<script>
const myMoudle = weex.requireModule("MyMoudle");
var modal = weex.requireModule("modal");

var globalEvent = weex.requireModule("globalEvent");
globalEvent.addEventListener("eventB", function(e) {
  console.log("get eventB"+e.data);
  modal.toast({
    message: "js收到了eventB " + e.data,
    duration: 1
  });
});

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
  created() {
    console.log("created", "created");
  },
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
    },
    onlongpress (event) {
        console.log('onlongpress:', event)
        myMoudle.fireNativeGlobalEvent("eventB",function (event) {
          console.log("received From Natvie "+event.data)
           modal.toast({
             message: 'Get Native result=  '+event.result,
             duration: 2
           });
        });
      },
      onappear (char) {
        console.log(char, 'appear')
        modal.toast({ message: char + ' appear' })
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
