<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
	<button data-class-subject-id="${classSubjectId}"
		data-class-group-id="${classGroupId}"
		onclick="getAddSubjectNotification(this)" type="button"
		class="btn btn-success">
		<i class="fa fa-plus"></i>
	</button>
</div>

<div>
	<c:forEach items="${subjectNotifications}" var="item">

		<div class="card my-1 border border-warning">
			<div class="card-header d-flex">
				<h5>
					<fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd HH:mm:ss" />
				</h5>
				<div class="mr-auto">
					<button class="btn btn-danger  btn-sm rounded-circle"
						data-subject-notificaion-id="${item.id}"
						onclick="deleteSubjectNotificaion(this)">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</div>
			<div class="card-body">
				<h5 class="card-title">${item.title}</h5>
				<p class="card-text">${item.note}</p>
			</div>
		</div>
	</c:forEach>

</div>