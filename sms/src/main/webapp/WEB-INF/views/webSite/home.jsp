<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources/img/webSite" var="imgDir" />

<div class="container">

	<div class="row">
		<div id="about"
			class="col-12 order-2 col-md-5 order-md-1 d-flex align-items-stretch">
			<div class="card card-body">
				<h3>بەخێربێن</h3>
				<h4>ساڵی خوێندی 2018-2019</h4>
				<p class="text-justify pt-4">بەبۆنەی سالێکی تازەوە
					قوتابخانەکەمان پیرۆزبایەکی گەرم لە هەموو گووتابیان دەکات،
					قوتابخانەکەمان خوازرە ئەمسال هەموو قوتابیەکان بە ورەیەکی بەرز
					دەستبکەنەوە بە وانەکانیان،هانگاوێکی تر بەروئایندەیەکی گەشترو
					کوردستانێکی پەێشکەوتووتر بنەن ،وەهەروەها داواکارین لە دایکو باوکانی
					خۆشەویست کەوا هاوکاری تەواوی قوتابیەکانیان بن بۆبنیات نانی
					داهاتوەکی گەشتر بۆ جگەر گۆشەکانیان</p>

			</div>
		</div>
		<div class="col-12 order-1 col-md-7  order-md-2">
			<div id="carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100" src="${imgDir}/carousel/1.jpg"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="${imgDir}/carousel/2.jpg"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="${imgDir}/carousel/3.jpg"
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carousel" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"
					aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carousel" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>

		</div>


	</div>

	<div class="row my-1">
		<div class="col-12">
			<div class="p-2  card card-body">
				<h4>دەربارە</h4>

				<p class='text-justify '>قوتابخانەی کۆرەک قوتابخانەیەکی کەرتی
					تایبەتە مۆلەتی وەزارەتی پەروەردەی پێدراوە ،یەکێکە لە هەرە
					قوتابخانەپێشکەوتوەکان لەکوردستان ،بەهۆی ئەو ئەنجامە نایابانەی
					قوتابخانەکەمان بەدەستی هێناوە لە سالانی رابردوو سالبەسال
					قوتابخانەکەمان لە بەرو پێشچونێكی بەردەوام دایە بۆخزمەت کردنی
					نەوەکانی کوردستان وەگەیاندی کوردستان بەرەو ئایندەیەکەکی گەشتر</p>
			</div>
		</div>

	</div>

	<div id="gallary-div-container">
		<div class="row">
			<div class="col-12 col-md-3">
				<a data-fancybox="gallery" href="${imgDir}/gallery/1.jpg"> <img
					src="${imgDir}/gallery/1.jpg" class="img-thumbnail">
				</a>
			</div>
			<div class="col-12 col-md-3">
				<a data-fancybox="gallery" href="${imgDir}/gallery/2.jpg"> <img
					src="${imgDir}/gallery/2.jpg" class="img-thumbnail">
				</a>
			</div>
			<div class="col-12 col-md-3">
				<a data-fancybox="gallery" href="${imgDir}/gallery/3.jpg"> <img
					src="${imgDir}/gallery/3.jpg" class="img-thumbnail">
				</a>
			</div>
			<div class="col-12 col-md-3">
				<a data-fancybox="gallery" href="${imgDir}/gallery/4.jpg"> <img
					src="${imgDir}/gallery/4.jpg" class="img-thumbnail">
				</a>
			</div>
		</div>

		<div class="row p-1">
			<div class="col-12 col-md-3">
				<a data-fancybox="gallery" href="${imgDir}/gallery/5.jpg"> <img
					src="${imgDir}/gallery/5.jpg" class="img-thumbnail">
				</a>
			</div>
			<div class="col-12 col-md-3">
				<a data-fancybox="gallery" href="${imgDir}/gallery/6.jpg"> <img
					src="${imgDir}/gallery/6.jpg" class="img-thumbnail">
				</a>
			</div>


			<div class="col-12 col-md-3">
				<a data-fancybox="gallery" href="${imgDir}/gallery/7.jpg"> <img
					src="${imgDir}/gallery/7.jpg" class="img-thumbnail">
				</a>
			</div>
			<div class="col-12 col-md-3">
				<a data-fancybox="gallery" href="${imgDir}/gallery/8.jpg"> <img
					src="${imgDir}/gallery/8.jpg" class="img-thumbnail">
				</a>
			</div>

		</div>

	</div>

	<div class="row border-top py-2">
		<div id="address" class="col-12 col-md-4 d-flex align-items-stretch">
			<div class="card card-body">
				<h6>ناونیشان</h6>
				<p>
			هەولێر-سۆران،شەقامی سەرەکی هەولێر سۆران 
				</p>
			</div>
		</div>
		<div id="contact" class="col-12 col-md-4  d-flex align-items-stretch">
			<div class="card  card-body">
				<h6>پەیوەندی</h6>
				korek.school@gmail.com<br> 07507081810 <br>
				07507081810
			</div>
		</div>
		<div id="related-site"
			class="col-12 col-md-4  d-flex align-items-stretch">
			<div class="card  card-body">
				<h6>لینکی پەیوەندیدارەکان</h6>
				<ul>
					<li><a href="https://www.azmoonakan.org/"> بەرێوەبەرایەتی
							گشتی ئەزموونەکان</a></li>
					<li><a href="https://moe-krg.com/"> وەزارەتی پەروەردە</a></li>
				</ul>
			</div>
		</div>
	</div>

</div>