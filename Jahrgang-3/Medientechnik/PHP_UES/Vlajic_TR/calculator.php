
<?php

# eval unter der verwendung von regex clientsite
    $data = $_GET['data'];

    if(isset($data)){
        try{
            eval("echo $data;");
        }catch(Exception $e){
            echo "[ArithmeticException]";
        }
    }else{
        echo "error occcured";
    }
  



    