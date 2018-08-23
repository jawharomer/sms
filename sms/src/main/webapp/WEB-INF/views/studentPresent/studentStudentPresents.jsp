<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

This is studentStudenPresent


<table id="studentTable" class="display nowrap">
	<thead>
		<tr>
			<th>بەروار</th>
			<th>هاتوە</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${studentPresents}" var="item">
			<tr>
				<td>${item.date}</td>
				<td><input type="checkbox" ${item.attend==true?"checked":""} /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>