<!DOCTYPE html>
<html>
<head>
<title>Customer | Registration</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>

body{
height:100vh;
display:flex;
justify-content:center;
align-items:center;
font-family:Segoe UI;
background: linear-gradient(135deg,#1a1a1a,#ff7a00);
}

/* Card */
.register-card{
background:#f5f5f5;
padding:35px;
border-radius:12px;
width:540px;
box-shadow:0 10px 25px rgba(0,0,0,0.25);
}

/* Heading */
.register-card h2{
text-align:center;
margin-bottom:25px;
font-weight:600;
}

/* Inputs */
.form-control{
height:42px;
border-radius:6px;
}

/* Input icons */
.input-group-text{
background:#fff;
color:#ff7a00;
border-right:0;
}

.form-control{
border-left:0;
}

/* Focus effect */
.form-control:focus{
border-color:#ff7a00;
box-shadow:0 0 6px rgba(255,122,0,0.4);
}

/* Register button */
.btn-register{
background:#ff7a00;
color:white;
width:100%;
height:42px;
border:none;
border-radius:6px;
font-size:16px;
font-weight:500;
}

.btn-register:hover{
background:#e56d00;
}

/* Login link */
.login-link{
text-align:center;
margin-top:15px;
}

.login-link a{
color:#ff7a00;
font-weight:500;
text-decoration:none;
}

.login-link a:hover{
text-decoration:underline;
}

</style>
</head>

<body>

<div class="register-card">

<h2>User Registration</h2>

<form method="post" action="Customer_Register_Controller">

<div class="row mb-3">

<div class="col-md-6">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fa fa-user"></i></span>
</div>
<input type="text" name="customername" class="form-control" placeholder="Customer Name">
</div>
</div>

<div class="col-md-6">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fa fa-phone"></i></span>
</div>
<input type="text" name="mobile" class="form-control" placeholder="Mobile Number">
</div>
</div>

</div>

<div class="row mb-3">

<div class="col-md-6">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fa fa-envelope"></i></span>
</div>
<input type="text" name="email" class="form-control" placeholder="Email">
</div>
</div>

<div class="col-md-6">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fa fa-location-dot"></i></span>
</div>
<input type="text" name="address" class="form-control" placeholder="Address">
</div>
</div>

</div>

<h6 class="mb-3">Credential Details</h6>

<div class="mb-3">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fa fa-user-circle"></i></span>
</div>
<input type="text" name="username" class="form-control" placeholder="Username">
</div>
</div>

<div class="row mb-3">

<div class="col-md-6">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fa fa-lock"></i></span>
</div>
<input type="password" name="password" class="form-control" placeholder="Password">
</div>
</div>

<div class="col-md-6">
<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fa fa-key"></i></span>
</div>
<input type="password" name="re-password" class="form-control" placeholder="Re-enter Password">
</div>
</div>

</div>

<button type="submit" class="btn-register">Register</button>

<div class="login-link">
Already Registered? <a href="./login.jsp">Login here</a>
</div>

</form>

</div>

</body>
</html>
