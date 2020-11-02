<%@include file="head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>


        <div class="row">
            <%@include file="mainmenu.jsp" %>

        </div>


        <div class="row">
            <div class="mainview" >
                <br>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6" style="color: #449D44">

                        <form action="" method="POST" class="form-horizontal">
                            <table >
                                <tr >
                                    <td ><label >PS Name : </label></td>
                                    <td ><input id="PSName" name="PSName" type="text" class="form-control" style="margin-left: 15px;margin-right: 15px"></td>
                                    <td><input type="submit" class="btn btn-success" value="Search" style="width: 100px"></td>

                                </tr>
                            </table>
                        </form>

                    </div>
                    <div class="col-md-3"></div>
                </div>
                <br>

                <script>
                    $(document).ready(function () {


                        $("#PSName").keyup(function () {
                            var PSName = $("#PSName").val();
                            if (PSName.length > 2)
                            {
                                $("#viewDiv").slideDown(500);
                                $.ajax({
                                    type: "GET",
                                    url: "ajaxSearchPS",
                                    data: {PSName: PSName}

                                });
                                setTimeout(function () {
                                    alert("Error occured...");
                                }, 1000);

//                                 $("#viewDiv").load(location.href+" #viewDiv>*","");
                            } else
                                $("#viewDiv").slideUp(500);
                        });
                        $("#viewDiv").load(location.href+" #viewDiv>*","");
                        //$("#viewDiv").load("tablePS.jsp");
                    });
                </script>

                <div class="row" id="viewDiv">
                    sadsafsafafa
                    <%@include file="tablePS.jsp" %>
                </div>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    

</body>




</html>
