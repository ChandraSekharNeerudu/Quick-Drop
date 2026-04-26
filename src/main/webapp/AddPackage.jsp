<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Package page</title>
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
    <body>
    <%@ include file="includes/navbar.jsp" %>
    
        <header class="linear">
            <h1 class="text-center">Hello Customer <%= session.getAttribute("un")%>,  Add ...!!!</h1>
        </header>
  <div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-7">
            <div class="card shadow-lg border-0">
                <div class="card-header bg-primary text-white p-3">
                    <h4 class="mb-0"><i class="fas fa-box-open me-2"></i> Ship New Package</h4>
                </div>
                <div class="card-body p-4">
                    <form action="AddPackageController" method="post">
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <input type="hidden" name="customername" value="<%= session.getAttribute("customerFullName") %>">
                                 <input type="hidden" name="customerid" value="<%= session.getAttribute("customerTableId") %>">
                                <label class="form-label fw-bold">Source Address</label>
                                <input type="text" name="source" class="form-control" placeholder="City, Area" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label fw-bold">Destination Address</label>
                                <input type="text" name="destination" class="form-control" placeholder="City, Area" required>
                            </div>
                        </div>

                        <div class="row mb-4">
                            <div class="col-md-6">
                                <label class="form-label fw-bold">Distance (km)</label>
                                <input type="number" id="distance" name="distance" class="form-control" placeholder="e.g. 15" oninput="calculateFee()" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label fw-bold">Weight (kg)</label>
                                <input type="number" id="weight" name="weight" class="form-control" placeholder="e.g. 2" step="0.1" oninput="calculateFee()" required>
                                <!-- Why you need it here: Since you are dealing with Weight (kg), a package might weigh 1.5kg or 2.2kg. Setting step="0.1" allows the user to enter decimals. -->
                            </div>
                        </div>

                        <div class="alert alert-info d-flex justify-content-between align-items-center">
                            <span class="fw-bold">Estimated Package Fee:</span>
                            <h3 class="mb-0 text-primary">₹ <span id="displayfee">0.00</span></h3>
                            <input type="hidden" id="packagefee" name="packagefee" value="0">
                        </div>
                        
                        <div class="row mb-4">
                            <div class="col-md-6">
                                <label class="form-label fw-bold">Reciever Name</label>
                                <input type="text" name="reciever" class="form-control" placeholder="Reciever Name" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label fw-bold">Reciever Mobile</label>
                                <input type="text" id="recievermobile" name="recievermobile" class="form-control" placeholder="e.g. 93818-49022" required>
                            </div>
                        </div>
                        
                        

                        <div class="d-grid gap-2 mt-4">
                            <button type="submit" class="btn btn-success btn-lg">
                                <i class="fas fa-plus-circle me-2"></i> Confirm and Add Product
                            </button>
                            <a href="Customer_home.jsp" class="btn btn-outline-secondary">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="includes/footer.jsp" %>    
    <script src="${pageContext.request.contextPath}/assets/js/Calculations.js"></script>
</body>
</html>