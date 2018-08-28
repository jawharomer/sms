<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<section id="admin-body">
	<section id="section-right" class="card">

		<ul class="list-group cus-right-nav">
			<li class="list-group-item"><a
				href='<c:url value="/admin/students" />'>قوتابیەکان</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/admin/teachers" />'>مامۆستاکان</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/schoolWeekDays" />'>رۆژانی هەفتە</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/classLevels" />'>هۆبەکان</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/classGroups" />'>پۆلەکان</a></li>
			<li class="list-group-item"><a
				href='<c:url value="/enrollments" />'>ناونوسین</a></li>
		</ul>
	</section>

	<section id="main-content">

		<tiles:insertAttribute name="adminBody" />

	</section>

</section>