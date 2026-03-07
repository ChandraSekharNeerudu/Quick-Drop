<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Forget | Password</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>

body{
height:100vh;
display:flex;
justify-content:center;
align-items:center;
background:linear-gradient(135deg,#000,#ff7a00);
font-family:Segoe UI;
}

.card-box{
background:#f8f9fa;
padding:35px;
width:350px;
border-radius:10px;
box-shadow:0 10px 25px rgba(0,0,0,0.4);
}

.input-group-text{
background:#ffffff;
color:#ff7a00;
border-right:0;
}

.form-control{
border-left:0;
}

.form-control:focus{
border-color:#ff7a00;
box-shadow:0 0 6px rgba(255,122,0,0.5);
}

.btn-reset{
background:#ff7a00;
border:none;
width:100%;
color:white;
font-weight:600;
}

.btn-reset:hover{
background:#e56d00;
}

</style>

</head>

<body>

<div class="card-box">

<h4 class="text-center mb-4">Forgot Password</h4>

<form action="CheckUserController" method="post">
<%
String msg1=(String)request.getAttribute("msg1");
if(msg1!=null){
%>

<p style="color:red;text-align:center;"><i class="fas fa-exclamation-circle"></i><%=msg1 %></p>

<%
}
%>
<div class="input-group mb-3">
<span class="input-group-text">
<i class="fa fa-user"></i>
</span>
<input type="text" name="username" class="form-control" placeholder="Enter Username" required>
</div>

<input type="submit" value="Continue" class="btn btn-reset">

</form>

</div>

</body>
</html>