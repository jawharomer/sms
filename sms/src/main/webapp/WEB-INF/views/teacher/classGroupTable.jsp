<%@page import="com.joh.sms.domain.model.ClassGroupTableD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="class-group-table-container">

	<h3>خشتەی هەفتانە</h3>



	<table class="table table-bordered">



		<thead>
			<tr>
				<td width="15%">ر.هەفتە</td>
				<td>وانەکان</td>
			</tr>
		</thead>
		<tbody>

			<%
				Integer oldSchoolWeekDayId = 0;
				boolean newRow = false;
				List<ClassGroupTableD> classGroupTableDs = (List<ClassGroupTableD>) request
						.getAttribute("classGroupTableDs");
				for (int i = 0; i < classGroupTableDs.size(); i++) {
					ClassGroupTableD item = classGroupTableDs.get(i);
					Integer schoolWeekDayId = item.getSchoolWeekDayId();

					if (schoolWeekDayId != oldSchoolWeekDayId) {
						newRow = true;
						oldSchoolWeekDayId = schoolWeekDayId;
						System.out.println("New Row");
					} else {
						newRow = false;
					}

					if (newRow) {
						System.out.println("New Row-><tr>");
						out.write("<tr>");
						out.write("<td>" + item.getWeekDay() + "</td>");
						out.write("<td class='cus-container-td'>");
					}
			%>

			<%
				if (item.getGroupName() != null && item.getSubjectName() != null && item.getLessonTime() != null) {
			%>
			<div
				class="d-inline-block border p-2 bg-secondary rounded text-white">
				<div>
					<%=item.getGroupName()%>
					&nbsp;
					<%=item.getLessonTime()%></div>
				<div class="border-top pt-1">
					<%=item.getSubjectName()%></div>
			</div>
			<%
				}
			%>

			<%
				if (i < classGroupTableDs.size() - 1) {
						if (classGroupTableDs.get(i + 1).getSchoolWeekDayId() != oldSchoolWeekDayId) {

							System.out.println("Close TD-></td>");
							out.write("</td>");
							System.out.println("Close Row-></tr>");
							out.write("</tr>");
						}
					} else {
						System.out.println("End Close TD-></td>");
						out.write("</td>");
						System.out.println("End RowClose Row-></tr>");
						out.write("</tr>");
					}
				}
			%>


		</tbody>

	</table>

</div>