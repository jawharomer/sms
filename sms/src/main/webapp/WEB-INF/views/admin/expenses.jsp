<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="admin-teachers-container">
	<h3>تێچوەکان</h3>
	<button class="btn btn-success" onclick="getAddingExpense()">
		<i class="fa fa-plus"></i>
	</button>

	<hr>

	<div class="p-1">
		<form action="<c:url value="/expenses" />">
			<table class="w-100">
				<tr>
					<td>
						<div class="d-flex">
							<div class="d-flex align-items-center p-1">لە</div>
							<div class="w-100">
								<input class="form-control" id="from" name="from"
									value="<fmt:formatDate pattern = "yyyy-MM-dd"  value = "${from}" />" />
							</div>
						</div>
					</td>
					<td>
						<div class="d-flex">
							<div class="d-flex align-items-center p-1">بۆ</div>
							<div class="w-100">
								<input class="form-control" id="to" name="to"
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

		<table id="expense-table" class="display nowrap">
			<thead>
				<tr>
					<td>#</td>
					<td>بەروار</td>
					<td>بڕ</td>
					<td>جۆر</td>
					<td>تێبینی</td>
					<td class="cus-not-export">کردارەکان</td>
				</tr>
			</thead>
			<tbody>
				<c:set var="sumTotalAmount" value="${0}" />
				<c:forEach items="${expenses}" var="item">
					<tr>
						<td>${item.id}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${item.time}" /></td>
						<td><fmt:formatNumber value="${item.amount}"
								maxFractionDigits="2"></fmt:formatNumber></td>

						<td>${item.type}</td>
						<td class="cus-note-td">${item.note}</td>
						<td>
							<button class="btn btn-danger btn-sm"
								onclick="deleteExpense(${item.id})">
								<i class="fa fa-times"></i>
							</button>
						</td>
						<c:set var="sumTotalAmount" value="${sumTotalAmount+item.amount}" />
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td><span>کۆی گشتی تێچووەکان</span> <span> <fmt:formatNumber
								type="number" maxFractionDigits="3" value="${sumTotalAmount}" />
					</span></td>
				</tr>
			</tfoot>


		</table>


	</div>

</div>

