## About

weex demos by duqian2010@gmail.com

## Commands

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

Project is running at http://192.168.0.68:8081/

preview your page like:
http://192.168.0.68:8081/web/index.html?page=/dist/web/index.js

### weex debug

```
cd path/to/src/
weex debug index.vue
```

### duqian2010@gmail.com

