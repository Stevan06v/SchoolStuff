<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Return to monke</title>
</head>

<body>
    <h1>Anmeldung für Schnelltest</h1>
    <?php
    if (isset($_POST['dataInput'])) {
        $input = array();
        $error = array();

        /* Wieso nicht auch fori? => Weil man die Überprüfungen noch ausbauen könnte */

        /* Vorname */
        if (isset($_POST['vorname']) && strlen(trim($_POST['vorname'])) && !is_array($_POST['vorname'])) {
            $input['vorname'] = $_POST['vorname'];
        } else {
            $error['vorname'] = 'vorname';
        }

        /* Nachname */
        if (isset($_POST['nachname']) && strlen(trim($_POST['nachname'])) && !is_array($_POST['nachname'])) {
            $input['nachname'] = $_POST['nachname'];
        } else {
            $error['nachname'] = 'nachname';
        }

        /* Geburtsdatum */
        if (isset($_POST['geburtsdatum']) && strlen(trim($_POST['geburtsdatum'])) && !is_array($_POST['geburtsdatum'])) {
            $input['geburtsdatum'] = $_POST['geburtsdatum'];
        } else {
            $error['geburtsdatum'] = 'geburtsdatum';
        }

        /* Sozialversicherungsnummer */
        if (isset($_POST['sozialversicherungsnummer']) && strlen(trim($_POST['sozialversicherungsnummer'])) && !is_array($_POST['sozialversicherungsnummer'])) {
            $input['sozialversicherungsnummer'] = $_POST['sozialversicherungsnummer'];
        } else {
            $error['sozialversicherungsnummer'] = 'sozialversicherungsnummer';
        }

        /* Telefonnummer */
        if (isset($_POST['telefonnummer']) && strlen(trim($_POST['telefonnummer'])) && !is_array($_POST['telefonnummer'])) {
            $input['telefonnummer'] = $_POST['telefonnummer'];
        } else {
            $error['telefonnummer'] = 'telefonnummer';
        }

        /* E-Mail Adresse */
        if (isset($_POST['email']) && strlen(trim($_POST['email'])) && !is_array($_POST['email'])) {
            $input['email'] = $_POST['email'];
        } else {
            $error['email'] = 'email';
        }

        /* Teststraße */
        if (isset($_POST['teststrasse']) && strlen(trim($_POST['teststrasse'])) && !is_array($_POST['teststrasse'])) {
            $input['teststrasse'] = $_POST['teststrasse'];
        } else {
            $error['teststrasse'] = 'teststrasse';
        }

        /* Testtermin */
        if (isset($_POST['testtermin']) && strlen(trim($_POST['testtermin'])) && !is_array($_POST['testtermin'])) {
            $input['testtermin'] = $_POST['testtermin'];
        } else {
            $error['testtermin'] = 'testtermin';
        }
    }
    ?>

    <form action="<?php echo htmlentities($_SERVER['PHP_SELF']); ?>" method="post">
        <!-- Vorname -->
        <style>
            <?php 

            $inputFields = [
                "vorname",
                "nachname",
                "geburtsdatum",
                "sozialversicherungsnummer",
                "telefonnummer",
                "email",
                "teststrasse",
                "testtermin"
            ];

            for ($i = 0; $i < count($inputFields); $i++) {
                if (isset($input[$inputFields[$i]])) {
                    $inputFiled = $inputFields[$i];

                    echo " #$inputFiled {background-color: rgba(0, 128, 0, 0.3); outline: none;} ";
                } else {
                    $inputFiled = $inputFields[$i];
                    echo " #$inputFiled  {background-color: rgba(255, 0, 0, 0.3); outline: none;} ";
                }
            }

        ?>
        </style>

        <label for="vorname">Vorname</label>
        <input type="text" name="vorname" id="vorname" value="vorname">
        <?php if (isset($input['vorname'])) echo 'value="' . $input['vorname'] . '"'; ?>

        <!-- Nachname -->
        <label for="nachname">Nachname</label>
        <input type="text" name="nachname" id="nachname" value="nachname">
        <?php if (isset($input['nachname'])) echo 'value="' . $input['nachname'] . '"'; ?>
        <br>

        <!-- Geburtsdatum -->
        <label for="geburtsdatum">Geburtsdatum</label>
        <input type="datetime-local" name="geburtsdatum" id="geburtsdatum" min="0000-00-00T00:00:00" 
        max="<?php $date = new DateTime();
        echo $date->format('Y-m-d\TH:i:s'); ?>" value="<?php $date = new DateTime();
        echo $date->format('Y-m-d\TH:i:s'); ?>" step="1">
        <?php if (isset($input['geburtsdatum'])) echo 'value="' . $input['geburtsdatum'] . '"'; ?>
        <br>

        <!-- Sozialversicherungsnummer -->
        <label for="sozialversicherungsnummer">Sozialversicherungsnummer</label>
        <input type="text" name="sozialversicherungsnummer" id="sozialversicherungsnummer" value="sozialversicherungsnummer">
        <?php if (isset($input['sozialversicherungsnummer'])) echo 'value="' . $input['sozialversicherungsnummer'] . '"'; ?>
        <br>

        <!-- Telefonnummer -->
        <label for="telefonnummer">Telefonnummer</label>
        <input type="tel" pattern="\+[0-9]+" name="telefonnummer" id="telefonnummer" value="+000000000000">
        <?php if (isset($input['telefonnummer'])) echo 'value="' . $input['telefonnummer'] . '"'; ?>
        <br>

        <!-- E-Mail Adresse -->
        <label for="email">E-Mail Adresse</label>
        <input type="email" pattern="+.+@+\.+" name="email" id="email" value="xxx.xxx@xxx.xxx">
        <?php if (isset($input['email'])) echo 'value="' . $input['email'] . '"'; ?>
        <br>

        <!-- Teststraße -->
        <label for="teststrasse">Teststraße</label>
        <select name="teststrasse" id="teststrasse" value="1">
            <option value="1">1</option>
            <option value="2">2</option>
        </select>
        <?php if (isset($input['teststrasse'])) echo 'value="' . $input['teststrasse'] . '"'; ?>
        <br>
        <!-- Testtermin -->
        <label for="testtermin">Testtermin</label>
        <input type="datetime-local" name="testtermin" id="testtermin" min="0000-00-00T00:00:00" max="<?php $date = new DateTime();
        echo $date->format('Y-m-d\TH:i:s'); ?>" value="<?php $date = new DateTime();                                                                                                                             
        echo $date->format('Y-m-d\TH:i:s'); ?>" step="1">
        <?php if (isset($input['testtermin'])) echo 'value="' . $input['testtermin'] . '"'; ?>
        <br>

        <label for="dataInput">submit</label>
        <input type="submit" name="dataInput" value="dataInput">
    </form>

    <?php
    $respond = "";
    if (empty($error)) {
        $geb = DateTime::createFromFormat('Y-m-d\TH:i:s', $input['geburtsdatum']);
        $gebStrg = $input['geburtsdatum'];
        if ($input['geburtsdatum']) {
            $gebStrg = $geb->format('Y.m.d H:i:s');
        }
        $dt = DateTime::createFromFormat('Y-m-d\TH:i:s', $input['testtermin']);
        $dtStrg = $input['testtermin'];
        if ($input['testtermin']) {
            $dtStrg = $dt->format('Y.m.d H:i:s');
        }

        $respond = "<br>Alle eingaben waren valide, ";
        echo $respond . "<b>" . $input['vorname'] . "</b> <b>" . $input['nachname'] . "</b>!<br>
                Geburtsdatum: <b>" . $gebStrg . "</b><br> 
                Sozialversicherungsnummer: <b>" . $input['sozialversicherungsnummer'] . "</b><br> 
                Telefonnummer: <b>" . $input['telefonnummer'] . "</b><br> 
                E-Mail Adresse: <b>" . $input['email'] . "</b><br>
                Teststraße: <b>" . $input['teststrasse'] . "</b><br>
                Testtermin: <b>" . $dtStrg . "</b>";
        /* exit(); */
    } else {
        $errors = implode(', ', $error);
        $respond = 'Es sind Fehler in folgenden Feldern aufgetreten: ' . $errors . "!";
        echo $respond;
    }
    ?>

</body>
</html>