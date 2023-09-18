<?php


/* if(isset($_GET["data"])){
    $output = $_GET["data"];

    echo eval($output);
}
 */

/* echo "";

echo '    
    <a href="./home.php?text=1">text 1</a>
    <a href="./home.php?text=2">text 2</a>
    <a href="./home.php?text=3">text 3</a>
'; */


$array = array(
    "ok" => "d",
    "name" => 2
);


echo "";


$path = "./books.json";

/*     if(file_exists($path)){
        $json = file_get_contents($path);
        echo json_encode($json);
    }else{
        echo "file not found";
    }
 */
    $book="";

    if(isset($_GET['book'])){
        $book = $_GET['book'];
        getBookByName($book);
    }


    function getBookByName($name){
        $path = "./books.json";
            if(file_exists($path)){
                $data = json_decode(file_get_contents("books.json")) ;
                
                for ($i=0; $i < count($data->library); $i++) { 
                    if($data->library[$i]->title == $name){
                        echo json_encode($data->library[$i]);
                        break;                      
                    }
                }
            }
        
    }

    function addBooks(){

    }
