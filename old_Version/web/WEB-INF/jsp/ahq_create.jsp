<%@include file="ahq_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ahq_header.jsp" %>


        <div class="row">
            <%@include file="ahq_mainmenu.jsp" %>

        </div>


        <div class="row">
            <div class="mainview" >
                <form class="form-horizontal" modelAttribute="PsUser" role="form" action="ahq_insert" method="POST">
                    <div class="form-group">

                        <div class="col-md-8" >
                            <div class="inp" style="margin-left: 150px">
                                
                                <label class="col-md-2 control-label">Division</label>
                                <select class="form-control" id="focusedInput" name="division" required >
                                    <option value="">Select</option>
                                    <option value="Barishal">Barishal</option>
                                    <option value="Chittagong">Chittagong</option>
                                    <option value="Chittagong">Dhaka</option>
                                    <option value="Chittagong">Chittagong</option>
                                    <option value="Mymensingh">Mymensingh</option>
                                    <option value="Khulna">Khulna</option>
                                    <option value="Rajshahi">Rajshahi</option>
                                    <option value="Rangpur">Rangpur</option>
                                    <option value="All">All</option>
                                </select>
                                
                                
                                <label class="col-md-2 control-label">District</label>
                                <select class="form-control" id="focusedInput" name="district" required >
                                    <option value="">Select</option>
                                    <option value="b.baria">b.baria</option>
                                    <option value="bagerhat">bagerhat</option>
                                    <option value="bandarban">bandarban</option>
                                    <option value="barguna">barguna</option>
                                    <option value="barisal">barisal</option>
                                    <option value="bhola">bhola</option>
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
                                    <option value="kushtia">kushtia</option>
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
                                    <option value="all">All</option>
                                </select>

                                <label class="col-md-2 control-label">Role</label>
                                <select class="form-control" id="focusedInput" name="role" required >
                                    <option value="">Select</option>
                                    <option value="Admin">Admin</option>
                                    <option value="police_station">Police Station</option>
                                </select><br>
                                
                                
                                <label class="col-md-2 control-label">Police Station name</label><br>
                                <input class="form-control" id="focusedInput" type="text" name="psName" required><br><br>
                                
                                <label class="col-md-2 control-label">Username</label>
                                <input class="form-control" id="focusedInput" type="text" name="username" required><br>
                                
                                
                                <label class="col-md-2 control-label">Password</label>
                                <input class="form-control" id="focusedInput" type="password" name="password" required><br>

                                <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" name="reg" value="Add"/>
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
