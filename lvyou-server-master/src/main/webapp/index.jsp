<%@ page language="java" import="java.util.*"
	pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="css/number.css" rel="stylesheet">
</head>
<body>
<h2>Hello World!</h2>
<form enctype="multipart/form-data" method="post" action="./AjaxFileUpload/111111">a

<input type="file" accept="image/*" capture="camera"  name="file"/>  <button type="submit">上传</button>

<input type="text" name="fileType" value="1"/> 
<input type="text" name="isFileToDb" value="true"/> 
<input type="text" name="webSiteId" value="1"/> 
<div><img id="IDImg_f" class="phoneIDImg"  src=""/></div>
</form>

<script>
	function xmTanUploadImgFront(obj, id) {
	var file = obj.files[0];
	//console.log(obj);
	//console.log(file);
	//console.log("file.size = " + file.size); //file.size 单位为byte
	var reader = new FileReader();
	//读取文件过程方法
	reader.onloadstart = function(e) {
		//console.log("开始读取....");
	}
	reader.onprogress = function(e) {
		//console.log("正在读取中....");
	}
	reader.onabort = function(e) {
		//console.log("中断读取....");
	}
	reader.onerror = function(e) {
		//console.log("读取异常....");
	}
	reader.onload = function(e) {
		//console.log("成功读取....");
		var img = document.getElementById(id);
		img.src = e.target.result;
		submitIdCardFront();

	}
	reader.readAsDataURL(file)
}
</script>
</body>
</html>
