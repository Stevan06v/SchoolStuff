
<?php



$website = "";

if (isset($getSite)) {
	switch ($getSite) {
		case "Medientechnik" || "medientechnik":
			$website  = strtolower($getSite);

		case "Informatik" || "informatik":
			$website  = strtolower($getSite);

		case "Elektronik" || "elektronik":
			$website  = strtolower($getSite);

		case "Medizintechnik" || "medizintechnik":
			$website  = strtolower($getSite);
		default:
		$website  = "home";

	}
}
echo '<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/style.css">
	<script>
	
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);

		const product = urlParams.get("site")

		console.log(product);
		setTimeout(()=>{
			if(product == null){
				document.getElementsByTagName("body")[0].id = "home";
			}else{
				document.getElementsByTagName("body")[0].id = product;
			}
			
		}, 100)
		

	</script>
	</head>
<body id="">
<div id="wrapper">

<header class="rows">
    <a href="home.php"><h1>HTL Leonding</h1></a>
</header>   

    ';

?>



