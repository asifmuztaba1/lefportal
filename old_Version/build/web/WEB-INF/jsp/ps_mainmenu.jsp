
<div class="mainmenu" >

    <div class="container-fluid">	
        <nav class="navbar navbar-inverse">
            
            <div class="col-md-12">
                <ul class="nav navbar-nav" style="font-size: 12px">
                    <li><a href="ps_dash" ><p><b>Home</b></p></a></li>
                    <li><a href="ps_newcase" ><p><b>New Case </b></p></a></li>
                    <li><a href="ps_documents?district=<%= user.getDistrict() %>" ><p><b>Documents </b></p></a></li>
                    <li ><a href="ps_notification?district=<%= user.getDistrict() %>&division=<%= user.getDivision() %>&ps=<%= user.getPsName() %>" ><p style="display: inline-block;vertical-align: top;"><b style='color: red'></b><b> Notification </b></p></a></li>
                    <li><a href="ps_makeNotification" ><p><b>Request Assistance</b></p></a></li>
                    <li><a href="ps_searchMissing" ><p><b>Search Missing Case</b></p></a></li>
                    <li><a href="ps_searchAccident" ><p><b>Search Accident Case</b></p></a></li>
                    <li><a href="ps_searchCriminal" ><p><b>Search Criminal</b></p></a></li>
                    <li><a href="ps_documents?district=<%= user.getDistrict() %>" ><p><b>Case List</b></p></a></li>
                    <li><a href="ps_criminalDoc" ><p><b>Criminal Documents</b></p></a></li>
                </ul>
        </nav>
    </div>

</div>