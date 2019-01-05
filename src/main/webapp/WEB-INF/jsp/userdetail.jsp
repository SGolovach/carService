<html>
<%@ include file="include/head.jsp" %>
<body>

<fmt:message key="msg.userdetail"/>

<form name="UserDetailForm" method="post" action="action">
    <input type="hidden" name="command" value="userdetail"/>
    <fmt:message key="msg.name"/>:<br/>
    <input type="text" name="name" value=""/>
    <br/><fmt:message key="msg.phone"/>:<br/>
    <input type="text" name="phone" value=""/>
    <br/><fmt:message key="msg.email"/>:<br/>
    <input type="email" name="email" value=""/>
    <br/>
    <input type="submit" value="<fmt:message key="submit.userDetail"/>"/>
</form>
</body>
</html>
