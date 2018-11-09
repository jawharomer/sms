<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="student-presents-container">
	<h3>${classGroup.name}</h3>
	<a class="btn btn-success"
		href="<c:url value="/studentPresents/add/classGroup/" />${classGroup.id}"
		target="_blank"> <i class="fa fa-plus"></i>
	</a> <a class="btn btn-warning"
		href="<c:url value="/studentPresents/add/classGroup/" />${classGroup.id}/all"
		target="_blank"> <i class="fa fa-edit"></i>
	</a>

	<div id="student-present-table">
		<table id="student-presents-table" class="display nowrap">
			<thead>
				<tr>
					<th>ناوەی قووتابی</th>
					<th>ژ.رۆژە هاتووەکان</th>
					<th>ژ.رۆژە نەهاتووەکان</th>
					<th class="cus-not-export">زیاتر</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentPresentDs}" var="item">
					<tr>
						<td>${item.studentName}</td>
						<td>${item.attendDays}</td>
						<td>${item.absentDays}</td>
						<td>
							<div>
								<button class="btn btn-sm btn-info"
									data-student-id="${item.studentId}"
									onclick="getStudentStudentPresents(this)">
									<i class="fa fa-eye"></i>
								</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>

	</div>