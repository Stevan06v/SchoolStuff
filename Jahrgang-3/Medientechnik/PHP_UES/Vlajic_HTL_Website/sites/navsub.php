
<?php

    echo '<nav class="rows">
    <div class="columns column-4">
        <a class="it" href="home.php?site=informatik">
            <h2>Informatik</h2>
        </a>
    </div>
    
    <div class="columns column-4">
        <a class="medt" href="home.php?site=medientechnik">
            <h2>Medientechnik</h2>
        </a>
    </div>
    
    <div class="columns column-4">
        <a class="et" href="home.php?site=elektronik">
            <h2>Elektronik</h2>
        </a>
    </div>
    
    <div class="columns column-4">
        <a class="medz" href="home.php?site=medizintechnik">
            <h2>Medizintechnik</h2>
        </a>
    </div>
</nav>';

    $currentSite="safasf";
 
    //PHP_UES/Vlajic_UE5/14.2_HTLHomepage_Loesung/sites/
  
    if(strpos($_SERVER['PHP_SELF'], "medientechnik")) $currentSite = "medientechnik"; 
    else if(strpos($_SERVER['PHP_SELF'], "elektronik")) $currentSite = "elektronik"; 
    else if(strpos($_SERVER['PHP_SELF'], "home")) $currentSite = "home";
    else if(strpos($_SERVER['PHP_SELF'], "medizintechnik")) $currentSite = "medizintechnik";
    else if(strpos($_SERVER['PHP_SELF'], "informatik")) $currentSite = "informatik";
    else  $currentSite = "error";

  
    echo `<h1>$currentSite</h1>`

?>


