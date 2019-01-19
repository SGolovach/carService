<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>

<c:set var="user" scope="session" value="${user}"/>

<form name="UserForm" method="post" action="action">
    <input type="hidden" name="command" value="editloginpassword"/>
    <fmt:message key="msg.login"/>:<br/>
    <input type="text" name="login" value="${user.getLogin()}"/>
    <br/><fmt:message key="msg.newpass"/>:<br/>
    <input type="password" name="newpassword" value=""/>
    <span class="help-block"><fmt:message key="msg.help.password"/> </span>
    <br/><fmt:message key="msg.oldpass"/>:<br/>
    <input type="password" name="oldpassword" value=""/>
    <br/>
    <input type="submit" value="<fmt:message key="submit.userDetail"/>"/>
</form>

</body>
<%@include file="include/footer.jsp"%>
</html>
