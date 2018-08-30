<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h3>خشتەی هەفتانە</h3>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>پۆل</th>
					<th><span>
							تۆماری نەهاتن </span></th>
					<th>قوتابیەکان</th>
					<th>خشتەی هەفتانە</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classGroups}" var="item">
					<tr>

						<td>${item.name}</td>

						<td><a target="_blank" class="btn btn-sm btn-success"
							href="<c:url value="/studentPresents/add/classGroup/" />${item.id}">
								<i class="fa fa-plus"></i>
						</a>
						
						<a target="_blank" class="btn btn-sm btn-info"
							href="<c:url value="/studentPresents/classGroup/" />${item.id}">
								<i class="fa fa-eye"></i>
						</a>
						
						</td>
						<td><a target="_blank" class="btn btn-sm btn-info"
							href="<c:url value="/classGroups/" />${item.id}/students"> <i
								class="fa fa-group"></i>
						</a></td>

						<td><a class="btn btn-sm btn-info"
							href="<c:url value="/classGroupTables/classGroup/" />${item.id}">
								<i class="fa fa-eye"></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>