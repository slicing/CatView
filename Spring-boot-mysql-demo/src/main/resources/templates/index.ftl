<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/css/index.css" rel="stylesheet">
    <script type="text/javascript" src="/webjars/jquery/2.2.4/jquery.min.js"></script>
    <title>index</title>
</head>
<body>
    <button id="title">${title}</button>
    <h1 id="title">${title}</h1>
    <p></p>
    <p></p>
    <p></p>
</body>
<script>
    $(function(){
        $("#title").click(function () {
            $.ajax({
                url:"http://localhost:8081/api/hello",
                type:"POST",
                data:{
                    name:"slicing"
                },
                success:function (data) {
                    $('p').html(data.action + " " + data.name);

                }
            })
        })
    })
</script>
</html>