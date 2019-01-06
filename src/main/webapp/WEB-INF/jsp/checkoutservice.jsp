<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>

<form name="OrderForm" method="post" action="action">
    <input type="hidden" name="command" value="checkoutservice"/>
    ${department.getNameDepartment()}<br/>
    <fmt:message key="msg.comment.description"/>:<br/>
    <input type="text" name="description" value=""/>
    <br/><fmt:message key="msg.navbar.service"/>:<br/>
    <input type="hidden" name="departmentId" value="${department.getIdDepartment()}"/>
    <br/><fmt:message key="msg.timeregister"/>:<br/>
    <input type="datetime-local" name="timeregister" value=""/>
    <br/><fmt:message key="msg.checkcar"/>:<br/>
    <select name="carId" class="input-xlarge">
        <c:forEach items="${carListForOrder}" var="carListForOrder">
            <option name="carId" value="${carListForOrder.getIdCar()}">
                    ${carListForOrder.getBrand()}
            </option>
        </c:forEach>
    </select>
    <br/>
    <input type="submit" value="<fmt:message key="submit.login"/>"/>
</form>
</body>
</html>
