// { "framework": "Vue" }
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
/***/ (function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = []

	/* styles */
	__vue_styles__.push(__webpack_require__(1)
	)

	/* script */
	__vue_exports__ = __webpack_require__(2)

	/* template */
	var __vue_template__ = __webpack_require__(3)
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
	__vue_options__.__file = "E:\\weex\\hlw\\src\\index.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
	__vue_options__._scopeId = "data-v-44c44b1f"
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


/***/ }),
/* 1 */
/***/ (function(module, exports) {

	module.exports = {
	  "add-button": {
	    "position": "absolute",
	    "top": 100,
	    "left": 0
	  },
	  "modal": {
	    "width": 600,
	    "height": 600,
	    "backgroundColor": "#FFFF00",
	    "position": "absolute",
	    "top": 0,
	    "left": 150
	  },
	  "jian-button": {
	    "position": "absolute",
	    "top": 100,
	    "left": 350,
	    "fontSize": 50,
	    "color": "#FF0000",
	    "textAlign": "center",
	    "borderWidth": 2,
	    "borderColor": "#008000",
	    "borderStyle": "solid"
	  },
	  "wrapper": {
	    "alignItems": "center",
	    "backgroundColor": "rgba(0,0,0,0)"
	  },
	  "title": {
	    "position": "absolute",
	    "top": 0,
	    "left": 0,
	    "fontSize": 50,
	    "color": "#FF0000"
	  },
	  "logo": {
	    "width": 200,
	    "height": 200
	  },
	  "desc": {
	    "paddingTop": 20,
	    "color": "#888888",
	    "fontSize": 24
	  }
	}

/***/ }),
/* 2 */
/***/ (function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
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

	var modal = weex.requireModule('modal');
	exports.default = {
	    data: {
	        logoUrl: 'http://pic.yupoo.com/56gee/BOGEdmua/nlZs8.jpg',
	        target: 'World',
	        imgCount: 100,
	        showModal: false,
	        step: 20,
	        pics: ['http://up.nonolive.com/sg/nonolive/nnimgs/f617b62637ae501c826a941a7bd8d3d2', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/e58f3f4ea42673949a1b21e94c15e044', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/ba7faf4f3c6426233b24b501146c4627', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/805087606f358ef35dac198f2a1fe69d', 'http://up.nonolive.com/sg/nonolive/nnimgs/abbb780bf57dc52ade03ba6e1cf80961', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/71024479934164c6f84c25a5147c6f6b', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/8da779be6345da9f19e244c90b224247', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/3bbb32f21a6cae35e3acd150732860b1', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/dec60ffe213275db3cab3f0d2cbf345a', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/c247e89cbae182b19ec4b3682ab122cb', 'http://up.nonolive.com/sg/nonolive/nnimgs/5f725a8f94965951a44f00fa4a20cb29', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/e6ee752828cfa7d83eb38e494089d934', 'http://up.nonolive.com/sg/nonolive/nnimgs/9dd5bcde0ef32af023d8ec8f7df61c2d', 'http://up.nonolive.com/sg/nonolive/nnimgs/bde405158f65fbae56ab6ea449ceee4b', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/2902a0a8db060bac8ef9c5e415a55cf9', 'http://fra.up.nonolive.com/de0b105b49f7972c5fdaae7bda8a3474', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/99992a7a61456622e2c1c2546bf537bf', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/581e7b6ab24a5763d132b4fd5f3921b0', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/2d09c0d354877bc3ef988f8215f8c810', 'http://up.nonolive.com/sg/nonolive/nnimgs/d1196c8eb547008cd99529de1fdc6b24', 'http://up.nonolive.com/sg/nonolive/nnimgs/e709f7f9f83c1013c4c093e27b69c184', 'http://up.nonolive.com/sg/nonolive/nnimgs/ed94a019cfe1d693d6d5075358aec29a', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/b63fc3b5c3f794e58fb7b8572ecc94ae', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/6382bb5959fd9f2e3fdb48bb6d7d5a06', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/ff1dc777840d9b96b093cd9418d75001', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/8b7b11c29a14d27fb01e9f2350804ece', 'http://up.nonolive.com/sg/nonolive/nnimgs/a747b572d60234f6eef1e94a731c8c25', 'http://up.nonolive.com/sg/nonolive/nnimgs/90a14cbcc685b18d9f2007077f507f2d', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/1006847485f3f6e6d09e37ad10b5c7f5', 'http://up.nonolive.com/sg/nonolive/nnimgs/e3a593cfebdbd5e06e70c2f974ca3272', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/f6e21b62ccfa80a799b673f05b0c5d8c', 'http://fra.up.nonolive.com/8b736606da1c5a3e366ae2cb6580c8b2', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/4b054285ac0ef1e3033cfc96053ca373', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/c08d9f9093b16434738b5d4f238c015b', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/8f5f54ed4236b035c65e938b53b78ef1', 'http://up.nonolive.com/sg/nonolive/nnimgs/e2b2d2fee63019a51706f3493f9dc357', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/418d358647a98042e4f6cfae282073f5', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/52f0292e97c0a550046e728b22887261', 'http://up.nonolive.com/sg/nonolive/nnimgs/c354ccce24fa8bf772f45d7b3d1f3b65', 'http://up.nonolive.com/sg/nonolive/nnimgs/e979067200fb81015d70edef0e12355f', 'http://up.nonolive.com/sg/nonolive/nnimgs/34dbc4a5ff8dff88430492c33fbb4b10', 'http://up.nonolive.com/sg/nonolive/nnimgs/6e35d4d77d588f64cd99030f623a96e9', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/29f115d7096ce57ccf1705d6079f4208', 'http://up.nonolive.com/sg/nonolive/nnimgs/9c26b1f003f4df5befbcc37b2cc92dc7', 'http://up.nonolive.com/sg/nonolive/nnimgs/e380b60a0fa932b2ae0761030e7e7878', 'http://up.nonolive.com/sg/nonolive/nnimgs/17923914338fcb57cc699d071e889498', 'http://up.nonolive.com/sg/nonolive/nnimgs/f42db37b170e8698f3405e68301e44a8', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/2e06252aa4eb5f27bfa96949731b44f6', 'http://up.nonolive.com/sg/nonolive/nnimgs/cdd304e288786a63eac8e7ac210c7845', 'http://up.nonolive.com/sg/nonolive/nnimgs/fdea4fc4338b20c4e69d10d676becd51', 'http://up.nonolive.com/sg/nonolive/nnimgs/1235d73ff94d3e78a815e4ae47c4e53b', 'http://fra.up.nonolive.com/3f1a0d5adc585e9348e3012d52d1f6f6', 'http://fra.up.nonolive.com/eb201db6f1922e81d37cb5345724c11a', 'http://up.nonolive.com/sg/nonolive/nnimgs/0f7c1994289144304601721631377876', 'http://up.nonolive.com/sg/nonolive/nnimgs/a83f46726b88686deb84df4e6cd1d306', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/cda68067a1b6b30a11c3745422af1836', 'http://up.nonolive.com/sg/nonolive/nnimgs/8525264e80b4cd8527ebf2311a70eba8', 'http://up.nonolive.com/sg/nonolive/nnimgs/10bd6c67001bffea75a352a444e951a8', 'http://up.nonolive.com/sg/nonolive/nnimgs/b14dcdd523473c217bb7fde55d258c34', 'http://up.nonolive.com/sg/nonolive/nnimgs/465626adde28560f27ffebd7294d0e35', 'http://up.nonolive.com/sg/nonolive/nnimgs/3aeee5807a9a78894808804a41edef00', 'http://up.nonolive.com/sg/nonolive/nnimgs/3861814f4fde9a141e63ea2f44cc82c3', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/f5f51beed97a5fae3cdf78cb6b069fc4', 'http://up.nonolive.com/sg/nonolive/nnimgs/96bfacdcd8b217d0b4e4a5376a23281c', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/523c0d4e02a684d85071a74d49a0c098', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/9aeaefad8e972b9851000ca6577d56cd', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/6da8830b1f96e9cc092b38c517c511a9', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/03837a41f204d81566fa2b0026aeba06', 'http://up.nonolive.com/sg/nonolive/nnimgs/3d493962426857ac5963f149347b51d6', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/ccd7bed9960f6d20b6180b6e36041c5f', 'http://up.nonolive.com/sg/nonolive/nnimgs/cda2b150c9a639ba90ff114e68d97e08', 'http://up.nonolive.com/sg/nonolive/nnimgs/8d5d99b1fc8ebe69e804000e6a6362dd', 'http://up.nonolive.com/sg/nonolive/nnimgs/687ee0ea4f57db2de76d86f545f51c50', 'http://up.nonolive.com/sg/nonolive/nnimgs/21ac15d69ad58a8a56e8fc1e1ca6b77b', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/7d2172b5353b2b4aae33cc3e7419eb11', 'http://up.nonolive.com/sg/nonolive/nnimgs/44b74b597789c07495d040951935b007', 'http://up.nonolive.com/sg/nonolive/nnimgs/c8036bdf99115e0cf938a84e62796321', 'http://up.nonolive.com/sg/nonolive/nnimgs/0bd4919efbcd0fe7f381f3837e179aba', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/b1de93d9f0d2f13ab282fbce188880c8', 'http://up.nonolive.com/sg/nonolive/nnimgs/b66a38aea362db3c61069fd943121fc1', 'http://up.nonolive.com/sg/nonolive/nnimgs/3cad38eb9c779d73a4770c660bd5060c', 'http://up.nonolive.com/sg/nonolive/nnimgs/4ea71c91779fc8547da9d6f74b3f9744', 'http://up.nonolive.com/sg/nonolive/nnimgs/480b3825c8063c08a692c343004c149d', 'http://up.nonolive.com/sg/nonolive/nnimgs/d6a23bd807a04d023557d9fb3491750c', 'http://up.nonolive.com/sg/nonolive/nnimgs/4178e91a4af569a2fb4ed0b93ec9316d', 'http://fra.up.nonolive.com/2b93db4f335117e8ad302c8e5f96daa3', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/242c2603a9f74e02c10c9d97465438d7', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/66e4a1b5f4c9d91b8152486f7a656536', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/b84ca4c817ae6722f9dd21560f3062b7', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/66a7d915534bb3ed9af2ad4d7fd87c46', 'http://up.nonolive.com/sg/nonolive/nnimgs/a0039f31bbf57532da7bb7516fa7be7b', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/27d30dd62bfee9697f02b8d148028e53', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/f5ec880bda900fdcbfc5272653ac619a', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/ebfa6ca8527cb45aec72717a57d1d91a', 'http://up.nonolive.com/sg/nonolive/nnimgs/c7deb7022b0d8d2602a751756b5859fd', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/ef4d7a6b1e285c83f4c01d7e018cde6d', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/8ab98601a04c4959f9d67bbb7b3c53e7', 'http://up.nonolive.com/sg/nonolive/nnimgs/975b27745a5d652cbaa603682dbea58b', 'http://up.nonolive.com/sg/nonolive/nnimgs/0ed69f435bce6d7dd840ec4a775f3bc9', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/1f21fdab8dfe96ab3ee64d5162cf075d', 'http://up.nonolive.com/sg/nonolive/nnimgs/6e941f779eb11cfab73bc8e7683dd303', 'http://up.nonolive.com/sg/nonolive/nnimgs/c1874d690f468c604aa7245d0c247672', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/113eba53bda9efb84bba4aa25160a9a8', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/88e6c07b24cfaa2edbdd1f233ac67277', 'http://up.nonolive.com/sg/nonolive/nnimgs/55cd3c7d415fc067688664ed44e58e99', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/58a3bc1595bc88b98421cb2d035ab237', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/decdaa47468e7bc16ffde1f20a75ee22', 'http://up.nonolive.com/sg/nonolive/nnimgs/ddec5603613a5283d1cb6c26535c9384', 'http://fra.up.nonolive.com/fra/nonolive-fra/nnimgs/9d6514a58c19c7e6c70ecfc456dc5843']
	    },
	    methods: {
	        add: function add(e) {
	            this.imgCount += this.step;
	        },
	        toggleModal: function toggleModal() {
	            this.showModal = !this.showModal;
	        },
	        jian: function jian(e) {
	            if (this.imgCount >= this.step) {
	                this.imgCount -= this.step;
	            }
	        }
	    }
	};
	module.exports = exports['default'];

/***/ }),
/* 3 */
/***/ (function(module, exports) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
	  return _c('div', {
	    staticClass: ["wrapper"]
	  }, [_c('div', {
	    staticClass: ["add-button"],
	    on: {
	      "click": _vm.toggleModal
	    }
	  }, [_c('image', {
	    staticClass: ["logo"],
	    attrs: {
	      "src": "https://image.ibb.co/fnuxb6/charity_gen.png"
	    }
	  })]), (_vm.showModal) ? _c('div', {
	    staticClass: ["modal"]
	  }) : _vm._e(), _c('text', {
	    staticClass: ["title"]
	  }, [_vm._v("showModal " + _vm._s(_vm.showModal))])])
	},staticRenderFns: []}
	module.exports.render._withStripped = true

/***/ })
/******/ ]);