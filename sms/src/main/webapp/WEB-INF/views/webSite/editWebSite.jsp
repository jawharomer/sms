<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<c:url value="/resources/img/webSite" var="imgDir" />

<div class="container-fluid">
	<div class="p-2">
		<h4>گۆرانکاری لە سایت</h4>

		<div class="row">


			<div class="col-6 p-1 border border-warning">
				<h5>وێنەی سەرەکی</h5>

				<form action="<c:url value="/webSite/files/add/coursel" />"
					method="POST" enctype="multipart/form-data">
					<input type="file"
						accept="image/x-png,image/gif,image/jpeg,image/jpg" name="file" />
					<button class="btn btn-sm btn-success">
						<i class="fa fa-image"></i>
					</button>
				</form>
				<p>
					تکایە هەروێنەیەک دادەنێت دەبێت قەبارەکەی <span class="text-danger">(پانی800
						x بەرزی600 )</span>
				</p>

				<div class="p-1">

					<table style="width: auto;">
						<c:forEach items="${webSite.carouselFiles}" var="item">
							<tr>
								<td><a data-fancybox="gallery"
									href="<c:url value="/attachedFiles/0/" />${item.id}"> <img
										src="<c:url value="/attachedFiles/1/" />${item.id}">
								</a></td>
								<td>
									<button class="btn btn-danger btn-sm roundled-circle"
										onclick="deleteCarouselFile(${item.id})">
										<i class="fa fa-times"></i>
									</button>
								</td>
							</tr>
						</c:forEach>

					</table>
				</div>

			</div>

			<div class="col-6 p-1 border border-warning">
				<h5>وێنەی ئەلبوومەکان</h5>

				<form action="<c:url value="/webSite/files/add/album" />"
					method="POST" enctype="multipart/form-data">
					<input type="file"
						accept="image/x-png,image/gif,image/jpeg,image/jpg" name="file" />
					<button class="btn btn-sm btn-success">
						<i class="fa fa-image"></i>
					</button>
				</form>
				<p>لەم بەشە بۆ جوانی سایتەکە وێنەکان بە چەندجارەی 4 ی دابنێ
					4,8,12</p>
				<p>

					تکایە هەروێنەیەک دادەنێت دەبێت قەبارەکەی <span class="text-danger">(پانی800
						x بەرزی600 )</span>
				</p>

				<div class="p-1">

					<table style="width: auto;">
						<c:forEach items="${webSite.albumFiles}" var="item">
							<tr>
								<td><a data-fancybox="gallery"
									href="<c:url value="/attachedFiles/0/" />${item.id}"> <img
										src="<c:url value="/attachedFiles/1/" />${item.id}">
								</a></td>
								<td>
									<button class="btn btn-danger btn-sm roundled-circle"
										onclick="deleteAlbumFile(${item.id})">
										<i class="fa fa-times"></i>
									</button>
								</td>
							</tr>
						</c:forEach>

					</table>
				</div>

			</div>


		</div>
		<!-- E-Row -->

		<sf:form id="update-web-site-form" method="POST" commandName="webSite"
			onsubmit="updateWebSite(event)">
			<sf:input type="hidden" path="id" />

			<div class="row py-1">



				<div class="col-6 p-1 border border-success">

					<h5>بەخێربێن</h5>
					<div id="header-div">
						<sf:textarea path="header" />
						<button class="btn btn-warning">
							<i class="fa fa-edit"></i>
						</button>
					</div>
				</div>

			</div>



			<div class="row py-1">
				<div class="col-12 p-1 border border-primary">
					<h5>دەربارەی</h5>
					<div id="header-div">
						<sf:textarea path="about" />
						<button class="btn btn-warning">
							<i class="fa fa-edit"></i>
						</button>
					</div>
				</div>
			</div>

			<div class="row py-1">
				<div class="col-4 p-1 border border-secondary">
					<h5>ناونیشان</h5>
					<div id="header-div">
						<sf:textarea path="address" />
						<button class="btn btn-warning">
							<i class="fa fa-edit"></i>
						</button>
					</div>
				</div>

				<div class="col-4 p-1 border border-secondary">
					<h5>پەیوەندی</h5>
					<div id="header-div">
						<sf:textarea path="contact" />
						<button class="btn btn-warning">
							<i class="fa fa-edit"></i>
						</button>
					</div>
				</div>

				<div class="col-4 p-1 border border-secondary">
					<h5>لینکی پەیوەندیدارەکان</h5>
					<div id="header-div">
						<sf:textarea path="link" />
						<button class="btn btn-warning">
							<i class="fa fa-edit"></i>
						</button>
					</div>
				</div>
			</div>
		</sf:form>
	</div>
</div>