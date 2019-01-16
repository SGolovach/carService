<html>
<%@ include file="include/head.jsp" %>
<body>
<%@include file="include/menuBar.jsp" %>
<table border="1">
    <tr>
        <td><a href="action?command=viewallinvoice&checkIllustreta=5">5</a></td>
        <td><a href="action?command=viewallinvoice&checkIllustreta=10">10</a></td>
        <td><a href="action?command=viewallinvoice&checkIllustreta=25">20</a></td>
    </tr>
</table>
<table border="1">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="msg.numberInvoice"/></th>
        <th scope="col"><fmt:message key="msg.cost"/></th>
        <th scope="col"><fmt:message key="msg.idorder"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${viewInvoiceList}" var="invoiceList">
    <tr>
        <td align="center">
                ${invoiceList.getNumberInvoice()}
        </td>
        <td align="center">
                ${invoiceList.getCost()}
        </td>
        <td align="center">
                ${invoiceList.getOrderId()}
        </td>
        </c:forEach>
    </tbody>
</table>

<table border="1">
    <tr>
        <c:choose>
            <c:when test="${countPageSessionEditAllInvoice > 1}">
                <fmt:message key="msg.help.page"/>
                <c:forEach begin="1" end="${countPageSessionEditAllInvoice}" var="i">
                    <td><a href="action?command=viewallinvoice&currentPage=${i}">${i}</a></td>
                </c:forEach>
            </c:when>
        </c:choose>
    </tr>
</table>


</body>
</html>