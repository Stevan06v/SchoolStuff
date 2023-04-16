<?php

$_db_host="localhost";
$_db_datenbank="web";
$_db_username="web";
$_db_passwort="abcdef01";

$conn = new mysqli($_db_host, $_db_username,$_db_passwort, $_db_datenbank);

if($conn->connect_error){
    die("Connection failed " . $conn->connect_errno);
}

if(!empty($_POST["submit"])){
    $_username = $conn->real_escape_string($_POST["username"]);
    $_passwort  = $conn->real_escape_string($_POST["passwort1"]);

    if(strcmp($_passwort, $conn->real_escape_string($_POST['passwort2']))!=0){
        include("create_user_form.html");
        exit;
    }

    $_passwort = "saver" . $_passwort;
    $insertStatement = "insert into login_username (username,password, user_deleted, last_login) 
    values('$_username', '".md5($_passwort)."' ,'0',NOW())";
    
    if($_res = $conn->query($insertStatement)){
        echo "<br>User $_username has been added to the database.<br> Try to log in.";
        include("login_form.html");
    }else{
        echo "<br>NO instertaion. User could not be added. Maybe $_username already exists.";
        include("create_user_form.html");
    }

    $conn->close();
    
}
