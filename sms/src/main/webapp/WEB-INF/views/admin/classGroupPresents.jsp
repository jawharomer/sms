<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h3>رۆژانی زیادکراو</h3>
	<table class="table table-bordered">
		<c:forEach items="${dates}" var="item">
			<tr>

				<td><a
					href="<c:url value="/studentPresents/classGroup/"/>${id}/${item}">
						${item} </a>

					<button class="btn btn-sm btn-danger"
						onclick="deleteClassGroupPresent(${id},'${item}')">
						<i class="fa fa-times"></i>
					</button></td>
			</tr>
		</c:forEach>
	</table>
</div>