<jsp:include page="include/header.jsp"></jsp:include>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<!-- Main -->
			<div id="main">
				<section class="wrapper style1">
					<div class="inner">
							<div class="row">
								<div class="col"></div>
								<div class="col"></div>
								<div class="col-8">
									<h1>Add New Contact</h1>
								</div>

								<div class="col"></div>
							</div>
						<div>
						<div class="row">
							  <div class="col"></div>
							  <div class="col"></div>
							  <div class="col col-8">
							  		<c:if test="${ERROR!=null }">
							  		<p class="12u$(xsmall) 5 u alert alert-danger">${ERROR}
							  		</p>
							  		</c:if>
							  </div>
							  <div class="col"></div>
						</div>
							<div class="row">
							  <div class="col"></div>
							  <div class="col"></div>
							  <div class="col-8">
						<s:url var = "url_cform" value="/contact_form"/>
						<f:form method="post" action="${url_cform}" modelAttribute="cmd" >
							<div class="12u$(xsmall) 4u">								
								Name: <f:input path="name"/>
								Phone: <f:input path="phone"/>
								Address: <f:textarea path="address"/>								
								Email: <f:input path="email"/>
								Comment: <f:textarea path="remark"/>
							<!--	<input type="password" name="password" id="password" value="" placeholder="password" /> -->
							</div>
							<br>
							<button type="submit" class="btn btn-primary btn-sm">Save Contact</button>
							<a href="/ContactApp" class="btn btn-danger btn-sm" role="button">Cancel</a>
						</f:form>
						</div>
							  <div class="col"> </div>
							</div>
						</div>
					</div>
				</section>
			</div>
<jsp:include page="include/footer.jsp"></jsp:include>
		<!-- Footer -->
