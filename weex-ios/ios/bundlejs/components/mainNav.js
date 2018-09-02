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
/******/ 	return __webpack_require__(__webpack_require__.s = 14);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */,
/* 1 */,
/* 2 */,
/* 3 */,
/* 4 */
/***/ (function(module, exports, __webpack_require__) {

var __vue_exports__, __vue_options__
var __vue_styles__ = []

/* styles */
__vue_styles__.push(__webpack_require__(5)
)

/* script */
__vue_exports__ = __webpack_require__(6)

/* template */
var __vue_template__ = __webpack_require__(7)
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
__vue_options__.__file = "/Users/duqian/Downloads/ximelly/weex/src/components/mainNav.vue"
__vue_options__.render = __vue_template__.render
__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
__vue_options__._scopeId = "data-v-64cd49ca"
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


/***/ }),
/* 5 */
/***/ (function(module, exports) {

module.exports = {
  "container": {
    "backgroundColor": "#ffffff"
  },
  "imageList": {
    "flexDirection": "row",
    "height": "160",
    "marginTop": "20"
  },
  "imageIcon": {
    "flex": 1,
    "justifyContent": "center",
    "alignItems": "center"
  },
  "image": {
    "width": "90",
    "height": "90"
  },
  "textOut": {
    "marginTop": "20"
  },
  "text": {
    "fontSize": "26"
  }
}

/***/ }),
/* 6 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


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
//
//
//

module.exports = {
  data: function data() {
    var imageHead = 'https://img2.mama100.com/o2oHomePage/201712/2c918082604496630160530c57';
    var textList = ['积分商城', '跨境购', '天天赚', '超级礼遇', '百分妈妈课堂', '孕育工具', '问专家', '在线咨询'];
    var imageList = [];
    var imageLast = ['440057', '4b0058', '4d0059', '51005a', '61005b', '64005c', '73005d', '76005e'];
    for (var i = 0; i < textList.length; i++) {
      imageList.push({ index: i, url: imageHead + imageLast[i] + '.png', imageText: textList[i] });
    }
    return {
      imageList: imageList
    };
  }
};

/***/ }),
/* 7 */
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: ["container"]
  }, [_c('div', {
    staticClass: ["imageList"]
  }, _vm._l((_vm.imageList), function(item) {
    return (item.index <= 3) ? _c('div', {
      key: item.index,
      staticClass: ["imageIcon"]
    }, [_c('image', {
      staticClass: ["image"],
      attrs: {
        "src": item.url
      }
    }), _c('div', {
      staticClass: ["textOut"]
    }, [_c('text', {
      staticClass: ["text"],
      attrs: {
        "lines": "1"
      }
    }, [_vm._v(_vm._s(item.imageText))])])]) : _vm._e()
  })), _c('div', {
    staticClass: ["imageList"]
  }, _vm._l((_vm.imageList), function(item) {
    return (item.index > 3) ? _c('div', {
      key: item.index,
      staticClass: ["imageIcon"]
    }, [_c('image', {
      staticClass: ["image"],
      attrs: {
        "src": item.url
      }
    }), _c('div', {
      staticClass: ["textOut"]
    }, [_c('text', {
      staticClass: ["text"],
      attrs: {
        "lines": "1"
      }
    }, [_vm._v(_vm._s(item.imageText))])])]) : _vm._e()
  }))])
},staticRenderFns: []}
module.exports.render._withStripped = true

/***/ }),
/* 8 */,
/* 9 */,
/* 10 */,
/* 11 */,
/* 12 */,
/* 13 */,
/* 14 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _mainNav = __webpack_require__(4);

var _mainNav2 = _interopRequireDefault(_mainNav);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

_mainNav2.default.el = '#root';
new Vue(_mainNav2.default);

/***/ })
/******/ ]);