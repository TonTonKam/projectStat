<c:import url="nav/headerClient.jsp"/>
<c:import url="nav/menuPrincipaleClient.jsp"/>

<div class="row">
<c:forEach var="img" items="${listImg }">
	<div class="grid-item col-md-6 col-sm-6">
	  <div class="media-grid">
  	    <a href="#?adress=${img }" ><img src="${img }" alt="" class="img-responsive post-image" /></a>
	  </div>
	</div>
 </c:forEach>
 </div>

<c:out value="Telecharger votre image :"/> <br />
<form action="upload" method="post" enctype="multipart/form-data">
	<input type="file" name="guru_file" size="50" />
	<br />
	<input type="submit" value="Upload" />
</form>

<c:import url="nav/footerClient.jsp"/>