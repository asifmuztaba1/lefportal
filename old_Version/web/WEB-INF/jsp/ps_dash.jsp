<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>

        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>

        </div>

        <div class="row">
            <div class="mainview" >
                <br>
                <h2 style="text-align: center">Police <%= user.getPsName() %></h2>
                <h4 style="text-align: center">District :<%= user.getDistrict()%></h4>
                <h4 style="text-align: center">Division :<%= user.getDivision() %></h4>  


                <h4 style="text-align: center">Role :<%= user.getRole() %></h4>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    


    <%@include file="js.jsp" %>
</body>




</html>
