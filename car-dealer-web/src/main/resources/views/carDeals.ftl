<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Blog posts</title>

    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.css">
    <style>
        .navbar-brand {
            font-size: 30px;
        }

        .blog-post-title {
            font-size: 24px;
            padding-top: 30px;
        }

        .blog-post-meta {
            color: #888888;
        }

        .blog-post {
            margin-bottom: 30px;
            border-bottom: 1px solid grey;
        }
    </style>
</head>

<body>
    <div class="container">

        <nav class="navbar navbar-dark bg-dark">
            <div class="navbar-brand">Blog Posts</a>
        </nav>

        <#list carDeals as carDeal>
        <div class="blog-post">
            <h2 class="blog-post-title">${carDeal.title}</h2>
            <p class="blog-post-meta">${carDeal.uploadDate?datetime} by <a href="#">${carDeal.writer}</a></p>

            <p>${carDeal.content}</p>
        </div>
        </#list>
    
        <h2>Add new blog post</h2>

        <form method="POST">
            <label for="title">Title:</label> <input type="text" name="title" required> <br>
            <label for="writer">Writer:</label> <input type="text" name="writer" required> <br>
            <label for="content">Content:</label> <input type="textarea" name="content" required> <br>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
