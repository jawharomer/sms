<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
				<th>کردارەکان</th>
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

				if (classSubjectId != oldClassSubjectId) {
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
		<td><%=item.getMark() == null ? "" : item.getMark()%></td>
		<%
			if (i < studentSubjectMarkDs.size() - 1) {
					if (studentSubjectMarkDs.get(i + 1).getClassSubjectId() != oldClassSubjectId) {
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




<!-- Modal -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>



