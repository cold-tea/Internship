<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param['add'] eq 'success'}">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Success!</strong> Course successfully added.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<c:if test="${param['update'] eq 'success'}">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Success!</strong> Course successfully updated.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<c:if test="${param['remove'] eq 'success'}">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Success!</strong> Course successfully removed.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<c:if test="${param['update'] eq 'fail'}">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  <strong>Warning!</strong> Course cannot be updated.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<c:if test="${param['remove'] eq 'fail'}">
	<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  <strong>Error!</strong> Course is related with other data. Remove those first.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<h2>Course Information</h2>
<hr />
<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> List of all Courses
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Serial</th>
						<th>Course Name</th>
						<th>Completion Price</th>
						<th>Start Time</th>
						<th>End Time</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="count" items="${courses }" var="course">
						<tr>
							<td>${count.index+1 }</td>
							<td>${course.name }</td>
							<td>${course.price }</td>
							<td>${course.startTime }</td>
							<td>${course.endTime }</td>
							<td>
								<%-- <a href="${root }/course/remove/${course.id}" class="btn btn-xl btn btn-outline-danger">
								<i class="fa fa-trash" aria-hidden="true"></i></a> --%>
								<a href="${root }/course/update/${course.id}" class="btn btn-xl btn btn-outline-primary">
								<i class="fa fa-pencil" aria-hidden="true"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
