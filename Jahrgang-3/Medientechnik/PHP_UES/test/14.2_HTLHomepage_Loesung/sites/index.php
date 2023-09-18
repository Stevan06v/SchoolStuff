<!doctype html>
<html lang="de">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTL Leonding</title>
    <meta name="description" content="Skalable Demopage of HTL Leonding">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
    <link rel="icon" href="../img/favicon.png" type="image/png" sizes="180x180">
</head>


<?php


$category = isset($_GET['category']) ? $_GET['category'] : "home";


echo "<body id='$category'>
<div id='wrapper'>";

include("./modules/header.php");


switch ($category) {
    case 'medientechnik':
        include("./modules/nav.php");
        include("./medientechnik.php");
        break;
    case 'informatik':
        include("./modules/nav.php");
        include("./informatik.php");
        break;
    case 'medizintechnik':
        include("./modules/nav.php");
        include("./medizintechnik.php");
        break;
    case 'elektronik':
        include("./modules/nav.php");
        include("./elektronik.php");
        break;
    case 'home':
        include("./modules/main.php");
        break;
}

include("./modules/footer.php");
echo "</div>
</body>";
?>

</html>