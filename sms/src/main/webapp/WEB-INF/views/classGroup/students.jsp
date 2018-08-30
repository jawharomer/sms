<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="class-group-student-container">
	<h3>${classGroup.name}</h3>
	<button class="btn btn-info" onclick="getAddingStudentNotificaion()">ئاگادارکرنەوە</button>
	<div id="student-table-div">
		<table id="student-table" class="display nowrap">
			<thead>
				<tr>
					<th>#</th>
					<th>ناو</th>
					<th>باوک</th>
					<th>باپی</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.firstName}</td>
						<td>${item.middleName}</td>
						<td>${item.lastName}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>#</th>
					<th>ناو</th>
					<th>باوک</th>
					<th>باپی</th>
				</tr>
			</tfoot>
		</table>
	</div>

</div>



