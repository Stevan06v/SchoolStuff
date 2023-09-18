<?php
    if(!strpos($_SERVER['PHP_SELF'], "home")) include ("./head.php");

    $s = ' 
            <nav class="rows">
            <div class="columns column-4">
                <a class="it" href="informatik.php">
                    <h2>Informatik</h2>
                </a>
            </div>
            
            <div class="columns column-4">
                <a class="medt" href="medientechnik.php">
                    <h2>Medientechnik</h2>
                </a>
            </div>
            
            <div class="columns column-4">
                <a class="et" href="elektronik.php">
                    <h2>Elektronik</h2>
                </a>
            </div>
            
            <div class="columns column-4">
                <a class="medz" href="medizintechnik.php">
                    <h2>Medizintechnik</h2>
                </a>
            </div>
        </nav>';
        
    $pos = strpos($s, $site[0]);
    echo $site[0];
    if(!strpos($_SERVER['PHP_SELF'], "home")) $s = substr($s, 0, $pos) . "active " .  substr($s, $pos, strlen($s));
    echo $s;
?>