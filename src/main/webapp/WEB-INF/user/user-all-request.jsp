<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>



<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Create request</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>

<body>

<div style="margin-top: 15px" class="container">
    <h2>
        My request
    </h2>
    <form method="get">

            <table class="table table-hover">
                <thead>
                <tr>

                    <th>request</th>
                    <th>status</th>
                    <th>price</th>
                    <th>reason</th>
                </tr>
                </thead>
                <c:forEach items="${requests}" var="r">
                    <tbody>
                    <tr>
                        <td><c:out value="${r.request}"/></td>
                        <td><c:out value="${r.status}"/></td>
                        <td><c:out value="${r.price}"/></td>
                        <td><c:out value="${r.reason}"/></td>

                    </tr>
                    </tbody></c:forEach>
            </table>

    </form>
</div>

</body>
</html>