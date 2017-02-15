/**
 * Created by rubenvarela on 2/15/17.
 */
(function(){
    var request = $.ajax({
        url: '/posts.json'
    });

    request.done(function(posts) {  //the HTTP response -> an array of JSON objects
        console.log(posts);
        var i, html = "";
        for (i = 0; i < posts.length; i++) {
            html += "<div><h2>" + posts[i].title + "</h2><p>" + posts[i].body + "</p></div>"
        }

        $("#load-posts").html(html)
    });

})();
