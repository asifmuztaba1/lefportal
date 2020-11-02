<%@ include file = "head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>
        <meta http-equiv="refresh" content="0.1;URL='index' " />    
        <div class="row">
            <div class="mainview" >
                <script>
                    setTimeout(function () {
                        alert("Successfully done...");
                    }, 100);
                </script>
            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    
</body>

</html>
