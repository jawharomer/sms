<%@page
	import="com.joh.sms.domain.model.ClassGroupTableD,java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<section id="teacher-body">
	<section id="section-right" class="card">
		<ul class="list-group cus-right-nav">
			<li class="list-group-item">
				<button data-student-id="${student.id}"
					onclick="getStudentStudentPresents(this)">خشتەی هاتن</button>
			</li>
			<li class="list-group-item"><a
				href='<c:url value="/teachers/classGroupTable/" />${teacher.id}'>خشتەی
					هەفتانە</a></li>
			<c:if test="${navClassGroupTableDs!=null}">
				<li class="list-group-item" id="cus-class-group-li">پۆلەکان
					<ul  class="list-group cus-list-level-1">
						<%
							Integer oldClassGroupId = 0;
								boolean newRow = false;
								List<ClassGroupTableD> navClassGroupTableDs = (List<ClassGroupTableD>) request
										.getAttribute("navClassGroupTableDs");
								for (int i = 0; i < navClassGroupTableDs.size(); i++) {
									ClassGroupTableD item = navClassGroupTableDs.get(i);
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
										System.out.println("New Row-><li>");
										out.write("<li class='list-group-item bg-secondary text-white'>");
										
										out.write("<div class='p-1'>"+item.getGroupName()+"</div>");
										out.write("<ul class='list-group cus-list-level-2'>");
									}
						%>
						<li class="list-group-item bg-secondary text-white"><a
							href="<c:url value="/teachers/marks?classSubjectId=" /><%=classSubjectId%>&classGroupId=<%=classGroupId%>">
								<%=item.getSubjectName() == null ? "" : item.getSubjectName()%>
						</a></li>
						<%
							if (i < navClassGroupTableDs.size() - 1) {
										if (navClassGroupTableDs.get(i + 1).getClassGroupId() != oldClassGroupId) {
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
			</c:if>
		</ul>
	</section>

	<section id="main-content">

		<tiles:insertAttribute name="teacherBody" />

	</section>

</section>