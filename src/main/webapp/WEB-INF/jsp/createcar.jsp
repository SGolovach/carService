<html>
<%@ include file="include/head.jsp"%>
<body>
<%@include file="include/menuBar.jsp"%>

<form name="loginForm" method="post" action="action">
    <input type="hidden" name="command" value="createcar"/>
    <fmt:message key="msg.brand"/>:<br/>
    <input type="text" name="brand" value=""/>
    <span class="help-block"><fmt:message key="msg.help.name"/> </span>
    <br/><fmt:message key="msg.model"/>:<br/>
    <input type="text" name="model" value=""/>
    <span class="help-block"><fmt:message key="msg.help.name"/> </span>
    <br/><fmt:message key="msg.year"/>:<br/>
    <input type="text" name="year" value=""/>
    <span class="help-block"><fmt:message key="msg.help.year"/> </span>
    <br/><fmt:message key="msg.codevin"/>:<br/>
    <input type="text" name="codeVIN" value=""/>
    <span class="help-block"><fmt:message key="msg.help.vincode"/> </span>
    <br/><fmt:message key="msg.fuel"/>:<br/>
    <input type="text" name="fuel" value=""/>
    <span class="help-block"><fmt:message key="msg.help.name"/> </span>
    <br/>
    <input type="submit" value="<fmt:message key="submit.createcar"/>"/>
</form>

</body>
<%@include file="include/footer.jsp"%>
</html>
