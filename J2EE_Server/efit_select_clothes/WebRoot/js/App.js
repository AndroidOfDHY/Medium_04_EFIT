/**
 * 定义框架基础命名空间
 */
window.undefined = window.undefined;
App = {
	//定义框架App的版本
	version:'.0.0',
	debug:false,
	browser:"ie"
};
/**
 * 继承方法
 * @param o 被继承的载体
 * @param c 要继承的方法
 * @param 默认
 */
App.apply = function(o,c,defaults){
    if(defaults){
        App.apply(o,defaults);
    }
    if(o && c && typeof c == 'object'){
        for(var p in c){
            o[p] = c[p];
        }
    }
    return o;
};
(function(){
	var toString = Object.prototype.toString;
	App.apply(App,{
		//定义命名控件
	    ns:function(){
	        var o, d;
	        App.each(arguments, function(v) {
	            d = v.split(".");
	            o = window[d[0]] = window[d[0]] || {};
	            App.each(d.slice(1), function(v2){
	                o = o[v2] = o[v2] || {};
	            });
	        });
	        return o;
	    },
		//打印日志
		log:function(){
			if(App.debug){
				var ars = Array.prototype.slice.call(arguments);
				if(ars && ars.length>0)console.log(ars.join('==='));
			}
		},
		logJson:function(){
			if(App.debug){
				var ars = Array.prototype.slice.call(arguments);
				var str = "";
				for(var key in ars){
					if(typeof ars[key]=="string"){
						str+=ars[key];
					}else{
						str+=JSON.stringify(ars[key]);
					}
				}
				App.log(str);
			}
		},
	    //控制显示方式
	    display:function(){
			if(arguments.length==1){
				$("#"+arguments[0]).show();
			}else if(arguments.length==2){
				if(arguments[1]){
					$("#"+arguments[0]).show();
				}else{
					$("#"+arguments[0]).hide();
				}
			}
	    },
		isEmpty:function(v,allowBlank){
			return v === null || v === undefined || ((App.isArray(v) && !v.length)) || (!allowBlank ? v === '' : false);
		},
		isArray : function(v){
		    return toString.apply(v) === '[object Array]';
		},
		isDate : function(v){
		    return toString.apply(v) === '[object Date]';
		},
		isObject : function(v){
		    return !!v && Object.prototype.toString.call(v) === '[object Object]';
		},
		isPrimitive : function(v){
		    return App.isString(v) || App.isNumber(v) || App.isBoolean(v);
		},
		isFunction : function(v){
		    return toString.apply(v) === '[object Function]';
		},
		isNumber : function(v){
		    return typeof v === 'number' && isFinite(v);
		},
		isString : function(v){
		    return typeof v === 'string';
		},
		isBoolean : function(v){
		    return typeof v === 'boolean';
		},
		isElement : function(v) {
		    return v ? !!v.tagName : false;
		},
		isDefined : function(v){
		    return typeof v !== 'undefined';
		},
		getQueryStr:function(pars){
			var reg = new RegExp("(^|\\?|&)"+ pars +"=([^&]*)(\\s|&|$)", "i");
			if (reg.test(location.href))
			return unescape(RegExp.$2.replace(/\+/g," ")); return "";
		},
		isIterable : function(v){
            if(App.isArray(v) || v.callee){
                return true;
            }
            if(/NodeList|HTMLCollection/.test(toString.call(v))){
                return true;
            }
            return ((typeof v.nextNode != 'undefined' || v.item) && App.isNumber(v.length));
        },
        extend:function(){
            var io = function(o){
                for(var m in o){
                    this[m] = o[m];
                }
            };
            var oc = Object.prototype.constructor;
            return function(sb, sp, overrides){
                if(typeof sp == 'object'){
                    overrides = sp;
                    sp = sb;
                    sb = overrides.constructor != oc ? overrides.constructor : function(){sp.apply(this, arguments);};
                }
                var F = function(){}, sbp, spp = sp.prototype;
                F.prototype = spp;
                sbp = sb.prototype = new F();
                sbp.constructor=sb;
                sb.superclass=spp;
                if(spp.constructor == oc){
                    spp.constructor=sp;
                }
                sb.override = function(o){
                    App.override(sb, o);
                };
                sbp.override = io;
                App.override(sb, overrides);
                sb.extend = function(o){App.extend(sb, o);};
                return sb;
            };
        }(),
        urlEncode : function(o, pre){
            var empty,
                buf = [],
                e = encodeURIComponent;

            App.iterate(o, function(key, item){
                empty = App.isEmpty(item);
                App.each(empty ? key : item, function(val){
                    buf.push('&', e(key), '=', (!App.isEmpty(val) && (val != key || !empty)) ? (App.isDate(val) ? App.encode(val).replace(/"/g, '') : e(val)) : '');
                });
            });
            if(!pre){
                buf.shift();
                pre = '';
            }
            return pre + buf.join('');
        },
        //对URL进行解码
        urlDecode : function(string, overwrite){
            if(App.isEmpty(string)){
                return {};
            }
            var obj = {},
                pairs = string.split('&'),
                d = decodeURIComponent,
                name,
                value;
            App.each(pairs, function(pair) {
                pair = pair.split('=');
                name = d(pair[0]);
                value = d(pair[1]);
                obj[name] = overwrite || !obj[name] ? value :
                            [].concat(obj[name]).concat(value);
            });
            return obj;
        },
        //遍历方法
	    each:function(array, fn, scope){
	        if(App.isEmpty(array, true)){
	            return;
	        }
	        if(!App.isIterable(array) || App.isPrimitive(array)){
	            array = [array];
	        }
	        for(var i = 0, len = array.length; i < len; i++){
	            if(fn.call(scope || array[i], array[i], i, array) === false){
	                return i;
	            };
	        }
	    },
		checkOneItem:function (obj){
		  var tagname=(arguments.length>1)?arguments[1]:'TR';
		  if(document.myform.checkAll.checked){
		    document.myform.checkAll.checked = document.myform.checkAll.checked&0;
		  }
		  var TB=TO=0;
		  for (var i=0;i<document.myform.elements.length;i++) {
		    var e = document.myform.elements[i];
		    if ((e.name != 'checkAll') && (e.type=='checkbox')) {
		      TB++;
		      if (e.checked) TO++;
		    }
		  }
		  document.myform.checkAll.checked=(TO==TB)?true:false;
		},
		/**选择所有**/
		checkAllItem:function(form){
		  var tagname=(arguments.length>1)?arguments[1]:'TR';
		  for (var i=0;i<form.elements.length;i++){
		    var e = form.elements[i];
		    if (e.name != 'checkAll' && e.disabled == false && e.type == 'checkbox') {
		      e.checked = form.checkAll.checked;
		    }
		  }
		},
		/***批量删除确认***/
		havaCheckedIds:function(){
			var idsArray = document.getElementsByName("ids");
			var doDelete=false;
			for(i=0;i<idsArray.length;i++){
				var element = idsArray[i];
				if(element.name != 'checkAll' && element.disabled == false && element.type == 'checkbox'){
					if(element.checked==true){
						doDelete=true;
						break;
					}
				}
			}
			if(!doDelete){
				App.alert("请选择！");
				return false;
			}
			return true;
		},
		/***批量删除确认***/
		checkDeleteIds:function (){
			return App.havaCheckedIds()&&App.checkDel();
		},
		waitInfo:function(){
			var message = arguments[0] || "系统正在运行中,请稍后...";
			ymPrompt.win({title:'程序运行中,请不要关闭窗口!!!',message:"<p style='padding:50px auto;margin:0 auto;text-align:center'>"+message+"</p>"})
		},
		alert:function(){
			var message = arguments[0] || "消息框";
			var handler = arguments[1] || function(){};
			ymPrompt.alert(message,null,null,'消息提示框',handler);
		},
		succeedInfo:function(){
			var message = arguments[0] || "操作成功";
			var handler = arguments[1] || function(){};
			ymPrompt.succeedInfo(message,null,null,"操作成功",handler)
		},
		errorInfo:function(){
			var message = arguments[0] || "操作失败";
			var handler = arguments[1] || function(){};
			ymPrompt.errorInfo(message,null,null,"操作失败",handler)
		}
	});
})()