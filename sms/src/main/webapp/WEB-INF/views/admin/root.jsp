<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<section id="admin-body">
	<section id="section-right">
		<ul class="cus-navbar">
			<li><a href='<c:url value="/admin/students" />'>Students</a></li>
			<li><a href='<c:url value="/admin/teachers" />'>Teachers</a></li>
			<li><a href='<c:url value="/classLevels" />'>Class Levels</a></li>
			<li><a href='<c:url value="/classGroups" />'>ClassGroupsTable</a></li>
		</ul>
	</section>

	<section id="main-content">

		<tiles:insertAttribute name="adminBody" />

	</section>

</section>