<%@ include file = "head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>

        <div class="row">
            <div class="mainview" >
                <div class="panel panel-default">

                    <div class="panel-body" style="color: #449D44;background-color: #F0F0F0">
                        <script>
                            $(document).ready(function () {

                                setTimeout(function () {
                                    $("#loginMsg").slideUp(1000);
                                }, 10000);
                            });
                        </script>
                        
                        <form class="form-horizontal" role="form" action="login" method="POST">
                            <div class="form-group">
                                <div class="col-md-2"></div>
                                <div class="col-md-8" style="margin: 100px auto">
                                    
                                    <h1 style="text-align: center">Login Here</h1>
                                    <p id="loginMsg" style="color: #e38d13;text-align: center">${loginMsg}</p>
                                    
                                    <div class="inp" style="margin-left: 150px;">

                                        <label class="col-md-2 control-label">Email</label>
                                        <input class="form-control"  type="text" name="email" required ><br>

                                        <label class="col-md-2 control-label">Password</label>
                                        <input class="form-control"  type="password" name="password" required><br>

                                        <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" name="reg" value="Login"/>
                                    </div>

                                </div>
                                <div class="col-md-2"></div>
                            </div>
                        </form>


                    </div>
                </div>

            </div>

            <%@include file="footer.jsp" %>
        </div>    



</body>




</html>
