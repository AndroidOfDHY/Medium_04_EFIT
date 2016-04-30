var orgData = [];
var _orgcache = [];
function initOrgan(){
	var setting = {callback:{beforeClick:input}};
	$.getJSON(contentPath+"/organization.do",{"act":"json","num":Math.random()},function(json){
		if(json.errorInfo){
			alert(json.errorInfo);
		}else{
			_orgcache = json.data;
			$.getJSON(contentPath+"/organization.do",{"act":"treeJson","num":Math.random()},function(msg){
				orgData = msg;
				$.fn.zTree.init($("#org_tree"),setting,msg);
			});
		}
	});
}
function input(){
	$("#showDiv").slideDown("fast");
	$("#editDiv").hide();
	var tree = arguments[1];
	var model = get(tree.id);
	App.logJson("当前选择的对象:",model);
	var parentModel = null;
	if(model.parentId>0){
		parentModel = get(model.parentId);
		$("#parentOrgName_s").val(parentModel.name);
		$("#parentBankId_s").val(parentModel.bankId);
	}else{
		$("#parentOrgName_s").val("-");
		$("#parentBankId_s").val("-");
	}
	$("#bankId_s").val(model.bankId);
	$("#orgName_s").val(model.name);
	$("#orgCode_s").val(model.orgCode);
	$("#orgId").val(model.id);
	$("#inputedit").attr("disabled","");
}
function get(orgId){
	for(var key in _orgcache){
		var model = _orgcache[key];
		if(model.id==orgId)return model;
	}
	return null;
}
/**显示添加**/
function showAdd(){
	var orgId = $("#orgId").val();
	if(orgId=="" || orgId==null){
		alert("请选择要添加机构的父机构!");
		return;
	}
	//initParent();
	var selEl = document.getElementById("parentId");
	selEl.options.length = 0;
	var varItem = document.createElement("option");
	var parModel = get(orgId);
	varItem.text=parModel.name;
	varItem.value=parModel.id;
	varItem.selected=true;
	selEl.options.add(varItem);
	$("#showDiv").slideUp("fast");
	$("#type").val("0");
	$("#bankId").val('');
	$("#orgName").val('');
	$("#orgCode").val('');
	$("#editDiv").show();
	$("#actName").val("添加");
}
/**显示更新*/
function showUpdate(){
	var orgId = $("#orgId").val();
	initParent();
	var model = get(orgId);
	App.logJson("当前选择的对象: ",model);
	$("#showDiv").slideUp("fast");
	$("#bankId").val(model.bankId);
	$("#orgName").val(model.name);
	$("#orgCode").val(model.orgCode);
	$("#editDiv").show();
	$("#type").val("1");
	$("#actName").val("修改");
}
function display(){
	$("#showDiv").slideDown("fast");
	$("#editDiv").hide();
}
function doUpdate(){
	var parentId =$("#parentId").find("option:selected").val();
	if($("#orgName").val()==""){
		App.errorInfo("请输入机构名称");return;
	}else if($("#bankId").val()==""){
		App.errorInfo("部门机构号");return;
	}
	var actName = $("#actName").val();
	if(!window.confirm("确定要"+actName+"吗？"))return;
	var els = $("#myform input");
	var data = {};
	$.each(els, function(i,n){
		var m = $(n);
		//App.log("设置:"+m.attr("id")+">>>>"+m.val());
		data[m.attr("id")]=m.val();
	});
	data["parentId"]=$("#parentId").val();
	data["act"]="addOrUpdate";
	if(data.type=="0"){
		data["orgId"]="0";
	}
	App.logJson("提交的数据: ",data);
	
	$.post(contentPath+"/organization.do",data,function(msg){
		eval("var json = "+msg);
		if(json.errorNo=="1"){
			App.succeedInfo(actName+"成功!",function(){window.location.reload();});
		}else if(json.errorNo=="-2"){
			App.errorInfo("你没有["+actName+"]权限!");
		}else{
			App.errorInfo(actName+"失败!");
		}
	});
}

function initParent(){
	var orgId = $("#orgId").val();
	var selModel = get(orgId);
	var selEl = document.getElementById("parentId");
	selEl.options.length = 0;
	if(selModel.parentId==0){
		var varItem = document.createElement("option");
		varItem.text="-";
		varItem.value="0";
		varItem.selected=true;
		selEl.options.add(varItem);
	}else{
		var parentModel = get(selModel.parentId);
		for(var key in _orgcache){
		var model = _orgcache[key];
			if(model.parentId==parentModel.parentId){
				var varItem ;
				var selected=get(orgId);
				if(selected.parentId==model.id){
					varItem = document.createElement("option");
					varItem.text=model.name;
					varItem.value=model.id;
					varItem.selected=true;
				}else{
					varItem = document.createElement("option");
					varItem.text=model.name;
					varItem.value=model.id;
				}
				selEl.options.add(varItem);
			}
		}
	}
}




function del() {
	var orgId = $('#orgId').val();
	if(orgId=="" || orgId==null){
		alert("请选择要删除的机构!");
		return;
	}
	if(orgId == '1') {
		alert('不能删除市区联社机构'); return ;		
	}
	var org = get(orgId);
	if(org.isLeaf == false) {
		alert('只能删除最低级别的机构');return ;
	}
	var isDel = window.confirm("确定要删除机构:" + org.name + "?"); 
	if(isDel) {
		$.post(contentPath+"/organization.do",{"act":"del","num":Math.random(), "orgId": orgId},function(msg){
			eval('var json =' + msg);
			App.logJson(json);
			if(json.errorNo=="-3") {
				App.errorInfo("只能删除最低级别的机构!");
			}else if(json.errorNo=="1"){
				App.succeedInfo("删除成功!",function(){window.location.reload();});
			}else if(json.errorNo=="-2"){
				App.errorInfo("你没有[删除]权限!");
			}else{
				App.errorInfo("删除失败!");
			}
		});
	}
}