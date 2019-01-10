<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>

<c:set var="carModel" scope="session" value="${carModel}"/>
<c:set var="orderUser" scope="session" value="${orderUser}"/>

<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.timeregister"/></th>
        <th scope="col"><fmt:message key="msg.comment.description"/></th>
        <th scope="col"><fmt:message key="msg.status"/></th>
        <th scope="col"><fmt:message key="msg.model"/></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td align="center">
            ${orderUser.getTimeRegister()}
        </td>
        <td align="center">
            ${orderUser.getDescription()}
        </td>
        <td align="center">
            ${orderUser.getStatus()}
        </td>
        <td align="center">
            ${carModel.getBrand()}
        </td>
    </tr>
    </tbody>
</table>

<a href="action?command=invoiceuser">
    <fmt:message key="href.info.signup"/>
</a>

</body>
</html>
