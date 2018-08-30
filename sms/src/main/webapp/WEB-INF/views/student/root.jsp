<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<section id="admin-body">
	<section id="section-right" class="card">
		<ul class="list-group cus-right-nav">
			<li class="list-group-item"><a
				href="<c:url value="/students/notifications" />${item.id}">
					ئاگادارکردنەوەکان</a></li>
			<li class="list-group-item">
				<button data-student-id="${student.id}"
					onclick="getStudentStudentPresents(this)">خشتەی هاتن</button>
			</li>
			<li class="list-group-item"><a href='<c:url value="/students/classGroupTable" />'>خشتەی
					هەفتانە</a></li>
			<li class="list-group-item"><a href='<c:url value="/students/marks" />'>نمرەکان</a></li>
			<li class="list-group-item">واجبەکان
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