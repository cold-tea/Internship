<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param['add'] eq 'success'}">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Success!</strong> Installment information added.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<h2>Installments</h2>
<hr />
<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> List of all installment made.
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Serial</th>
						<th>Student Name</th>
						<th>Course Name</th>
						<th>Original Price</th>
						<th>Applicable Price</th>
						<th>Total Installment</th>	
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="count" items="${installments }" var="installment">
						<tr>
							<td>${count.index+1 }</td>
							<td>${installment.student.fName } ${installment.student.lName }</td>
							<td>${installment.course.name }</td>
							<td>${installment.course.price }</td>
							<td>${installment.applicablePrice }</td>
							<td>${installment.totalInstallment }</td>
							<td align="center">
								<!-- <a href="#" class="btn btn-xl btn btn-outline-success">
								<i class="fa fa-plus" aria-hidden="true"></i></a> -->
								<button  sid="${installment.student.id }" cid="${installment.course.id }"  type="button" 
									class="btn btn-outline-success btn-xl" data-toggle="modal" data-target="#addInstallment">
								  <i class="fa fa-plus" aria-hidden="true"></i>
								</button>
								<a href="#" class="btn btn-xl btn btn-outline-info">
								<i class="fa fa-eye aria-hidden="true"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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
