<jsp:include page="include/header.jsp"></jsp:include>
		<!-- Banner -->
			<section id="banner">
				<div class="inner">
					<header>
						<h1>This is the Contact App</h1>
						<p>All contacts in one place.</p>
						<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
						 <c:if test="${param.act eq 'lo'}">
								<p>Logout Successful! Thanks for using this contact Application</p>
						 </c:if>						
					</header>
					<a href="/ContactApp/register" class="btn btn-primary">Register</a>
					<a href="/ContactApp/login" class="btn btn-primary">Login</a>
				</div>
			</section>
<jsp:include page="include/footer.jsp"></jsp:include>