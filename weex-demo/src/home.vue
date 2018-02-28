<template>
    <div class="wrap">
        <text class="wrap_text" @click="goSite">Hello,Weex from Dusan!</text>

        <button class="btn" value="用户登陆" type="success" @click="testClick">Click</button>

        <a class='a_link' :href="url">
            <text value="duqian2010@gmail.com"></text>
        </a>
        <div @click="testClick">
           <image class="img" :src="img"  />
        </div>
        <div>
          <text value="内置web组件"></text>
          <web class="webview" src="http://duqian.site" ></web> 
        </div>
        <div ref="box" class="box">
          <text class="info">Width: {{size.width}}</text>
          <text class="info">Height: {{size.height}}</text>
          <text class="info">Top: {{size.top}}</text>
          <text class="info">Bottom: {{size.bottom}}</text>
          <text class="info">Left: {{size.left}}</text>
          <text class="info">Right: {{size.right}}</text>
        </div>

        
    </div>
</template>

<script>
const dom = weex.requireModule("dom");
const myMoudle = weex.requireModule("MyModule");
const modal = weex.requireModule("modal");
var navigator = weex.requireModule("navigator");

module.exports = {
  data: {
    url:
      "http://dotwe.org/raw/dist/ef2bd84edd068291e8bb8ea334e33cb9.bundle.wx?_wx_tpl=http://dotwe.org/raw/dist/ef2bd84edd068291e8bb8ea334e33cb9.bundle.wx",
    img:
      "//gw.alicdn.com/tps/i2/TB1DpsmMpXXXXabaXXX20ySQVXX-512-512.png_400x400.jpg",
    size: {
      width: 0,
      height: 0,
      top: 0,
      bottom: 0,
      left: 0,
      right: 0
    }
  },
  mounted() {
    console.log("mounted", "mounted");
    setTimeout(() => {
      dom.getComponentRect(this.$refs.box, option => {
        if (option.result && option.size) {
          this.size = option.size;
        }
      });
    }, 20);

    var platform = WXEnvironment.platform;//weex.config.env.platform.toLowerCase();
    console.log("platform=" + platform);
    if ("Web"===platform) {
      this.url =
        "http://192.168.0.68:8081/web/index.html?page=/dist/web/index.js";
    }
  },
  methods: {
    goSite() {
      console.log("goSite", "goSite");
      navigator.push({
        url: this.url,
        animated: "false"
      });
    },

    testClick: function() {
      console.log("testClick", "testClick");
      myMoudle.openPageByUrl(
        this.url
        //"http://dotwe.org/raw/dist/6fe11640e8d25f2f98176e9643c08687.bundle.js"
      );
      goSite();
    }
  }
};
</script>

<style scoped>
.wrap {
  width: 750px;
  align-items: center;
  justify-content: center;
}
.wrap_text {
  font-size: 45;
  margin: 20px auto;
  height: 50px;
}
.img {
  width: 200px;
  height: 200px;
  align-items: center;
  justify-content: center;
}
.a_link {
  margin-top: 20;
  align-items: center;
  justify-content: center;
}
.box {
  width: 720px;
  height: 220px;
  background-color: #ddd;
  border-width: 2px;
  border-style: solid;
  border-color: rgb(162, 217, 192);
  background-color: rgba(162, 217, 192, 0.2);
}
.webview {
  width: 720px;
  height: 400px;
  margin: 10px auto;
}
</style>
