<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>

        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>

        </div>

        <div class="row">
            <div class="mainview" >
               
                <form class="form-horizontal" role="form" action="ps_searchMissing" method="POST">
                            <div class="form-group">
                              
                              <div class="col-md-8" >
                                  <div class="inp" style="margin-left: 150px">
                                  <label class="col-md-2 control-label">Age</label>
                                  <input class="form-control" id="focusedInput" type="number" name="ageStart" required ><br>
                                  
                                  <label class="col-md-2 control-label">to</label>
                                  <input class="form-control" id="focusedInput" type="number" name="ageEnd" required><br>

                                  <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" name="reg" value="Search"/>
                                  </div>
                                  
                              </div>
                            </div>
                        </form>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    


    <%@include file="js.jsp" %>
</body>




</html>
