<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>
<table border="1">
    <tr>
        <td><a href="action?command=editservice&checkIllustreta=5">5</a></td>
        <td><a href="action?command=editservice&checkIllustreta=10">10</a></td>
        <td><a href="action?command=editservice&checkIllustreta=25">20</a></td>
    </tr>
</table>

<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.namedepartment"/></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${departmentList}" var="departmentList">
        <form name="editService" method="post" action="action">
            <input type="hidden" name="command" value="editservice"/>
            <input type="hidden" name="idDepartment" value="${departmentList.getIdDepartment()}"/>
            <tr>
                <td align="center">
                    <input type="text" name="namedepartment" value="${departmentList.getNameDepartment()}"/>
                </td>
                <td align="center">
                    <div class="form-group mb-1">
                        <button name="update" class="btn btn-success">
                            <fmt:message key="submit.update"/>
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
            <c:when test="${countPageSessionEditDepartment > 1}">
                <c:forEach begin="1" end="${countPageSessionEditDepartment}" var="i">
                    <td><a href="action?command=editservice&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>

</body>
</html>