# weex-demo-dusan
![splash](https://duqian291902259.github.io/dusan/weex/weex-demo-dusan.gif)

## How to start
This demo is based on weex.
so,you should ensure that installed the environment of weex ,A framework for building Mobile cross-platform UI: [http://alibaba.github.io/weex](http://alibaba.github.io/weex)

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
开启server后，浏览器输入http://localhost:8080/，查看首页。localhost改为自己电脑的ip地址，方便pc和app中查看效果。

－－－build后的目标代码，将对应的url生成二维码后，用官方的playground扫描二维码，可以在app中渲染：

http://192.168.100.47:8080/src/build/main.js

－－－浏览器中预览页面效果：

http://192.168.100.47:8080/index.html?page=./src/build/main.js


---

### Overview 
接触了一下weex，是不是感觉666？该demo仅用weex实现了splash，guide，home页面，交互主要是点击，左右，上下滑动。

1，进入splash页面，有个loading动画效果，缩放，旋转。
![splash](https://duqian291902259.github.io/dusan/weex/page-splash.png)

2，自动（点击）进入用户向导，左右滑动切换（自动切换），索引，点击立即体验。

![splash](https://duqian291902259.github.io/dusan/weex/page-guide.png)


3，home界面简单，仅做演示。后续完善login，网络交互等更复杂的场景。

![splash](https://duqian291902259.github.io/dusan/weex/page-home.png)

### Future 
demo虽小，也能显现weex项目的结构和特点，三端统一，write once，run everywhere.有常见的移动端交互，动画，事件。

weex的强大之处，有待研究，后续完善。

### Thanks to weex team！
Weex，I will follow you!