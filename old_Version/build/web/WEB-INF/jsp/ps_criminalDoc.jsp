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
                <form class="form-horizontal" role="form" action="ps_criminalDoc" method="POST">
                    <div class="inp" style="margin-left: 150px">
                        <label class="col-md-2 control-label">Criminal ID</label>
                        <input class="form-control" id="focusedInput" type="number" name="criminal_id" required ><br>

                        <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit"  value="Search"/>
                    </div>

                </form>

                <h1>Criminal Information</h1>
                <table class="table">
                    <tr>
                        <th>Criminal ID</th>
                        <th>Father</th>
                        <th>Contact</th>
                        <th>Address</th>
                        <th>District</th>
                        <th>Division</th>
                        <th>Action</th>
                    </tr>
                    
                        <tr>
                            
                            <td>${criminal_info.id}</td>
                            <td>${criminal_info.father}</td>
                            <td>${criminal_info.contact}</td>
                            <td>${criminal_info.address}</td>
                            <td>${criminal_info.district}</td>
                            <td>${criminal_info.division}</td>
                            <td>
                                <a href="ps_upCriminalDoc?id=${criminal_info.id}"><input class="btn btn-success" style="width: 100px;" type="submit"  value="Upload Documents"/></a>
                            </td>
                        </tr>
                
                </table>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    


    <%@include file="js.jsp" %>
</body>




</html>
