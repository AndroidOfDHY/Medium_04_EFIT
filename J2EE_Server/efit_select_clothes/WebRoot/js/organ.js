/**初始化当前的机构关联表*/
var _user;
var _orgcache = [];
var _current;
(function(){
	if (window.Organ)return;
	window.Organ={
		init:function(orgId){
			$.getJSON(contentPath+"/setting/user.do",{"act":"queryUser","rd":new Date()},function(json){
				if(json.errorInfo){
					alert(json.errorInfo);
					//JSON.stringify(a);
				}else{
					_user = json;
					App.logJson("当前登录用户: ",json);
					if(App.isEmpty(orgId)){
						Organ.createSelect(json.orgId);
					}else{
						App.log("初始化当前用户:"+orgId);
						Organ.createSelect(orgId);
					}
				}
			});
		},
		createSelect:function(orgId){
			if(App.isEmpty(orgId))return;
			$.getJSON(contentPath+"/organization.do",{"act":"json","rd":new Date()},function(json){
				if(json.errorInfo){
					alert(json.errorInfo);
					return null;
				}
				//缓冲
				_orgcache = json.data;
				_user = Organ.get(_user.orgId);
				App.logJson("当前用户所处级别: ",_user);
				//当前根对象
				_current = Organ.get(orgId);
				//根对象数组
				var parents = new Array();
				var forId = orgId;
				while(true){
					var item = Organ.get(forId);
					App.logJson("初始化父节点对象",item);
					parents.push(item);
					if(item.parentId != 0){
						forId = item.parentId;
						continue;
					}else{
						break;
					}
				}
				parents.reverse();
				for(var i=0;i<parents.length;i++){
					var item = parents[i];
					App.log("创建Select: org_"+item.depth);
					$("#orgbox").append("<select name='org_"+item.depth+"' id='org_"+item.depth+"' style='200px'></select>");
					var sel = $("#org_"+item.depth);
					//初始化数据
					Organ.fillBrothers(item,sel);
					App.log("当前对象>>"+item.depth + " , user: "+ _user.depth);
					if(item.depth < (_user.depth+1)){
						sel.attr("disabled","disabled");
					}
				}
				//初始化子节点
				App.log("当前节点是否还有下一级: "+(_current.isLeaf==true?"是叶子节点,没有了":"还有节点"));
				if(_current.isLeaf==false){
					Organ.createChildren(_current);
				}
				//初始化完成
				$("#orgId").val(_current.id);
			});
		},
		fillBrothers:function(item,sel){
			if(item.depth>0){
				sel.append("<option value='-1'>--</option>");
			}
			for(var key in _orgcache){
				var model = _orgcache[key];
				if(model.parentId == item.parentId){
					sel.append("<option value='"+model.id+"' "+(model.id==item.id?"selected":"")+">"+model.name+"</option>");
				}
			}
			//绑定事件
			sel.change(function(){Organ.change(this);});
		},
		createChildren:function(current){
			var nextDepth = current.depth+1;
			App.log("创建下一级Select: org_"+nextDepth);
			var sel = $("#org_"+nextDepth);
			if(sel.length > 0){
				//已经存在子节点了
				//alert("已经存在子节点了");
				//var nextSelect = document.getElementById("org_"+nextDepth);
				//alert("删除节点选项: "+ nextSelect.options.length);
				//if(nextSelect.options.length>1)for(var i = nextSelect.options.length-1; i>=0; i--) nextSelect.options[i] = null;
				//nextSelect.options.length = 0;
				sel.attr("disabled",(current.isLeaf==true?"disabled":""));
				//alert("执行成功");
			}else{
				//alert("创建: #org_"+nextDepth);
				$("<select name='org_"+nextDepth+"' id='org_"+nextDepth+"' style='200px'></select>").appendTo($("#orgbox"));
				sel = $("#org_"+nextDepth);
				//绑定事件
				sel.change(function(){Organ.change(this);});
			}
			//$("<option value='-1'>--</option>").appendTo($("#org_"+nextDepth));
			var topOption = new Option("--","-1");
			var selEl = document.getElementById("org_"+nextDepth);
			selEl.options.length = 0;//清空
			selEl.options.add(topOption);
			for(var key in _orgcache){
				var model = _orgcache[key];
				if(model.parentId == current.id){
					var varItem = new Option(model.name,model.id);
        			selEl.options.add(varItem);
					//$("<option value='"+model.id+"'>"+model.name+"</option>").appendTo($("#org_"+nextDepth));
				}
			}
		},
		change:function(obj){
			var select = $(obj);
			var orgId = select.val();
			if(orgId==-1 || orgId=="" || orgId == null){
				App.log("选择了顶级");
				//找上级ID
				var prev = select.prev("select");
				orgId = prev.val();
				//下级清空
				var next = select.next("select");
				if(next.length>0)next.attr("disabled","disabled");
			}else{
				var model = Organ.get(orgId);
				App.log("是否创建下一级: "+(model.isLeaf?"否":"是"));
				if(model.isLeaf==false){
					Organ.createChildren(model);
				}else{
					var next = $("#org_"+(model.depth+1));
					if(next.length>0){
						next.val(-1);
						next.attr("disabled","disabled");
					}
				}
			}
			_current = Organ.get(orgId);
			$("#orgId").val(_current.id);
			App.logJson("当前系统设置的ORG_ID：",_current);
		},
		get:function(orgId){
			for(var key in _orgcache){
				var model = _orgcache[key];
				if(model.id==orgId)return model;
			}
			return null;
		}
	}
})();