<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>
        
        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>
            
        </div>

        <div class="row">
            <div class="mainview" >
                           <h1>Upload Documents</h1><br>
                           <form class="form-horizontal" role="form" modelAttribute="Document" action="ps_upDocuments" method="POST" enctype="multipart/form-data">
                            <div class="form-group">
                              
                              <div class="col-md-8" >
                                  <div class="inp" style="margin-left: 150px">
                                  <label class="col-md-2 control-label">Case ID :</label>
                                  <input class="form-control" id="focusedInput" type="text" name="caseId" value="${case_id}" readonly ><br>
                                  
                                  <label class="col-md-2 control-label">File Name :</label>
                                  <input class="form-control" id="focusedInput" type="text" name="name" required><br>
                                  
                                  <label class="col-md-2 control-label">Choose file :</label>
                                  <input class="form-control" id="focusedInput" type="file" name="file" required>
                                  
                                  <label class="col-md-2 control-label">File Type :</label>
                                  <select class="form-control" id="focusedInput" name="type" required >
                                      <option value="">Select</option>
                                      <option value="Image">Image</option>
                                      <option value="Documents">Documents</option>
                                  </select>
                                  <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" value="Upload"/>
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
