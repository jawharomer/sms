<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div style="max-height:400px;overflow: auto;padding:5px">
	<table id="studentsTable" class="w-100 table table-bordered">
		<thead>
			<tr>
				<th>ناو</th>
				<th>ن.باوک</th>
				<th>ن.باپیر</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.firstName}</td>
					<td>${student.middleName}</td>
					<td>${student.lastName}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</div>