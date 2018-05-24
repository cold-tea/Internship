<c:if test="${update eq 'fail'}">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  <strong>Warning!</strong> Validation failed.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<h2>Update Student</h2>
<hr />
<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-id-card" aria-hidden="true"></i> Fill up the Fields
	</div>
	<div class="card-body">
		<form:form role="form" modelAttribute="student" method="post"
			action="${root }/student/update">
			<div class="form-group">
					<label for="fName"><spring:message code="firstName" /></label>
					<form:input pattern="^[a-zA-Z ]*$" required="true" path="fName" class="form-control" id="fName"
						title="This field can only contain text." placeholder="Enter First Name" />
					<form:errors path="fName" cssClass="txt-error" />
				</div>
				<div class="form-group">
					<label for="lName"><spring:message code="lastName" /></label>
					<form:input pattern="^[a-zA-Z ]*$" required="true" path="lName" class="form-control" id="lName"
						title="This field can only contain text." placeholder="Enter Last Name" />
					<form:errors path="lName" cssClass="txt-error" />
				</div>
				<label><spring:message code="gender" /></label>
				<br />
				<div class="form-check form-check-inline">
					<label class="form-check-label"> <form:radiobutton
							class="form-check-input" path="gender" value="male" /> <spring:message
							code="male" />
					</label>
				</div>
				<div class="form-check form-check-inline">
					<label class="form-check-label"> <form:radiobutton
							class="form-check-input" path="gender" value="female" /> <spring:message
							code="female" />
					</label>
				</div>
				<br />
				<form:errors path="gender" cssClass="txt-error" />
				<button type="submit" class="btn btn-primary">
					<form:hidden path="id" />
					<spring:message code="submit" />
				</button>
		</form:form>
	</div>
</div>