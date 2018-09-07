<%@page import="com.joh.sms.domain.model.ClassGroupTableD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row pt-2">
	<div class="col-8">
		<table class="table table-bordered table-striped">
			<tr>
				<td>ناوی قوتابی</td>
				<td>${student.firstName}</td>
			</tr>
			<tr>
				<td>ناوی باوک</td>
				<td>${student.middleName}</td>
			</tr>
			<tr>
				<td>ناوی باپیر</td>
				<td>${student.lastName}</td>
			</tr>
			<tr>
				<td>بەرواری لەدایک بوون</td>
				<td>${student.birthDate}</td>
			</tr>

		</table>
	</div>
	<div class="col-4">
		<p style="font-size: 8em">
			<c:if test="${student.gender==1}">
				<i class="fa fa-male"></i>
			</c:if>
			<c:if test="${student.gender==0}">
				<i class="fa fa-female"></i>
			</c:if>
		</p>
	</div>
</div>
