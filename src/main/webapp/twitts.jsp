<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/11/13
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script>
        $(document).ready( function() {
            Tweet.renderTweets();
        });

        var Tweet = {
            sendTweet: function() {

                var tweet = $("#tweet-message").val();
                var email = "user1@gmail.com";
                $.ajax({
                    type: "POST",
                    url: "addTweet",
//                    data: {tweet:tweet, email:email},
                    data: {tweet:tweet},
                    sucess: function() {

                    },
                    error: function() {

                    },
                    complete: function() {
                        Tweet.renderTweets();
//                        console.log("complete render me")
                    }
                })


            },

            renderTweets: function() {
                var tweets = "";
                $.ajax({
                    type: "POST",
                    url: "getTweets",
                    dataType: "json",
                    success: function(data) {
//                    console.log(data);
                        $.each(data, function(index, value) {
                            tweets += "<div class='tweets-div'>"+value.tweet+"</div>"
//                        console.log(value.tweet);
                        })
                        $("#tweet-and-info").html(tweets);
                    },
                    error: function() {

                    }
                })

            }
        }
    </script>
    <style>
        #main {
            width: 90%;
            height: 100%;
            border: 1px solid black;
            margin: auto;
            /*background: url("https://abs.twimg.com/a/1383435013/t1/img/wash-white-30.png") repeat scroll 0 0 rgba(0, 0, 0, );*/
        }
        #info-twitts {
            width: 35%;
            height: 800px;
            margin: auto;
            /*border: 1px solid black;*/

        }
        #user-info {
            width: auto;
            height: 250px;
            border: 1px solid black;
            background-color: #444444;
        }
        #twitts {
            width: auto;
            height: auto;
            border: 1px solid black;

        }
        .info-twitt {
            border-radius: 4px;
            margin-top: 20px;
        }
        #follow-info {
            width: auto;
            height: 50px;
            background-color: white;
        }
        #personal-info {
            width: auto;
            /*background-color: purple;*/
            height: 200px;
        }
        #count-tweets {
            width: 100px;
            border-right: 1px solid black;
            padding: 5px;
            float: left;
        }
        #count-tweets span {
            padding-left: 20px;
            text-align: center;
        }
        #following {
            width: 100px;
            border-right: 1px solid black;
            float: left;
            padding: 5px;
        }
        #sendTwitt {
            width: auto;
            border-bottom: 1px solid black;
        }
        .tweets-div {
            width: auto;
            height: 40px;
            border-bottom: 1px solid black;
        }
    </style>
</head>
<body>
<div id="main">
    <div id="info-twitts">
        <div id="user-info" class="info-twitt">
            <div id="personal-info"></div>
            <div id="follow-info">
                <div id="count-tweets">
                    <span>456</span><br>
                    <span>tweets</span>
                </div>
                <div id="following">
                    <span>456</span><br>
                    <span>tweets</span>
                </div>
                <div id="followers"></div>
            </div>
        </div>

        <div id="twitts" class="info-twitt">
            <div id="sendTwitt">
                <textarea id="tweet-message" class="form-control" rows="2"></textarea> <br>
                <input type="button" value="Tweet" onclick="javascript: Tweet.sendTweet();">
                <div id="tweet-and-info"></div>
            </div>
        </div>
    </div>
</div>

</body>
</html>