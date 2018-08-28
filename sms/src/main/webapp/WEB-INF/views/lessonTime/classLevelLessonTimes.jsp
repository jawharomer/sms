<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="class-lesson-times-body">
	<h3>${classLevel.name}</h3>

	<div>
		<button data-class-level-id="${classLevel.id}"
			onclick="getAddLessonTime(this)" type="button"
			class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<div id="class-l-l-ts-div">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>کات</th>
					<th>کردارەکان</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lessonTimes}" var="item">
					<tr>
						<td><fmt:formatDate value="${item.time}" pattern="HH:mm" /></td>
						<td>
							<div>


								<button class="btn btn-sm btn-danger"
									data-lesson-time-id="${item.id}"
									onclick="deleteLessonTime(this)">
									<i class="fa fa-times"></i>
								</button>
								<button class="btn btn-sm btn-warning"
									data-lesson-time-id="${item.id}" onclick="editLessonTime(this)">
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








