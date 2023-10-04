<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <?php

    echo "<h1>Ich liebe den PHP Master aber WEB MASTER > PHP MASTER</h1>";
    

    $a = 9;
    $b = 10;


    //php parameter 
    //http://localhost/Mitschrift_ifs/home.php?name=Stevan&id=23&nachname=vlajic
  

    //php 
    // boolean wird auch als 0 = false und 1 = true 
    // a wird in b gespeichert 
    // a = 10 und a !=0 d.h. true


    //=== vergleicht den Datentyp


    if ($a = $b) {
        echo "wahr";
    } else {
        echo "falsch";
    }

    echo "<pre>";

    //vardump gibt mehr als echo aus
    //http://localhost/Mitschrift_ifs/home.php?user=Stevan&id=23
    var_dump($_GET["user"]);
    var_dump($_GET["id"]);

    
    echo date("-r");


    $price = $_GET["zimmer"];

    // abfrage ob der wert gesetzt ist:
    // wenn ja true oder 0 sonst false 
    if(isset($price) && $price > 100){
        echo "<p>Zimmer teuer: $price </p><br>";
    }else{
        echo "<p>Zimmer billiger: $price </p><br>";
    }


    // whole array
    var_dump($_GET);


    echo "</pre>";

 
   
    ?>


</body>

</html>