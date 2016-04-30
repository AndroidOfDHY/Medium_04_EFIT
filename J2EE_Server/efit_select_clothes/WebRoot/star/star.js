window.onload = function ()
{
	var oStar = document.getElementById("star");
	var aLi = oStar.getElementsByTagName("li");
	var oUl = oStar.getElementsByTagName("ul")[0];
	var oSpan = oStar.getElementsByTagName("label")[0];
	var oP = oStar.getElementsByTagName("p")[0];
	var i = iScore = iStar = 1;
	var aMsg = [
				"很不满意|很不好",
				"不满意|不好",
				"一般|一般",
				"满意|不错",
				"非常满意|非常好"
				]
	fnPoint(1);
	oP.style.display = "none";
	oSpan.innerHTML = "<strong>" + (1) + " 分</strong> (" + aMsg[1 - 1].match(/\|(.+)/)[1] + ")";
//	oStar.getElementsByTagName("p")[1].style.display = "none";
//	oSpan.innerHTML = "<strong>" + (this.index) + " 分</strong> (" + aMsg[this.index - 1].match(/\|(.+)/)[1] + ")";
	for (i = 1; i <= aLi.length; i++)
	{
		aLi[i - 1].index = i;
		//鼠标移过显示分数
		aLi[i - 1].onmouseover = function ()
		{
			fnPoint(this.index);
			//浮动层显示
		//	oP.style.display = "block";
			//计算浮动层位置
		//	oP.style.left = oUl.offsetLeft + this.index * this.offsetWidth - 104 + "px";
			//匹配浮动层文字内容
			//oP.innerHTML = "<em><b>" + this.index + "</b> 分 " + aMsg[this.index - 1].match(/(.+)\|/)[1] + "</em>" + aMsg[this.index - 1].match(/\|(.+)/)[1]
		};
		//鼠标离开后恢复上次评分
		aLi[i - 1].onmouseout = function ()
		{
			fnPoint();
			//关闭浮动层
			oP.style.display = "none"
		};
		//点击后进行评分处理
		aLi[i - 1].onclick = function ()
		{
			iStar = this.index;
			oP.style.display = "none";
			oSpan.innerHTML = "<strong>" + (this.index) + " 分</strong> (" + aMsg[this.index - 1].match(/\|(.+)/)[1] + ")";
		}
	}
	//评分处理
	function fnPoint(iArg)
	{
		
		//分数赋值
		iScore = iArg || iStar;
	//	alert(iScore);
		for (i = 0; i < aLi.length; i++) aLi[i].className = i < iScore ? "on" : "";	
		$("#score").val(iScore);
	}
};