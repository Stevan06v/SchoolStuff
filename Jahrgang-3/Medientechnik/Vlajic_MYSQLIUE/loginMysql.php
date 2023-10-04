<?php

session_start();

$_db_host = "localhost";
$_db_datenbank = "web";
$_db_username="web";
$_db_passwort= "abcdef01";

$conn = new mysqli($_db_host, $_db_username, $_db_passwort, $_db_datenbank);


if($conn->connect_error){
    die("Connection failed: ".$conn->connect_error);
}

if(!empty($_POST['submit'])){
        $_username = $conn->real_escape_string($_POST["username"]);
        $_passwort = $conn->real_escape_string($_POST["passwort"]);

        $_passwort = "saver".$_passwort;


        $_sql = "
            select * from login_username where username='$_username'
        ";


if($res = $conn->query($_sql)){
    if($res->num_rows >0){
        echo "Der Login war erfolgreich.<br>";
        $_SESSION["login"]=1;

        $_SESSION["user"] = $res->fetch_assoc();

        $sql = "update login_username set last_login=NOW() where id= ".$_SESSION["user"]["id"]."";
        $conn->query($sql);
    }else{
        echo "Login Daten sind nicht korrekt. <br>";
        include("login_form.html");
        exit;
    }
        $res->close();
    }
}



if($_SESSION["login"] != 1){
    include("login_form.html");
    exit;
}

echo "<br> User " . $_SESSION["user"]["username"] . " is logged in since " .$_SESSION["user"]["last_login"].".<br>";
$table ="login_username";
$query = "select * from $table";

if($result = $conn->query($query)){
    echo "<br> Select returned ".$result->num_rows ."rows. <br>";

    if($result->num_rows >0){
        echo "<table><tr><th>ID</th><th>USER</th><th>Last Login</th></tr>";

        while($row = $result->fetch_assoc()){
            echo "
                <tr><td>
            ". $row["id"]. "</td><td>".$row["username"]."</td><td>".$row["last_login"]."</td></tr>";
        }
        
        echo "</table>";
    }else{
        echo "No results";
    }
}
$conn->close();

?>