<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="school-week-days-container">
	<h3>رۆژانی هەفتە</h3>

	<div>
		<button onclick="getAddSchoolWeekDay()" type="button"
			class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<div id="school-w-ds-div">

		<table id="schoolWeekDayTable" class="table table-bordered">
			<thead>
				<tr>
					<td>ناو</td>
					<td>کردارەکان</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${schoolWeekDays}" var="item">
					<tr>
						<td>${item.weekDay}</td>
						<td>
							<div>
								<button class="btn btn-sm btn-danger"
									data-school-week-day-id="${item.id}"
									onclick="deleteSchoolWeekDay(this)">
									<i class="fa fa-times"></i>
								</button>
								<button class="btn btn-sm btn-warning"
									data-school-week-day-id="${item.id}"
									onclick="editSchoolWeekDay(this)">
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





