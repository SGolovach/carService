<div class="container">
    <c:set var="ID" scope="session" value="${roleId}"/>
    <c:choose>
    <c:when test="${ID==1}">
        <%@ include file="menuAdmin.jsp" %>
    </c:when>
    <c:when test="${ID==2}">
        <%@ include file="menuUser.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file="menu.jsp" %>
    </c:otherwise>
    </c:choose>
