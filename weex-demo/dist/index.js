// { "framework": "Vue"} 

/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// identity function for calling harmony imports with the correct context
/******/ 	__webpack_require__.i = function(value) { return value; };
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 10);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */,
/* 1 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

const myMoudle = weex.requireModule("MyMoudle");
const modal = weex.requireModule("modal");
var navigator = weex.requireModule("navigator");

var globalEvent = weex.requireModule("globalEvent");
globalEvent.addEventListener("testEvent", function (e) {
  console.log("get testEvent");
  modal.toast({
    message: "weex js收到了Native的 " + e.key,
    duration: 1
  });
});
/* harmony default export */ __webpack_exports__["default"] = ({
  data: {
    logoUrl: "http://img1.vued.vanthink.cn/vued08aa73a9ab65dcbd360ec54659ada97c.png",
    target: "Weex"
  },
  methods: {
    update() {
      console.log("update");
      this.target = "Nono";
      console.log("target:", this.target);

      modal.toast({
        message: "update weex 2 nono",
        duration: 1
      });
    },
    jump(event) {
      console.log("will jump");
      navigator.push({
        //http://192.168.0.68:8081/dist/hello.js
        url: "http://dotwe.org/raw/dist/6fe11640e8d25f2f98176e9643c08687.bundle.js", //web用 http://192.168.0.68:8081/web/index.html?page=/dist/hello.js
        animated: "false"
      }, event => {
        modal.toast({ message: "callback: " + event });
      });
    },
    sendMsg() {
      console.log("sendMsg");
      myMoudle.sendMessage("weex发送指令给native");
      myMoudle.openPageByUrl("http://dotwe.org/raw/dist/6fe11640e8d25f2f98176e9643c08687.bundle.js");

      modal.toast({
        message: "sendMsg 2 native",
        duration: 1
      });
    }
  }
});

/***/ }),
/* 2 */,
/* 3 */
/***/ (function(module, exports) {

module.exports = {
  "wrapper": {
    "alignItems": "center",
    "height": 1000,
    "backgroundColor": "#888888",
    "paddingTop": 50
  },
  "title": {
    "paddingTop": 20,
    "paddingBottom": 20,
    "fontSize": 35,
    "color": "#FAEBD7"
  },
  "logo": {
    "width": 360,
    "height": 156,
    "marginTop": 50
  },
  "desc": {
    "paddingTop": 20,
    "color": "#F0FFFF",
    "fontSize": 24
  },
  "btn": {
    "width": 350,
    "backgroundColor": "#FAEBD7",
    "marginTop": 10,
    "marginBottom": 10,
    "alignItems": "center",
    "textAlign": "center",
    "paddingTop": 10,
    "paddingRight": 10,
    "paddingBottom": 10,
    "paddingLeft": 10
  }
}

/***/ }),
/* 4 */,
/* 5 */,
/* 6 */
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: ["wrapper"],
    on: {
      "load": _vm.update
    }
  }, [_c('image', {
    staticClass: ["logo"],
    attrs: {
      "src": _vm.logoUrl
    }
  }), _c('text', {
    staticClass: ["title"],
    on: {
      "click": _vm.update
    }
  }, [_vm._v("Hello DuQian, " + _vm._s(_vm.target) + " Up!")]), _c('text', {
    staticClass: ["desc"]
  }, [_vm._v("Now, let's use vue to build weex app.")]), _c('button', {
    staticClass: ["btn"],
    on: {
      "click": _vm.update
    }
  }, [_vm._v("点我测试toast")]), _c('a', {
    attrs: {
      "href": "http://192.168.0.68:8081/dist/hello.js"
    }
  }, [_c('button', {
    staticClass: ["btn"],
    on: {
      "click": _vm.sendMsg
    }
  }, [_vm._v("a链接")])], 1), _c('button', {
    staticClass: ["btn"],
    on: {
      "click": _vm.jump
    }
  }, [_vm._v("测试页面跳转")]), _c('input', {
    attrs: {
      "value": "text"
    }
  })], 1)
},staticRenderFns: []}
module.exports.render._withStripped = true

/***/ }),
/* 7 */,
/* 8 */,
/* 9 */,
/* 10 */
/***/ (function(module, exports, __webpack_require__) {

var __vue_exports__, __vue_options__
var __vue_styles__ = []

/* styles */
__vue_styles__.push(__webpack_require__(3)
)

/* script */
__vue_exports__ = __webpack_require__(1)

/* template */
var __vue_template__ = __webpack_require__(6)
__vue_options__ = __vue_exports__ = __vue_exports__ || {}
if (
  typeof __vue_exports__.default === "object" ||
  typeof __vue_exports__.default === "function"
) {
if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
__vue_options__ = __vue_exports__ = __vue_exports__.default
}
if (typeof __vue_options__ === "function") {
  __vue_options__ = __vue_options__.options
}
__vue_options__.__file = "/Users/duqian/Development/MyGitHub/weex-demo-dusan/weex-demo/src/index.vue"
__vue_options__.render = __vue_template__.render
__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
__vue_options__._scopeId = "data-v-37904d4e"
__vue_options__.style = __vue_options__.style || {}
__vue_styles__.forEach(function (module) {
  for (var name in module) {
    __vue_options__.style[name] = module[name]
  }
})
if (typeof __register_static_styles__ === "function") {
  __register_static_styles__(__vue_options__._scopeId, __vue_styles__)
}

module.exports = __vue_exports__
module.exports.el = 'true'
new Vue(module.exports)


/***/ })
/******/ ]);