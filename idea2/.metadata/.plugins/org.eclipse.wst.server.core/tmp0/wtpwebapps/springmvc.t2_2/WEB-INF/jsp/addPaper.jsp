<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加论文</title>
</head>
<body>
<h3>你所在的位置是>>添加论文</h3>
<form action="addPaper" method="post" enctype="multipart/form-data">
<label>论文题目:</label><input type="text" name="title" required="required">
<span style="color: red;"></span>
 <br>
<label>类型</label>
<select name="cid" required="required">
<c:forEach items="${CODE_LIST }" var="c">
<option value="${c.id }" />${c.codetypename}
</c:forEach>
</select>
 <br>
<label>论文摘要</label>
<textarea name="papersummary" required="required">

</textarea>
 <br>
<label>论文内容</label><input type="file" name="filename2">
<span  style="color: red;"></span>
 <br>
 <span class="tishi1" style="color: red;"></span>
<input type="submit"><button><a href="toManage">返回</a></button>
</form>

</body>
<script type="text/javascript" src="../static/jquery-1.12.4.js"></script>
<script type="text/javascript">
        var pass;
        var flag=true;
       $("[name=title]").blur(function(){
    	   title=$(this);
    	   $.ajax("checkPaper",{
    		   data:{title:title.val()},
    		   type:"post",
    		   success:function(data){
    			   if(data=="OK"){
    				   pass=true;
    				   title.next().html("");
    			   }else{
    				   pass=false;
    				   title.next().html("已存在");
    			   };
    		   }
    	   });
       });
       $("input[name='filename2']").on("change", function(e) {
   		var file = this.files[0];//获得文件对象
   		self=$(this);
   		var _temp = file.name.match(/\.doc|\.docx/i);
   		if (!_temp) {
   			flag = false;
   			this.value = "";
   			$(".tishi1").html("目前只支持doc,docx格式文件");
   			return false;
   		} else{
   			$(".tishi1").html("");
   		} 
   		if (file.size > (1024 * 1024*5)) {
   			flag = false;
   			this.value = "";
   			self.next().html("目前只支持小于5M大小文件");
   			return false;
   		}else{
   			self.next().html("");
   		}
   		flag=true;
   		return true;
   	});
       $("form").submit(function() {
   		if (!flag) {
   			alert("文件格式或大小不匹配！");
   			return false;
   		}
   		if (!pass) {
   			alert("该题目已存在！");
   			return false;
   		}
   		if(confirm("是否保存?")){
   			return true;
   		}else{
   			return false;
   		}
   		
   	});
       

</script>
</html>