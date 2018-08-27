<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="admin-teachers-container">
	<h3>مامۆستاکان</h3>
	<div>
		<button onclick="getAddTeacher()" class="btn btn-primary">زیادکردن</button>
	</div>

	<div id="teacher-table-div">

		<table id="teachersTable" class="display nowrap">
			<thead>
				<tr>
					<td>FirstName</td>
					<td>LastName</td>
					<td>LastName</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${teachers}" var="item">
					<tr>
						<td>${item.firstName}</td>
						<td>${item.lastName}</td>
						<td>
							<div>
								<button class="btn btn-danger btn-sm" data-teacher-id="${item.id}"
									onclick="deleteTeacher(this)">
									<i class="fa fa-times"></i>
									</button>
								<button class="btn btn-warning btn-sm" data-teacher-id="${item.id}" onclick="editTeacher(this)">
										<i class="fa fa-edit"></i></button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>


	</div>

</div>

