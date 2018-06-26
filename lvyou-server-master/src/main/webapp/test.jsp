<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getLocalAddr() + ":" + request.getLocalPort()
			+ request.getContextPath();
	String context = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link type="text/css" href="resources/css/test.css" rel="stylesheet">
<script language="javascript" type="text/javascript"
	src="resources/js/jquery.js"></script>
<script type="text/javascript">
	(function($) {  
 		$.fn.generColor = function(o) {
 			$('table tr:even').css("background-color","#f7faff");
        }

})(jQuery);

$(function(){
	$(".restb").generColor();
	//一级
	var slvlist=$(".sl-v-list");
	var dl=slvlist.children("dl");
	var da=dl.children("a");
	da.click(function(){
	 	$(this).parent().parent().toggleClass("checked");
	 	$(this).parent().parent().find(".J_valueList").toggle();
	 });
	
	
  //二级
	var J_valueList=$(".J_valueList");
	var li=J_valueList.children("li");
	var a=li.children("a");
	 a.click(function(){
	 	$(this).parent().toggleClass("selected");
	 });
	 a.click(function(){	
		 animalOption='';
		 inputScopeOption='';
		 scopeOption='';
		 homeWildOption='';
		 oddOption='';
		 colorOption='';
		 bigOption='';
		 headOption='';
		 endOption='';
		 codeOption='';
		 animalTypeOption='';
		 noInputCodeOption='';
		 noHomeWildOption='';
		 noOddOption='';
		 noColorOption='';
		 noBigOption='';
		 noHeadOption='';
		 noEndOption='';
		 noCodeOption='';
		 noAnimalOption='';
		
		 getOptions();
		 $.post("<%=context%>/maSearch",
			{
			 "animalOption":animalOption,
			 "inputScopeOption":inputScopeOption,
			 "scopeOption":scopeOption,
			 "homeWildOption":homeWildOption,
			 "oddOption":oddOption,
			 "colorOption":colorOption,
			 "bigOption":bigOption,
			 "headOption":headOption,
			 "endOption":endOption,
			 "codeOption":codeOption,
			 "animalTypeOption":animalTypeOption,
			 "noInputCodeOption":noInputCodeOption,
			 "noHomeWildOption":noHomeWildOption,
			 "noOddOption":noOddOption,
			 "noColorOption":noColorOption,
			 "noBigOption":noBigOption,
			 "noHeadOption":noHeadOption,
			 "noEndOption":noEndOption,
			 "noCodeOption":noCodeOption,
			 "noAnimalOption":noAnimalOption

			} ,function(result) {
						//删除一行
		
						$("#restb tr").each(function() {
							$(this).remove();
						});
		                if(result!=null&&result!=''){
		                	$("#restb").append(result);
		                }
						
						
		});
	})
	li.removeClass("selected");
});
	
	
function getOptions(){
	if($(".animalOption").hasClass("checked")){
		var J_valueList=$(".animalOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			
			animalOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(animalOption!=''){
			animalOption=animalOption.substring(0,animalOption.length-1);
		}
	}
	if($(".animalTypeOption").hasClass("checked")){
		var J_valueList=$(".animalTypeOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			animalTypeOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(animalTypeOption!=''){
			animalTypeOption=animalTypeOption.substring(0,animalTypeOption.length-1);
		}
	}
	if($(".codeOption").hasClass("checked")){
		var J_valueList=$(".codeOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			codeOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(codeOption!=''){
			codeOption=codeOption.substring(0,codeOption.length-1);
		}
	}
	if($(".endOption").hasClass("checked")){
		var J_valueList=$(".endOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			endOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(endOption!=''){
			endOption=endOption.substring(0,endOption.length-1);
		}
	}
	if($(".headOption").hasClass("checked")){
		var J_valueList=$(".headOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			headOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(headOption!=''){
			headOption=headOption.substring(0,headOption.length-1);
		}
	}
	if($(".bigOption").hasClass("checked")){
		var J_valueList=$(".bigOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			bigOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(bigOption!=''){
			bigOption=bigOption.substring(0,bigOption.length-1);
		}
	}
	if($(".colorOption").hasClass("checked")){
		var J_valueList=$(".colorOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			colorOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(colorOption!=''){
			colorOption=colorOption.substring(0,colorOption.length-1);
		}
	}
	if($(".oddOption").hasClass("checked")){
		var J_valueList=$(".oddOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			oddOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(oddOption!=''){
			oddOption=oddOption.substring(0,oddOption.length-1);
		}
	}
	if($(".homeWildOption").hasClass("checked")){
		var J_valueList=$(".homeWildOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			homeWildOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(homeWildOption!=''){
			homeWildOption=homeWildOption.substring(0,homeWildOption.length-1);
		}
	}
	if($(".scopeOption").hasClass("checked")){
		var J_valueList=$(".scopeOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			scopeOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(scopeOption!=''){
			scopeOption=scopeOption.substring(0,scopeOption.length-1);
		}
	}
	if($(".inputScopeOption").hasClass("checked")){
		var J_valueList=$(".inputScopeOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			inputScopeOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(inputScopeOption!=''){
			inputScopeOption=inputScopeOption.substring(0,inputScopeOption.length-1);
		}
	}
	
	//
	if($(".noAnimalOption").hasClass("checked")){
		var J_valueList=$(".noAnimalOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			noAnimalOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(noAnimalOption!=''){
			noAnimalOption=noAnimalOption.substring(0,noAnimalOption.length-1);
		}
	}
	if($(".noCodeOption").hasClass("checked")){
		var J_valueList=$(".noCodeOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			noCodeOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(noCodeOption!=''){
			noCodeOption=noCodeOption.substring(0,noCodeOption.length-1);
		}
	}
	if($(".noEndOption").hasClass("checked")){
		var J_valueList=$(".noEndOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			noEndOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(noEndOption!=''){
			noEndOption=noEndOption.substring(0,noEndOption.length-1);
		}
	}
	if($(".noHeadOption").hasClass("checked")){
		var J_valueList=$(".noHeadOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			noHeadOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(noHeadOption!=''){
			noHeadOption=noHeadOption.substring(0,noHeadOption.length-1);
		}
	}
	if($(".noBigOption").hasClass("checked")){
		var J_valueList=$(".noBigOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			noBigOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(noBigOption!=''){
			noBigOption=noBigOption.substring(0,noBigOption.length-1);
		}
	}
	if($(".noOddOption").hasClass("checked")){
		var J_valueList=$(".noOddOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			noOddOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(noOddOption!=''){
			noOddOption=noOddOption.substring(0,noOddOption.length-1);
		}
	}
	if($(".noHomeWildOption").hasClass("checked")){
		var J_valueList=$(".noHomeWildOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			noHomeWildOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(noHomeWildOption!=''){
			noHomeWildOption=noHomeWildOption.substring(0,noHomeWildOption.length-1);
		}
	}
	if($(".noInputCodeOption").hasClass("checked")){
		var J_valueList=$(".noInputCodeOption").find(".J_valueList");
		var selected=J_valueList.find("li.selected");
		selected.each(function(){
			noInputCodeOption+=translate($(this).children("a")[0].innerText)+","
		});
		if(noInputCodeOption!=''){
			noInputCodeOption=noInputCodeOption.substring(0,noInputCodeOption.length-1);
		}
	}
	
	
	
}

	function translate(name) {
		switch (name) {
		case '鼠':
			return '鼠';
		case '牛':
			return '牛';
		case '虎':
			return '虎';
		case '兔':
			return '兔';
		case '龙':
			return '龙';
		case '蛇':
			return '蛇';
		case '马':
			return '马';
		case '羊':
			return '羊';
		case '猴':
			return '猴';
		case '鸡':
			return '鸡';
		case '狗':
			return '狗';
		case '猪':
			return '猪';

		case '01':
			return '1';
		case '02':
			return '2';
		case '03':
			return '2';
		case '04':
			return '4';
		case '05':
			return '5';
		case '06':
			return '6';
		case '07':
			return '7';
		case '08':
			return '8';
		case '09':
			return '9';
		case '10':
			return '10';
		case '11':
			return '11';
		case '12':
			return '12';
		case '13':
			return '13';
		case '14':
			return '14';
		case '15':
			return '15';
		case '16':
			return '16';
		case '17':
			return '17';
		case '18':
			return '18';
		case '19':
			return '19';
		case '20':
			return '20';
		case '21':
			return '21';
		case '22':
			return '22';
		case '23':
			return '23';
		case '24':
			return '24';
		case '25':
			return '25';
		case '26':
			return '26';
		case '27':
			return '27';
		case '28':
			return '28';
		case '29':
			return '29';
		case '30':
			return '30';
		case '31':
			return '31';
		case '32':
			return '32';
		case '33':
			return '33';
		case '34':
			return '34';
		case '35':
			return '35';
		case '36':
			return '36';
		case '37':
			return '37';
		case '38':
			return '38';
		case '39':
			return '39';
		case '40':
			return '40';
		case '41':
			return '41';
		case '42':
			return '42';
		case '43':
			return '43';
		case '44':
			return '44';
		case '45':
			return '45';
		case '46':
			return '46';
		case '47':
			return '47';
		case '48':
			return '48';
		case '49':
			return '49';

		case '美女肖':
			return '蛇,鸡,羊,兔';
		case '天肖':
			return '兔,马,猴,猪,牛,龙';
		case '地肖':
			return '蛇,羊,鸡,狗,鼠,虎';

		case '大数':
			return '大';
		case '小数':
			return '小';

		case '1头':
			return '1';
		case '2头':
			return '2';
		case '3头':
			return '3';
		case '4头':
			return '4';

		case '0尾':
			return '0';
		case '1尾':
			return '1';
		case '2尾':
			return '2';
		case '3尾':
			return '3';
		case '4尾':
			return '4';
		case '5尾':
			return '5';
		case '6尾':
			return '6';
		case '7尾':
			return '7';
		case '8尾':
			return '8';
		case '9尾':
			return '9';

		case '单数':
			return '单';
		case '双数':
			return '双';
		case '家畜':
			return '家';
		case '野兽':
			return '野';
		case '红波':
			return '红';
		case '蓝波':
			return '蓝';
		case '绿波':
			return '绿';

		case '红单':
			return '红,单';
		case '蓝单':
			return '蓝,单';
		case '绿单':
			return '绿,单';
		case '红双':
			return '红,双';
		case '蓝双':
			return '蓝,双';
		case '绿双':
			return '绿,双';
		}

	}

	function refreshResult() {
		/* 	$.get(function(){
		 "restb"
		 })
		
		 $("button").click(function(){
		 $.get("/maSearch",function(data,status){
		 alert("Data: " + data + "nStatus: " + status);
		 });
		 }); */
	}
</script>
</head>
<body>
	<h2>Hello World!</h2>
	<form method="post">
		<div class="selector middle">
			<div class="J_selectorLine s-line">
				<div class="sl-wrap multiple">

					<div class="sl-key">
						<span>帅选条件：</span>
					</div>
					<div class="sl-value">
						<div class="sl-v-list animalOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>生肖：</span>
							</div>
							<ul class="J_valueList">
								<li class="selected"><a><i></i>鼠</a></li>
								<li class="selected"><a><i></i>牛</a></li>
								<li class="selected"><a><i></i>虎</a></li>
								<li class="selected"><a><i></i>兔</a></li>
								<li class="selected"><a><i></i>龙</a></li>
								<li class="selected"><a><i></i>蛇</a></li>
								<li class="selected"><a><i></i>马</a></li>
								<li class="selected"><a><i></i>羊</a></li>
								<li class="selected"><a><i></i>猴</a></li>
								<li class="selected"><a><i></i>鸡</a></li>
								<li class="selected"><a><i></i>狗</a></li>
								<li class="selected"><a><i></i>猪</a></li>
							</ul>
						</div>
						<div class="sl-v-list animalTypeOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>分类生肖：</span>
							</div>
							<ul class="J_valueList">
								<li class="selected"><a><i></i>美女肖</a></li>
								<li class="selected"><a><i></i>天肖</a></li>
								<li class="selected"><a><i></i>地肖</a></li>
							</ul>
						</div>
						<div class="sl-v-list codeOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>号码：</span>
							</div>
							<ul class="J_valueList">
								<li class="selected"><a><i></i>01</a></li>
								<li class="selected"><a><i></i>02</a></li>
								<li class="selected"><a><i></i>03</a></li>
								<li class="selected"><a><i></i>04</a></li>
								<li class="selected"><a><i></i>32</a></li>
								<li class="selected"><a><i></i>43</a></li>
								<li class="selected"><a><i></i>34</a></li>
								<li class="selected"><a><i></i>23</a></li>
								<li class="selected"><a><i></i>28</a></li>
								<li class="selected"><a><i></i>19</a></li>
							</ul>
						</div>
						<div class="sl-v-list endOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>尾数：</span>
							</div>
							<ul class="J_valueList">
								<li class="selected"><a><i></i>0尾</a></li>
								<li class="selected"><a><i></i>1尾</a></li>
								<li class="selected"><a><i></i>2尾</a></li>
								<li class="selected"><a><i></i>3尾</a></li>
								<li class="selected"><a><i></i>4尾</a></li>
								<li class="selected"><a><i></i>5尾</a></li>
								<li class="selected"><a><i></i>6尾</a></li>
								<li class="selected"><a><i></i>7尾</a></li>
								<li class="selected"><a><i></i>8尾</a></li>
								<li class="selected"><a><i></i>9尾</a></li>
							</ul>
						</div>
						<div class="sl-v-list headOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>头数：</span>
							</div>
							<ul class="J_valueList">
								<li class="selected"><a><i></i>1头</a></li>
								<li class="selected"><a><i></i>2头</a></li>
								<li class="selected"><a><i></i>3头</a></li>
								<li class="selected"><a><i></i>4头</a></li>
							</ul>
						</div>
						<div class="sl-v-list bigOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>大小：</span>
							</div>
							<ul class="J_valueList">
								<li class="selected"><a><i></i>大数</a></li>
								<li class="selected"><a><i></i>小数</a></li>
							</ul>
						</div>
						<div class="sl-v-list colorOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>波色：</span>
							</div>
							<ul class="J_valueList">
								<li class="selected"><a><i></i>红波</a></li>
								<li class="selected"><a><i></i>蓝波</a></li>
								<li class="selected"><a><i></i>绿波</a></li>

							</ul>
						</div>
						<div class="sl-v-list oddOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>单/双：</span>
							</div>
							<ul class="J_valueList">
								<li class=""><a><i></i>单数</a></li>
								<li class=""><a><i></i>双数</a></li>
							</ul>
						</div>
						<div class="sl-v-list homeWildOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>家畜/野兽：</span>
							</div>
							<ul class="J_valueList">
								<li class="selected"><a><i></i>家畜</a></li>
								<li class="selected"><a><i></i>野兽</a></li>

							</ul>
						</div>
						<div class="sl-v-list scopeOption checked" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>号码范围：</span>
							</div>
							<ul class="J_valueList">
								<li><i>大于<input type="text" maxlength="2" size="2"
										class="min2" name="txtNumInput" id="txtNumInput_11"
										title="请输入数字" onblur="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')"
										onkeyup="jumpNextText(this,11);"></i></li>
								<li><i>小于<input type="text" maxlength="2" size="2"
										class="min2" name="txtNumInput" id="txtNumInput_11"
										title="请输入数字" onblur="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')"
										onkeyup="jumpNextText(this,11);"></i></li>

							</ul>
						</div>
						<div class="sl-v-list inputScopeOption checked" style="border: none;">
							<div class="sl-key">
								<span>号码范围：</span>
							</div>
							<ul class="J_valueList">
								<li><i> <textarea></textarea>
								</i></li>

							</ul>
						</div>
						<div class="sl-btns">
							<a class="btn btn-primary J_btnsConfirm" href="javascript:;">确定</a>
							<a class="btn btn-default J_btnsCancel" href="javascript:;">取消</a>
						</div>
					</div>
					<div class="sl-ext" style="">
						<a class="sl-e-more J_extMore" href="javascript:;"
							style="visibility: hidden;">更多<i></i></a> <a
							class="sl-e-multiple J_extMultiple" href="javascript:;">多选<i></i></a>
					</div>
				</div>
			</div>
			<div class="J_selectorLine s-line">
				<div class="sl-wrap multiple">
					<div class="sl-key">
						<span>排除条件：</span>
					</div>
					<div class="sl-value" style="background: #f6f7ff;">
						<div class="sl-v-list noAnimalOption" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>排除生肖：</span>
							</div>
							<ul class="J_valueList hide">
								<li class="selected"><a><i></i>鼠</a></li>
								<li class="selected"><a><i></i>牛</a></li>
								<li class="selected"><a><i></i>虎</a></li>
								<li class="selected"><a><i></i>兔</a></li>
								<li class="selected"><a><i></i>龙</a></li>
								<li class="selected"><a><i></i>蛇</a></li>
								<li class="selected"><a><i></i>马</a></li>
								<li class="selected"><a><i></i>羊</a></li>
								<li class="selected"><a><i></i>猴</a></li>
								<li class="selected"><a><i></i>鸡</a></li>
								<li class="selected"><a><i></i>狗</a></li>
								<li class="selected"><a><i></i>猪</a></li>
							</ul>
						</div>
						<div class="sl-v-list noCodeOption" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>排除号码：</span>
							</div>
							<ul class="J_valueList hide">
								<li class="selected"><a><i></i>01</a></li>
								<li class="selected"><a><i></i>02</a></li>
								<li class="selected"><a><i></i>03</a></li>
								<li class="selected"><a><i></i>04</a></li>
								<li class="selected"><a><i></i>32</a></li>
								<li class="selected"><a><i></i>43</a></li>
								<li class="selected"><a><i></i>34</a></li>
								<li class="selected"><a><i></i>23</a></li>
								<li class="selected"><a><i></i>28</a></li>
								<li class="selected"><a><i></i>19</a></li>
							</ul>
						</div>
						<div class="sl-v-list noEndOption" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>排除尾数：</span>
							</div>
							<ul class="J_valueList hide">
								<li class="selected"><a><i></i>0尾</a></li>
								<li class="selected"><a><i></i>1尾</a></li>
								<li class="selected"><a><i></i>2尾</a></li>
								<li class="selected"><a><i></i>3尾</a></li>
								<li class="selected"><a><i></i>4尾</a></li>
								<li class="selected"><a><i></i>5尾</a></li>
								<li class="selected"><a><i></i>6尾</a></li>
								<li class="selected"><a><i></i>7尾</a></li>
								<li class="selected"><a><i></i>8尾</a></li>
								<li class="selected"><a><i></i>9尾</a></li>
							</ul>
						</div>
						<div class="sl-v-list noHeadOption" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>排除头数：</span>
							</div>
							<ul class="J_valueList hide">
								<li class="selected"><a><i></i>1头</a></li>
								<li class="selected"><a><i></i>2头</a></li>
								<li class="selected"><a><i></i>3头</a></li>
								<li class="selected"><a><i></i>4头</a></li>
							</ul>
						</div>
						<div class="sl-v-list noBigOption" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>排除大/小：</span>
							</div>
							<ul class="J_valueList hide">
								<li class="selected"><a><i></i>大数</a></li>
								<li class="selected"><a><i></i>小数</a></li>
							</ul>
						</div>
						<div class="sl-v-list noColorOption" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>排除波色：</span>
							</div>
							<ul class="J_valueList hide">
								<li class="selected"><a><i></i>红单</a></li>
								<li class="selected"><a><i></i>蓝单</a></li>
								<li class="selected"><a><i></i>绿单</a></li>
								<li class="selected"><a><i></i>红双</a></li>
								<li class="selected"><a><i></i>蓝双</a></li>
								<li class="selected"><a><i></i>绿双</a></li>
							</ul>
						</div>
						<div class="sl-v-list noOddOption" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>排除单/双：</span>
							</div>
							<ul class="J_valueList hide">
								<li class=""><a><i></i>单数</a></li>
								<li class=""><a><i></i>双数</a></li>

							</ul>
						</div>
						<div class="sl-v-list noHomeWildOption" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>排除家畜/野兽：</span>
							</div>
							<ul class="J_valueList hide">
								<li class="selected"><a><i></i>家畜</a></li>
								<li class="selected"><a><i></i>野兽</a></li>

							</ul>
						</div>
						<div class="sl-v-list noInputCodeOption" style="border: none;">
							<dl>
								<a><i></i></a>
							</dl>
							<div class="sl-key">
								<span>杀码：</span>
							</div>
							<ul class="J_valueList hide">
								<li><i> <textarea></textarea>
								</i></li>

							</ul>
						</div>
						<div class="sl-btns">
							<a class="btn btn-primary J_btnsConfirm" href="javascript:;">确定</a>
							<a class="btn btn-default J_btnsCancel" href="javascript:;">取消</a>
						</div>
					</div>
					<div class="sl-ext" style="">
						<a class="sl-e-more J_extMore" href="javascript:;"
							style="visibility: hidden;">更多<i></i></a> <a
							class="sl-e-multiple J_extMultiple" href="javascript:;">多选<i></i></a>
					</div>
				</div>
			</div>
		</div>
		<table class="middle restb" id="restb">
			<tr>
				<td>数字</td>
				<td>生肖</td>
				<td>波色</td>
				<td>单双</td>
				<td>家野</td>
				<td>女肖</td>
				<td>天肖/地肖</td>
				<td>五行</td>
				<td>尾数</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>32</td>
				<td>兔</td>
				<td>绿</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>34</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
			<tr>
				<td>20</td>
				<td>兔</td>
				<td>蓝</td>
				<td>双</td>
				<td>野</td>
				<td>女</td>
				<td>地</td>
				<td>土</td>
				<td>0</td>
			</tr>
		</table>
	</form>
</body>
</html>
