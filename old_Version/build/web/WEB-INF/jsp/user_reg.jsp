<%@ include file = "head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>

        <div class="row">
            <div class="mainview" >
                <div class="panel panel-default">
                    
                    <div class="panel-body" style="color: #449D44;background-color: #262626">
                        <h1 style="text-align: center">User Registration</h1>
                        <form class="form-horizontal" role="form" ModelAttribute="PUser" action="insert_user" method="POST">
                            <div class="form-group">
                              
                              <div class="col-md-8" >
                                  <div class="inp" style="margin-left: 150px">
                                  <label class="col-md-2 control-label">Name</label>
                                  <input class="form-control" id="focusedInput" type="text" name="name" required ><br>
                                  
                                  <label class="col-md-2 control-label">Email</label>
                                  <input class="form-control" id="focusedInput" type="email" name="email" required ><br>
                                  
                                  <label class="col-md-2 control-label">Password</label>
                                  <input class="form-control" id="focusedInput" type="password" name="password" required="8"><br>
                                  
                                  <label class="col-md-2 control-label">District</label>
                                  <input class="form-control" id="focusedInput" type="text" name="district" required ><br>
                                  
                                  <label class="col-md-2 control-label">Address</label>
                                  <input class="form-control" id="focusedInput" type="text" name="address"  ><br>
                                  
                                  <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" name="reg" value="Register"/>
                                  </div>
                                  
                              </div>
                            </div>
                        </form>
                    </div>
                </div>
                
                
                
                
            </div>
        </div>
        
<%@include file="footer.jsp" %>
    </div>    


<%@include file="js.jsp" %>
</body>




</html>
