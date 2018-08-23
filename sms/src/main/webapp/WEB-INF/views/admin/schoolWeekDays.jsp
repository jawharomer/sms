<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

School Week Days

<div>
	<!-- Button trigger modal -->
	<button onclick="getAddSchoolWeekDay()" type="button"
		class="btn btn-primary">زیادکردن</button>
</div>

<table id="schoolWeekDayTable" class="display nowrap">
	<thead>
		<tr>
			<td>Name</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${schoolWeekDays}" var="item">
			<tr>
				<td>${item.weekDay}</td>
				<td>
					<div>
						<button data-school-week-day-id="${item.id}"
							onclick="deleteSchoolWeekDay(this)">delete</button>
						<button data-school-week-day-id="${item.id}"
							onclick="editSchoolWeekDay(this)">edit</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>


</table>





<!-- Modal -->
<div class="modal fade" id="modal" tabindex="-1">
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





