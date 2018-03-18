<%--
  Created by IntelliJ IDEA.
  User: wuyoujian
  Date: 2018/3/17
  Time: 01:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

  <title>在Form表单中使用验证码</title>
  <script type="text/javascript">
      //刷新验证码
      function changeImg(obj,createTypeFlag){
          document.getElementById(obj.id).src="${pageContext.request.contextPath}/random?createTypeFlag="+createTypeFlag+"&"+Math.random();
      }
  </script>
</head>

<body>
<%--<form action="${pageContext.request.contextPath}/checkcode" method="post">--%>
  <%--数字字母混合验证码：<input type="text" name="validateCode_nl"/>--%>
  <%--<img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/random?createTypeFlag=nl" id="validateCodeImg1" onclick="changeImg(this,'nl')">--%>
  <%--<br/>--%>
  <%--<input type="submit" value="提交">--%>
<%--</form>--%>
<form action="${pageContext.request.contextPath}/checkcode" method="post">
  中文验证码：<input type="text" name="validateCode_ch"/>
  <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/random?createTypeFlag=ch" id="validateCodeImg2" onclick="changeImg(this,'ch')">
  <br/>
  <input type="submit" value="提交">
</form>
<%--<form action="${pageContext.request.contextPath}/checkcode" method="post">--%>
  <%--英文验证码：<input type="text" name="validateCode_l"/>--%>
  <%--<img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/random?createTypeFlag=l" id="validateCodeImg3" onclick="changeImg(this,'l')">--%>
  <%--<br/>--%>
  <%--<input type="submit" value="提交">--%>
<%--</form>--%>
<%--<form action="${pageContext.request.contextPath}/checkcode" method="post">--%>
  <%--数字验证码：<input type="text" name="validateCode_n"/>--%>
  <%--<img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/random?createTypeFlag=n" id="validateCodeImg4" onclick="changeImg(this,'n')">--%>
  <%--<br/>--%>
  <%--<input type="submit" value="提交">--%>
<%--</form>--%>
</body>
</html>
