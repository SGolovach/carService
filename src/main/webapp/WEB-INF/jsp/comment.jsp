<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp"%>
<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.comment.name"/> </th>
        <th scope="col"><fmt:message key="msg.comment.description"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="userList">
        <tr>
            <td align="center">${userList.getName()}</td>
        </tr>
    </c:forEach>
    <c:forEach items="${commentList}" var="commentList">
        <tr>
            <td align="center">${commentList.getDescription()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

