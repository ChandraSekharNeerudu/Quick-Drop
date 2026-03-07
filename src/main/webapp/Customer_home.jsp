<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>   
<%@ page import="com.Model.Package"%>   
<!DOCTYPE html>
<html>
<head>
        <title>Customer | Home</title>
        <meta name="charset" content="UTF-8">
        <meta name="viewport" content=" width=device-width,initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
       .linear{
        background: linear-gradient(to left,rgb(23,43,12),rgb(123,243,26),hsl(33, 95%, 54%));
        padding: 20px 0;
        } 
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
    <nav class="navbar navbar-expand-md navbar-light bg-light shadow-sm fixed-top">
    <div class="container-fluid">
         <button class="navbar-toggler me-2" type="button" data-bs-toggle="collapse" data-bs-target="#mynav">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <a class="navbar-brand fw-bold" href="#" id="brand-logo">
            <img src="assets/images/Quick_Drop_brand_logo2.png" alt="STYLESTACK Logo" width="150" height="50">
        </a>
        
        <div id="mynav" class="collapse navbar-collapse">
                <ol class="navbar-nav w-100">
                    <li class="nav-item"><a href="#" class="nav-link text-primary">Home</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-primary">About</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-primary">Quick links</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-primary">Feedback</a></li>
                <!--<li class="nav-item ms-auto text-center">
                        <a href="#" class="nav-link text-dark ">
                            <i class="fas fa-user-circle fa-2x d-block"></i> <span>Profile</span>
                        </a>
                    </li>-->
                </ol>
        </div>
        <form method="get" name="logout" id="logout" class="form-group me-4" action="LogoutController">
        <input type="submit" value="logout" class="btn btn-danger form-controller">
        </form>

        <a href="#" class="nav-link text-dark text-center">
            <i class="fas fa-user-circle fa-2x d-block text-center"></i> <span><%=session.getAttribute("un") %></span>
        </a>
        
    </div>
    </nav>

    <div >
            <header class="linear">
            <h1 class="text-center">Hello Customer <%= session.getAttribute("un")%>,  Welcome to the Quick-Drop...!!!</h1>
            </header>
    </div> 
    
    
    <div class="container mt-5">
        <div class="row mb-5 text-center">
            <div class="col-md-12">
                <a href="AddPackage.jsp" class="btn btn-outline-primary btn-lg px-5 shadow-sm me-3">
                    <i class="fas fa-box-open me-2"></i> Ship New Package
                </a>
                <a href="CustomerHistoryController" class="btn btn-outline-secondary btn-lg px-5 shadow-sm">
                    <i class="fas fa-history me-2"></i> View Detailed History
                </a>
            </div>
        </div>

        <div class="card shadow-sm border-0 ">
            <div class="card-header bg-secondary py-3">
                <h4 class="mb-0 text-dark fw-bold"><i class="fas fa-shipping-fast me-2 text-danger"></i> Recent Shipments</h4>
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
                                <th>Agent MobileNo</th>
                                <th>Date</th>
                                <th>Fee</th>
                                <th class="text-center">Status</th>
                            </tr>
                        </thead>
                        <tbody class="table-secondary">
                            <%-- This part will be populated by your Servlet --%>
                            <% List<Package> fewpackageList=(List<Package>)session.getAttribute("fewpackageList");%>
                            <%@ taglib prefix="c" uri="jakarta.tags.core" %>
                           <%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%> 
                            <c:forEach var="pkg" items="${fewpackageList}">
                                <tr>
                                    <td><strong>#${pkg.pkgId}</strong></td>
                                    <td>${pkg.source}</td>
                                    <td>${pkg.destination}</td>
                                    <td>${pkg.reciever}</td>
                                    <td>${pkg.agentId} </td>
                                    <td>${pkg.agentMobile}</td>
                                    <td>${pkg.date}</td>
                                    <td>₹${pkg.packageFee}</td>
                                    <td class="text-center">
                                        <span class="badge 
                                            ${pkg.status == 'DELIVERED' ? 'bg-success text-dark' : (pkg.status == 'CANCELLED' ? 'bg-danger text-dark':(pkg.status == 'PENDING' ? 'bg-warning text-dark':'bg-primary text-dark'))}">${pkg.status}
                                           </span>
                                    </td>
                                </tr>
                            </c:forEach>
                            
                            <%-- Empty State Check --%>
                            <c:if test="${empty fewpackageList}">
                                <tr>
                                    <td colspan="10" class="text-center py-5 text-muted">
                                        <i class="fas fa-parachute-box fa-2x d-block mb-3"></i> No recent shipments found. Start shipping today!
                                    </td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="card-footer bg-secondary text-center py-3">
                <a href="CustomerHistoryController?all=true" class="text-decoration-none card_footer ofw-bold text-">
                    <h5>See More Activity<i class="fas fa-chevron-right ms-1"></i></h4>
                </a>
            </div>
        </div>
    </div>
    
    
    
    
    <footer class="bg-dark text-white pt-4 pb-4  pl-3 pr-3 mt-5">
        <div class=" container text-center text-md-start ">
            <div class="row">
        <div class="col-md-5 mt-3">
            <h5 class="text-uppercase mb-4 font-weight-bold text-warning">Quick-Drop</h5>
                <p>Your one-stop destination for the Quick and Safe delivery.</p>
        </div>
        <div class="col-md-3 mt-3">
            <h5 class="text-warning text-uppercase mb-4 font-weight-bold">policies</h5>
            <p><a href="#" class="text-white" style="text-decoration: none;">Returns</a></p>
            <p><a href="#" class="text-white" style="text-decoration: none;">Shipping</a></p>
        </div>
        <div class="col-md-4 mt-3">
            <h5 class="text-warning text-uppercase mb-4 font-weight-bold">Contact</h5>
           <p><i class="bi bi-house-door me-4"></i> Hyderabad,india</p>
           <p><i class="bi bi-envelope me-4"></i> Support@Quickdrop.com</p>
        </div>
        </div>
        </div>
        
    </footer>  
<body>

</body>
</html>