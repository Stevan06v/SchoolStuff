<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <?php



    $array = array("hallo", "wioe gehts", "ok");

    $array2 = array(1, 6, 2, 4, 5, 3);


    sort($array2) ;

    
    
    for ($i=0; $i < count($array2); $i++) { 
        echo "<li>$array2[$i]</li>";
    }


    for ($i = 0; $i < count($array); $i++) {
        echo "$array[$i]";
    }


    echo "start";

    $data = "";
    $path  = "./news.json";
    if (file_exists($path)) {
        $data = json_decode(file_get_contents($path));
    }


    $category = "";

    include('./nav.php');


    if (isset($_GET['category'])) {
        $category = $_GET['category'];

        switch ($category) {
            case 'sport':

                for ($i = 0; $i < count($data->sport); $i++) {
                    echo $data->sport[$i]->name;
                    echo $data->sport[$i]->text;
                    echo $data->sport[$i]->description;
                }

                break;
            case 'school':
                include('loadData.php');

                break;
            case 'home':
                include('loadData.php');


                break;
            case 'tech':
                include('loadData.php');


                break;
            case 'science':
                include('loadData.php');
                break;
        }
    }


    ?>







</body>

</html>