<h2>Student Detail</h2>
<hr />
<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-eye"></i> View
	</div>
	<div class="card-body">
		<h4>${student.fName } ${student.lName }</h4>
		<hr />
		<h5>Gender: ${student.gender }</h5><br />
		<h5>Courses:</h5> <br />
		<c:forEach items="${student.stuCourses }" var="course">
		
		<div style="margin-left: 40px; margin-right: 10px; float: left; width: 18rem;" class="card border-dark mb-3">
		  <div class="card-header">Course</div>
		  <div class="card-body text-dark">
		    <h4 class="card-title">${course.name }</h4>
		    <p class="card-text">Price: ${course.price }</p>
		    <p class="card-text">Applicable Price: ${course.applicablePrice }</p>
		  </div>
		  <div class="card-footer text-dark">
		  	<button style="float: right;"  sid="${student.id }" cid="${course.id }"  type="button" 
				class="btn btn-outline-warning btn-sm" data-toggle="modal" data-target="#addInstallment">
			  <i class="fa fa-money" aria-hidden="true"></i>
			</button>
		  </div>
		</div>
		</c:forEach>
	</div>
</div>



<!-- Modal -->
<div class="modal fade" id="addInstallment" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Installment</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form role="form" method="post" action="${root }/installment/add">
        	<div class="form-group">
			    <label for="installment_amount">Installment Amount</label>
			    <input type="number" min="100" value="0" max="50000" name="installmentAmount" 
			    	class="form-control" id="installment_amount">
			 </div>
			 <input type="hidden" id="hidden_sid" name="sid"/>
			 <input type="hidden" id="hidden_cid" name="cid"/>
        	 <input type="submit" style="float: right;" class="btn btn-success" value="Save"/>
        </form>
      </div>
    </div>
  </div>
</div>