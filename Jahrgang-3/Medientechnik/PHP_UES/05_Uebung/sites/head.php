<?php
    $site = null;
    if(strpos($_SERVER['PHP_SELF'], "home")) $site = ["", "home"];
    else if(strpos($_SERVER['PHP_SELF'], "informatik")) $site = ["it", "informatik"];
    else if(strpos($_SERVER['PHP_SELF'], "elektronik")) $site = ["et", "elektronik"];
    else if(strpos($_SERVER['PHP_SELF'], "medientechnik")) $site = ["medt", "medientechnik"];
    else if(strpos($_SERVER['PHP_SELF'], "medizintechnik")) $site = ["medz", "medizintechnik"];
    
    echo '
    <!doctype html>
    <html lang="de">
        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>HTL Leonding</title>
            <meta name="description" content="Skalable Demopage of HTL Leonding">
            <link rel="stylesheet" type="text/css" href="../css/style.css">
            <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
        </head>
    <body id="' . $site[1] . '">
            <div id="wrapper">
                <header class="rows">
                    <a href="home.php"><h1>HTL Leonding</h1></a>
                </header>   
    ';
?>