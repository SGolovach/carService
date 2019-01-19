<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>
<table border="1">
    <tr>
        <td><a href="action?command=editorder&checkIllustreta=5">5</a></td>
        <td><a href="action?command=editorder&checkIllustreta=10">10</a></td>
        <td><a href="action?command=editorder&checkIllustreta=25">25</a></td>
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
    <c:forEach items="${orderList}" var="orderList">
        <form name="editOrder" method="post" action="action">
            <input type="hidden" name="command" value="editorder"/>
            <input type="hidden" name="idOrder" value="${orderList.getIdOrder()}"/>
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
            <c:when test="${countPageSessionEditOrder > 1}">
                <<fmt:message key="msg.help.page"/>
                <c:forEach begin="1" end="${countPageSessionEditOrder}" var="i">
                    <td><a href="action?command=editorder&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>

</body>
<%@include file="include/footer.jsp"%>
</html>

