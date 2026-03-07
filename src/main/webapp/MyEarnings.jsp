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
        .this_month{
         background-color: rgb(236, 126, 16);
        }
    </style>  
</head>
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
            <i class="fas fa-user-circle fa-2x d-block"></i> <span><%=session.getAttribute("un") %></span>
        </a>
    </div>
    </nav>

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
</body>
</html>