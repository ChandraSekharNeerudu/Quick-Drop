<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Packge Add | Success Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    
    <style>
        .success-icon {
            font-size: 80px;
            color: #28a745;
            animation: scaleUp 0.5s ease-in-out;
        }
        @keyframes scaleUp {
            0% { transform: scale(0); }
            100% { transform: scale(1); }
        }
    </style>
</head>
<body class="bg-light">

    <div class="container mt-5 pt-5">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center">
                <div class="card shadow-lg border-0 p-5">
                    <div class="card-body">
                        <div class="mb-4">
                            <i class="fas fa-check-circle success-icon"></i>
                        </div>
                        
                        <h2 class="fw-bold text-dark">Shipment Created!</h2>
                        <p class="text-muted fs-5">
                            Your package has been successfully added to our system. 
                            An agent will be assigned to your  pick-up shortly.
                        </p>
                        
                        <div class="mt-4">
                            <i class="fas fa-truck-loading fa-spin text-primary me-2"></i>
                            <span class="text-secondary">Redirecting to Dashboard in <span id="timer">10</span> seconds...</span>
                        </div>

                        <div class="d-grid gap-2 mt-4">
                            <a href="Customer_home.jsp" class="btn btn-primary btn-lg">
                                <i class="fas fa-home me-2"></i> Go to Dashboard Now
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        let timeLeft = 10;
        let timerElement = document.getElementById('timer');
        
        setInterval(() => {
            timeLeft--;
            if(timeLeft >= 0) {
                timerElement.innerText = timeLeft;
            }
            if(timeLeft === 0) {
                window.location.href = "Customer_home.jsp";
            }
        }, 1000);
    </script>

</body>
</html>