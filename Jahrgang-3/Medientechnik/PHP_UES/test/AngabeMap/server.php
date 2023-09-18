<?php


if(isset($_GET['input'])){
    $input = $_GET['input'];

     eval("echo $input;");

}else{
    echo "nothing receibved";
}



?>