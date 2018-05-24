<c:if test="${add eq 'fail'}">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  <strong>Warning!</strong> Failed while adding Student.
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>

<h2>Add Student</h2>
<hr />
<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-id-card" aria-hidden="true"></i> Fill up the Fields
	</div>
	<div class="card-body">
		<form:form role="form" modelAttribute="student" method="post"
			action="${root }/student/add">
			<div class="form-group">
				<label for="fName"><spring:message code="firstName" /></label>
				<form:input pattern="^[a-zA-Z ]*$" required="true" path="fName" class="form-control"
					title="This field can only contain text." id="fName" placeholder="Enter First Name" />
				<form:errors path="fName" cssClass="txt-error" />
			</div>
			<div class="form-group">
				<label for="lName"><spring:message code="lastName" /></label>
				<form:input pattern="^[a-zA-Z ]*$" required="true" path="lName" class="form-control"
					title="This field can only contain text." id="lName" placeholder="Enter Last Name" />
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
			<div class="form-group">
				<label for="course"><spring:message code="courses" /></label>
				<form:select required="true" itemLabel="name" itemValue="id"
					path="course" multiple="false" items="${courses }" id="course"
					class="form-control"/>
				<form:errors path="course" cssClass="txt-error" />
			</div>
			<div class="form-group">
				<label for="applicable_amount">Applicable Amount</label>
				<form:input min="500" max="50000" type="number" required="true" path="applicableAmount" class="form-control"
					id="applicable_amount" placeholder="Enter Applicable Amount" />
				<form:errors path="applicableAmount" cssClass="txt-error" />
			</div>
			<div class="form-group">
				<label for="installment_amount">Installment Amount</label>
				<form:input value="0" max="50000" type="number" path="installmentAmount" class="form-control"
					id="installment_amount" placeholder="Enter Installment Amount" />
				<form:errors path="installmentAmount" cssClass="txt-error" />
			</div>
			<button style="float: clear;" type="submit"
				class="btn btn btn-primary">
				<spring:message code="submit" />
			</button>
		</form:form>
	</div>
</div>
