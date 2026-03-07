<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <title>Admin | Home</title>
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
        .mtop-8{
        margin-top: 10cap;
        }
        
        .btn-custom-orange {
        color: rgb(236, 126, 16); 
        border: 2px solid rgb(236, 126, 16);
        background-color: transparent;
        transition: all 0.3s ease; /* Makes the hover effect smooth */
        }
        .btn-custom-orange:hover {
        /* Background becomes orange and text becomes white when hovering */
        background-color: rgb(236, 126, 16);
        color: white;
        border-color: rgb(236, 126, 16);
        }
        
        .btn-custom-pink {
        color: rgba(244, 7, 157, 0.966); 
        border: 2px solid rgba(244, 7, 157, 0.966);
        background-color: transparent;
        transition: all 0.3s ease; /* Makes the hover effect smooth */
        }
        .btn-custom-pink:hover {
        /* Background becomes orange and text becomes white when hovering */
        background-color: rgba(244, 7, 157, 0.966);
        color: white;
        border-color: rgba(244, 7, 157, 0.966);
        }
        
        .btn-custom-maroon {
        color: rgba(181, 4, 4, 0.966); 
        border: 2px solid rgba(181, 4, 4, 0.966);
        background-color: transparent;
        transition: all 0.3s ease; /* Makes the hover effect smooth */
        }
        .btn-custom-maroon:hover {
        /* Background becomes orange and text becomes white when hovering */
        background-color: rgba(181, 4, 4, 0.966);
        color: white;
        border-color: rgba(181, 4, 4, 0.966);
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

    <div class="mb-5" >
            <header class="linear">
            <h1 class="text-center">Hello <%= session.getAttribute("un")%>,  Welcome to the Quick-Drop...!!!</h1>
            </header>
    </div> 
   
    
    <div class="container mt-5">
    <div class="row">
    <div class="col-md-6 text-center">
    <form class="form-group mb-5 " method="get" action="CustomerDetailsController">
        <input type="submit" value="get Customers Details" class="btn btn-outline-primary btn-lg px-5 shadow-sm  fw-bold form-controller" >
    </form>
    </div>
    
    <div class="col-md-6 text-center">
    <form class="form-group mb-5" method="get" action="AgentDetailsController">
        <input type="submit" value="get Agents Details   " class="btn btn-custom-maroon btn-lg px-5 shadow-sm  fw-bold form-controller " >
    </form>
    </div>
    </div>
    </div>
    
    
    
    <div class="container mt-5 ">
    <div class="row">
    <div class="col-md-6 text-center">
    <form class="form-group mb-5" method="get" action="UsersDetailsController">
        <input type="submit" value="get Users Details         " class="btn btn-custom-orange btn-lg px-5 shadow-sm  fw-bold form-controller" >
    </form>
    </div>
    
    <div class="col-md-6 text-center">
    <form class="form-group mb-5" method="get" action="PackageDetailsController">
        <input type="submit" value="get Packages Details" class="btn btn-custom-pink btn-lg px-5 shadow-sm  fw-bold form-controller" >
    </form>
    </div> 
    </div>
    </div>
    
    
    
    
    <footer class="bg-dark text-white pt-4 pb-4  pl-3 pr-3 mtop-8">
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