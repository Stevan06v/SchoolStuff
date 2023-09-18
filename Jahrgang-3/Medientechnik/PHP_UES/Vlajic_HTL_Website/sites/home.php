<?php
	include("./header.php");
    $site = null;

	if(!isset($_GET["site"])){
		include("./main.php");
		include("./footer.php");

		return;
	}else{
		$site = $_GET["site"];
		if($site == "medizintechnik"){
			$site = "medizientechnik";
		}
	}
	
	
	include("./navsub.php");
    include("./".$site.".php");
	include("./footer.php");
?>



