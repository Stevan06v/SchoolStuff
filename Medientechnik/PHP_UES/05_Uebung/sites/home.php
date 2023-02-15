<?php
    include("./head.php");
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

	include("./foot.php");
