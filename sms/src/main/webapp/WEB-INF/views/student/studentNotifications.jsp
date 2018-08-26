<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div>
	<c:forEach items="${studentNotifications}" var="item">
		<div>
			<div>${item.title}</div>
			<div>
				<fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd HH:mm:ss" />
			</div>
			<div>${item.note}</div>
		</div>
	</c:forEach>

</div>