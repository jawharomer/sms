<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="class-levels-container">
	<h3>هۆبەکان</h3>
	<div>
		<button id="cus-btn-addstudent" onclick="getAddClassLevel()"
			type="button" class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<div id="class-levels-container">

		<table id="teacherTable" class="table table-bordered">
			<thead>
				<tr>
					<td>ناو</td>
					<td>بابەتەکان</td>
					<td>کردارەکان</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classLevels}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>
							<button class="btn btn-sm btn-outline-info">
								<i class="fa fa-eye"></i>
							</button>
						</td>
						<td>
							<div>
								<button class="btn btn-sm btn-danger"
									data-classlevel-id="${item.id}"
									onclick="deleteClassLevel(this)">
									<i class="fa fa-times"></i>
								</button>
								<button class="btn btn-sm btn-warning"
									data-classlevel-id="${item.id}" onclick="editClassLevel(this)">
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