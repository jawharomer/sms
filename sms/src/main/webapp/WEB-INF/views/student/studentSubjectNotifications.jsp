<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div>
	<h3>${classSubject.name}</h3>
	<c:forEach items="${subjectNotifications}" var="item">

		<div class="card my-1 border border-warning">
			<div class="card-header">
				<h5>
					<fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd HH:mm:ss" />
				</h5>
			</div>
			<div class="card-body">
				<h5 class="card-title">${item.title}
					<c:if test="${item.attachedFile!=null}">
						<span class="h2 class-info"> <a class="text-primary" target="_blank"
							href="<c:url value="/attachedFiles/download/" />${item.attachedFile.id}">
								<i class="fa fa-download"></i>
						</a>
						</span>
					</c:if>

				</h5>

				<p class="card-text">${item.note}</p>
			</div>
		</div>
	</c:forEach>

</div>

