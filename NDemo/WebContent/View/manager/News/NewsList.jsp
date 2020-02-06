<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>新闻列表</title>
<link href="../Style/Css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<h3 class="subTitle">新闻资讯</h3>
<ul class="button">
	<li><a href="findType.do">添加新闻</a></li>
</ul>

<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
	<tr>
	    <th width="8%" nowrap="nowrap">序号</th>
	    <th nowrap="nowrap">标题</th>
	    <th width="15%" nowrap="nowrap">日期</th>
	    <th width="12%">修改</th>
	    <th width="12%">删除</th>
	</tr>
	
	<c:forEach items="${NewPage.data }" var="news" varStatus="i">
		<tr>
		    <td align="center">${i.count }</td>
		    <td align="center">${news.n_title }</td>
		    <td align="center"><fmt:formatDate value="${news.n_publishtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td><!--  -->
		    <td align="center"><a href="findType.do?n_id=${news.n_id }">修改</a></td>
		    <td align="center"><a href="deleteNewById.do?n_id=${news.n_id }">删除</a></td>
		</tr>
	</c:forEach>
</table>

<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="page">
	<tr>
		<td width="50%" align="left">共有${NewPage.rows }条记录，<span style="font-family:宋体; font-size:9.0pt; color:black; ">第</span><span style="font-family:Tahoma; font-size:9.0pt; color:black; "> ${NewPage.curPage }/${NewPage.totalPage } </span><span style="font-family:宋体; font-size:9.0pt; color:black; ">页</span></td>
		<td width="50%" align="right">
		<c:choose>
            	<c:when test="${NewPage.curPage == 1 }">首页</c:when>
            	<c:otherwise><a href="getNewByPage.do?curPage=1">首页</a></c:otherwise>
            </c:choose>
            <c:choose>
            	<c:when test="${NewPage.curPage > 1 }"><a href="getNewByPage.do?curPage=${NewPage.curPage-1 }">上一页</a></c:when>
            	<c:otherwise>上一页</c:otherwise>
            </c:choose>
			<c:choose>
				<c:when test="${NewPage.curPage < NewPage.totalPage }"><a href="getNewByPage.do?curPage=${NewPage.curPage+1 }">下一页</a></c:when>
            	<c:otherwise>下一页</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${NewPage.curPage == NewPage.totalPage }">末页</c:when>
            	<c:otherwise><a href="getNewByPage.do?curPage=${NewPage.totalPage }">末页</a></c:otherwise>
			</c:choose>
			<form action="getNewByPage.do">
	            <input type="submit" value="跳转到"/>
			    <select name="curPage">
				    <%
				    Integer totalPage = (Integer)request.getSession().getAttribute("NewTotalPage");
				    for(int i=1;i<=totalPage;i++){
				    %>
				      <option><%=i %></option>
				    <%} %>
			    </select>
		    </form>
		</td>
	</tr>
</table>

</body>
</html>
