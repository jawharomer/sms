<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="student-subject-mark-container">
	<c:if test="${noDataError==null}">
		<h3>نمرەکان</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th width="30%">بابەت</th>
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
					Integer oldClassSubjectId = 0;
						boolean newRow = false;
						List<StudentSubjectMarkD> studentSubjectMarkDs = (List<StudentSubjectMarkD>) request
								.getAttribute("studentSubjectMarkDs");
						for (int i = 0; i < studentSubjectMarkDs.size(); i++) {
							StudentSubjectMarkD item = studentSubjectMarkDs.get(i);

							Integer studentSubjectMarkId = item.getStudentSubjectMarkId();
							Integer studenId = item.getStudentId();
							Integer classSubjectId = item.getClassSubjectId();
							Integer classMarkId = item.getClassMarkId();

							if (classSubjectId.intValue() != oldClassSubjectId.intValue()) {
								newRow = true;
								oldClassSubjectId = classSubjectId;
								System.out.println("New Row");
							} else {
								newRow = false;
							}

							if (newRow) {
								System.out.println("New Row-><tr>");
								out.write("<tr>");
								out.write("<td>" + item.getSubjectName() + "</td>");
							}
				%>
				<td>
					<%
						if (item.getMark() != null) {
									if (item.isLevel()) {
										String level = "";
										switch (item.getMark().intValue()) {
										case 0:
											level = "خراپە";
											break;
										case 1:
											level = "پەسەندە";
											break;
										case 2:
											level = "ناوەندە";
											break;
										case 3:
											level = "باشە";
											break;
										case 4:
											level = "زۆرباشە";
											break;
										case 5:
											level = "خراپە";
											break;
										case 6:
											level = "نایابە";
											break;
										}
										out.write(level);
									} else {
										out.write("" + item.getMark());
									}
								} else {
									out.write("");
								}
					%>
				</td>
				<%
					if (i < studentSubjectMarkDs.size() - 1) {
								if (studentSubjectMarkDs.get(i + 1).getClassSubjectId().intValue() != oldClassSubjectId
										.intValue()) {
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
	</c:if>


</div>



