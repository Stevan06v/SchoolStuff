<!DOCTYPE html>
<html lang="de">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="./script.js" defer></script>
</head>

<body>

    <p onclick="getData()">button</p>

    <div>
        <input type="text" id="text">
        <div id="send" onclick="sendData()">send</div>
    </div>

    <?php


    $array  = array("a"=>"jk","s"=>"hj");



    foreach($array as $key => $value){
        echo $key . ": " . $value . "\n";
    }




    $data = "";
    if (file_exists("books.json")) {
        $data = json_decode(file_get_contents("books.json"));

        echo "<pre>";

        var_dump($data);

        echo "</pre>";

        for ($i = 0; $i < count($data->library); $i++) {
            $isbn = $data->library[$i]->isbn;
            echo "<div class='data'>";
            echo "<h1>$isbn</h1>";
            echo "</div>";
        }
    }






    ?>




    <?php
    


    function validate($data){
        $data = trim($data);
        $data = htmlspecialchars($data);
        $data = stripslashes($data);

        return $data;
    }


    if(isset($_POST['name']) && isset($_POST['lastname']) && isset($_POST['date']) ){
        
        if(strlen(validate($_POST['name'])) > 4){
            echo "name";
        }else{
            echo "false";
        }

        if (strlen(validate($_POST['lastname'])) > 4) {
            echo "lastname";
        } else {
            echo "false";
        }


    }else {
        include("./components/input.php");
    }
    
    ?>



</body>

</html>