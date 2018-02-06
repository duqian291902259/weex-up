# weex-demo-dusan
![splash](https://github.com/duqian291902259/weex-demo-dusan/blob/master/screenshot/weex-demo-dusan.gif)

更新：2018年新增了android工程，weex demo，主要是演示weex如何加载和渲染页面。

## How to start
This demo is based on weex.
so,you should ensure that installed the environment of weex ,A framework for building Mobile cross-platform UI: [https://github.com/apache/incubator-weex](https://github.com/apache/incubator-weex)

先安装好weex的各种脚手架工具。再按照以下说明运行本项目demo。

---

## About 项目说明：
### weex-android-demo

基于weex sdk及官方demo，使用vue写weex页面，web和android端测试渲染效果，新增了多个实例demo，js来自weex-demo编译打包后的js bundle文件，放在assets目录里面。更新如下：

##### 1，多WXSDKInstance实现子页面。

##### 2，从android asset目录，网络加载weex js。

##### 3，Native和Weex页面交互。

##### 4，拓展原生module，图片加载，Toast，相互通信等。

##### 5，使用Vue重写以前的demo，测试新的weex-ui组件。

## weex-demo
使用最近的weex版本，用vue.js开发的一些demo，测试常用的一些场景。配合weex-android-demo使用。以下是前端开发常用命令：

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
http://192.168.0.68:8081/web/index.html?page=/dist/index.js

the dist file：
http://192.168.0.68:8081/dist/index.js

### weex2016
weex2016,基于weex早期版本，依然适用，但建议移步最新的官方文档。以最新的语法和sdk为准。


## Future 
demo虽小，五脏俱全，weex三端统一，write once，run everywhere，sdk逐步完善，满足各种场景的展示，交互，动画等需求，值得研究和应用。

早期相关博文：

[1，Weex开源测试之环境搭建，weex未来展望](http://blog.csdn.net/dzsw0117/article/details/51702319)

[2，Weex开发笔记](http://blog.csdn.net/dzsw0117/article/details/51773175)


## Thanks to weex team！
Weex，We will follow you!