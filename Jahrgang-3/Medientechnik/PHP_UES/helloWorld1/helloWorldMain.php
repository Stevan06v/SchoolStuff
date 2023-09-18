<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- 
        File ist ueber localost:80/Uebungen/helloworld.php aufrufbar
        Php werden nie direkt ueber filezugriff gecallt
        * immer [;] am Ende  
     -->
    <?php 

        #vordefinierte PHP variablen werdern Gross und mit unterstrich geschrieben

        #holt sich alles aus header.php datei
        include('./helloWorldHeader.php');


        echo $_SERVER;


        #Kommentar
        //Kommentar
        /* Kommentar */

        $name= "Stevan";

        #variable werden mit $ angefuehrt
        #php template String funktionieren mit doppeltem hochkomma 
        echo "<h2>What are you doing? $name". $name ."</h2> ${name}";
        echo "hallo";

        $city= "linz";

        //{}
        echo "<p>{$city} stadt</p>";
        
        echo "<p>$citystadt</p>";  #error 

        #rechnen 
        $x = 10;
        $y=17;

        echo "$x + $y= " . $x +$y;
      
        

        # [.] <-- text wird zusammengesetzt
        echo "hallo"."welt";
        # [+] oerator ist ein reiner Rechenoperator
        echo "17"+"5"; # parst string automatisch zu Integern
        
        

    include('./footer.php');

    ?>
</body>
</html>