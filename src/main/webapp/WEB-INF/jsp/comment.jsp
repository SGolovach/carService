<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>

<table border="1">
    <tr>
        <td><a href="action?command=comment&checkIllustreta=3">3</a></td>
        <td><a href="action?command=comment&checkIllustreta=10">10</a></td>
        <td><a href="action?command=comment&checkIllustreta=20">20</a></td>
    </tr>
</table>

<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.comment.name"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${commentList}" var="commentList">
        <tr>
            <td align="center">${commentList.getDescription()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<table border="1">
    <tr>
        <c:choose>
            <c:when test="${countPageSession > 1}">
                <c:forEach begin="1" end="${countPageSession}" var="i">
                    <td><a href="action?command=comment&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>

</body>
</html>

