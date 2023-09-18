<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<h1>Annuität</h1>

<?php

    $zinssatz = 0.05;
    $years = 10;
    $kredit_sum = 200000;
    $todays_zins= 0.0380;

    # round(value, kommastellen)
    $annu = round(($kredit_sum * $zinssatz * (1+ $zinssatz)**$years) / ((1+$zinssatz)**$years -1), 3);
    
    echo "Früher: {$annu}€";

    $annu_today =round(($kredit_sum * $todays_zins * (1 + $todays_zins) ** $years) / ((1 + $todays_zins) ** $years - 1), 3);
    echo "<br>";
    echo "Heute: {$annu_today}€";


?>
    
</body>
</html>