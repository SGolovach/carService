<c:set var="ID" scope="session" value="${roleId}"/>
<c:choose>
    <c:when test="${ID==1}">
        <%@ include file="accountAdmin.jsp" %>
    </c:when>
    <c:when test="${ID==2}">
        <%@ include file="accountUser.jsp" %>
    </c:when>
</c:choose>
