<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>

<table border="1">
    <tbody>
    <c:forEach items="${departmentList}" var="departmentList">
        <tr>
            <td align="center">
                <a href="action?command=checkoutservice&serviceId=${departmentList.getIdDepartment()}">
                        ${departmentList.getNameDepartment()}
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
