<%--
  Created by IntelliJ IDEA.
  User: emily
  Date: 2/17/2025
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="head.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results Page</title>
</head>
<body>
    <div class="container-fluid">
    <h2>Search Results: </h2>

        <table border="1">
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Entry</th>
            </tr>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.userName}</td>
                    <td>${user.entry}</td>

                </tr>
            </c:forEach>
        </table>
        <c:if test="${empty users}">
            <p>No results found for your search.</p>
        </c:if>
    </div>

</body>
</html>
