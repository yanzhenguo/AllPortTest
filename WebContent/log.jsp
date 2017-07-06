<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<div>
	<table id="message">
	</table>
</div>
 <script type="text/javascript">
 	setInterval(function(){
 		$.get("GetRecent",function(result,status){
 			if (result=="null") return;
 			var obj = JSON.parse(result);
 			
 			for (var i=0;i<obj.content.length;i++){
 				$("#message").append("<li>"+obj.content[i].message+"</li>");
 			}
 			//$.each(result.content,function(index,content){
 			//	$("#message").append("<li>"+content+"</li>");
 			//});
 		});
 	},500);
 </script>
</body>
</html>