<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

this is class buejct Root Page
<section>
	<a
		href="<c:url value="/teachers/marks?classSubjectId=${classSubjectId}&classGroupId=${classGroupId}" />">
		marks </a> <a
		href="<c:url value="/teachers/notifications?classSubjectId=${classSubjectId}&classGroupId=${classGroupId}" />">
		marks </a>
</section>

<section id="main-content">
	<tiles:insertAttribute name="classSubjectBody" />
</section>
