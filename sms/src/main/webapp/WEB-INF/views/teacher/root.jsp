<%@page
	import="com.joh.phms.domain.model.ClassGroupTableD,java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<section id="admin-body">
	<section id="section-right">
		<ul class="cus-navbar">
			<li><a
				href="<c:url value="/students/notifications" />${item.id}">
					ئاگادارکردنەوەکان</a></li>
			<li>
				<button data-student-id="${student.id}"
					onclick="getStudentStudentPresents(this)">خشتەی هاتن</button>
			</li>
			<li><a href='<c:url value="/students/classGroupTable" />'>خشتەی
					هەفتانە</a></li>
			<li><a href='<c:url value="/students/marks" />'>نمرەکان</a></li>
			<li>واجبەکان
				<ul>
					<%
						Integer oldClassGroupId = 0;
						boolean newRow = false;
						List<ClassGroupTableD> classGroupTableDs = (List<ClassGroupTableD>) request
								.getAttribute("classGroupTableDs");
						for (int i = 0; i < classGroupTableDs.size(); i++) {
							ClassGroupTableD item = classGroupTableDs.get(i);
							Integer classGroupId = item.getClassGroupId();
							Integer lessonTimeId = item.getLessonTimeId();
							Integer classSubjectId = item.getClassSubjectId();
							System.out.println("classSubjectId=" + classSubjectId);

							if (classGroupId != oldClassGroupId) {
								newRow = true;
								oldClassGroupId = classGroupId;
								System.out.println("New Row");
							} else {
								newRow = false;
							}

							if (newRow) {
								System.out.println("New Row-><tr>");
								out.write("<li>");
								out.write(item.getGroupName());
								out.write("<ul>");
							}
					%>
					<li><a
						href="<c:url value="/teachers/marks?classSubjectId=" /><%=classSubjectId%>&classGroupId=<%=classGroupId%>">
							<%=item.getSubjectName() == null ? "" : item.getSubjectName()%>
					</a></li>
					<%
						if (i < classGroupTableDs.size() - 1) {
								if (classGroupTableDs.get(i + 1).getClassGroupId() != oldClassGroupId) {
									System.out.println("Close Row-></tr>");
									out.write("</ul>");
								}
							} else {
								System.out.println("End RowClose Row-></tr>");
								out.write("</ul>");
							}
						}
					%>
				</ul>
			</li>
		</ul>
	</section>

	<section id="main-content">

		<tiles:insertAttribute name="teacherBody" />

	</section>

</section>



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