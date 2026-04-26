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
    <%@ include file="includes/navbar.jsp" %>

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
    
    
    
    
    <%@ include file="includes/footer.jsp" %>  
<body>

</body>
</html>