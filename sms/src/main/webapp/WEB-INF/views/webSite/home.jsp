<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources/img/webSite" var="imgDir" />

<div class="container animated slideInUp delay-1s">

	<div class="row">
		<div id="about"
			class="col-12 order-2 col-md-5 order-md-1 d-flex align-items-stretch">
			<div class="card card-body">${webSite.header}</div>
		</div>
		<div class="col-12 order-1 col-md-7  order-md-2">
			<div id="carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<c:forEach items="${webSite.carouselFiles}" var="item"
						varStatus="loop">
						<c:if test="${loop.index==0}">
							<div class="carousel-item active">
								<img class="d-block w-100"
									src="<c:url value="/attachedFiles/0/" />${item.id}"
									alt="First slide">
							</div>
						</c:if>

						<c:if test="${loop.index!=0}">
							<div class="carousel-item">
								<img class="d-block w-100"
									src="<c:url value="/attachedFiles/0/" />${item.id}"
									alt="Second slide">
							</div>
						</c:if>

					</c:forEach>
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
			<div class="p-2  card card-body">${webSite.about}</div>
		</div>

	</div>

	<div id="gallary-div-container">
		<div class="row">
			<c:forEach items="${webSite.albumFiles}" var="item">
				<div class="col-12 col-md-3">
					<a data-fancybox="gallery"
						href="<c:url value="/attachedFiles/0/" />${item.id}"> <img
						src="<c:url value="/attachedFiles/0/" />${item.id}"
						class="img-thumbnail">
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<div class="row border-top py-2">
		<div id="address" class="col-12 col-md-4 d-flex align-items-stretch">
			<div class="card card-body">${webSite.address}</div>
		</div>
		<div id="contact" class="col-12 col-md-4  d-flex align-items-stretch">
			<div class="card  card-body">${webSite.contact}</div>
		</div>
		<div id="related-site"
			class="col-12 col-md-4  d-flex align-items-stretch">
			<div class="card  card-body">${webSite.link}</div>
		</div>
	</div>

</div>