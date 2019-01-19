<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>

<form name="loginForm" method="post" action="action">
    <input type="hidden" name="command" value="billorder"/>
    <fmt:message key="msg.numberInvoice"/>:<br/>
    <input type="text" name="numberInvoice" value=""/>
    <br/><fmt:message key="msg.cost"/>:<br/>
    <input type="text" name="cost" value=""/>
    <br/>
    <input type="hidden" name="orderId" value="${idOrder}"/>
    <br/>
    <input type="submit" value="<fmt:message key="submit.createcar"/>"/>
</form>
</body>
<%@include file="include/footer.jsp"%>
</html>
