<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Agent Registration</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
body {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: Segoe UI;
	background: linear-gradient(135deg, #000000, #ff7a00);
}

/* Card */
.register-card {
	background: #f8f9fa;
	padding: 35px;
	border-radius: 12px;
	width: 560px;
	box-shadow: 0 12px 30px rgba(0, 0, 0, 0.4);
}

/* Heading */
.register-card h2 {
	text-align: center;
	margin-bottom: 25px;
	font-weight: 600;
}

/* Inputs */
.form-control {
	height: 42px;
	border-radius: 6px;
}

/* Icons */
.input-group-text {
	background: #ffffff;
	color: #ff7a00;
	border-right: 0;
}

.form-control {
	border-left: 0;
}

/* Focus effect */
.form-control:focus {
	border-color: #ff7a00;
	box-shadow: 0 0 6px rgba(255, 122, 0, 0.5);
}

/* Button */
.btn-register {
	background: #ff7a00;
	color: white;
	width: 100%;
	height: 42px;
	border: none;
	border-radius: 6px;
	font-size: 16px;
	font-weight: 600;
	transition: 0.3s;
}

.btn-register:hover {
	background: #e56d00;
	transform: scale(1.02);
}

/* Login link */
.login-link {
	text-align: center;
	margin-top: 15px;
}

.login-link a {
	color: #ff7a00;
	font-weight: 600;
	text-decoration: none;
}

.login-link a:hover {
	text-decoration: underline;
}
</style>
</head>

<body>

	<div class="register-card">

		<h2>Agent Registration</h2>

		<form id="register" method="post" action="Agent_Register_Controller">

			<div class="row mb-3">

				<div class="col-md-6">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fa fa-user"></i></span>
						</div>
						<input type="text" name="agentname" class="form-control"
							placeholder="Agent Name" required>
					</div>
				</div>

				<div class="col-md-6">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fa fa-phone"></i></span>
						</div>
						<input type="text" id="mobileNo" name="mobile" 
						class="form-control" placeholder="00000-00000" required>
						<h6 id="mobile-span"></h6>
					</div>
				</div>

			</div>

			<div class="row mb-3">

				<div class="col-md-6">
					<div class="input-group">
						<span class="input-group-text"><i
							class="fa fa-location-dot"></i></span> <input type="text" name="address"
							class="form-control" placeholder="Address" required>
					</div>
				</div>

				<div class="col-md-6">
					<div class="input-group">
						<span class="input-group-text"><i class="fa fa-envelope"></i></span>
						<input type="text" id="mail" name="e-mail" class="form-control"
							placeholder="ramu12@gmail.com" required>
					    <h6 id="email-span"></h6>
					</div>
				</div>

			</div>

			<div class="row mb-3">

				<div class="col-md-6">
					<div class="input-group">
						<span class="input-group-text"><i class="fa fa-truck"></i></span>
						<input type="text" name="vehicletype" class="form-control"
							placeholder="Ex: Bike,Car,Van...etc" required>
					</div>
				</div>

				<div class="col-md-6">
					<div class="input-group">
						<span class="input-group-text"><i class="fa fa-car"></i></span> <input
							type="text" name="vehicleno" class="form-control"
							placeholder="Vehicle Number" required>
					</div>
				</div>

			</div>

			<h6 class="mb-3">Credential Details</h6>

			<div class="mb-3">
				<div class="input-group">
					<span class="input-group-text"><i class="fa fa-user-circle"></i></span>
					<input type="text" name="username" class="form-control"
						placeholder="Username" required>
				</div>
			</div>

			<div class="row mb-3">

				<div class="col-md-6">
					<div class="input-group">
						<span class="input-group-text"><i class="fa fa-lock"></i></span> <input
							type="password" id="password" name="password"
							class="form-control" placeholder="Password" required>
					</div>
				</div>

				<div class="col-md-6">
					<div class="input-group">
						<span class="input-group-text"><i class="fa fa-key"></i></span> <input
							type="password" id="confirm-password" name="re-password"
							class="form-control" placeholder="Re-enter Password" required>
					</div>
				</div>

			</div>
			
			<div class="row mb-3">
				<div class="col-md-6">
					<h6 id="pwd1-span"></h6>
				</div>
				<div class="col-md-6">
					<h6 id="pwd2-span"></h6>
				</div>
			</div>

			<button type="submit" class="btn-register">Register</button>

			<div class="login-link">
				Already Registered? <a href="./login.jsp">Login here</a>
			</div>

		</form>

	</div>
	<script src="${pageContext.request.contextPath}/assets/js/FormValidation.js"></script>
</body>
</html>