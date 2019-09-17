<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Accepted requests</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
<body>

<form style="padding-top:75px" method="post" id="formAccept" action="${pageContext.request.contextPath}/manager/new_requests/accept">
    <label> price</label>
    <input style="margin-left:20px; margin-right: 20px;" id="price"
          name="price"
           type="text"
           class="form-control"
           pattern="[0-9]+"/>
<%--    <input th:value="${param.id}" th:field="*{id}" type="hidden"/>--%>

    <label>master</label>
    <select name="email" >
<c:forEach items="${masters}" var="master">
        <option value="${master.email}"><c:out value="${master.email}"></c:out></option>
</c:forEach>
    </select>

    <button type="submit">accept</button>
</form>
</body>
</html>
