<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp"%>
<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.brand"/> </th>
        <th scope="col"><fmt:message key="msg.model"/></th>
        <th scope="col"><fmt:message key="msg.year"/></th>
        <th scope="col"><fmt:message key="msg.codevin"/></th>
        <th scope="col"><fmt:message key="msg.fuel"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${carList}" var="carList">
        <tr>
            <td align="center">${carList.getBrand()}</td>
            <td align="center">${carList.getModel()}</td>
            <td align="center">${carList.getYear()}</td>
            <td align="center">${carList.getCodeVIN()}</td>
            <td align="center">${carList.getFuel()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

