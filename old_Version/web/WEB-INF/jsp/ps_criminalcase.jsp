<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>
        
        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>
            
        </div>

        <div class="row">
            <div class="mainview" >
                <form class="form-horizontal" modelAttribute="Criminalcase" role="form" action="insert_criminalcase" method="POST">
                            <div class="form-group">
                              
                              <div class="col-md-8" >
                                  <div class="inp" style="margin-left: 150px">
                                  <label class="col-md-2 control-label">Case ID :</label>
                                  <input class="form-control" id="focusedInput" type="number" value="${case_id}" name="caseId" required ><br>
                                  
                                  <label class="col-md-2 control-label">Criminal ID :</label>
                                  <input class="form-control" id="focusedInput" type="number" value="${criminal_id}" name="criminalId" required><br>
                                  
                                  <label class="col-md-2 control-label">Case Status :</label>
                                  <input class="form-control" id="focusedInput" type="text" value="Running" name="status" required >
                                  
                                  
                                  <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" value="Confirm"/>
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
