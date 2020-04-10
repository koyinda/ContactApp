<jsp:include page="include/header.jsp"></jsp:include>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<section class="wrapper style1">
	<div class="inner">

<div class="container table-wrapper">
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	 <c:if test="${param.act eq 'sav'}">
			<p class="alert alert-primary" role="alert">Contact saved successfully!</p>
	 </c:if>
	 <c:if test="${param.act eq 'del'}">
			<p class="alert alert-primary" role="alert">Contact deleted successfully!</p>
	 </c:if>
	  <c:if test="${param.act eq 'upd'}">
			<p class="alert alert-primary" role="alert">Contact updated successfully!</p>
	 </c:if>

	<form class="form-inline md-form mr-auto mb-4"  action="<s:url value="contact_search"/>" >
  		<input class="form-control mr-sm-2" type="text" name="freeText" value="${param.freeText}" placeholder="Enter Text To Search" aria-label="Search">
		<button class="btn btn-elegant btn-rounded btn-sm my-0" type="submit">Search</button>
	</form>            					
	<table class="alt">
		<thead>
			<tr>
				<th>S/N</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
             <c:if test="${empty contactList}">
                 <tr>
                     <td align="center" colspan="8" class="error">No Records Present</td>
                 </tr>
              </c:if>
			<c:forEach var="c" items="${contactList}" varStatus="st">
				<tr>
					<td>${st.count}</td>
					<td>${c.name}</td>
					<td>${c.phone}</td>
					<td>${c.email}</td>
					<td>${c.address}</td>
					
					<s:url var="url_del" value="/del_contact">
                     	<s:param name="cid" value="${c.contactid}"/>
                    </s:url>   
                     <s:url var="url_edit" value="/edit_contact">
                         <s:param name="cid" value="${c.contactid}"/>
                     </s:url> 
                     <td><a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	</div>
	</section>
<jsp:include page="include/footer.jsp"></jsp:include>