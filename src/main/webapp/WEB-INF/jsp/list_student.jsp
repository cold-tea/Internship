<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param['add'] eq 'success'}">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Success!</strong> Record successfully added.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<c:if test="${param['remove'] eq 'success'}">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Success!</strong> Record successfully removed.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<c:if test="${param['add_enroll'] eq 'success'}">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Success!</strong> Enrollment information updated.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<c:if test="${param['remove'] eq 'fail'}">
	<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  <strong>Error!</strong> This student has installment information. Cant delete the record.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<c:if test="${param['update'] eq 'success'}">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Success!</strong> Record successfully updated.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<c:if test="${param['update'] eq 'fail'}">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  <strong>Warning!</strong> Record failed to be updated.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<h2>Student Information</h2>
<hr />
<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> List of all Students
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Serial</th>
						<th>Full Name</th>
						<th>Gender</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="count" items="${students }" var="student">
						<tr>
							<td>${count.index+1 }</td>
							<td>${student.fName } ${student.lName }</td>
							<td style="text-transform: capitalize">${student.gender }</td>
							<td align="center">
								<%-- <a href="${root }/student/remove/${student.id}" class="btn btn-xl btn btn-outline-danger">
								<i class="fa fa-trash" aria-hidden="true"></i></a> --%>
								<a href="${root }/student/update/${student.id}" class="btn btn-xl btn btn-outline-primary">
								<i class="fa fa-pencil" aria-hidden="true"></i></a>
								<a href="${root }/course/enroll/add/${student.id}" class="btn btn-xl btn btn-outline-success">
								<i class="fa fa-plus" aria-hidden="true"></i></a>
								<a href="${root }/student/view/${student.id}" class="btn btn-xl btn btn-outline-info">
								<i class="fa fa-eye aria-hidden="true"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
