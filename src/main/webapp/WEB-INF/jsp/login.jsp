<html>
<%@ include file="include/head.jsp"%>
<body>
<%@include file="include/menuBar.jsp"%>

<form name="loginForm" method="post" action="action">
    <input type="hidden" name="command" value="login"/>
    <fmt:message key="msg.login"/>:<br/>
    <input type="text" name="login" value=""/>
    <br/><fmt:message key="msg.password"/>:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    <input type="submit" value=<fmt:message key="submit.login"/>/>
</form>

</body>
</html>
