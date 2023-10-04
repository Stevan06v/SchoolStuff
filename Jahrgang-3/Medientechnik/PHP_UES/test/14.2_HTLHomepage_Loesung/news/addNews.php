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

    $success = array();
    $errors = array();



    if (isset($_POST['name']) && isset($_POST['lastname']) && isset($_POST['description']) && isset($_POST['date']) && isset($_POST['email'])) {
        $name = testInput($_POST['name']);

        if (isset($_POST['submit'])) {
            if (strlen($name) > 4) {
                array_push($success, $name);
            } else {
                array_push($errors, $name);
            }

            $lastname = testInput($_POST['name']);

            if (strlen($lastname) > 4) {
                array_push($success, $lastname);
            } else {
                array_push($errors, $lastname);
            }

            if (empty($errors)) {
                echo "successfully logged in";
                foreach ($success as $iterator) {
                    echo $iterator . " ";
                }
                exit();
            } else {
                foreach ($errors as $iterator) {
                    echo $iterator;
                }
            }
        }
    }else{
        include("form.php");
    }


    function testInput($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }




    ?>


</body>

</html>