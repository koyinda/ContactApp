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
									<h1>Register</h1>
									<p>It you have a login please click <a href="/Login" class="btn btn-outline-info">Login</a></p>
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
						<s:url var = "url_register" value="/register"/>
						<f:form method="post" action="${url_register}" modelAttribute="cmd" >
							<div class="12u$(xsmall) 4u">								
								Name: <f:input path="user.name"/>
								Phone: <f:input path="user.phone"/>
								Address: <f:textarea path="user.address"/>								
								Email: <f:input path="user.email"/>
								User Name: <f:input id="id_username" path="user.username"/> <button type="button" id="id_check_avail">Check</button>
                                    <div id="id_res_div" class="error"></div>
								Password: <f:password path="user.password"/>
								Role: <f:input path="user.role"/>
							<!--	<input type="password" name="password" id="password" value="" placeholder="password" /> -->
							</div>
							<br>
							<button type="submit" class="btn btn-primary btn-sm">Register</button>
							<a href="/ContactApp" class="btn btn-danger btn-sm" role="button">Cancel</a>
						</f:form>
						</div>
							  <div class="col"> </div>
							</div>
						</div>
					</div>
				</section>
			</div>
			<script>
            $(document).ready(function (){
                $("#id_check_avail").click(function(){
                    $.ajax({
                        url : 'checkavail',
                        data : { username: $("#id_username").val()} ,
                        success : function(data){
                            $("#id_res_div").html(data);
                        }
                    });
                });
            });
        </script>
<jsp:include page="include/footer.jsp"></jsp:include>
		<!-- Footer -->
