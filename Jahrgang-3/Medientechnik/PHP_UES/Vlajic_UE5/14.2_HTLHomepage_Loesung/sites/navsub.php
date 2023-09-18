
<?php

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


