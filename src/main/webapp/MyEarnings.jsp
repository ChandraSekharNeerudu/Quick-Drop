<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <title>My Earnings Page</title>
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
        .this_month{
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
    <div class="row">
        <div class="col-md-4 mb-4">
            <div class="card border-0 shadow-sm this_month text-white text-center p-3">
                <div class="card-body">
                    <h6 class="text-uppercase  opacity-75">This Month</h6>
                    <h2 class="fw-bold">₹ ${thisMonth != null ? thisMonth : '0.00'}</h2>
                </div>
            </div>
        </div>

        <div class="col-md-4 mb-4">
            <div class="card border-0 shadow-sm bg-secondary text-white text-center p-3">
                <div class="card-body">
                    <h6 class="text-uppercase opacity-75">Last Month</h6>
                    <h2 class="fw-bold">₹ ${lastMonth != null ? lastMonth : '0.00'}</h2>
                </div>
            </div>
        </div>

        <div class="col-md-4 mb-4">
            <div class="card border-0 shadow-sm bg-primary text-white text-center p-3">
                <div class="card-body">
                    <h6 class="text-uppercase opacity-75">Total Lifetime</h6>
                    <h2 class="fw-bold">₹ ${totalEarnings != null ? totalEarnings : '0.00'}</h2>
                </div>
            </div>
        </div>
    </div>
    
    <div class="row justify-content-center mt-3">
        <div class="col-md-4 d-grid">
            <button class="btn btn-success btn-lg shadow-sm">
                <i class="fas fa-hand-holding-usd me-2"></i>Withdraw Funds
            </button>
        </div>
    </div>
</div>
    
    
    
    

<%@ include file="includes/footer.jsp" %>
</body>
</html>