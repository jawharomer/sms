<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>پۆل</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classGroups}" var="item">
					<tr>

						<td>
						   <a href="<c:url value="/classGroupTables/classGroup/" />${item.id}">${item.name}</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>