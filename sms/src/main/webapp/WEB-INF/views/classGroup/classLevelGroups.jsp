<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="class-level-class-groups-container">
	<h3>${classLevel.name}</h3>

	<div>
		<button data-class-level-id="${classLevel.id}"
			onclick="getAddClassGroup(this)" class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<div id="class-g-l-gs-div">
		<table class="w-100 table table-bordered">
			<thead>
				<tr>
					<th>ناوی پۆل</th>
					<th>کردارەکان</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classGroups}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>
							<div>
								<button class="btn btn-sm btn-danger"
									data-class-group-id="${item.id}"
									onclick="deleteClassGroup(this)">
									<i class="fa fa-times"></i>
								</button>
								<button class="btn btn-sm btn-warning"
									data-class-group-id="${item.id}" onclick="editClassGroup(this)">
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








