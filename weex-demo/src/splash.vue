<!-- 模版，特定语法，DSL写法参考weex提供的samples-->
<template>
  <div class="wrap">
    <div class="logo_wrap" @click="testClick" >
       <image class="img_logo" :src="splash_logo" @click="testClick" resize="contain"/>
       <image class="img_circle" :src="splash_circle" @click="testClick" resize="contain"/>
    </div>
     <!-- <button @click="testClick">animation</button> -->
  </div>
</template>


<script>
var navigator = weex.requireModule("navigator");
var modal = weex.requireModule("modal");
var animation = weex.requireModule("animation");
const myMoudle = weex.requireModule("MyModule");
module.exports = {
  data: function() {
    return {
      splash_circle: "//duqian291902259.github.io/dusan/oair/splash_circle.png",
      splash_logo:"//gw.alicdn.com/tps/i2/TB1DpsmMpXXXXabaXXX20ySQVXX-512-512.png_400x400.jpg",
      transformOrigin: "center center",
      current_rotate: 0,
      current_scale: 1,
      current_color: "#FF0000",
      current_opacity: 1,
      current_translate: "",
      current_transform: "",
      isStop: true,
      nextUrl:
        "http://dotwe.org/raw/dist/ef2bd84edd068291e8bb8ea334e33cb9.bundle.wx?_wx_tpl=http://dotwe.org/raw/dist/ef2bd84edd068291e8bb8ea334e33cb9.bundle.wx",
     };
  },

  methods: {
    testClick() {
      console.log("testClick");
      modal.toast({
        message: "Welcome to Weex...",
        duration: 0.3
      });
      this.rotate();
      this.goSite();
    },
    goSite() {
      console.log("goSite", "goSite");
      navigator.push({
        url: this.nextUrl,
        animated: "false"
      });
    },

    anim: function(styles, timingFunction, duration, callback) {
      animation.transition(
        this.$refs.block,
        {
          styles: styles,
          timingFunction: timingFunction,
          duration: duration
        },
        callback
      );
    },
    // 旋转
    rotate: function() {
      console.log("rotate", "rotating");
      var self = this;
      self.current_rotate += 30;
      self.anim(
        {
          transform: "rotate(" + self.current_rotate + "deg)"
        },
        "ease-in-out",
        100,
        function() {
          if (self.current_rotate === 360) {
            self.current_rotate = 0;
            self.goSite();
          } else {
            self.rotate();
            if (self.current_rotate === 180) {
              self.scale();
            }
          }
        }
      );
    },

    // 缩放
    scale: function() {
      var self = this;
      self.current_scale = self.current_scale === 2 ? 0.5 : 0.3;
      self.anim(
        {
          transform: "scale(" + self.current_scale + ")"
        },
        "linear",
        500,
        function() {}
      );
    }
  }
};
</script>

<style scoped>
/*weex支持的css样式，详见官方文档。如果渲染有差异，很可能是style有兼容性问题*/
.wrap {
  margin: 0px auto;
  align-items: center;
  justify-content: center;
  background-color: #000000;
}
.logo_wrap {
  width: 600px;
  height: 600px;
  margin: 0px auto;
  align-items: center;
  justify-content: center;
  background-color: #000000;
}
.img_logo {
  width: 400px;
  height: 400px;
  align-items: center;
  justify-content: center;
}

.img_circle {
  width: 300px;
  height: 300px;
  align-items: center;
  margin: 30px auto;
  justify-content: center;
}
</style>
