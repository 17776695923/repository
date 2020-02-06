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
<c:choose>
	<c:when test="${AllTypeList == null }"><script>window.location.href="http://localhost:8080/NDemo/View/loadIndex.do";</script></c:when>
	<c:when test="${QueryHotList == null }"><script>window.location.href="http://localhost:8080/NDemo/View/loadIndex.do";</script></c:when>
	<c:when test="${QueryNewList == null }"><script>window.location.href="http://localhost:8080/NDemo/View/loadIndex.do";</script></c:when>
</c:choose>
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
	<div id="main" class="wrapfix">
		<div id="mostlyCon">
			<div class="newslist">
				<div class="hd"><h3>新闻头条</h3></div>
				<div class="bd">
					<ul class="list">
						<c:forEach items="${QueryNewList }" var="news">
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
			<div class="newslist">
				<div class="hd"><h3>热点新闻</h3></div>
				<div class="bd">
					<ul class="list">
						<c:forEach items="${QueryHotList }" var="news">
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
		</div>
		<!--[if !IE]>mostlyCon 结束<![endif]-->
		<div id="sideCon">
			<div id="nav">
				<h3>新闻类别</h3>
				<ul>
					<c:forEach items="${AllTypeList }" var="type">
						<li><a href="findNewsByType.do?t_id=${type.t_id }">${type.t_name }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!--[if !IE]>sideCon 结束<![endif]-->
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;夏末不离去 </p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>