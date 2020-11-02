<%@ include file = "ps_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ps_header.jsp" %>

        <div class="row">
            <%@include file="ps_mainmenu.jsp" %>

        </div>

        <div class="row">
            <div class="mainview" >

                <h1 style="text-align: center">Case Information</h1>
                <form class="form-horizontal" role="form" modelAttribute="Case" action="insert_case" method="POST">
                    <div class="form-group">

                        <div class="col-md-8" >
                            <div class="inp" style="margin-left: 150px">

                                <label class="col-md-2 control-label">Case Name</label>
                                <input class="form-control" id="focusedInput" type="text" name="caseName" required ><br>

                                <label class="col-md-2 control-label">Case type</label>
                                <select class="form-control" id="focusedInput" name="type" required >
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
                                
                                <label class="col-md-2 control-label">Victim name</label>
                                <input class="form-control" id="focusedInput" type="text" name="victim" required ><br>
                                
                                <label class="col-md-2 control-label">Victim age</label>
                                <input class="form-control" id="focusedInput" type="text" name="victimAge" required ><br>
                                
                                <label class="col-md-2 control-label">Crime date</label>
                                <input class="form-control" id="focusedInput" type="date" name="crimeDate" required ><br>
                                
                                <label class="col-md-2 control-label">Case date</label>
                                <input class="form-control" id="focusedInput" type="date" name="caseDate" required ><br>
                                
                                <label class="col-md-2 control-label">Investigating Officer</label>
                                <input class="form-control" id="focusedInput" type="text" name="officer" required ><br>
  
                                
                                <label class="col-md-2 control-label">District</label>
                                <select class="form-control" id="sel2" name="district" required>
                                    
                                    <option value="">Select</option>
                                    <option value="b.baria">b.baria</option>
                                    <option value="bagerhat">bagerhat</option>
                                    <option value="bandarban">bandarban</option>
                                    <option value="barguna">barguna</option>
                                    <option value="barisal">barisal</option>
                                    <option value="4">bhola</option>
                                    <option value="bhola">bogra</option>
                                    <option value="c. nawabganj">c. nawabganj</option>
                                    <option value="chandpur">chandpur</option>
                                    <option value="chittagong">chittagong</option>
                                    <option value="chuadanga">chuadanga</option>
                                    <option value="chuadanga">comilla</option>
                                    <option value="cox's bazar">cox's bazar</option>
                                    <option value="dhaka">dhaka</option>
                                    <option value="dinajpur">dinajpur</option>
                                    <option value="faridpur">faridpur</option>
                                    <option value="feni">feni</option>
                                    <option value="gaibandha">gaibandha</option>
                                    <option value="gazipur">gazipur</option>
                                    <option value="gopalganj">gopalganj</option>
                                    <option value="habiganj">habiganj</option>
                                    <option value="jamalpur">jamalpur</option>
                                    <option value="jessore">jessore</option>
                                    <option value="jhalokathi">jhalokathi</option>
                                    <option value="jhenaidah">jhenaidah</option>
                                    <option value="joypurhat">joypurhat</option>
                                    <option value="khagrachari">khagrachari</option>
                                    <option value="khulna">khulna</option>
                                    <option value="kishoreganj">kishoreganj</option>
                                    <option value="kurigram">kurigram</option>
                                    <option value="40">kushtia</option>
                                    <option value="kushtia">lalmonirhat</option>
                                    <option value="laxmipur">laxmipur</option>
                                    <option value="madaripur">madaripur</option>
                                    <option value="magura">magura</option>
                                    <option value="manikganj">manikganj</option>
                                    <option value="meherpur">meherpur</option>
                                    <option value="moulvibazar">moulvibazar</option>
                                    <option value="munshiganj">munshiganj</option>
                                    <option value="mymensingh">mymensingh</option>
                                    <option value="naogaon">naogaon</option>
                                    <option value="narail">narail</option>
                                    <option value="narayanganj">narayanganj</option>
                                    <option value="narshingdi">narshingdi</option>
                                    <option value="natore">natore</option>
                                    <option value="netrokona">netrokona</option>
                                    <option value="nilphamari">nilphamari</option>
                                    <option value="noakhali">noakhali</option>
                                    <option value="pabna">pabna</option>
                                    <option value="panchagarh">panchagarh</option>
                                    <option value="patuakhali">patuakhali</option>
                                    <option value="perojpur">perojpur</option>
                                    <option value="rajbari">rajbari</option>
                                    <option value="rajshahi">rajshahi</option>
                                    <option value="rangamati">rangamati</option>
                                    <option value="rangpur">rangpur</option>
                                    <option value="satkhira">satkhira</option>
                                    <option value="sirajganj">sirajganj</option>
                                    <option value="sirajganj">shariatpur</option>
                                    <option value="sherpur">sherpur</option>
                                    <option value="sunamganj">sunamganj</option>
                                    <option value="sylhet">sylhet</option>
                                    <option value="tangail">tangail</option>
                                    <option value="thakurgaon">thakurgaon</option>
                                </select>
                                
                                
                                <label class="col-md-2 control-label">Division</label>
                                <select class="form-control" id="sel1" name="division" required>
                                    <option value="">Select</option>
                                    <option value="Barishal">Barishal</option>
                                    <option value="Chittagong">Chittagong</option>
                                    <option value="Chittagong">Dhaka</option>
                                    <option value="Chittagong">Chittagong</option>
                                    <option value="Mymensingh">Mymensingh</option>
                                    <option value="Khulna">Khulna</option>
                                    <option value="Rajshahi">Rajshahi</option>
                                    <option value="Rangpur">Rangpur</option>
                                </select>
                                
                                <input class="form-control" id="focusedInput" type="text" name="policeStation" value="<%= user.getPsName() %>" required ><br>
                                
                                <br>
                                <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" value="Insert"/><br>
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
