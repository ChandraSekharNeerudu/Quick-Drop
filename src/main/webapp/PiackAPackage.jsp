<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <title>Pick-Package</title>
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
    <div class="card shadow-sm border-0 hey mb-5">
            <div class="card-header bg-secondary py-3">
                <h3 class="mb-0 text-dark fw-bold"><i class="fas fa-route me-2 text-danger"></i>Packages Out for  Deliveries</h3>
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
                                <th class="text-center text-primary">pick-package </th>
                            </tr>
                        </thead>
                        <tbody class="table-secondary">
                            <%@ taglib uri="jakarta.tags.core" prefix="c" %>
                            <c:forEach var="pkg" items="${unAssignedPackages}">
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
                                    <td class="text-warning fw-bold">${pkg.status}</td>
                                    <td>
                                    <a href="PickUpedController?pid=${pkg.pkgId}" 
                                    class="btn btn-sm btn-primary">
                                    <i class="fas fa-hand-holding me-1"></i> Pick-up
                                    </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            
                            <%-- Empty State --%>
                            <c:if test="${empty unAssignedPackages}">
                                <tr>
                                    <td colspan="12" class="text-center py-5 text-muted">
                                        <i class="fas fa-parachute-box fa-2x d-block mb-3"></i>
                                        No Pending Packages to Deliver.
                                    </td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
   
    
    
    
 <%@ include file="includes/footer.jsp" %>      
</body>
</html>