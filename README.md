# weex-demo-dusan
![android-demos](https://github.com/duqian291902259/weex-demo-dusan/blob/master/release/weex-android-demos.png)

### 新增了android工程，weex demos。
本项目源码包括了android工程和weex工程，仅供参考。可以学习weex原理和应用，跨平台应用的特定语法，前端框架，webpack，vue.js，android集成weex，以及weex调试等。

release apk下载：
[weex-android-demos-release.apk](https://github.com/duqian291902259/weex-demo-dusan/blob/master/release/weex-android-demos-release.apk)

项目github地址，感兴趣的话请star，fork一下吧！

[https://github.com/duqian291902259/weex-demo-dusan](https://github.com/duqian291902259/weex-demo-dusan)


## How to start
This demo is based on weex.
so,you must install the environment of weex .
A framework for building Mobile cross-platform UI: [https://github.com/apache/incubator-weex](https://github.com/apache/incubator-weex)

先安装好weex的各种脚手架工具。再按照以下说明运行本项目demo。

---

## About 项目说明：
### weex-android-demo

基于weex sdk，使用vue写weex页面，web和android端测试渲染效果，新增了多个实例demo，js来自weex-demo编译打包后的js bundle文件，放在assets目录里面。更新如下：

##### 1，同一界面，用多WXSDKInstance渲染多个Weex页面。

##### 2，从本地asset目录，和网络加载weex js。

##### 3，Native和Weex页面交互，子页面间消息传递。

##### 4，拓展原生module，图片加载，Toast，获取Native信息等。

##### 5，客户端weex-ui组件案例。

##### 6，动态创建weex窗口，显示，隐藏，关闭窗口实例。

##### 7，weex窗口管理器

## weex-demo
使用最新的weex版本，用vue.js开发的一些demo，测试常用的一些场景。配合weex-android-demo使用。

##### 1，使用Vue重写以前的demo，图片加载，轮播图片。

##### 2，页面展示，页面跳转，vue页面结构。

##### 3，weex调用Native方法，原生回调给js。

##### 4，BroadcastChannel消息机制，事件监听回调。

##### 5，storage本地存储，测试新的weex-ui组件。

##### 6，检测natvie是否支持某个module/某个方法。


![splash](https://github.com/duqian291902259/weex-demo-dusan/blob/master/screenshot/weex-demo-dusan.gif)
![weex-android-local-js](https://github.com/duqian291902259/weex-demo-dusan/blob/master/release/weex-android-local-js.png)


以下是前端开发常用命令：

### npm install

install all dependencies, weex-ui.
进入你本地weex-demo根目录，安装所有依赖包，本项目使用了weex-ui，也一并安装。

```
cd /path/to/weex-demo 
npm install
npm i weex-ui -S
```
install babel-preset-stage-0
为了不打包所有的组件，你需要使用 babel-plugin-component 来只引入需要的组件打包。

``` 
npm i babel-preset-stage-0 babel-plugin-component  -D
```

### npm start

Starts the development server for you to preview your weex page on browser.
You can also scan the QR code using weex playground to preview weex page on native.

### npm run build

build src with webpack.Packaging html5 project into `/dist` folder.

### npm run dev

Open the code compilation task in watch mode.

### npm run serve

Starts local server for develop weex page:
Project is running at local server，like http://192.168.0.68:8081/

preview your page:
1， http://192.168.0.68:8081/web/index.html?page=/dist/web/index.js

the dist file：
2， http://192.168.0.68:8081/dist/index.js

以上ip改为你本地的ip地址，预览使用第一个地址。Native加载网络js可以用第二个地址。dist目录里面生成的xxx.js文件,可以放在assets目录中加载。

### weex debug

```
cd path/to/src/
weex debug index.vue
```

### weex2016
weex2016,基于weex早期版本，弃用！请移步最新的官方文档，以最新的语法和sdk为准。


## Future 
demo虽小，五脏俱全，weex三端统一，write once，run everywhere，sdk逐步完善，满足各种场景的展示，交互，动画等需求，值得研究和应用。

早期相关博文：

[1，Weex开源测试之环境搭建，weex未来展望](http://blog.csdn.net/dzsw0117/article/details/51702319)

[2，Weex开发笔记](http://blog.csdn.net/dzsw0117/article/details/51773175)


## Thanks to weex team！