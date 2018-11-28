<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h5>
	سیمکارت
	<meter value="${modemStatus.signal}" min="0" max="31"></meter>
</h5>
<div class="p-1">
	<button class="btn btn-success btn-sm" onclick="getAddingBalance()">زیادکردنی
		بالانس</button>
</div>
<div class="p-top-2">
	<div class="card card-body border-success">
		${modemStatus.balance}</div>
</div>

<table class="table table-bordered">

	<thead>
		<tr>
			<th>بۆ</th>
			<th>نامە</th>
			<th>بەروار</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${smsMessages}" var="item">
			<tr>
				<td>${item.to}</td>
				<td>${item.message}</td>
				<td><fmt:formatDate value="${item.time}"
						pattern="yyyy-MM-dd hh:mm:ss" /></td>
			</tr>
		</c:forEach>
	</tbody>


</table>