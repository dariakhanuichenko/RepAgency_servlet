<html>
<head>
    <title>Registration form</title>

</head>
<body>
        <h2>
            This is registration form! <br/>
        </h2>

        <form method="get" action="${pageContext.request.contextPath}/app/registration">

            Name <input type="text" name="name"><br/>
            Email <input type="text" name="email"><br/>
            Password <input type="password" name="pass"><br/>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>
                    select your role
                </label>
                <select name="role" path="roles" class="selectpicker">
                    <option value="ROLE_USER">
                        ROLE_USER
                    </option >
                    <option  value="ROLE_MASTER">
                        ROLE_MASTER
                    </option >
                    <option  value="ROLE_MANAGER">
                        ROLE_MANAGER
                    </option >
                </select>
            </div><br/>
            <input class="button" type="submit" value="Submit">

        </form>

        <a href="${pageContext.request.contextPath}/index.jsp">Index</a>
</body>
</html>