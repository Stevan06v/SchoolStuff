<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add News article</title>
</head>

<body>

<?php


    $eingabe = array(
        2,1,6,3,0,4,2
    );
    $error= array(2,4);



    $fruits = array("hallo" => "Zitrone","hfallo" => "Orange", "haello"=>"Banane","hawllo"=> "Apfel");

    $temp = array("ok"=>"ok");



    array_push($error,23);


    foreach($error as $iterator){
        echo "$iterator". "<br>";
    }



    if(isset($_POST['titel']) && strlen(trim($_POST['title'])) > 4 && !is_array($_POST['title'])){
        $eingabe['title']=htmlspecialchars(trim($_POST['title']));
    
    }else{
        $error['title'] = 'title';
    }

    if(isset($_POST['author']) && strlen(trim($_POST['author'])) > 4 && !is_array($_POST['author'])){
        $eingabe['author']=htmlspecialchars(trim($_POST['author']));
    
    }else{
        $error['author'] = 'author';
    }

    echo '<form action="' . htmlspecialchars($_SERVER["PHP_SELF"]) . '" method="post">';
        echo '<input type="text" name="title" id="title">';
        echo '<input type="text" name="msg" id="msg">';
        echo '<input type="date" name="date" id="date">';
    echo '<input type="submit" value="">';
    echo '</form>';


    if(empty($error)){
            $success="Everything succeded!";

            echo $success;
            exit();
        }else{
            $errors = implode(', ',$error);
            $err="There are errors";
        }
    

?>



</body>

</html>