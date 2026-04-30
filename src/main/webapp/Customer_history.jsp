<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>   
<%@ page import="com.Model.Package"%>   
<!DOCTYPE html>
<html>
<head>
        <title>Customer| History</title>
        <meta name="charset" content="UTF-8">
        <meta name="viewport" content=" width=device-width,initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="assets/css/header_footer.css">
    <style>
        .h1{
         color: rgb(55, 0, 255);
        }
        .hey{
            overflow:hidden;
        }
        body {
        padding-top: 75px; /* Standard height for a fixed navbar + small gap */
        }
        .card_footer{
        color: rgb(0, 174, 255);
        }
    </style>  
</head>
    <body>    
    <%@ include file="includes/navbar.jsp" %>

    <div >
            <header class="linear">
            <h1 class="text-center">Hello Customer <%= session.getAttribute("un")%>,  Welcome to the Quick-Drop...!!!</h1>
            </header>
    </div>
	<div class="container mt-5">
		<div class="card shadow-sm border-0 mb-5">
			<div class="card-header bg-secondary py-3">
				<h4 class="mb-0 text-dark fw-bold">
					<i class="fas fa-shipping-fast me-2 text-danger"></i> Recent
					Shipments
				</h4>
			</div>
			<div class="card-body p-0">
				<div class="table-responsive">
					<table class="table table-hover mb-0 align-middle">
						<thead class="table-dark">
							<tr>
								<th>Pkg ID</th>
								<th>Source</th>
								<th>Destination</th>
								<th>Receiver</th>
								<th>Agent_ID</th>
								<th>Agent_Mobile</th>
								<th>Date</th>
								<th>Fee</th>
								<th class="text-center">Status</th>
							</tr>
						</thead>
						<tbody class="table-secondary">
							<%-- This part will be populated by your Servlet --%>
							<% List<Package> packageList=(List<Package>)session.getAttribute("packageList");%>
							<%@ taglib prefix="c" uri="jakarta.tags.core"%>
							<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
							<c:forEach var="pkg" items="${packageList}">
								<tr>
									<td><strong>#${pkg.pkgId}</strong></td>
									<td>${pkg.source}</td>
									<td>${pkg.destination}</td>
									<td>${pkg.reciever}</td>
									<td>${pkg.agentId == 0 ? '-' : pkg.agentId}</td>
									<td>${pkg.agentMobile==null ? '-': pkg.agentMobile}</td>
									<td>${pkg.date}</td>
									<td>₹${pkg.packageFee}</td>
									<td class="text-center"><span
										class="badge 
                                            ${pkg.status == 'DELIVERED' ? 'bg-success text-dark' : (pkg.status == 'CANCELLED' ? 'bg-danger text-dark':(pkg.status == 'PENDING' ? 'bg-warning text-dark':'bg-primary text-dark'))}">${pkg.status}
									</span></td>
								</tr>
							</c:forEach>
							<nav>

								<%-- Empty State Check --%>
								<c:if test="${empty packageList}">
									<tr>
										<td colspan="8" class="text-center py-5 text-muted"><i
											class="fas fa-parachute-box fa-2x d-block mb-3"></i> No
											recent shipments found. Start shipping today!</td>
									</tr>
								</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4 mr-5"></div>
			<div class="col-md-4 pl-5">
				<c:set var="currentPage"
					value="${not empty param.page ? param.page : 1}" /><!-- variable initialization -->
				<ul class="pagination">
					<li class="page-item ${currentPage == 1 ? 'disabled' : ''} ">
						<a class="page-link"
						href="CustomerHistoryController?page=${currentPage - 1}">Previous</a>
					</li>
					<li class="page-item">
					    <a class="page-link"
						href="CustomerHistoryController?page=${currentPage}">Page:${currentPage}</a></li>
					<li 
					class="page-item ${currentPage >= totalPages ? 'disabled' : ''}">
						<a class="page-link"
						href="CustomerHistoryController?page=${currentPage + 1}">Next
							Page</a>
					</li>
				</ul>
				</nav>
			</div>
		</div>

	</div>

	<%@ include file="includes/footer.jsp" %>     
<body>

</body>
</html>