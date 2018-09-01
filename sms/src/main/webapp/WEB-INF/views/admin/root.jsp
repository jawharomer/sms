<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-MM-dd" />


<section id="admin-body">
	<section id="section-right" class="card">

		<ul class="list-group cus-right-nav">
			<li class="list-group-item"><a
				href='<c:url value="/admin/students" />'>قوتابیەکان</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/admin/teachers" />'>مامۆستاکان</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/admin/teacherLecturePresents" />?from=${currentDate}&to=${currentDate}'>وانەبێژی</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/admin/teacherPresents" />?from=${currentDate}&to=${currentDate}'>ئ.مامۆستایان</a></li>

			<li class="list-group-item"><a
				href='<c:url value="/schoolWeekDays" />'>رۆژانی هەفتە</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/classLevels" />'>هۆبەکان</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/classGroups" />'>پۆلەکان</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/enrollments" />'>ناونوسین</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/admin/students/notificaions" />'>ئ.قوتابی</a></li>
		</ul>
	</section>

	<section id="main-content">

		<tiles:insertAttribute name="adminBody" />

	</section>

</section>