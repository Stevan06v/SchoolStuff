<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="./js/script.js" defer></script>
    <link rel="stylesheet" href="./css/style.css">
</head>

<body>

<a href="./modules/addNews.php">add news</a>

    <?php
        include('./modules/category.php');
    ?>

    <div id="articles"></div>


</body>
</html>