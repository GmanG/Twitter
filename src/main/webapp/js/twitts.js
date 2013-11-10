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
                $("#tweet-message").val("");
//                        console.log("complete render me")
            }
        })


    },
    transformDate: function(date) {
        var d = new Date(date);
        return d.toLocaleDateString();
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
                    tweets += "<div class='tweets-div'>"+value.message+"</div><span> " + Tweet.transformDate(value.dat) + "</span>"
//                        console.log(value.tweet);
                })
                $("#tweet-and-info").html(tweets);
            },
            error: function() {

            }
        })

    },

    follow: function(owner, listener) {
        console.log(owner+" \\follow\\ "+listener);
        $.ajax({
            type: "POST",
            url: "followUser",
            data: {owner: owner, listener: listener},
            errot: function() {

            }
        })
    }
}