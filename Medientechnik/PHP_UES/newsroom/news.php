<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stevan NEWS</title>
    <link rel="stylesheet" href="style.css">
    <script src="./script.js"></script>
    <link rel="stylesheet" href="./css/style.css">
</head>

<body>


    <?php
    $categories = array("austria", "science", "sports", "all");

    echo "<div id='navGrid'>";
    for ($i = 0; $i < 4; $i++) {
        echo "<a href='./news.php?category=$categories[$i]'>$categories[$i]</a>";
    }
    echo "</div>";


    $param = isset($_GET['category']) ? $_GET['category'] : "not defined";

    switch ($param) {
        case 'austria':
            include("./categories/austria.php");
            break;
        case 'science':
            include("./categories/science.php");
            break;
        case 'sports':
            include("./categories/sports.php");
            break;
        case 'all':
            include("./categories/all.php");
            break;
        default:
            include("./categories/all.php");
            break;
    }




    ?>





</body>

</html>