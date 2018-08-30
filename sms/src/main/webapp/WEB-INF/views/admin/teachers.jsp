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

		<table id="teachersTable" class="display nowrap">
			<thead>
				<tr>
					<td>ناو</td>
					<td>باوک</td>
					<td>باپیر</td>
					<td>بری پارە</td>
					<td>ن.بەکاربەر</td>
					<td>وشەی نهێنی</td>
					<td>کردرارەکان</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${teachers}" var="item">
					<tr>
						<td>${item.firstName}</td>
						<td>${item.middleName}</td>
						<td>${item.lastName}</td>
						<td>${item.hireAmount}</td>
						<td>${item.userName}</td>
						<td>${item.password}</td>
						
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

