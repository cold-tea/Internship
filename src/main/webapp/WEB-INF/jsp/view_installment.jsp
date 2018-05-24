<h2>Installment Detail</h2>
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
		</div>
		</c:forEach>
	</div>
</div>