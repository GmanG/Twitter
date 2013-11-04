<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
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
    <script>
        $(document).ready( function() {
//            User.myAlert('my alert');
            User.some();
            var ss = $('#inputEmail3').val();
//            console.log(ss);
//            console.log(User.loginFileds.login);
//            Twitt.addTwitt();
            $.ajax({
                url: "getuser",
                type: "GET",
                success: function(data) {
//                    $("#info").html(data);
                }
            })
//            Register.register();

        });
//        var User =  {
//
//            myAlert: function(info) {
//                alert(info);
//            },
//
//            loginFileds: {
//                login: $("#inputEmail3").val(),
//                password: "",
//                button: ""
//            },
//
//            some: function() {
//                var r = $("#inputEmail3").val();
////                $("#register").html(r);
//        }
//        };
        var UserLogin = {
            checkUser: function() {
                var email = "user1@gmail.com";
                var password = "pass";
                $.ajax({
                    type: "POST" +
                            "",
                    url: "usercheck",
                    data: {email:email, password:password},
                    success: function() {

                    },
                    erorr: function() {

                    }
                })
            }
        };

        var Registration = {

            register: function() {
                var fullName = $("#name-register").val();
                var email = $("#email-register").val();
                var password = $("#register-password").val();

//                $("#register-button").click( function() {
//                    console.log(mail+" :=====: "+pass);
//                })
                $.ajax({
                    url: "registration",
                    type: "POST",
                    data: {fullName:fullName, email: email, password: password },
                    success: function() {

                    },

                    erorr: function() {

                    }

                })
            }
        };

//        var Twitt = {
//
//            tr: {
//                one: "one",
//                two: "two",
//                three: "three"
//            },
//
//            addTwitt: function() {
//                $.each({
//                    one: "one",
//                    two: "two",
//                    three: "three"
//                }, function(index, value) {
//                    console.log(value);
//                })
//            }
//        }

    </script>
    <%--<link rel='stylesheet' href="<c:url value="/css/main.css" />"--%>
    <%--<link rel='stylesheet' href=""/css/main.css">--%>
    <style>
        body {
            background: radial-gradient(circle, #94D2F8, #3A92C8) repeat scroll 0 0 rgba(0, 0, 0, 0);
        }
        #main {
            width: 80%;
            height: 800px;
            margin: 20px auto;
            /*background-color: red;*/
            border: 1px solid black;
        }
        #right {
            width: 80%;
            height: 600px;
            border: 1px solid blue;
            float: left;
        }
        #left {
            width: 15%;
            height: 600px;
            border: 1px solid red;
            float: left;
        }
        #welcome {
            width: 450px;
            height: 320px;
            border: 1px solid black;
            float: left;
        }
        #login {
            width: 350px;
            height: 150px;
            border: 1px solid black;
            margin: 0 20px;

        }
        #register {
            width: 350px;
            height: 150px;
            border: 1px solid black;
            margin: 20px;
        }
        .main-page {
            border-radius: 4px;
            background-color: white;
        }
        #login-register {
            float: left;
        }
        #exampleInputPassword1 {
            width: 160px;
            margin-top: 5px;;
        }
    </style>
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
