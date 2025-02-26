<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="head.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goals</title>
</head>
<body>
<div class="container-fluid">
    <h2>Add Goals</h2>
    <form action="addGoal" method="post">
        <label for="goal">Goal:</label>
        <input type="text" id="goal" name="goal">
        <button type="submit">Add Goal</button>
    </form>
</div>

</body>
</html>
