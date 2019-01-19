<html>
<%@ include file="include/head.jsp" %>
<body>

<fmt:message key="msg.userdetail"/>

<form name="UserDetailForm" method="post" action="action">
    <input type="hidden" name="command" value="userdetail"/>
    <fmt:message key="msg.name"/>:<br/>
    <input type="text" name="name" value=""/>
    <span class="help-block"><fmt:message key="msg.help.name"/> </span>
    <br/><fmt:message key="msg.phone"/>:<br/>
    <input type="text" name="phone" value=""/>
    <span class="help-block"><fmt:message key="msg.help.mobile"/> </span>
    <br/><fmt:message key="msg.email"/>:<br/>
    <input type="email" name="email" value=""/>
    <span class="help-block"><fmt:message key="msg.help.email"/> </span>
    <br/>
    <input type="submit" value="<fmt:message key="submit.userDetail"/>"/>
</form>

</body>
<%@include file="include/footer.jsp"%>
</html>
