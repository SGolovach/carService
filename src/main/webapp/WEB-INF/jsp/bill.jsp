<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>


<table border="1">
    <tr>
        <td><a href="action?command=bill&checkIllustreta=5">5</a></td>
        <td><a href="action?command=bill&checkIllustreta=10">10</a></td>
        <td><a href="action?command=bill&checkIllustreta=25">25</a></td>
    </tr>
</table>

<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.timeregister"/></th>
        <th scope="col"><fmt:message key="msg.comment.description"/></th>
        <th scope="col"><fmt:message key="msg.status"/></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderNewList}" var="orderNewList">
        <tr>
            <td align="center">
                    ${orderNewList.getTimeRegister()}
            </td>
            <td align="center">
                    ${orderNewList.getDescription()}
            </td>
            <td align="center">
                    ${orderNewList.getStatus()}
            </td>
            <td align="center">
                <a href="action?command=billorder&orderId=${orderNewList.getIdOrder()}">
                    <fmt:message key="msg.gotoorder"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<table border="1">
    <tr>
        <c:choose>
            <c:when test="${countPageSessionEditAllOrder > 1}">
                <c:forEach begin="1" end="${countPageSessionEditAllOrder}" var="i">
                    <td><a href="action?command=bill&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>

</body>
</html>
