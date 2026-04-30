<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.Model.Agent_profle"%>
<!DOCTYPE html>
<html>
<head>
<title>All Agent | Details</title>
<meta name="charset" content="UTF-8">
<meta name="viewport" content=" width=device-width,initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<link rel="stylesheet" href="assets/css/header_footer.css">
<style>
.hey {
	overflow: hidden;
}

body {
	padding-top: 75px; /* Standard height for a fixed navbar + small gap */
}

.icon_color {
	color: rgb(236, 126, 16);
}
</style>
</head>
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>

	<div>
		<header class="linear">
			<h1 class="text-center ">
				Hello
				<%= session.getAttribute("un")%>, Welcome to the Quick-Drop...!!!
			</h1>
		</header>
	</div>


	<div class="container mt-5">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<h4 class="text-center text-danger">
					<b>Agents Details Table</b>
				</h4>
				<div class="card shadow-sm border-0 hey">
					<div class="card-header bg-secondary py-3">
						<h4 class="mb-0 icon_color fw-bold">
							<i class="fa-solid fa-person-biking"></i>
						</h4>
					</div>
					<div class="card-body p-0">
						<div class="table-responsive">
							<table class="table table-hover mb-0 align-middle">
								<thead class="table-dark">
									<tr>
										<th class="text-warning">Agent ID</th>
										<th class="text-warning">User ID</th>
										<th class="text-warning">Agent Name</th>
										<th class="text-warning">Mobile</th>
										<th class="text-warning">mail</th>
										<th class="text-warning">Address</th>
										<th class="text-warning">Vehicle Type</th>
										<th class="text-warning">Vehicle No</th>
										<!--     <th class="text-success text-center">Update</th>
                <th class="text-danger text-center">Delete</th>-->
									</tr>
								</thead>

								<%
								List<Agent_profle> list=(List<Agent_profle>)session.getAttribute("agents");
								   if (list != null) {
									for (Agent_profle obj : list) {
								%>
								<tbody class="table-secondary">
									<tr>
										<td><%=obj.getAgentId() %></td>
										<td><%=obj.getUserId() %></td>
										<td><%=obj.getAgentName() %></td>
										<td><%=obj.getMobile() %></td>
										<td><%=obj.getMail() %></td>
										<td><%=obj.getAddress() %></td>
										<td><%=obj.getVehicleType()  %></td>
										<td><%=obj.getVehicleNo() %></td>
										<!--<td ></td>
    <td></td>-->
									</tr>
								</tbody>
								<%
								}
								    } else {
								%>
								<tr>
									<td colspan="4" class="text-center">No Agents Found</td>
								</tr>
								<% } %>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<%@ taglib prefix="c" uri="jakarta.tags.core"%>
		<div class="row mt-3">
			<div class="col-md-5 "></div>
			<div class="col-md-4 pl-3">
				<c:set var="currentPage"
					value="${not empty param.page ? param.page : 1}" />
				<!-- variable initialization -->
				<ul class="pagination">
					<li class="page-item ${currentPage == 1 ? 'disabled' : ''} ">
						<a class="page-link"
						href="CustomerDetailsController?page=${currentPage - 1}">Previous</a>
					</li>
					<li class="page-item"><a class="page-link"
						href="CustomerDetailsController?page=${currentPage}">Page:${currentPage}</a></li>
					<li
						class="page-item ${currentPage >= totalAgentPages ? 'disabled' : ''}">
						<a class="page-link"
						href="CustomerDetailsController?page=${currentPage + 1}">Next Page</a>
					</li>
				</ul>
				</nav>
			</div>
		</div>
		
	</div>




	<%@ include file="includes/footer.jsp"%>
<body>

</body>
</html>