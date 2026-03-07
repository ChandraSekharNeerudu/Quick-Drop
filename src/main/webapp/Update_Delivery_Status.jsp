<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update | Delivery Status</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        body { background-color: #f8f9fa; padding-top: 50px; }
        .card { border-radius: 15px; }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card shadow-lg border-0">
                    <div class="card-header bg-warning p-4 text-center">
                        <h3 class="mb-0 fw-bold"><i class="fas fa-sync-alt me-2"></i>Update Shipment</h3>
                    </div>
                    <div class="card-body p-4">
                        <form action="UpdateDeliveryStatusController" method="post">
                            <input type="hidden" name="pid" value="<%= request.getParameter("pid") %>">
                            <input type="hidden" name="aid" value="<%=session.getAttribute("agentTableId") %>">
                            
                            <div class="mb-4">
                                <label class="form-label fw-bold">Package ID</label>
                                <input type="text" class="form-control bg-light" value="#<%= request.getParameter("pid") %>" readonly>
                            </div>

                            <div class="mb-4">
                                <label class="form-label fw-bold">Select New Status</label>
                                <select name="status" class="form-select form-select-lg border-primary" required>
                                    <option value="" disabled selected>-- Choose Status --</option>
                                    <option value="In_Transport">In Transport <i class="fas fa-truck"></i></option>
                                    <option value="Delivered">Delivered <i class="fas fa-check-circle"></i></option>
                                    <option value="Cancelled">Cancelled <i class="fas fa-times-circle"></i></option>
                                    <option value="Pending" class="text-danger fw-bold">Return to Pool (Quit Delivery) <i class="fas fa-undo"></i></button>
                                </select>
                            </div>

                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-primary btn-lg fw-bold shadow-sm">
                                    <i class="fas fa-save me-2"></i> Confirm Update
                                </button>
                                <a href="Agent_home.jsp" class="btn btn-outline-secondary">Back to Dashboard</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>