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
									<h1>Login</h1>
									<c:if test="${param.act eq 'reg'}">
									 <p>Registration Successful! please login</p>
									</c:if>
									<c:if test="${param.act eq ''}">
									 <p>It you do not have a login please click <a href="ContactApp/register" class="btn btn-outline-info">Register</a></p>
									</c:if>
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
						<s:url var = "url_login" value="/login"/>
						<f:form method="post" action="${url_login}" modelAttribute="command" >
							<div class="12u$(xsmall) 3u">
							<!--	<input type="text" name="username" id="username" value="" placeholder="username" /> -->
								<f:input path="username"/>
								<br>
								<f:password path="password"/>
							<!--	<input type="password" name="password" id="password" value="" placeholder="password" /> -->
							</div>
							<br>
							<button type="submit" class="btn btn-primary btn-sm">Login</button>
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
