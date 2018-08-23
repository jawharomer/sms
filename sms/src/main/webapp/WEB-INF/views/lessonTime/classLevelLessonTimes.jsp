<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="class-lesson-times-body">
	<div>${classLevel.name}</div>

	<div>
		<button data-class-level-id="${classLevel.id}"
			onclick="getAddLessonTime(this)" type="button"
			class="btn btn-primary">زیادکردن</button>
	</div>

	<div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>ناوی نمرە</th>
					<th>کردارەکان</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lessonTimes}" var="item">
					<tr>
						<td><fmt:formatDate value="${item.time}" pattern="HH:mm" /></td>
						<td>
							<div>

								<button data-lesson-time-id="${item.id}"
									onclick="editLessonTime(this)">Edit</button>
								<button data-lesson-time-id="${item.id}"
									onclick="deleteLessonTime(this)">Delete</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>







