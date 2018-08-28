<%@page import="com.joh.sms.domain.model.ClassGroupTableD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ر.هەفتە</th>
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

					Integer classGroupTableId = item.getClassGroupTableId();
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
					<div class="td-inline-div"><%=item.getSubjectName() == null ? "" : item.getSubjectName()%></div>
					<div class="td-inline-div"><%=item.getTeacherName() == null ? "" : item.getTeacherName()%></div>
					<div class="td-inline-div border-top pt-1">

						<%
							if (classGroupTableId == null) {
						%>
						<button class="btn btn-sm btn-success"
							data-class-group-id="${classGroupId}"
							data-school-week-day-id="<%=schoolWeekDayId%>"
							data-lesson-time-id="<%=lessonTimeId%>"
							onclick="getAddClassGroupTable(this)">
							<i class="fa fa-plus"></i>
						</button>
						<%
							} else {
						%>
						<button class="btn btn-sm btn-danger"
							data-class-group-table-id="<%=classGroupTableId%>" onclick="deleteClassGroupTable(this)">
							<i class="fa fa-times"></i>
						</button>
						<%
							}
						%>
					</div>

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




