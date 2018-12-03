<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="admin-teachers-container">
	<h3>پارەدانی قووتابیان</h3>

	<hr>

	<div class="p-1">
		<form action="<c:url value="/enrollmentPayments" />">
			<table class="w-100">
				<tr>
					<td>
						<div class="d-flex">
							<div class="d-flex align-items-center p-1">لە</div>
							<div class="w-100">
								<input readonly="readonly" class="form-control" id="from"
									name="from"
									value="<fmt:formatDate pattern = "yyyy-MM-dd"  value = "${from}" />" />
							</div>
						</div>
					</td>
					<td>
						<div class="d-flex">
							<div class="d-flex align-items-center p-1">بۆ</div>
							<div class="w-100">
								<input readonly="readonly" class="form-control" id="to"
									name="to"
									value="<fmt:formatDate pattern = "yyyy-MM-dd"  value = "${to}" />" />
							</div>
						</div>
					</td>
					<td>
						<div class="p-1">
							<button class="btn btn-success">
								<i class="fa fa-eye"></i>
							</button>
						</div>
					</td>
				</tr>
			</table>

		</form>

	</div>

	<div id="teacher-table-div">

		<table id="expense-table" class="display w-100">
			<thead>
				<tr>
					<td width="10%">#</td>
					<td>بەروار</td>
					<td>بڕ</td>
					<td>قووتابی</td>
					<td>تێبینی</td>
					
				</tr>
			</thead>
			<tbody>
				<c:set var="sumTotalAmount" value="${0}" />
				<c:forEach items="${enrollmentPayments}" var="item">
					<tr>
						<td width="5%">${item.id}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${item.time}" /></td>
						<td><fmt:formatNumber value="${item.amount}"
								maxFractionDigits="2"></fmt:formatNumber></td>

						<td>
						 <span>${item.enrollment.student.firstName}&nbsp; ${item.enrollment.student.middleName}&nbsp;${item.enrollment.student.lastName}</span>
						</td>
						<td class="cus-note-td">${item.note}</td>
						<c:set var="sumTotalAmount" value="${sumTotalAmount+item.amount}" />
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td><span>کۆی گشتی پارەکان</span> <span> <fmt:formatNumber
								type="number" maxFractionDigits="3" value="${sumTotalAmount}" />
					</span></td>
				</tr>
			</tfoot>


		</table>


	</div>

</div>

