<%@include file="ahq_head.jsp" %>

<body>
    <div class="container-fluid">
        <%@include file="ahq_header.jsp" %>


        <div class="row">
            <%@include file="ahq_mainmenu.jsp" %>

        </div>


        <div class="row">
            <div class="mainview" >
                <form class="form-horizontal" modelAttribute="ahqSearch" role="form" action="ahq_viewAll" method="POST">
                    <div class="form-group">

                        <div class="col-md-8" >
                            <div class="inp" style="margin-left: 150px">
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


                                <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" name="search" value="Search"/>
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
