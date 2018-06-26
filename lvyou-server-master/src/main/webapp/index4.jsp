<%@ page language="java" import="java.util.*"
	pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="css/number.css" rel="stylesheet">
</head>
<body>
<h2>Hello World!</h2>
<form enctype="multipart/form-data" method="post" action="./upload/publicDynamicinfo/">

<input type="file" name="file"/> 
<input type="file" name="file"/> 
<input type="file" name="file"/> 
<input type="text" name="fileType" value="2"/> 
<input type="text" name="isFileToDb" value="true"/> 
<input type="text" name="webSiteId" value="1"/> 
<input type="text" name="userName" value="lich3"/> 
<input type="text" name="commentnote" value="郴州旅游动态！"/> 
<input type="text" name="commentaddress" value="url地址"/> 
<input type="text" name="oper" value="0"/> 
 <button type="submit">上传</button>
</form>
</body>
</html>
