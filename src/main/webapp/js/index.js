$(document).ready( function() {
    var ss = $('#inputEmail3').val();
    $.ajax({
        url: "getuser",
        type: "GET",
        success: function(data) {
        }
    })
//    Register.register();

        });
    var UserLogin = {
        checkUser: function() {
            var email = "user1@gmail.com";
            var password = "pass";
            $.ajax({
                type: "GET",
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