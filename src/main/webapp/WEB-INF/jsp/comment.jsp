<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>

<table border="1">
    <tr>
        <td><a href="action?command=comment&checkIllustreta=5">5</a></td>
        <td><a href="action?command=comment&checkIllustreta=10">10</a></td>
        <td><a href="action?command=comment&checkIllustreta=25">20</a></td>
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
            <c:when test="${countPageSessionCommentAll > 1}">
                <fmt:message key="msg.help.page"/>
                <c:forEach begin="1" end="${countPageSessionCommentAll}" var="i">
                    <td><a href="action?command=comment&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>

</body>
</html>

