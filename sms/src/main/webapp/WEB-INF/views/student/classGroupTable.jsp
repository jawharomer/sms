<%@page import="com.joh.sms.domain.model.ClassGroupTableD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="class-group-table-container">
	<div id="section-to-print">
		<div class="d-print-none p-2">
			<button class="btn btn-sm btn-info" onclick="window.print()">
				<i class="fa fa-print"></i>
			</button>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ز.هەفتە</th>
					<c:forEach items="${lessonTimes}" var="item">
						<th>${item.time}</th>
					</c:forEach>
				</tr>
			</thead>

			<tbody>
				<%
					Integer oldSchoolDayId = 0;
					boolean newRow = false;
					List<ClassGroupTableD> classGroupTableDs = (List<ClassGroupTableD>) request
							.getAttribute("classGroupTableDs");
					for (int i = 0; i < classGroupTableDs.size(); i++) {
						ClassGroupTableD item = classGroupTableDs.get(i);
						Integer schoolWeekDayId = item.getSchoolWeekDayId();
						Integer lessonTimeId = item.getLessonTimeId();

						if (schoolWeekDayId != oldSchoolDayId) {
							newRow = true;
							oldSchoolDayId = schoolWeekDayId;
							System.out.println("New Row");
						} else {
							newRow = false;
						}

						if (newRow) {
							System.out.println("New Row-><tr>");
							out.write("<tr>");
							out.write("<td>" + item.getWeekDay() + "</td>");
						}
				%>

				<td>

					<div class="td-container-div">
						<div class="cus-p-100 td-inline-div"><%=item.getSubjectName() == null ? "" : item.getSubjectName()%></div>
						<div class="d-print-none border-top"></div>
						<div class="d-none d-print-block border-right"></div>
						<div class="mt-1  cus-p-100  td-inline-div"><%=item.getTeacherName() == null ? "" : item.getTeacherName()%></div>
					</div>

				</td>

				<%
					if (i < classGroupTableDs.size() - 1) {
							if (classGroupTableDs.get(i + 1).getSchoolWeekDayId() != oldSchoolDayId) {
								System.out.println("Close Row-></tr>");
								out.write("</tr>");
							}
						} else {
							System.out.println("End RowClose Row-></tr>");
							out.write("</tr>");
						}
					}
				%>
			</tbody>

		</table>

	</div>

</div>