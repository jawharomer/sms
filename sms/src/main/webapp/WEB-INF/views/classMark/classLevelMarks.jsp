<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="class-level-marks-container">
	<h3>${classLevel.name}</h3>

	<div>
		<button data-class-level-id="${classLevel.id}"
			onclick="getAddClassMark(this)" type="button" class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<div id="class-marks-div">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ناوی</th>
					<th>نمرە</th>
					<th>کردارەکان</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classMarks}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>${item.limit}</td>
						<td>
							<div>


								<button class="btn btn-sm btn-danger"
									data-class-mark-id="${item.id}" onclick="deleteClassMark(this)">
									<i class="fa fa-times"></i>
								</button>
								<button class="btn btn-sm btn-warning"
									data-class-mark-id="${item.id}" onclick="editClassMark(this)">
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