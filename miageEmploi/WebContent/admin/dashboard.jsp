<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/head.jsp" />
<jsp:include page="include/nav.jsp" />

	<div class="wrapper">
       <div class="container-fluid">
			<div class="row">
            	<div class="col-12">
                    <div class="page-title-box col-12" style="padding-bottom: 50px">
                        <div class="float-right col-offset-7 col-5">
                        	<select class="select2-jour">
                        		<option value="-1">Selectionner</option>
                        		<c:out value="${select}" escapeXml="false"/>  
                            </select>
                        </div>
                    </div>
                	<div class="card-box">
                		<h3 class="m-t-0 header-title">Emploi du temps</h3>
						<div class="table-responsive">
                            <table class="table table-striped table-bordered text-center" style="width:100%">
                                <thead>
                                    <tr>
                                        <th style="width: 10%">Jour</th>
                                        <th style="width: 15%">08:30 -- 10:15</th>
                                        <th style="width: 15%">10:30 -- 11:45</th>
                                        <th style="width: 15%;">12:00 -- 13:30</th>
                                        <th style="width: 15%">14:15 -- 15:45</th>
                                        <th style="width: 15%">16:00 -- 17:30</th>
                                    </tr>
                                </thead>
                                <tbody id="emploi">
                                	
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>Jour</th>
                                        <th>08:30 -- 10:15</th>
                                        <th>10:30 -- 11:45</th>
                                        <th>12:00 -- 13:30</th>
                                        <th>14:15 -- 15:45</th>
                                        <th>16:00 -- 17:30</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                   </div>
               </div>
           </div>
       </div> <!-- end container -->
   </div>
   <!-- end wrapper -->

<jsp:include page="include/footer.jsp" />
<jsp:include page="include/script.jsp" />
<script>
	$(document).ready(function() {
		$(".select2-jour").select2();
		$( ".select2-jour" ).change(function() {
			$.ajax({
	        	url     : 'afficher-emploi.html',
	        	method  : 'POST',
	        	data    : {id : $(".select2-jour").val()},
	        	success : function(resultText){
                    $("#emploi").html(resultText);
	        	},
	        	error : function(jqXHR, exception){
	        		console.log('Error occured!!');
	        	}
        	});
        });
	} );
</script>
<jsp:include page="include/fin.jsp" />