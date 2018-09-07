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
					<td width="5%">#</td>
					<td>ناو</td>
					<td>ن.باوک</td>
					<td>ن.باپیر</td>
					<td width="5%">رەگەز</td>
					<td width="8%">ژ.مۆبایل</td>
					<td width="8%">ژ.م بەخێوکەر</td>
					<td width="7%">بەکاربەر</td>
					<td width="7%">بەخێوکەر</td>
					<td width="7%" class="cus-not-export">کردارەکان</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.id}</td>
						<td>${student.firstName}</td>
						<td>${student.middleName}</td>
						<td>${student.lastName}</td>
						<td><c:if test="${student.gender==0}">م</c:if> <c:if
								test="${student.gender==1}">ن</c:if></td>
						<td>${student.mobile}</td>
						<td>${student.parentMobile}</td>
						<td>
							<button class="btn btn-info btn-sm" data-role="ROLE_STUDENT"
								data-student-id="${student.id}" onclick="getAddUser(this)">
								<i class="fa fa-user"></i>
							</button>
						</td>
						<td>
							<button class="btn btn-info btn-sm" data-role="ROLE_PARENT"
								data-student-id="${student.id}" onclick="getAddUser(this)">
								<i class="fa fa-user"></i>
							</button>
						</td>
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





