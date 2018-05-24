<h2>Update Course</h2>
<hr />
<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-id-card" aria-hidden="true"></i> Fill up the Fields
	</div>
	<div class="card-body">
		<form:form role="form" modelAttribute="course" method="post"
			action="${root }/course/update">
			<div class="form-group">
				<label for="name">Name</label>
				<form:input pattern="^[a-zA-Z ]*$" required="true" path="name" class="form-control"
					title="This field can only contain text." id="name" placeholder="Enter Course Name" />
				<form:errors path="name" cssClass="txt-error" />
			</div>
			<div class="form-group">
				<label for="price">Completion Price</label>
				<form:input min="500" max="50000" type="number" required="true" path="price" class="form-control"
					id="price" placeholder="Course Completion Price" />
				<form:errors path="price" cssClass="txt-error" />
			</div>
			
			<div class="form-group">
				<label for="startTime">Start Time</label>
				<form:input type="time" required="true" path="startTime" class="form-control"
					id="startTime" placeholder="Enter Course Name" />
				<form:errors path="startTime" cssClass="txt-error" />
			</div>
			
			<div class="form-group">
				<label for="endTime">End Time</label>
				<form:input type="time" required="true" path="endTime" class="form-control"
					id="endTime" placeholder="Enter Course Name" />
				<form:errors path="endTime" cssClass="txt-error" />
			</div>
			<form:hidden path="id" />
			<button style="float: clear;" type="submit"
				class="btn btn btn-primary">
				Submit
			</button>
		</form:form>
	</div>
</div>
