<%@include file="head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="header.jsp" %>


        <div class="row">
            <%@include file="mainmenu.jsp" %>

        </div>


        <div class="row">
            <div class="mainview" >

                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-body" style="color: #122B40;background-color: #F0F0F0;text-align: center">
                                <h3>Case Summary</h3>
                                <hr style="display: block;border-top: 1px solid #449D44;height: 1px;">
                                <form class="form-horizontal" modelAttribute="CaseRecord" action="newCase" method="POST">
                                    <label class="col-md-3 control-label">Case type</label>
                                    <select class="form-control" id="focusedInput" style="width: 350px;" name="caseType" required >
                                        <option value="">Select</option>
                                        <option value="Murder">Murder</option>
                                        <option value="Attemp to murder">Attemp to Murder</option>
                                        <option value="Robbery">Robbery</option>
                                        <option value="Missing">Missing</option>
                                        <option value="Accident">Accident</option>
                                        <option value="Kidnap">Kidnap</option>
                                        <option value="Arms act">Arms act</option>
                                        <option value="Drugs">Drugs</option>
                                        <option value="Thievery">Thievery</option>
                                        <option value="Smuggling">Smuggling</option>
                                        <option value="UnIdentified body">UnIdentified body</option>

                                    </select><br>
                                    <label class="col-md-3 control-label">Victim name</label>
                                    <input class="form-control" id="focusedInput" type="text" name="victimName" required ><br>

                                    <label class="col-md-3 control-label">Victim age</label>
                                    <input class="form-control" id="focusedInput" type="text" name="victimAge" required ><br>

                                    <label class="col-md-3 control-label">Crime date</label>
                                    <input class="form-control" id="focusedInput" type="date" name="crimeDate" required ><br>

                                    <label class="col-md-3 control-label">Case File date</label>
                                    <input class="form-control" id="focusedInput" type="date" name="caseFileDate" required ><br>

                                    <label class="col-md-3 control-label">Investigating Officer</label>
                                    <input class="form-control" id="focusedInput" type="text" name="officer" ><br>
                                    
                                    <input type="submit" style="width: 200px;" value="Insert" class="btn btn-success">
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3"></div>

                </div>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>    

</body>


</html>
