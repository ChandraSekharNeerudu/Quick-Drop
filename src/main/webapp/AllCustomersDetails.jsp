<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.Model.Customer_profile" %>   
<!DOCTYPE html>
<html>
<head>
        <title>All Customer | Details</title>
        <meta name="charset" content="UTF-8">
        <meta name="viewport" content=" width=device-width,initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

    <style>
       .linear{
        background: linear-gradient(to left,rgb(23,43,12),rgb(123,243,26),hsl(33, 95%, 54%));
        padding: 5px 0;
        } 
        .hey{
            overflow:hidden;
        }
        body {
        padding-top: 75px; /* Standard height for a fixed navbar + small gap */
        }
        .Users_color{
        color: rgb(236, 126, 16);
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
            <h1 class="text-center ">Hello <%= session.getAttribute("un")%>,  Welcome to the Quick-Drop...!!!</h1>
            </header>
    </div> 
    
   
    <div class="container mt-5">
    <div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
    <h4 class="text-center text-danger"><b>Customer Details Table</b></h4>
    <div class="card shadow-sm border-0 hey">
            <div class="card-header bg-secondary py-3">
                <h4 class="mb-0 Users_color fw-bold"><i class="fa-solid fa-users"></i> </h4>
            </div>
    <div class="card-body p-0">
    <div class="table-responsive">
    <table class="table table-hover mb-0 align-middle">
        <thead class="table-dark"> <tr>
                <th class="text-warning">Customer ID</th>
                <th class="text-warning">User ID</th>
                <th class="text-warning">Name</th>
                <th class="text-warning">Mobile</th>
                <th class="text-warning">mail</th>
                <th class="text-warning">Address</th>
                <th class="text-success text-center">Update</th>
                <th class="text-danger text-center">Delete</th>
            </tr>
        </thead>
        
    <%List<Customer_profile> list=(List<Customer_profile>)session.getAttribute("customers");
    if(list!=null){
      for(Customer_profile obj:list){
    %>
    <tbody class="table-secondary">
    <tr>
    <td><%=obj.getCustId() %></td>
    <td><%=obj.getUserId() %></td>
    <td><%=obj.getCutomerName() %></td>
    <td><%=obj.getMobile() %></td>
    <td><%=obj.getMail() %></td>
    <td><%=obj.getAddress() %></td>
    <td ></td>
    <td></td>
    </tr>
    </tbody>
    <%}
    }
else {
	 %>
      <tr>
        <td colspan="4" class="text-center">No Customers Found</td>
    </tr>
    <% } %>
    </table>
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
<body>

</body>
</html>