<?php

$data = file_get_contents("./data/news.json");
        $data_obj = json_decode($data); 

        $title="";
        $img="";
        $message="";
        $date="";
        $author="";

        echo "<h2 style='margin-top:1vw; text-align: center;'>---  Science  ---</h2>";
        echo "<div class='boxGrid'>";
     for ($i=0; $i < sizeof($data_obj->science); $i++) {

        $title = $data_obj->science[$i]->title;
        echo "<div> <h1>$title</h1>";

        $img = $data_obj->science[$i]->img;
        echo "<img src='$img'></img> </div>";

        $message= $data_obj->science[$i]->message;
        echo "<p>$message</p>";

        $date= $data_obj->science[$i]->date;
        echo "<p>$date</p>";

        $author= $data_obj->science[$i]->author;
        echo "<p>$author</p>";
        
        } 
        echo "</div>";
       
?>

