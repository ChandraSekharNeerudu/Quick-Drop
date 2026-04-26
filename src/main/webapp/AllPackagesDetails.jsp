<!--<%@page import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.Model.Package" %>   
<!DOCTYPE html>
<html>
<head>
        <title>All Package | Details</title>
        <meta name="charset" content="UTF-8">
        <meta name="viewport" content=" width=device-width,initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="assets/css/header_footer.css">
    <style> 
        .hey{
            overflow:hidden;
        }
        body {
        padding-top: 75px; /* Standard height for a fixed navbar + small gap */
        }
        .home_icon{
        color:rgb(227, 8, 223);
        }
    </style>  
</head>
</head>
    <body>    
    <%@ include file="includes/navbar.jsp" %>

    <div >
            <header class="linear">
            <h1 class="text-center ">Hello <%= session.getAttribute("un")%>,  Welcome to the Quick-Drop...!!!</h1>
            </header>
    </div> 
    
   
    <div class="container-fluid  mt-5">
    <div class="row">
    <div class="col-12">
    <h4 class="text-center text-danger"><b>Packages Details Table</b></h4>
    <div class="card shadow-sm border-0 hey">
            <div class="card-header bg-secondary py-3">
                <h4 class="mb-0 text-dark fw-bold"><i class="fas fa-home me-2 home_icon"></i> All Packages list</h4>
            </div>
            <div class="card-body p-0">
                <div class="table-responsive">
                    <table class="table table-hover mb-0 align-middle">
                        <thead class="table-dark">
                        <tr>
                        <th >Package ID</th>
                        <th >Source</th>
                        <th >Destination</th>
                        <th >Reciever</th>
                        <th >Customer Id</th>
                        <th >Agent Id</th>
                        <th >Status</th>
                        <th >Shipped Date</th>
                        <th >Package Fee</th>
                        <th >Delivery Fee</th>
                        <!--<th class="text-success">Update</th>
                        <th class="text-danger">Delete </th>-->
                        </tr>
                        </thead>
                        <%List<Package> list=(List<Package>)session.getAttribute("packages");
                        
        		if(!list.isEmpty()){
        			for(Package obj:list){
        			%>
        			
        			<tbody class="table-secondary">
    <tr>
    <td><%=obj.getPkgId() %></td>
    <td><%=obj.getSource() %></td>
    <td><%=obj.getDestination() %></td>
    <td><%=obj.getReciever() %></td>
    <td><%=obj.getCustomerId() %></td>
    <td><%=obj.getAgentId() %></td>
    <td>
    <% 
        String status = obj.getStatus();
        String badgeClass = "bg-secondary"; // Default color

        if ("Delivered".equalsIgnoreCase(status)) {
            badgeClass = "bg-success";
        }else if ("Cancelled".equalsIgnoreCase(status)){
        	badgeClass = "bg-danger";
        }else if("Shipped".equalsIgnoreCase(status)){
        	badgeClass = "bg-warning text-dark";
        }else{
        	badgeClass = "bg-primary text-dark";
        }
    %>
    <span class="badge <%= badgeClass %>">
        <%= status %>
    </span>
</td>
    <td><%=obj.getDate() %></td>
    <td><%=obj.getPackageFee() %></td>
    <td><%=obj.getDeliveryFee() %></td>
    <!--<td ></td>
    <td></td>-->
    </tr>
    </tbody>
                <%}
                 }
        		else {
        		%>
        		<tr>
        		<td colspan="12" class="text-center py-5 text-muted">
        		<i class="fas fa-parachute-box fa-2x d-block mb-3"></i>
        		No Packages are there yet.
        		</td>
        		</tr>
        		<% } %>
        		</table>
        		</div>
            </div>
         </div>
    </div>
   </div>
   </div>
    
    
    
    
    
    
    <%@ include file="includes/footer.jsp" %> 
<body>

</body>
</html>