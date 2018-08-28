<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="class-level-subjects-container">
	<h3>${classLevel.name}</h3>

	<div>
		<button data-class-level-id="${classLevel.id}" id="cus-btn-addstudent"
			onclick="getAddClassSubject(this)" type="button"
			class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<div id="class-level-ss-div">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ناوی بابەت</th>
					<th>کردارەکان</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classSubjects}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>
							<div>


								<button class="btn btn-sm btn-danger"
									data-class-subject-id="${item.id}"
									onclick="deleteClassSubject(this)">
									<i class="fa fa-times"></i>
								</button>
								<button class="btn btn-sm btn-warning"
									data-class-subject-id="${item.id}"
									onclick="editClassSubject(this)">
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