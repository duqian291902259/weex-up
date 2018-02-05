# weex-demo-dusan
![splash](https://github.com/duqian291902259/weex-demo-dusan/blob/master/screenshot/weex-demo-dusan.gif)


## How to start
This demo is based on weex.
so,you should ensure that installed the environment of weex ,A framework for building Mobile cross-platform UI: [http://alibaba.github.io/weex](http://alibaba.github.io/weex)

---

以下操作，基于weex早期版本，依然适用，但建议移步最新的官方文档。以最新的语法和sdk为准。

---

### Install dependencies
cd path/to/project and install dependencies.

```
npm install
```
进入项目根目录，执行install命令，安装package.json中相关的依赖。
### Development

* `npm run build`: build `src/main.we` into `build/main.js`
* `npm run dev`: watch file changes of `src/main.we` and automatically build into `build/main.js`
* `npm run serve`: preview in html5 renderer through `http://localhost:8080/`

*note: the entry file can be configured in `webpack.config.js`, learn more from [weex-loader](https://www.npmjs.com/package/weex-loader)*

Finally the generated code will be found in `src/build/` folder.

---

1,将.we源文件转换为对应的js文件，位于src/build目录。

```
npm run build
```
2，监控文件变化，改动代码后自动build，实时看效果。

```
npm run dev
```

3，开启本地server服务，端口可自定义，可用pc浏览器调试H5页面。

```
npm run serve
```

### debug and run

开启server后，浏览器输入http://localhost:8080/，可以预览页面。

1，在APP中渲染：

build后的目标代码，将对应的url生成二维码(localhost改为自己电脑的ip地址），方便用官方的playground扫描二维码并在app中渲染： 
http://192.168.100.47:8080/src/build/main.js

2，在浏览器中预览页面效果：

http://192.168.100.47:8080/index.html?page=./src/build/main.js


---

### Overview 
scr中的三个页面，是用weex实现，分别为splash，guide，home页面，交互主要是点击，左右，上下滑动等，展示图片，文本，动画等效果。

1，进入splash页面，有个loading动画效果，缩放，旋转。

![splash界面](https://github.com/duqian291902259/weex-demo-dusan/blob/master/screenshot/page-splash.png)

2，自动（点击）进入用户向导，左右滑动切换（自动切换），索引，点击立即体验。

![用户向导pages](https://github.com/duqian291902259/weex-demo-dusan/blob/master/screenshot/page-guide.png)

3，home界面简单，仅做演示。后续完善login，网络交互等更复杂的场景。

![home界面](https://github.com/duqian291902259/weex-demo-dusan/blob/master/screenshot/page-home.png)

### Future 
demo虽小，也能显现weex项目的结构和特点，三端统一，write once，run everywhere.sdk逐步完善，满足各种场景交互，动画，事件等。

早期相关博文：

[1，Weex开源测试之环境搭建，weex未来展望](http://blog.csdn.net/dzsw0117/article/details/51702319)

[2，Weex开发笔记](http://blog.csdn.net/dzsw0117/article/details/51773175)


### Thanks to weex team！
Weex，I will follow you!