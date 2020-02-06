<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>添加新闻类别</title>
<link href="../Style/Css.css" rel="stylesheet" type="text/css" />
<script language="javascript">
  String.prototype.Trim  =  function()
  {
		return  this.replace(/(^\s*)|(\s*$)/g,"");  
	}
	function back()
	{
		document.all.form1.action="getTypeByPage.do?curPage=1";
		document.form1.submit();
	}
</script>
</head>

<body>
<h3 class="subTitle">新闻类别</h3>

<%
String t_id = request.getParameter("t_id");
if(t_id == null || t_id.equals(""))
	t_id = "-1";
%>
<form id="form1" name="form1" action="addOrUpdate.do" method="post">
	<input type="hidden" name="t_id" value="<%=t_id %>"/>
	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table2">			
  		<tr>
          <th width="15%" align="right">类别名称</th>
          <td><input name="t_name" type="text" class="input1" /></td>
      </tr>
  		<tr>
          <th width="15%" align="right">类别备注</th>
          <td><input name="t_memo" type="text" class="input1" /></td>
      </tr>
    </table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
            	<input type="submit" value="提交"/> 
           		<input type="reset"  value="重置" />
           		<input type="button" value="取消" onclick="back()"/>
           	</td>
        </tr>
    </table>
</form>
</body>
</html>
