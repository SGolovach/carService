<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>
<table border="1">
    <tr>
        <td><a href="action?command=viewallorder&checkIllustreta=5">5</a></td>
        <td><a href="action?command=viewallorder&checkIllustreta=10">10</a></td>
        <td><a href="action?command=viewallorder&checkIllustreta=25">25</a></td>
    </tr>
</table>

<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.timeregister"/></th>
        <th scope="col"><fmt:message key="msg.comment.description"/></th>
        <th scope="col"><fmt:message key="msg.status"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${viewOrderList}" var="orderList">
        <tr>
            <td align="center">
                    ${orderList.getTimeRegister()}
            </td>
            <td align="center">
                    ${orderList.getDescription()}
            </td>
            <td align="center">
                    ${orderList.getStatus()}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<table border="1">
    <tr>
        <c:choose>
            <c:when test="${countPageSessionEditAllOrder > 1}">
                <fmt:message key="msg.help.page"/>
                <c:forEach begin="1" end="${countPageSessionEditAllOrder}" var="i">
                    <td><a href="action?command=viewallorder&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>

</body>
</html>