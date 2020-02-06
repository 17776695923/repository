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
			<form id="form2" method="post" action="SearchNew.do">
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
		<div class="doc-info-view">
			<div class="hd"><h1>${NEW.n_title }</h1></div>
			<hr class="double" />
			<!--[if !IE]>文章属性<![endif]-->
			<div class="doc-parameter">
				<div>作者：夏末不离去</div>
				<div><fmt:formatDate value="${NEW.n_publishtime }" pattern="yyyy-MM-dd HH:mm:ss"/></div>
				<div>来源：《平南娱乐信报》</div>
			</div>
			<!--[if !IE]>正文<![endif]-->
			<div class="doc-text">
				<p>${NEW.n_content }</p>
			</div>
			<!--[if !IE]>评论<![endif]-->
			<hr class="double" />
			<div class="comment">
				<div class="hd"><h3>最新评论</h3></div>
				<!--[if !IE]>评论列表 开始<![endif]-->
				<ol class="com-list">
					<c:forEach items="${ReviewByNew }" var="review" varStatus="i">
						<li>
							<p class="title wrapfix"><span class="num">${i.count }.</span>
							<span class="name">
								<c:choose>
									<c:when test="${review.r_username != null }">${review.r_username }</c:when>
									<c:otherwise>游客</c:otherwise>
								</c:choose>
							</span>
							<span class="time"><fmt:formatDate value="${review.r_revtime }" pattern="yyyy-MM-dd HH:mm:ss"/></span></p>
							<div class="com-body">
								${review.r_content }
							</div>
						</li>
					</c:forEach>
				</ol>
				<!--[if !IE]>评论列表 结束<![endif]-->
				<!--[if !IE]>填写评论 开始<![endif]-->
				<div class="com-form">
				<hr class="double" />
					<div class="hd"><h3>发表评论</h3></div>
					<p class="tips">请自觉遵守互联网相关政策法规，评论不得超过250字。</p>
					<form id="form1" method="post" action="addReview.do">
						<input type="hidden" name="n_id" value="${NEW.n_id }"/>
						<p><textarea name="r_content" id="textarea" rows="5" class="textarea"></textarea></p>
						<p>
							<label for="r_username">昵称</label><input type="text" name="r_username" size="10" id="r_username" class="iText" />
							<input type="submit" class="btn" value="发表评论" />
						</p>
					</form>
				</div>
				<!--[if !IE]>填写评论 开始<![endif]-->
			</div>
		</div>
		<!--[if !IE]>新闻详情 结束<![endif]-->
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;夏末不离去</p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>