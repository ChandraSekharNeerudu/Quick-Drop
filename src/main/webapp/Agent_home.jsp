<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.Model.Package" %>
<!DOCTYPE html>
<html>
<head>
        <title>Agent | Home</title>
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
         .Update_Delivery_Status{
         background-color: rgb(236, 126, 16);
        }
    </style>  
</head>
</head>
    <body>    
     <%@ include file="includes/navbar.jsp" %>

    <div >
            <header class="linear">
            <h1 class="text-center">Hello Agent <%= session.getAttribute("un")%>,  Welcome to the Quick-Drop...!!!</h1>
            </header>
    </div> 
    
    <div class="container mt-5">
        <div class="row mb-5 text-center">
            <div class="col-md-12">
                <a href="PickAPackageController">
                    <button class="btn btn-outline-primary btn-lg px-5 shadow-sm me-3  fw-bold">
                    <i class="fas fa-edit me-2"></i> Pick a New Delivery 
                    </button>
                </a>
   
                <a href="MyEarningsController">
                    <button class="btn btn-outline-primary btn-lg px-5 shadow-sm fw-bold">
                    <i class="fas fa-wallet me-2"></i> My Earnings
                   </button>
                </a>   
            </div>
        </div>

        <div class="card shadow-sm border-0 hey">
            <div class="card-header bg-secondary py-3">
                <h3 class="mb-0 text-dark fw-bold"><i class="fas fa-route me-2 text-danger"></i> Assigned Deliveries</h3>
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
                                <th>Receiver MobileNo</th>
                                <th>Customer ID</th>
                                <th>Customer Mobile</th>
                                <th>Date</th>
                                <th>Your Fee</th>
                                <th class="text-center">Status</th>
                                <th class="text-center text-success">Update Deliver Status</th>
                            </tr>
                        </thead>
                        <tbody class="table-secondary">
                         <% List<Package> assignedPackages=(List<Package>)session.getAttribute("assignedPackages");%>
                            <%@ taglib uri="jakarta.tags.core" prefix="c" %>
                            <c:forEach var="pkg" items="${assignedPackages}">
                                <tr>
                                    <td><strong>#${pkg.pkgId}</strong></td>
                                    <td>${pkg.source}</td>
                                    <td>${pkg.destination}</td>
                                    <td>${pkg.reciever}</td>
                                    <td>${pkg.recieverMobile}</td>
                                    <td>${pkg.customerId}</td>
                                     <td>${pkg.customerMobile }</td>
                                    <td>${pkg.date}</td>
                                    <td class="text-success fw-bold">₹${pkg.deliveryFee}</td>
                                    <td class="text-center">
                                        <span class="badge 
                                           ${pkg.status == 'DELIVERED' ? 'bg-success text-dark' : (pkg.status == 'CANCELLED' ? 'bg-danger text-dark':(pkg.status == 'PENDING' ? 'bg-warning text-dark':'bg-primary text-dark'))}">${pkg.status}
                                        </span>
                                    </td>
                                   <td>
                                   <a href="Update_Delivery_Status.jsp?pid=${pkg.pkgId}&currentStatus=${pkg.status}">
                                   <input type="button" value="Update Status" class="btn Update_Delivery_Status fw-bold">
                                   </a>
                                   </td>
                                </tr>
                            </c:forEach>
                            
                            <%-- Empty State --%>
                            <c:if test="${empty assignedPackages}">
                                <tr>
                                    <td colspan="12" class="text-center py-5 text-muted">
                                        <i class="fas fa-parachute-box fa-2x d-block mb-3"></i>
                                        No deliveries assigned to you yet.
                                    </td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

     <!--  <div class="row mt-5">
			<div class="col-md-4 mr-3"></div>
			<div class="col-md-4 pl-5">
				<c:set var="currentPage"
					value="${not empty param.page ? param.page : 1}" />
				<ul class="pagination">
					<li class="page-item ${currentPage == 1 ? 'disabled' : ''} ">
						<a class="page-link"
						href="LoginController?page=${currentPage - 1}">Previous</a>
					</li>
					<li class="page-item">
					    <a class="page-link"
						href="LoginController?page=${currentPage}">Page:${currentPage}</a></li>
					<li 
					class="page-item ${currentPage >= totalPages ? 'disabled' : ''}">
						<a class="page-link"
						href="LoginController?page=${currentPage + 1}">Next
							Page</a>
					</li>
				</ul>
				</nav>
			</div>
		</div>
		 --> 
	</div>
    
    
    
    <%@ include file="includes/footer.jsp" %>   
</body>
</html>