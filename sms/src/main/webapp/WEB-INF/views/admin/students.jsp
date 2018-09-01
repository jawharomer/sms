<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="students-container">
	<h3>قوتابیەکان</h3>
	<div>
		<button onclick="getAddStudent()" class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<div class="student-table-div">

		<table id="studentsTable" class="display">
			<thead>
				<tr>
					<td>ناو</td>
					<td>ن.باوک</td>
					<td>ن.باپیر</td>
					<td>ن.بەکاربەر</td>
					<td>وشوەی نهێنی</td>
					<td>ن.ب بەخێوکەر</td>
					<td>و.ن بەخێوکەر</td>
					<td>رەگەز</td>
					<td>ژ.مۆبایل</td>
					<td>ژ.م بەخێوکەر</td>

					<td>کردارەکان</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.firstName}</td>
						<td>${student.middleName}</td>
						<td>${student.lastName}</td>
						<td>${student.userName}</td>
						<td>${student.password}</td>
						<td>${student.parentUserName}</td>
						<td>${student.parentPassword}</td>
						<td><c:if test="${student.gender==0}">م</c:if> <c:if
								test="${student.gender==1}">ن</c:if></td>
						<td>${student.mobile}</td>
						<td>${student.parentMobile}</td>
						<td>
							<div>
								<button class="btn btn-danger btn-sm"
									data-student-id="${student.id}" onclick="deleteStudent(this)">
									<i class="fa fa-times"></i>
								</button>
								<button class="btn btn-sm btn-warning"
									data-student-id="${student.id}" onclick="editStudent(this)">
									<i class="fa fa-edit"></i>
								</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>

	</div>



</div>





