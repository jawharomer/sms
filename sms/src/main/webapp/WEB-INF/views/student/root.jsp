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
				<button style="background: transparent;" class="btn" data-student-id="${student.id}"
					onclick="getStudentStudentPresents(this)">خشتەی هاتن</button>
			</li>
			<li class="list-group-item"><a
				href='<c:url value="/students/classGroupTable" />'>خشتەی هەفتانە</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/students/marks" />'>نمرەکان</a></li>

			<!-- 
			<li class="list-group-item">واجبەکان
				<ul>
					
				</ul>
			</li>
			 -->
			<li class="list-group-item px-0" style="max-width: 170px;width: 170px;"><a
				style="padding: 0 1.25rem; background-color: transparent"
				data-toggle="collapse" href="#notific-collapse-div">واجبەکان</a>
				<div></div>
				<div class="collapse py-0 mt-2" id="notific-collapse-div">
					<div >
						<ul class="list-group px-0">
							<c:forEach items="${classSubjects}" var="item">
								<li class="list-group-item bg-secondary"><a
									href="<c:url value="/students/notifications/classSubject/" />${item.id}">${item.name}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div></li>
			<li class="list-group-item">dd</li>
		</ul>
	</section>

	<section id="main-content">

		<tiles:insertAttribute name="studentBody" />

	</section>

</section>