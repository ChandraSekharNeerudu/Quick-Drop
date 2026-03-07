<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="assets/images/favicon_circle2.png?v=150">
        <title>Quick-Drop</title>
        <meta name="charset" content="UTF-8">
        <meta name="viewport" content=" width=device-width,initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
       .linear{
        background: linear-gradient(to left,rgb(23,43,12),rgb(123,243,26),hsl(33, 95%, 54%));
        padding: 5px 0;
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
        
       /* Use a dot for class selectors */
  .custom_curosel_img {
    object-fit: contain;
    height: 65vh; /* 50% of the screen height */
    width: 100%;  /* Ensures it fills the width of the col-md-6 */
    background-color: #ffffff; 
  }

  /* 1. Change the color of the inactive indicators */
.carousel-indicators li {
    background-color: #000; /* Pure Black */
    opacity: 0.5;           /* Semi-transparent for inactive */
}

/* 2. Change the color of the active indicator */
.carousel-indicators .active {
    background-color: #000; /* Pure Black */
    opacity: 1;             /* Fully solid for the current slide */
}

/* 3. Optional: Change the side control icons (arrows) to black too */
.carousel-control-prev-icon,
.carousel-control-next-icon {
    filter: invert(100%);
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
        
        <a href="./login.jsp"><input type="button" class="btn btn-success me-4" value="Login"> </a>
        <a href="#" class="nav-link text-dark text-center">
            <i class="fas fa-user-circle fa-2x d-block"></i> <span>Profile</span>
        </a>
    </div>
    </nav>





    
    <div >
            <header class="linear">
            <h1 class="text-center">Welcome to the Quick-Drop Worlds Top Shipping System...!!!</h1>
            </header>
    </div>  
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            
                                <h5>"Customer" Registraion</h5>
                                <a href="./Customer_Register.jsp"><input type="submit" value="Ship a Package                         " class="btn btn-custom-orange fw-bold text-orange"></a>
                            
                        </div>
                    </div>
                </div>    
            </div>
        <div class="col-md-6 pl-3 pr-3">
        <div id="demo" class="carousel slide" data-bs-ride="carousel">

        <!-- Indicators -->
         <ul class="carousel-indicators">
            <li data-bs-target="#demo" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#demo" data-bs-slide-to="1"></li>
            <li data-bs-target="#demo" data-bs-slide-to="2"></li>
         </ul>

         <!-- The slideshow class="custom_curosel_img"-->
          <div class="carousel-inner">
            <div class="carousel-item active">
            <img src="assets/images/quick-drop-airplane.png" alt="airplane"class="custom_curosel_img">
            </div>
            <div class="carousel-item ">
                <img src="assets/images/quick-drop-van.png" alt="van" class="custom_curosel_img">
            </div>
            <div class="carousel-item ">
                <img src="assets/images/quick-drop-scooty.png" alt="scooty" class="custom_curosel_img">
            </div>
          </div>
            
    
          <!-- left and right controllers-->
           <a class="carousel-control-prev " href="#demo" data-bs-slide="prev">
            <span class="carousel-control-prev-icon "></span>
           </a>
           <a class="carousel-control-next " href="#demo" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
           </a>
          </div>
        </div>
        <div class="col-md-3">
            <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            
                                <h5>"Agent" Registraion</h5>
                                <a href="./Agent_Register.jsp"><input type="submit" value="Join as a Delivery Partner" class="btn btn-custom-orange fw-bold text-orange"></a>
                            
                        </div>
                    </div>
                </div>    
          </div>
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