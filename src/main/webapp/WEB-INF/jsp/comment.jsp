<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>
<c:set var="commentList" value="${commentList}"/>
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

</body>
</html>

