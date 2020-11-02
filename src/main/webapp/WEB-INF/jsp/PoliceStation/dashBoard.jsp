<%@include file="head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>
        
        
        <div class="row">
            <%@include file="mainmenu.jsp" %>
            
        </div>
        
        
        <div class="row">
            <div class="mainview" >
              <br>
              <h2 style="text-align: center"> <%= user.getPsName() %> Police Station</h2>
        <h4 style="text-align: center">District :<%= user.getDistrict() %></h4>
<h4 style="text-align: center">Division :<%= user.getDivision() %></h4>  

 
 <h4 style="text-align: center">Role :<%= user.getRole() %></h4>
 
  
            </div>
        </div>
        
<%@include file="footer.jsp" %>
    </div>    

</body>




</html>
