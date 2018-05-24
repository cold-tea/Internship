<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Add Enrollment</h2>
<hr />
<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-id-card" aria-hidden="true"></i> Fill up the Fields
	</div>
	<div class="card-body">
		<form:form role="form"  method="post"
			action="${root }/course/enroll/add">
			<div class="form-group">
			    <label for="applicable_price">Applicable Amount</label>
			    <input value="0" required min="500" max="50000" type="number" class="form-control" name="applicablePrice" id="applicable_price">
			</div>
			
			<div class="form-group">
			    <label for="installment_price">Installment Amount</label>
			    <input  value="0" max="50000" type="number" class="form-control" name="installmentPrice" id="installment_price">
			</div>
			
			 <div class="form-group">
			    <label for="course">Select Course</label>
			    <select required class="form-control" name="course" id="course">
			      <c:forEach items="${courses }" var="course">
			      	<option value="${course.id }">${course.name }</option>
			      </c:forEach>
			    </select>
			  </div>
			<input type="hidden" value="${id }" name="id"/>
			<button style="float: clear;" type="submit"
				class="btn btn btn-primary">
				<spring:message code="submit" />
			</button>
		</form:form>
	</div>
</div>