<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<section id="admin-body">
	<section id="section-right">
		<ul class="cus-navbar">
			<li><a
				href="<c:url value="/students/notifications" />${item.id}">
					ئاگادارکردنەوەکان</a></li>
			<li>
				<button data-student-id="${student.id}"
					onclick="getStudentStudentPresents(this)">خشتەی هاتن</button>
			</li>
			<li><a href='<c:url value="/students/classGroupTable" />'>خشتەی
					هەفتانە</a></li>
			<li><a href='<c:url value="/students/marks" />'>نمرەکان</a></li>
			<li>واجبەکان
				<ul>
					<c:forEach items="${classSubjects}" var="item">
						<li><a
							href="<c:url value="/students/notifications/classSubject/" />${item.id}">${item.name}</a>
						</li>
					</c:forEach>
				</ul>
			</li>
		</ul>
	</section>

	<section id="main-content">

		<tiles:insertAttribute name="studentBody" />

	</section>

</section>



<!-- Modal -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>