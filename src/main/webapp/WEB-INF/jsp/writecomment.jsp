<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp"%>

<form name="loginForm" method="post" action="action">
    <input type="hidden" name="command" value="writecomment"/>
    <fmt:message key="msg.comment.description"/>:<br/>
    <input type="text" name="description" value=""/>
    <span class="help-block"><fmt:message key="msg.help.description"/> </span>
    <br/>
    <input type="submit" value="<fmt:message key="submit.writecomment"/>"/>
</form>

</body>
<%@include file="include/footer.jsp"%>
</html>