<!doctype html>
<html lang="de">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HTL Leonding</title>
	<meta name="description" content="Skalable Demopage of HTL Leonding">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
	<link rel="icon" href="../img/favicon.png" type="image/png" sizes="180x180">
</head>

<body id="home">

	<div id="wrapper">
		<?php
		
		
		include('./header.php');
		
		?>

		<?php
		echo '
		<main class="rows">
			<iframe class="video" src="https://www.youtube.com/embed/rEEHioWI8ys?autoplay=1&loop=1&controls=0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"></iframe>
		</main>
		
		
		<nav class="rows">
			<div class="columns column-2">
				<a class="it" href="informatik.php">
					<h2>Informatik</h2>
					<img src="../img/informatik.jpg" alt="Informatik">
				</a>
			</div>
			
			<div class="columns column-2">
				<a class="medt" href="medientechnik.php">
						<h2>Medientechnik</h2>
					<img src="../img/medientechnik.jpg" alt="Medientechnik">
				</a>
			</div>
			
			<div class="columns column-2">
				<a class="et" href="elektronik.php">
					<h2>Elektronik</h2>
					<img src="../img/elektronik.jpg" alt="Elektronik">
				</a>
			</div>
			
			<div class="columns column-2">
				<a class="medz" href="medizintechnik.php">
					<h2>Medizintechnik</h2>
					<img src="../img/medizintechnik.jpg" alt="Medizintechnik">
				</a>
			</div>
		</nav>
';
		
		?>
		<?php
		include('./footer.php');

		?>
	</div>
</body>

</html>