//window.alert = ymPrompt.alert;
$(document).ready(function(){
	if((typeof init != "undefined") && (typeof init == "function")){
		init();
	}
});
function goBack(){
	history.go(-1);
}
function initPermCode(permCode){
	if(permCode==null || permCode=="")return;
	if(permCode.length>0){
		var codes = permCode.split(",");
		for(var idx=0;idx<codes.length;idx++){
			var code = codes[idx];
			var subCode = code.substring(0,code.length-1);
			$("#perm_code_"+code).attr("checked",true);
			var codeInt = parseInt(code,16);
			var arrays = [1,2,4,8];
			for(var ik in arrays){
				if((codeInt & arrays[ik]) == arrays[ik]){
					$("#perm_code_"+subCode+arrays[ik]).attr("checked",true);
				}
			}
		}
	}	
}
function menuBg(){
	var topId = arguments[0] || "";
	var leftId = arguments[1] || "";
	var leftId1 = arguments[2] || "";	
	if(topId!=""){
		$("#top_menu_"+topId).css({background:"url("+contentPath+"/images/nav_bg2.jpg)"});
	}
	if(leftId!=""){
		$("#left_menu_"+leftId).css({background:"url("+contentPath+"/images/nav_bg3.jpg)"});
		$("#left_menu_"+leftId).css({color:"#FFFFFF"});
	}
	if(leftId1 !=""){
		$("#left1_menu_"+leftId1).css({background:"url("+contentPath+"/images/5642.jpg)"});
		$("#left1_menu_"+leftId1).css({color:"#bc3834"});
		
	}
}

//左侧 left 菜单 收起，展开
function ish1(obj,i){
	var divs = $(obj).parent().parent().find("div");
	var div = $(divs[i]);
	var o = $(div).css("display");
	if(o=="" || o=="none" ){
		$(div).show();
	}else{
		$(div).hide();;
	}
	
}

function getArrayByName(){
	var checkbox = $("input:checkbox");
	var percodes = new Array();
	for(var idx=0;idx<checkbox.length;idx++){
		var cbd = $(checkbox[idx]);
		if(cbd.attr("checked")){
			percodes.push(cbd.val());
		}
	}
	if(percodes.length==0){
		return "";
	}
	var ids = percodes.join(",");
	return ids;
}

function checkInput(json){
	var b = true;
	for(var key in json){
		var val = $("#"+key).val();
		if(val==null || val=="" || val=="null"){
			alert(json[key]);
			b=false;
		}
	}
	return b;
}

/**doDisplay(obj1,obj2),obj1 要显示的对象,obj2要隐藏对象，两个类型都可以为字符串或者数组**/
function doDisplay(currents,items){
	if(!$.isArray(currents)){
		var newCurrents = new Array();
		newCurrents.push(currents);
		currents = newCurrents;
	}
	if(!$.isArray(items)){
		var newItems = new Array();
		newItems.push(items);
		items = newItems;
	}
	for(var i=0;i<currents.length;i++){
		var cur = $("#"+currents[i]);
		if(cur.css("display")=="none" || cur.css("display")==""){
			cur.show();
		}else{
			cur.hide();
		}
	}
	for(var i=0;i<items.length;i++){
		$("#"+items[i]).hide();
	}
}

function changeDisplay(objDiv){
	var o = $("#"+objDiv).css("display");
	if(o=="" || o=="none"){
		$("#"+objDiv).show();
	}else{
		$("#"+objDiv).hide();
	}
}

function compareDate(d1, d2) {
	//d1比d2大， 返回true
	return Date.parse(d1.replace(/-/g, "/")) > Date.parse(d2.replace(/-/g, "/"))   
}


function shouldDisplay(array, displayId) {
	var b = false;
	for(var i = 0; i < array.length; i ++){
		var val = $("#"+array[i]).val();
		if(val != null && val != '-1' && val != ''){
			b=true;
			break;
		}
	}
	if(b || App.getQueryStr("org_2")!="") {
		$('#' + displayId).show();
	} 
	
}


//验证金额
function checkmoney(data){ 
	var tmp; 
	if (data == " ") return true; 
	var re = /^[\-\+]?([0-9]\d*|0|[1-9]\d{0,2}(,\d{3})*)(\.\d+)?$/; 
	return re.test(data); 
} 


function getCheckedArray(){
	var checkbox = $("input:checkbox");
	var percodes = new Array();
	for(var idx=0;idx<checkbox.length;idx++){
		var cbd = $(checkbox[idx]);
		if(cbd.attr("checked")){
			percodes.push(cbd.val());
		}
	}
	if(percodes.length==0){
		return null;
	}
	return percodes;
}

