<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>京博书画网</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="Keywords" content="关键字" />
<meta name="Description" content="描述" />
<link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"><a href="Index.jsp" title="京博书画网">京博书画网</a></div>
		<!--[if !IE]>logo 结束<![endif]-->
		<div class="search">
			<form id="form1" method="post" action="SearchNew.do">
				<input type="text" name="key" class="iText" />
				<select name="select">
					<option selected="selected">标题</option>
					<option>内容</option>
				</select>
				<input type="submit" class="btn" value="搜索" />
			</form>
		</div>
		<!--[if !IE]>search 结束<![endif]-->
	</div>
	<!--[if !IE]>header 结束<![endif]-->
	<div id="main">
		<div class="newslist">
			<div class="hd"><h3>搜索结果</h3></div>
			<div class="bd">
				<ul class="list">
					<c:forEach items="${NewPageBySearch.data }" var="news">
						<li><span class="category">
							<c:forEach items="${AllTypeList }" var="type">
								<c:if test="${news.t_id == type.t_id}">${type.t_name }</c:if>
							</c:forEach>
						</span>
						<a href="findReviewByNew.do?n_id=${news.n_id }" target="_blank">${news.n_title }</a><span class="date"><fmt:formatDate value="${news.n_publishtime }" pattern="yyyy-MM-dd HH:mm:ss"/></span></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!--[if !IE]>newslist 结束<![endif]-->
		<div class="paging wrapfix">
			<div class="total">共有${NewPageBySearch.rows }条记录&nbsp;当前${NewPageBySearch.curPage }/${NewPageBySearch.totalPage }页</div>
			<div class="pn">
				<c:choose>
					<c:when test="${NewPageBySearch.curPage <= 1 }">上一页</c:when>
					<c:otherwise><a href="SearchNew.do?select=<%=request.getParameter("select") %>&key=<%=request.getParameter("key") %>&curPage=${NewsByTypePage.curPage-1 }" title="上一页" class="nobar">上一页</a></c:otherwise>
				</c:choose>
				<%
				Integer totalPage = (Integer)session.getAttribute("TotalPage");
				Integer curPage = Integer.parseInt(request.getParameter("curPage"));
				for(int i=1;i<=totalPage;i++){
					if(i == curPage){
				%>
					<a href="#" class="nonce"><%=i %></a>
				<%}else{%>
					<a href="SearchNew.do?select=<%=request.getParameter("select") %>&key=<%=request.getParameter("key") %>&curPage=<%=i %>"><%=i %></a>
				<%}} %>
				<c:choose>
					<c:when test="${NewPageBySearch.curPage < NewPageBySearch.totalPage }">
						<a href="SearchNew.do?select=<%=request.getParameter("select") %>&key=<%=request.getParameter("key") %>&curPage=${NewsByTypePage.curPage+1 }" title="下一页" class="nobar">下一页</a>
					</c:when>
					<c:otherwise>下一页</c:otherwise>
				</c:choose>
			</div>
		</div>
		<!--[if !IE]>paging 结束<![endif]-->

	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;夏末不离去</p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>