<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<a href="/springmvc_2/addPerson.html">新增员工</a>
	<table border="1" width="500">
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>生日</th>
				<th>靓照</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${PAGE_INFO.list}" var="temp">
				<tr>
					<td><a href="#">${temp.pid }</a></td>
					<td>${temp.pname }</td>
					<td>${temp.psex==0?'男':'女'}</td>
					<td><fmt:formatDate value="${temp.pdate}"
							pattern="yyyy年MM月dd日" /></td>
					<td><img src="/springmvc_2/images/${temp.pimg}" /></td>
					<td><a href="#">修改</a>&nbsp;<a href="/springmvc_2/person/delete?pid=${temp.pid}">移除</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="6"><a
					href="/springmvc_2/person/list?p=1&s=${PAGE_INFO.pageSize}">首页</a>
					&nbsp;&nbsp; <c:if test="${PAGE_INFO.isHasPreviousPage()}">
						<a
							href="/springmvc_2/person/list?&p=${PAGE_INFO.prePage}&s=${PAGE_INFO.pageSize}">上一页</a>
					</c:if> &nbsp;&nbsp; <c:if test="${PAGE_INFO.isHasNextPage()}">
						<a
							href="/springmvc_2/person/list?&p=${PAGE_INFO.nextPage}&s=${PAGE_INFO.pageSize}">下一页</a>
					</c:if> &nbsp;&nbsp; <a
					href="/springmvc_2/person/list?&p=${PAGE_INFO.lastPage}&s=${PAGE_INFO.pageSize}">末页</a>
				</th>
			</tr>
		</tfoot>
	</table>
</body>
</html>
