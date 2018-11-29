<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="admin-teachers-container">
	<h3>مامۆستاکان</h3>
	<div>
		<button onclick="getAddTeacher()" class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<div id="teacher-table-div">

		<table id="teachersTable" class="display w-100">
			<thead>
				<tr>
					<td>#</td>
					<td>ناو</td>
					<td>باوک</td>
					<td>باپیر</td>
					<td>مۆبایل</td>
					<td>بری پارە</td>
					<td>تێبینی</td>
					<td>بەکاربەر</td>
					<td>کردرارەکان</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${teachers}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.firstName}</td>
						<td>${item.middleName}</td>
						<td>${item.lastName}</td>
						<td>${item.mobile}</td>
						<td>${item.hireAmount}</td>
						<td class="cus-note-td">${item.note}</td>
						<td>
							<button class="btn btn-info btn-sm" data-role="ROLE_TEACHER"
								data-student-id="${item.id}" onclick="getAddUser(this)">
								<i class="fa fa-user"></i>
							</button>
						</td>

						<td>
							<div>
								<button class="btn btn-danger btn-sm"
									data-teacher-id="${item.id}" onclick="deleteTeacher(this)">
									<i class="fa fa-times"></i>
								</button>
								<button class="btn btn-warning btn-sm"
									data-teacher-id="${item.id}" onclick="editTeacher(this)">
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

