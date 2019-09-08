<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript">
    	xhr = null;
		if(window.XMLHttpRequest){
			//1实例化
			xhr  = new XMLHttpRequest();
			//2创建请求
			xhr.open("get","url",true);
			//3发送请求,get必须为null
			xhr.send(null);
			xhr.XMLHttpRequest = funtion(){
				//就绪码
				if(xhr.redyState == 4){
					if(xhr.status == 200){
						var rs = xhr.responseText // 文本
						$("#id").html(rs);
					}else if(xhr.status == 404){
						alert("资源不存在")
					}else if(xhr.status == 500){
						alert("服务器出错")
					}
				}
			}
		}
    </script>
    <body>
 	</body>
</html>