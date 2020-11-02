<%@ include file = "head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>

        <div class="row">
            <div class="mainview" >
                <div class="panel panel-default">
                    
                    <div class="panel-body" style="color: #449D44;background-color: #262626">
                        <h1 style="text-align: center">Login Here</h1>
                       
                        
                        <form class="form-horizontal" modelAttribute="PUser" role="form" action="login" method="POST">
                            <div class="form-group">
                              
                              <div class="col-md-8" >
                                  <div class="inp" style="margin-left: 150px">
                                  <label class="col-md-2 control-label">Email</label>
                                  <input class="form-control" id="focusedInput" type="text" name="email" required ><br>
                                  
                                  <label class="col-md-2 control-label">Password</label>
                                  <input class="form-control" id="focusedInput" type="password" name="password" required="8"><br>

                                  <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" name="reg" value="Login"/>
                                  </div>
                                  
                              </div>
                            </div>
                        </form>
                        
                        
                    </div>
                </div>
        
        </div>
        
<%@include file="footer.jsp" %>
    </div>    


<%@include file="js.jsp" %>
</body>




</html>
