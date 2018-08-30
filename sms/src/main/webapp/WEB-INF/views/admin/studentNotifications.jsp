<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h3>ئاگادارکردنوە کانی قوتابی</h3>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>بەروار</th>
					<th>بابەت</th>
					<th>ناوەرۆک</th>
					<th>قوتابیەکان</th>
					<th>کردارەکان</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentNotifications}" var="item">
					<tr>

						<td>${item.time}</td>
						<td>${item.title}</td>
						<td class="cus-note-td">${item.note}</td>
						<td>
							<button class="btn btn-sm btn-info"
								data-student-notification-id="${item.id}"
								onclick="getStudenttNotificationStudents(this)">
								<i class="fa fa-eye"></i>
							</button>
						</td>
						<td>
							<div>
								<button class="btn btn-sm btn-danger"
									data-student-notification-id="${item.id}"
									onclick="deleteStudentNotifications(this)">
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