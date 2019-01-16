<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>

<c:set var="userDetail" scope="session" value="${userDetail}"/>

<form name="UserDetailForm" method="post" action="action">
    <input type="hidden" name="command" value="edituserdetail"/>
    <input type="hidden" name="idUserDetail" value="${userDetail.getIdUserDetail()}">
    <fmt:message key="msg.name"/>:<br/>
    <input type="text" name="name" value="${userDetail.getName()}"/>
    <span class="help-block"><fmt:message key="msg.help.name"/> </span>
    <br/><fmt:message key="msg.phone"/>:<br/>
    <input type="text" name="phone" value="${userDetail.getPhone()}"/>
    <span class="help-block"><fmt:message key="msg.help.mobile"/> </span>
    <br/><fmt:message key="msg.email"/>:<br/>
    <input type="email" name="email" value="${userDetail.getEmail()}"/>
    <span class="help-block"><fmt:message key="msg.help.email"/> </span>
    <br/>
    <input type="submit" value="<fmt:message key="submit.userDetail"/>"/>
</form>
</body>
</html>
