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
<div style="margin-left:20px; margin-right: 20px;" class="row">
    <div class="col">
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>Request</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${newRequests}" var="request">
                    <tr>
                        <td><c:out value="${request.request}"/></td>
                        <td><c:out value="${request.status}"/></td>

                        <td>
                            <a href="${pageContext.request.contextPath}/app/manager/new_requests/accept?id=${request.id}">
                                Accept
                            </a>
                            <!-- <a href="#formAccept" class="accept">Accept</a>-->
<%--                            <a th:href="@{/manager/new_requests/reject?(id=${request.id})}">Reject</a>--%>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>


        </div>
    </div>
</div>
</form>
</body>
</html>
