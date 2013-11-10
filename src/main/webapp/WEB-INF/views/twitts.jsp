<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <script type="text/javascript" src="<c:url value="/js/twitts.js"/>"></script>
    <link rel='stylesheet' href="<c:url value="/css/twitts.css" />" type='text/css'>
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
                <div id="followers"><input type="button" value="Follow" onclick="javascript: Tweet.follow(2, 3);"></div>
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