<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<section id="class-subject">
	<div style="direction: ltr;" class="btn-group" role="group"
		aria-label="Basic example">
		<a class="btn btn-secondary"
			href="<c:url value="/teachers/notifications?classSubjectId=${classSubjectId}&classGroupId=${classGroupId}" />">
			ئاگادارکردنەوەکان </a> <a class="btn btn-secondary"
			href="<c:url value="/teachers/marks?classSubjectId=${classSubjectId}&classGroupId=${classGroupId}" />">
			نمرەکان </a>
	</div>


</section>

<section id="main-content">
	<h5>
		<span class="text-info">${classGroup.name}</span> <span
			class="text-primary">${classSubject.name}</span>
	</h5>
	<tiles:insertAttribute name="classSubjectBody" />
</section>
