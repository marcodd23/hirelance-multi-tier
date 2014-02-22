<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%-- <%@ page import="javax.naming.*" %> --%>
<%-- <%@ page import="java.util.Collection" %> --%>
<%-- <%@ page import="java.util.Properties" %> --%>

<html>
<head><title>List Page</title></head>
<body>
    <h1>All Employees</h1>

    <table border="1">
        <tr>
           <th>Name</th>
<!--            <th>Position</th> -->
<!--            <th>Salary</th> -->
        </tr>
        <c:if test="${not empty users}">
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
<%--                 <td>${employee.department.name}</td> --%>
<%--                 <td>${employee.salary}</td> --%>
            </tr> 
        </c:forEach>
        </c:if>
    </table>
</body>
</html>

