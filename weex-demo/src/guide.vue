<template>
  <div class="wrap" >
    <slider class="slider size" auto-play="isAutoPlay" interval="intervalValue">
      <div v-for="src in posters">
        <image class="size" resize="contain" :src="src"  @click="go"></image>
      </div>
      <indicator class="indicator"></indicator>
    </slider>

    <!-- 开始体验－Start -->
    <text class='btn' @click="go">{{txt}}</text>
  </div>
</template>


<script>
const modal = weex.requireModule("modal");
const myMoudle = weex.requireModule("MyMoudle");
var event = weex.requireModule("event");
var navigator = weex.requireModule("navigator");

export default {
  data() {
    return {
      nextUrl:
        "https://github.com/duqian291902259/weex-demo-dusan/blob/master/weex-demo/dist/home.js", //todo 修改
      txt: "Start-DusanWeex",
      intervalValue: 1000,
      isShowIndicators: "true",
      isAutoPlay: "true",
      posters: [
        "http://weex-project.io/guide/images/weex-example-yo.png",
        "https://img3.doubanio.com/view/photo/l/public/p2465527446.webp",
        "http://weex-project.io/guide/images/vue-rax.png",
        "https://duqian291902259.github.io/dusan/oair/bg1.png"
      ]
    };
  },
  methods: {
    go() {
      console.log("hi,duqian");
      modal.toast({
        message: "next page",
        duration: 1
      });

      myMoudle.openPageByUrl(this.nextUrl);
      navigator.push({
        url: this.nextUrl,
        animated: "false"
      });
    },
  }
};
</script>

<style scoped>
.wrap {
  align-items: center;
  justify-content: center;
  background-color: #2b2d2f;
}
.size {
  width: 720px;
  height: 960px;
}
/* .slider {
  position: relative;
} */
.indicator {
  width: 750px;
  height: 60px;
  bottom: 10px;
  margin: 10px auto;
  align-items: center;
  justify-content: center;
}

.btn {
  width: 300px;
  padding-top: 20px;
  padding-bottom: 20px;
  margin-bottom: 30px;
  background-color: #0096ff;
  font-size: 25;
  font-weight: bold;
  align-items: center;
  justify-content: center;
  border-radius: 50;
  color: #ffffff;
  text-align: center;
}
</style>

