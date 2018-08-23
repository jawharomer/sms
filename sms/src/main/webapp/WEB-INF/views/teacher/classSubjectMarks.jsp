<%@page import="com.joh.phms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


This is Teacher Class Subject Marks


<table>
	<thead>
		<tr>
			<th>&nbsp;</th>
			<c:forEach items="${classMarks}" var="item">
				<th>
					<div>
						<div>${item.name}</div>
						<div>${item.limit}</div>
					</div>
				</th>
			</c:forEach>
			<th>کردارەکان</th>
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
				<div>
					<%
						if (studentSubjectMarkId == null) {
					%>
					<button data-student-id="<%=studenId%>"
						data-class-subject-id="<%=classSubjectId%>"
						data-class-mark-id="<%=classMarkId%>"
						onclick="getAddStudentSubjectMark(this)">Add</button>
					<%
						} else {
					%>
					<button data-student-subject-mark-id="<%=studentSubjectMarkId%>"
						onclick="getEditStudentSubjectMark(this)">Edit</button>
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
