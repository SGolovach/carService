<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp"%>

<form name="loginForm" method="post" action="action">
    <input type="hidden" name="command" value="signup"/>
    <fmt:message key="msg.login"/>:<br/>
    <input type="text" name="login" value=""/>
    <span class="help-block"><fmt:message key="msg.help.login"/> </span>
    <br/><fmt:message key="msg.password"/>:<br/>
    <input type="password" name="password" value=""/>
    <span class="help-block"><fmt:message key="msg.help.password"/> </span>
    <br/>
    <input type="submit" value="<fmt:message key="submit.signup"/>"/>
</form>

</body>
<%@include file="include/footer.jsp"%>
</html>
