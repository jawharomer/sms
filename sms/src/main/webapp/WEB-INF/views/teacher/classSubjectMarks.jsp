<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="class-subject-marks-container">

	<h5>نمرەی وانەکان</h5>
	

	<table class="table table-bordered">
		<thead>
			<tr>
				<th width="20%">ناو</th>
				<c:forEach items="${classMarks}" var="item">
					<th>
						<div>
							<div>${item.name}</div>
							<div>${item.limit}</div>
						</div>
					</th>
				</c:forEach>
			</tr>
		</thead>

		<tbody>
			<%
				Integer oldStudentId = 0;
				boolean newRow = false;
				List<StudentSubjectMarkD> studentSubjectMarkDs = (List<StudentSubjectMarkD>) request
						.getAttribute("studentSubjectMarkDs");
				for (int i = 0; i < studentSubjectMarkDs.size(); i++) {
					StudentSubjectMarkD item = studentSubjectMarkDs.get(i);

					Integer studentSubjectMarkId = item.getStudentSubjectMarkId();
					Integer studenId = item.getStudentId();
					Integer classSubjectId = item.getClassSubjectId();
					Integer classMarkId = item.getClassMarkId();
					Integer studentId = item.getStudentId();

					if (studentId != oldStudentId) {
						newRow = true;
						oldStudentId = studentId;
						System.out.println("New Row");
					} else {
						newRow = false;
					}

					if (newRow) {
						System.out.println("New Row-><tr>");
						out.write("<tr>");
						out.write("<td>" + item.getStudentName() + "</td>");
					}
			%>
			<td>
				<div>
					<div><%=item.getMark() == null ? "" : item.getMark()%></div>
					<div class="border-top pt-1 text-center">
						<%
							if (studentSubjectMarkId == null) {
						%>
						<button class="btn btn-success btn-sm"
							data-student-id="<%=studenId%>"
							data-class-subject-id="<%=classSubjectId%>"
							data-class-mark-id="<%=classMarkId%>"
							onclick="getAddStudentSubjectMark(this)">

							<i class="fa fa-plus"></i>
						</button>
						<%
							} else {
						%>
						<button class="btn btn-warning btn-sm"
							data-student-subject-mark-id="<%=studentSubjectMarkId%>"
							onclick="getEditStudentSubjectMark(this)">
							<i class="fa fa-edit"></i>
						</button>
						<%
							}
						%>
					</div>
				</div>
			</td>
			<%
				if (i < studentSubjectMarkDs.size() - 1) {
						if (studentSubjectMarkDs.get(i + 1).getStudentId() != oldStudentId) {
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
