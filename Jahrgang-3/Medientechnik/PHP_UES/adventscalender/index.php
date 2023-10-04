<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Advent Advent</title>
    <link rel="stylesheet" href="./css/style.css">
    <script src="https://kit.fontawesome.com/61efd671c0.js" crossorigin="anonymous"></script>
    <script src="./script.js" defer></script>
    <link rel="stylesheet" href="./css/snow.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.4.0/styles/atom-one-dark.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.4.0/highlight.min.js" defer></script>
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-LLWL5N9CSM"></script>

</head>
<body>


    <div id="letItSnow"></div>
    <div id="stuff"></div>
    <?php


    $arr = array(
        "first",
        "second",
        "thrid",
        "fourth"
    );
    $icons = array(
        "fa-solid fa-gift",
        "fa-solid fa-code",
        "fa-solid fa-gear",
        "fa-brands fa-raspberry-pi"
    );
    $dates = array(
        "01-12-2022 - 06.12.22",
        "06-12-2022 - 12.12.22",
        "12-12-2022 - 18.12.22",
        "18-12-2022 - 24.12.22"
    );
    $headlines = array(
        "Sensors",
        "Gear",
        "Coding",
        "Raspberry"
    );

    $rank = "usual";
    $counter = 1;
    $temp = 0;

    echo "<div>";
    echo "<h1 id='headText'>Advent calendar for creators</h1>";
    echo "</div>";

    echo "<div class='upperGrid'>";
    for ($i = 1; $i <= 4; $i++) {

        echo "<div>";

        echo "<div class='area-head'>";

        echo "<p> Topic -$headlines[$temp]</p>";
        echo "<p class='date'>$dates[$temp]</p>";


        echo "</div>";

        echo "<div class='adventGrid'>";
        for ($j = 1; $j <= 6; $j++) {
            switch ($i) {
                case 1:
                    generate_Box("boxUsuals", "usualICON icon", $icons[$i - 1], $counter);
                    break;
                case 2:
                    generate_Box("boxCoding", "usualICON icon", $icons[$i - 1], $counter);
                    break;
                case 3:
                    generate_Box("boxGear", "usualICON icon", $icons[$i - 1], $counter);
                    break;
                case 4:
                    generate_Box("boxRaspi", "usualICON icon", $icons[$i - 1], $counter);
                    break;
                default:
                    generate_Box("boxUsuals", "usualICON icon", $icons[$i - 1], $counter);
                    break;
            }

            $counter++;
        }
        echo "</div>";
        echo "</div>";

        $temp++;
    }
    echo "</div>";



    // funcs 
    function generate_Box($boxType, $rank, $icon, $id)
    {
        echo "    
    <div class='$boxType $rank' onclick='selectPos($id)'>
        <div class='innerFlex'>
            <i class='$icon'></i>
        </div>
    </div>";
    }

    ?>




</body>

</html>