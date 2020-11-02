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
                <form class="form-horizontal"  role="form" modelAttribute="CriminalDocument" action="ps_upCriminalDoc" method="POST" enctype="multipart/form-data">
                    <div class="inp" style="margin-left: 150px">
                        <label class="col-md-2 control-label">Criminal ID</label>
                        <input class="form-control" id="focusedInput" type="number" name="criminalId" readonly value="${criminal_id}"><br>

                        <label class="col-md-2 control-label">File name</label>
                        <input class="form-control" id="focusedInput" type="text" name="name" required ><br>

                        <label class="col-md-2 control-label">Choose file :</label>
                        <input class="form-control" id="focusedInput" type="file" name="file" required>

                        <label class="col-md-2 control-label">File type</label>
                        <select class="form-control" id="focusedInput" name="type" required >
                            <option value="">Select</option>
                            <option value="Image">Image</option>
                            <option value="Documents">Documents</option>
                        </select>
                        <br>
                        <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit"  value="Upload"/>
                    </div>

                </form>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    


    <%@include file="js.jsp" %>
</body>




</html>
