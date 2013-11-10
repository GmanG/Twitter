<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ page session="false"%>--%>
<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="<c:url value="/js/index.js"/>"></script>
    <link rel='stylesheet' href="<c:url value="/css/index.css" />" type='text/css'>
</head>
<body>
    <div id="main">
        <div id="right" >
            <div id="welcome" class="main-page"></div>
            <div id="login-register">
                <div id="login" class="main-page">
                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="Email" value="aaaaa">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                            <button type="button" id="signin-button"  class="btn btn-primary btn-sm" onclick="javascript: UserLogin.checkUser();">Sign in</button>
                        </div>
                    </div>
                    <%--<div class="checkbox">--%>
                        <%--<label>--%>
                            <%--<input type="checkbox"> Remember me--%>
                        <%--</label>--%>
                    <%--</div>--%>
                </div>

                <div id="register" class="main-page">
                    Register:
                    <input type="email" class="form-control" id="name-register" placeholder="Full Name">
                    <input type="email" class="form-control" id="email-register" placeholder="Email">
                    <input type="password" class="form-control" id="register-password" placeholder="Password">
                    <button type="button" id="register-button"  class="btn btn-primary btn-sm" onclick="javascript: Registration.register();">Register</button>
                </div>
            </div>
        </div>
        <div id="left">

        </div>
    </div>
    <form method="GET" action="/usercheck">
        <input type="submit" value="Redirect Page"/>
    </form>
</body>
</html>
