/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports) {

	;__weex_define__("@weex-component/e8a531af45f7e9d8c44661bbcb1a5551", [], function(__weex_require__, __weex_exports__, __weex_module__){

	;
	__weex_module__.exports = {
	    data: function () {return {
	      txt:"开始体验-DusanWeex",
	      intervalValue:"1000",
	      isShowIndicators:"true",
	      isAutoPlay:"true",
	      itemList: [
	        {title: 'A', pictureUrl: 'https://duqian291902259.github.io/dusan/oair/bg1.png'},
	        {title: 'B', pictureUrl: 'https://duqian291902259.github.io/dusan/oair/bg2.png'},
	        {title: 'C', pictureUrl: 'https://duqian291902259.github.io/dusan/oair/bg1.png'}
	      ]
	    }},
	    methods: {
	      goNext: function () {
	         this.$openURL('http://192.168.100.47:8080/index.html?page=./src/build/home.js')
	         //this.$openURL('http://192.168.100.47:8080/src/build/home.js');
	      }
	    }
	}

	;__weex_module__.exports.template = __weex_module__.exports.template || {}
	;Object.assign(__weex_module__.exports.template, {
	  "type": "div",
	  "classList": [
	    "wrap"
	  ],
	  "children": [
	    {
	      "type": "slider",
	      "classList": [
	        "slider"
	      ],
	      "attr": {
	        "interval": function () {return this.intervalValue},
	        "autoPlay": function () {return this.isAutoPlay}
	      },
	      "children": [
	        {
	          "type": "indicator",
	          "classList": [
	            "indicator"
	          ]
	        },
	        {
	          "type": "div",
	          "classList": [
	            "slider-pages"
	          ],
	          "repeat": function () {return this.itemList},
	          "events": {
	            "click": "goNext"
	          },
	          "children": [
	            {
	              "type": "image",
	              "classList": [
	                "thumb"
	              ],
	              "attr": {
	                "src": function () {return this.pictureUrl},
	                "resize": "stretch"
	              }
	            }
	          ]
	        }
	      ]
	    },
	    {
	      "type": "text",
	      "classList": [
	        "btn"
	      ],
	      "events": {
	        "click": "goNext"
	      },
	      "attr": {
	        "value": function () {return this.txt}
	      }
	    }
	  ]
	})
	;__weex_module__.exports.style = __weex_module__.exports.style || {}
	;Object.assign(__weex_module__.exports.style, {
	  "wrap": {
	    "alignItems": "center",
	    "justifyContent": "center",
	    "flexDirection": "column",
	    "backgroundColor": "#2B2D2F"
	  },
	  "slider": {
	    "margin": 0,
	    "width": 750,
	    "height": 1000,
	    "backgroundColor": "rgba(0,0,0,0)",
	    "alignItems": "center",
	    "justifyContent": "center"
	  },
	  "thumb": {
	    "width": 720,
	    "height": 1280,
	    "alignItems": "center",
	    "justifyContent": "center"
	  },
	  "slider-pages": {
	    "flexDirection": "row",
	    "width": 720,
	    "height": 1000,
	    "alignItems": "center",
	    "justifyContent": "center"
	  },
	  "indicator": {
	    "position": "absolute",
	    "top": 970,
	    "width": 720,
	    "height": 30,
	    "itemColor": "#dddddd",
	    "itemSelectedColor": "rgb(40, 96, 144)"
	  },
	  "btn": {
	    "width": 300,
	    "height": 60,
	    "marginTop": 20,
	    "backgroundColor": "#0096FF",
	    "fontSize": 25,
	    "fontWeight": "bold",
	    "alignItems": "center",
	    "justifyContent": "center",
	    "borderRadius": 50,
	    "color": "#FFFFFF"
	  }
	})
	})
	;__weex_bootstrap__("@weex-component/e8a531af45f7e9d8c44661bbcb1a5551", {
	  "transformerVersion": "0.3.1"
	},undefined)

/***/ }
/******/ ]);