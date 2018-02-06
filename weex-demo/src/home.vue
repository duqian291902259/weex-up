<template>
    <div class="wrap">
        <text class="wrap_text" @click="goSite">Hello,Weex from Dusan!</text>
        <button value="用户登陆" type="success" @click="testClick">Login</button>
        <a class='a_link' href="http://g.tbcdn.cn/ali-wireless-h5/res/0.0.16/hello.js">
            <text value="duqian2010@gmail.com"></text>
        </a>
        <image class="img" :src="img"  @click="testClick" />

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
const myMoudle = weex.requireModule("MyMoudle");
const modal = weex.requireModule("modal");
var navigator = weex.requireModule("navigator");

module.exports = {
  data: {
    url: "http://g.tbcdn.cn/ali-wireless-h5/res/0.0.16/hello.js",
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

    var platform = this.$getConfig().env.platform.toLowerCase();
    console.log("platform="+platform);
    if (platform === "web") {
      this.url = "http://192.168.0.68:8081/web/index.html?page=/dist/web/index.js";
    }
  },
  methods: {
    testClick: function() {
      console.log("testClick", "testClick");
       myMoudle.openPageByUrl(
        "http://dotwe.org/raw/dist/6fe11640e8d25f2f98176e9643c08687.bundle.js"
      );
    },
    goSite() {
      console.log("goSite", "goSite");
      navigator.push({
        url: this.url,
        animated: "false"
      });
    }
  }
};
</script>

<style scoped>
.wrap {
  width: 750px;
  height: 800px;
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
  width: 450px;
  height: 300px;
  background-color: #ddd;
  border-width: 2px;
  border-style: solid;
  border-color: rgb(162, 217, 192);
  background-color: rgba(162, 217, 192, 0.2);
}
</style>
