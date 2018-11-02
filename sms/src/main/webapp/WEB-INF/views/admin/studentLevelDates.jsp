<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="admin-student-level-dates-container">
	<h3>ڕۆژانی هەلسەنگاندن</h3>
	<div>
		<button onclick="getAddingStudentLevelDates()" class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<div id="admin-student-level-dates-div">

		<table id="student-level-dates" class="table table-bordered">
			<thead>
				<tr>
					<td>#</td>
					<td>بەروار</td>
					<td>کردارەکان</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentLevelDates}" var="item">
					<tr>
						<td>${item.id}</td>
						<td><fmt:formatDate value="${item.date}"
								pattern="yyyy-MM-dd" />
						</td>
						<td>
							<div>
								<button class="btn btn-danger btn-sm"
									onclick="deleteStudentLevelDate(${item.id})">
									<i class="fa fa-times"></i>
								</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

