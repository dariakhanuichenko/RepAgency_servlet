<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>

<body>
<%--<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">--%>
<%--    <div class="container"><a class="navbar-brand" href="#">RepAgency</a>--%>
<%--        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span--%>
<%--                class="navbar-toggler-icon"></span></button>--%>
<%--        <div class="collapse navbar-collapse"--%>
<%--             id="navcol-1">--%>
<%--            <ul class="nav navbar-nav mr-auto">--%>
<%--                <li class="nav-item"  ><a class="nav-link"--%>
<%--                                          href="/user/create_request"--%>
<%--                                          th:text="#{new_request}"></a>--%>
<%--                </li>--%>
<%--                <li class="nav-item" ><a class="nav-link"--%>
<%--                                         href="/user/all_requests"--%>
<%--                                         "></a>--%>
<%--                </li>--%>
<%--                <li class="nav-item" ><a--%>
<%--                        class="nav-link"--%>
<%--                        href="/user/create_comment" >Create comment</a>--%>
<%--                </li>--%>
<%--                --%>
<%--            </ul>--%>
<%--            <span class="navbar-text actions"> <a class="login" th:href="@{/logout}" th:text="#{nav.logout}"></a></span>--%>
<%--            <button class="btn" type="button" id="locales" value="uk"--%>
<%--                    style="height: 20px;background-image: url(&quot;/assets/img/ua.jpg&quot;);background-position: center;margin-right: 2px;margin-left: 15px;"></button>--%>
<%--            <button--%>
<%--                    class="btn" type="button" id="locales2" value="en"--%>
<%--                    style="height: 20px;background-image: url(&quot;/assets/img/en.jpg&quot;);background-position: center;background-size: cover;background-repeat: no-repeat;padding-right: 12px;margin: 6px;margin-top: 6px;margin-right: -27px;margin-left: 1px;"></button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<%--<div th:if="${param.error}">--%>
<%--    <div class="alert alert-danger" th:text="#{empty.value}">--%>
<%--    </div>--%>
<%--    <div th:if="${param.logout}">--%>
<%--        <div class="alert alert-info">--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<div  style="margin:0 auto;" class="row justify-content-center align-items-center align-content-center align-self-center">
    <input name="request" type="hidden"/>
    <div class="col" style="width: 404px;">
        <form  action="${pageContext.request.contextPath}/app/create_request"
               method="get">
            <label>New Request</label>
            <br/>
            <textarea name="request" rows="3"></textarea>
            <br/>
            <button type="submit"  class="btn btn-light">
                Create
            </button>
        </form>
    </div>
</div>
</body>
</html>