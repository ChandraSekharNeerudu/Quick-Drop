<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>

body{
height:100vh;
display:flex;
justify-content:center;
align-items:center;
font-family:Segoe UI;
background: linear-gradient(135deg,#000000,#ff7a00);
}

/* Login Card */
.login-card{
background:#f8f9fa;
padding:40px;
border-radius:12px;
width:380px;
box-shadow:0 12px 30px rgba(0,0,0,0.4);
}

/* Heading */
.login-card h2{
text-align:center;
margin-bottom:25px;
font-weight:600;
}

/* Inputs */
.form-control{
height:42px;
border-radius:6px;
}

/* Icons */
.input-group-text{
background:#ffffff;
color:#ff7a00;
border-right:0;
}

.form-control{
border-left:0;
}

/* Input focus */
.form-control:focus{
border-color:#ff7a00;
box-shadow:0 0 6px rgba(255,122,0,0.5);
}

/* Login button */
.btn-login{
background:#ff7a00;
color:white;
width:100%;
height:42px;
border:none;
border-radius:6px;
font-weight:600;
transition:0.3s;
}

.btn-login:hover{
background:#e56d00;
transform:scale(1.02);
}

/* Register link */
.register-link{
text-align:center;
margin-top:15px;
}

.register-link a{
color:#ff7a00;
font-weight:600;
text-decoration:none;
}

.register-link a:hover{
text-decoration:underline;
}

</style>

</head>

<body>

<div class="login-card">

<h2>User Login</h2>
<%
    // request.getParameter looks at the URL for "?error=1"
    String errorFlag = request.getParameter("error");
    
    if(errorFlag != null && errorFlag.equals("1")) {
%>
    <p style="color:red; text-align:center; ">
        <i class="fas fa-exclamation-circle"></i> Invalid Credentials, Username or password is wrong
    </p>
<%
    }
%>

<form name="login" method="post" action="LoginController">

<div class="mb-3">
<div class="input-group">
<span class="input-group-text"><i class="fa fa-user"></i></span>
<input type="text" name="username" class="form-control" placeholder="Username" required>
</div>
</div>

<div class="mb-3">
<div class="input-group">
<span class="input-group-text"><i class="fa fa-lock"></i></span>
<input type="password" name="password" class="form-control" placeholder="Password" required>
</div>
</div>
<div class="mb-3 text-right">
<a href="forgot_password.jsp" style="color:#ff7a00;font-weight:600;">Forgot Password?</a>
</div>

<button type="submit" class="btn-login">Login</button>

<div class="register-link">
<a href="./index.jsp">Go to Registration...!!!</a>
</div>

</form>

</div>

</body>
</html>