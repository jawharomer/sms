<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="enrollment-payments-container">
	<h4>
		<span>پارەدانی ناونیسین </span>- <span>${enrolllment.student.firstName}&nbsp;
			${enrolllment.student.middleName}&nbsp;${enrolllment.student.lastName}</span>
	</h4>

	<button class="cus-not-print btn btn-success"
		data-enrollment-id="${enrollmentId}"
		onclick="getAddEnrollmentPayment(this)" type="button"
		class="btn btn-primary">
		<i class="fa fa-plus"></i>
	</button>

	<div id="section-to-print">
		<div id="enrollment-table-div">
			<table id="enrollment-payment-table" class="display nowrap">
				<thead>
					<tr>
						<th>کات</th>
						<th>بڕ</th>
						<th>تێبینی</th>
						<th class="cus-not-print cus-not-export">کردارەکان</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="totalEnrollmentPayment" value="0" />
					<c:forEach items="${enrollmentPayments}" var="item">
						<tr>
							<td><fmt:formatDate value="${item.time}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${item.amount}</td>
							<c:set var="totalEnrollmentPayment"
								value="${totalEnrollmentPayment+item.amount}" />
							<td class="cus-note-td">${item.note}</td>
							<td class="cus-not-print">
								<div>
									<button class="btn btn-sm btn-danger"
										data-enrollment-payment-id="${item.id}"
										onclick="deleteEnrollmentPayment(this)">
										<i class="fa fa-times"></i>
									</button>
									<button class="btn btn-sm btn-warning"
										data-enrollment-payment-id="${item.id}"
										onclick="editEnrollmentPayment(this)">
										<i class="fa fa-edit"></i>
									</button>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td>
							<div>
								<span>بری پارەی ناونیسین</span> <span> <fmt:formatNumber
										type="number" maxFractionDigits="3" value="${enrolllment.fee}" />
								</span>
							</div>
							<div>
								<span>بری پارەی دراو</span> <span> <fmt:formatNumber
										type="number" maxFractionDigits="3"
										value="${totalEnrollmentPayment}" />
								</span>
							</div>
							<div>
								<span>ماوە</span> <span> <fmt:formatNumber type="number"
										maxFractionDigits="3"
										value="${enrolllment.fee-totalEnrollmentPayment}" />
								</span>
							</div>

						</td>
					</tr>
				</tfoot>

			</table>
		</div>
	</div>
</div>