<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>
<table border="1">
    <tr>
        <td><a href="action?command=editcomment&checkIllustreta=5">5</a></td>
        <td><a href="action?command=editcomment&checkIllustreta=10">10</a></td>
        <td><a href="action?command=editcomment&checkIllustreta=25">20</a></td>
    </tr>
</table>

<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.comment.description"/></th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${commentList}" var="commentList">
        <form name="editCar" method="post" action="action">
            <input type="hidden" name="command" value="editcomment"/>
            <input type="hidden" name="idComment" value="${commentList.getIdComment()}"/>
            <tr>
                <td align="center">
                    <input type="text" name="description" value="${commentList.getDescription()}"/>
                </td>
                <td align="center">
                    <div class="form-group mb-1">
                        <button name="update" class="btn btn-success">
                            <fmt:message key="submit.update"/>
                        </button>
                    </div>
                </td>
                <td align="center">
                    <div class="form-group mb-1">
                        <button name="delete" class="btn btn-success">
                            <fmt:message key="submit.delete"/>
                        </button>
                    </div>
                </td>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>

<table border="1">
    <tr>
        <c:choose>
            <c:when test="${countPageSessionComment > 1}">
                <fmt:message key="msg.help.page"/>
                <c:forEach begin="1" end="${countPageSessionComment}" var="i">
                    <td><a href="action?command=editcomment&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>

</body>
</html>
