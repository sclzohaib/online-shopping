<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h2>${title}</h2>
	<c:if test="${not empty message}">
		<div class=col-xs-12>
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${message}
			</div>
	</c:if>
	<sf:form action="${contextRoot}/employee" modelAttribute="employee"
		method="POST">
		<div class="form-row">
			<div class="col-md-4 mb-3">
				<label for="name">Name</label>
				<sf:input type="text" class="form-control" id="name" path="name"></sf:input>
				<sf:errors path="name" cssClass="help-block" element="em" />
			</div>
		</div>
		<div class="form-row">
			<div class="col-md-4 mb-3">
				<label for="date">Joining Date</label>
				<!-- HTML Form (wrapped in a .bootstrap-iso div) -->
				<div class="bootstrap-iso">
					<sf:input class="form-control" id="jdate" path="jdate"
						placeholder="MM/DD/YYYY" type="text" />
					<sf:errors path="date" cssClass="help-block" element="em" />
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="col-md-4 mb-3">
				<label for="validationServerUsername">Route</label>
				<div class="input-group">
					<sf:input type="text" class="form-control" id="route" path="route"
						aria-describedby="inputGroupPrepend3" />
					<sf:errors path="route" cssClass="help-block" element="em" />
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="col-md-3 mb-3">
				<label for="validationServer03">City</label>
				<sf:input type="text" class="form-control" id="city" path="city" />
			</div>
		</div>
		<button class="btn btn-primary" type="submit">Submit</button>
		<sf:hidden path="id" />
	</sf:form>
</div>