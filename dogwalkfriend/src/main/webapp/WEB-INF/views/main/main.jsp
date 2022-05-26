<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<link rel="stylesheet" href="/dogwalkfriend/resources/bootstrap/css/main.css" />
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
</head>
<body>
<div class="swiper-container">
	<div class="swiper-wrapper">
		<div class="slide1 swiper-slide"></div>
		<div class="slide2 swiper-slide"></div>
		<div class="slide3 swiper-slide"></div>
		<div class="slide4 swiper-slide"></div>
	</div>
	<div class="swiper-pagination"></div>
	
	<div class="swiper-button-next"></div>
	<div class="swiper-button-prev"></div>
	
</div>
<script type="text/javascript">
new Swiper('.swiper-container', {
		autoplay : {
			delay : 2500,
		},
		loop : true,
		loopAdditionalSlides : 1,
		pagination : {
			el : '.swiper-pagination',
			clickable : true,
		},
		navigation : {
			nextEl : '.swiper-button-next',
			prevEl : '.swiper-button-prev',
		},
	});
</script>
</body>
</html>