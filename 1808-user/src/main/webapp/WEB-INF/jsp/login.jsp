<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="/jquery/dist/jquery.min.js"></script>

</head>

<body> 

	<div>
	
	<form id="form-login" action="/service/user/doLogin">
		<input type="text" name="username" /><br/>
		
		<input type="text" name="password"/><br/>
		
		<input type="submit" value="登录" />
	</form>
	</div>
	
	<div class="regist">
            <span><a href="/user/register.html" >注册&gt;&gt;</a></span>
        </div>
	
	
</body>

</html>