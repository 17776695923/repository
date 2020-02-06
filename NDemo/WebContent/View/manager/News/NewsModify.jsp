<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>编辑新闻</title>
<link href="../Style/Css.css" rel="stylesheet" type="text/css" />

<script language="javascript">
  String.prototype.Trim  =  function(){
		return  this.replace(/(^\s*)|(\s*$)/g,"");  
	}
	
	function goto()
	{
		if(check()){
	    	document.form1.submit();
		}
	}

	function check()
	{
		if(document.all.form1.title.value.Trim()==""){
			alert("请填写标题!");
			return false;
		 }

		 return true;
	}
	
	function back()
	{
		document.all.form1.action="NewsList.jsp";
		document.form1.submit();
	}
</script>
</head>
<body>
<h3 class="subTitle">编辑新闻</h3>

<form id="form1" name="form1" action="addOrUpdateNews.do" method="post">
		<c:if test="${N_ID != null and N_ID > 0 }">
			<input name="n_id" value="${N_ID }" type="hidden"/>
		</c:if>
		<table width="90%" border="0" align="center" cellpadding="0" class="table2" cellspacing="0">
		    <tr>
          <th width="15%" align="right">新闻类别</th>
          <td>
          	<select name="t_id">
          		<option value="0" selected="selected">选择类型</option>
          		<c:forEach items="${AllTypeList }" var="type">
          			<option value="${type.t_id }">${type.t_name }</option>
          		</c:forEach>
			</select>
		   </td>
      	  </tr>
		    <tr>
		        <th align="right">文章标题</th>
		        <td><input name="n_title" type="text" class="input1" id="header"/></td>
		    </tr>
		    <tr>
		        <th align="right" valign="top">文章内容</th>
		        <td>
		        	<textarea name="n_content" rows="10" cols="165"></textarea>
		        	<!-- <iframe src="NewsList.jsp" frameborder="0" scrolling="no" width="650" height="350"></iframe> -->
		        </td>
		    </tr>
		</table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
            	<input type="submit" name="Submit" value="提交" />
            	<input type="reset" name="Submit2" value="重置" />
            	<input type="button" name="Submit" value="取消" onclick="back()"/> 
           	</td>
        </tr>
    </table>
</form>
</body>
</html>
