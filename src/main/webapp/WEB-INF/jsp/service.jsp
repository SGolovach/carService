<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>
<table border="1">
    <tr>
        <td><a href="action?command=service&checkIllustreta=5">5</a></td>
        <td><a href="action?command=service&checkIllustreta=10">10</a></td>
        <td><a href="action?command=service&checkIllustreta=25">20</a></td>
    </tr>
</table>

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

<table border="1">
    <tr>
        <c:choose>
            <c:when test="${countPageSessionEditDepartment > 1}">
                <fmt:message key="msg.help.page"/>
                <c:forEach begin="1" end="${countPageSessionEditDepartment}" var="i">
                    <td><a href="action?command=service&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>

</body>
</html>
