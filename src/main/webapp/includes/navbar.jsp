<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md navbar-light bg-light shadow-sm sticky-top">
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
            <i class="fas fa-user-circle fa-2x d-block"></i>
             <span><%= (session.getAttribute("un") == null) ? "Profile" : session.getAttribute("un") %></span>
        </a>
   </div>
</nav>