<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div>
	<h5>بەرواری ئاستی زانستی</h5>
	<table class="table table-bordered">
		<c:forEach items="${studentLevelDates}" var="item">
			<tr>
				<td><a
					href="<c:url value="/students/studentLevel/" />${item.id}">
						<fmt:formatDate value="${item.date}" pattern="yyyy-MM-dd" />
				</a></td>
			</tr>
		</c:forEach>
	</table>

</div>