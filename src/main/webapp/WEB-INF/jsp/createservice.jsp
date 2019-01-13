<html>
<%@ include file="include/head.jsp"%>
<body>
<%@include file="include/menuBar.jsp"%>

<form name="loginForm" method="post" action="action">
    <input type="hidden" name="command" value="createservice"/>
    <fmt:message key="msg.namedepartment"/>:<br/>
    <input type="text" name="namedepartment" value=""/>
    <br/>
    <input type="submit" value="<fmt:message key="submit.createcar"/>"/>
</form>

</body>
</html>