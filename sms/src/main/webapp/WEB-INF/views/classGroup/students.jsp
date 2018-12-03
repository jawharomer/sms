<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="class-group-student-container">
	<h3>${classGroup.name}</h3>
	<button class="btn btn-info" onclick="getAddingStudentNotificaion()">ئاگادارکرنەوە</button>
	<sec:authorize access="hasRole('ADMIN')">
		<button class="btn btn-info" onclick="getAddingStudentSMS()">کورەتەنامە</button>
	</sec:authorize>

	<div id="student-table-div">
		<table id="student-table" class="display nowrap">
			<thead>
				<tr>
					<th>#</th>
					<th>ناو</th>
					<th>باوک</th>
					<th>باپی</th>
					<sec:authorize access="hasRole('ADMIN')">
						<th>ئاستی زانستی</th>
						<th>تۆماری نەهاتن</th>
						<th>نمرەکان</th>
					</sec:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.firstName}</td>
						<td>${item.middleName}</td>
						<td>${item.lastName}</td>
						<sec:authorize access="hasRole('ADMIN')">
							<td>
								<button class="btn btn-sm btn-info" data-student-id="${item.id}"
									onclick="getStudentStudnetLevelDates(this)">
									<i class="fa fa-line-chart"></i>
								</button>
							</td>
							<td>
								<button class="btn btn-sm btn-info" data-student-id="${item.id}"
									onclick="getStudentStudnetPresents(this)">
									<i class="fa fa-eye"></i>
								</button>
							</td>
							<td>
								<button class="btn btn-sm btn-info" data-student-id="${item.id}"
									onclick="getStudentStudnetSubjectMarks(this)">
									<i class="fa fa-eye"></i>
								</button>
							</td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>

</div>



