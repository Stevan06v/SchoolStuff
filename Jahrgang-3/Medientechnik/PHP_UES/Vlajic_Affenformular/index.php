<!DOCTYPE html>
<html lang="de">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Affenformular</title>
    <link rel="stylesheet" href="./style.css">
</head>

<body>

    <?php

    $array = array('voranme', 'nachname', 'geburtsdatum', 'testtermin', 'sozialversicherungsnummer', 'email');
        $input = array();
        $error = array();

    if (isset($_POST['senden'])) {
        

        for ($i = 0; $i < count($array); $i++) {
            if (isset($_POST["$array[$i]"]) && strlen(trim($_POST["$array[$i]"]) && !is_array($_POST["$array[$i]"]))) {
                $eingabe["$array[$i]"] = htmlspecialchars(trim($_POST["$array[$i]"]));
            } else {
                $error["$array[$i]"] = "$array[$i]";
            }
        }

        if (isset($_POST['telefon']) && strlen(trim($_POST['telefon']) > 4 && !is_numeric($_POST['telefon']))) {
            $eingabe['telefon'] = (trim($_POST['telefon']));
        } else {
            $error['telefon'] = 'telefon';
        }




        if (empty($error)) {
            $success = 'All right';
            exit();
        } else {
            $errors = implode(', ', $error);
            $err = 'Es sind Fehler aufgetretn: ' . $errors;
        }
    }
    ?>



    <div id="wrapper">
        <form action="
        <?php
        echo htmlentities($_SERVER['PHP_SELF']);
        ?>" method="post">
            <div>
                <div class="input">
                    <label for="vorname">Vorname</label><br>
                    <input type="text" name="vorname" id="vorname">
                    <?php if (isset($input['vorname'])) echo 'value="' . $input['vorname'] . '"'; ?>
                </div>

                <div class="input">
                    <label for="nachname">Nachname</label><br>
                    <input type="text" name="nachname" id="nachname">
                    <?php if (isset($input['nachname'])) echo 'value="' . $input['nachname'] . '"'; ?>
                    <br>
                </div>
            </div>

            <div>
                <div class="input">
                    <label for="geburtsdatum">Geburtsdatum</label><br>
                    <input type="datetime-local" name="geburtsdatum" id="geburtsdatum" min="0000-00-00T00:00:00" ?>
                    <?php if (isset($input['geburtsdatum'])) ?>
                    <br>
                </div>


                <div class="input">
                    <label for="sozialversicherungsnummer">Sozialversicherungsnummer</label><br>
                    <input type="text" name="sozialversicherungsnummer" id="sozialversicherungsnummer">
                    <?php if (isset($input['sozialversicherungsnummer'])) echo 'value="' . $input['sozialversicherungsnummer'] . '"'; ?>
                    <br>
                </div>
            </div>

            <div>
                <div class="input">
                    <label for="telefon">Telefonnummer</label><br>
                    <input type="tel" pattern="\+[0-9]+" name="telefon" id="telefon">
                    <?php if (isset($input['telefon'])) echo ' value="' . $input['telefon'] . '"'; ?>
                    <br>
                </div>

                <div class="input">
                    <label for="email">E-Mail Adresse</label><br>
                    <input type="email" pattern="+.+@+\.+" name="email" id="email">
                    <?php if (isset($input['email'])) echo ' value="' . $input['email'] . '"'; ?>
                    <br>
                </div>
            </div>

            <div>

                <div class="input">
                    <label for="teststrasse">Teststraße</label><br>
                    <select name="teststrasse" id="teststrasse" value="1">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                    <?php if (isset($input['teststrasse'])) echo ' value="' . $input['teststrasse'] . '"'; ?>
                    <br>
                </div>

                <div class="input">
                    <label for="testtermin">Testtermin</label><br>
                    <input type="datetime-local" name="testtermin" id="testtermin" min="0000-00-00T00:00:00" max="<?php $date = new DateTime();

                                                                                                                    echo $date->format('Y-m-d\TH:i:s'); ?>" value="<?php $date = new DateTime();
                                                                                                                                                        echo $date->format('Y-m-d\TH:i:s'); ?>" step="1">
                    <?php if (isset($input['testtermin'])) echo 'value="' . $input['testtermin'] . '"'; ?>
                    <br>
                </div>

            </div>


            <input type="submit" name="senden" value="submit">

        </form>
    </div>

    <?php
    if (!empty($error)) {
        echo "<h1>Something went wrong!<h1>";
    } else {
        echo "all fine!";
    }
    ?>


</body>

</html>