<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>
<table border="1">
    <tr>
        <td><a href="action?command=editcar&checkIllustreta=5">5</a></td>
        <td><a href="action?command=editcar&checkIllustreta=10">10</a></td>
        <td><a href="action?command=editcar&checkIllustreta=25">20</a></td>
    </tr>
</table>

<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.brand"/></th>
        <th scope="col"><fmt:message key="msg.model"/></th>
        <th scope="col"><fmt:message key="msg.year"/></th>
        <th scope="col"><fmt:message key="msg.codevin"/></th>
        <th scope="col"><fmt:message key="msg.fuel"/></th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${carList}" var="carList">
        <form name="editCar" method="post" action="action">
            <input type="hidden" name="command" value="editcar"/>
            <input type="hidden" name="idCars" value="${carList.getIdCar()}"/>
            <tr>
                <td align="center">
                    <input type="text" name="brand" value="${carList.getBrand()}"/>
                </td>
                <td align="center">
                    <input type="text" name="model" value="${carList.getModel()}"/>
                </td>
                <td align="center">
                    <input type="text" name="year" value="${carList.getYear()}"/>
                </td>
                <td align="center">
                    <input type="text" name="codeVIN" value="${carList.getCodeVIN()}"/>
                </td>
                <td align="center">
                    <input type="text" name="fuel" value="${carList.getFuel()}"/>
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
            <c:when test="${countPageSessionEditCar > 1}">
                <fmt:message key="msg.help.page"/>
                <c:forEach begin="1" end="${countPageSessionEditCar}" var="i">
                    <td><a href="action?command=editcar&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>

</body>
</html>

