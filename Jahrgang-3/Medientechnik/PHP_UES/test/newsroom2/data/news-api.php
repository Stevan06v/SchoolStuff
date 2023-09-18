<?php


$data = "";
$category = "";



if (file_exists('data.json')) {

    # get data out of json
    $data = json_decode(file_get_contents("./data.json"));


    if (isset($_GET['category'])) {
        $category = $_GET['category'];

        switch ($category) {
            case 'sport':
                echo json_encode($data->sport);
                break;
            case 'science':
                echo json_encode($data->science);
                break;
            case 'all':
                echo json_encode($data);
                break;
        }
    }
}
