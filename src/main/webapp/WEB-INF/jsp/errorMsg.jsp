<%@ include file = "head.jsp" %>

<body>
    <meta http-equiv="refresh" content="0.1;URL='index'" />    
    <div class="container-fluid">
        <%@include file="header.jsp" %>

        <div class="row">
            <div class="mainview" >
                <script>
                    setTimeout(function () {
                       alert("Error occured...");
                    }, 100);
                    
                </script>
                      
            </div>
        </div>
        
<%@include file="footer.jsp" %>
    </div>    
</body>

</html>
