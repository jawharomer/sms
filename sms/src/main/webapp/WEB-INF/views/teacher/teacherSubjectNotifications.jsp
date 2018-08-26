<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
	<button data-class-subject-id="${classSubjectId}"
		data-class-group-id="${classGroupId}"
		onclick="getAddSubjectNotification(this)" type="button"
		class="btn btn-primary">زیادکردن</button>
</div>

<div>
	<c:forEach items="${subjectNotifications}" var="item">
		<div>
			<div>${item.title}</div>
			<div>
				<fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd HH:mm:ss" />
			</div>
			<div>${item.note}</div>
		</div>
	</c:forEach>

</div>