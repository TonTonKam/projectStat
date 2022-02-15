<!-- Post Create Box
================================================= -->
<div class="create-post">
  <form method="post" action="creationArticle">
	<div class="row">
		<div class="col-md-6 col-sm-6">
         <input type="text" class="form-control" name="titre" placeholder="entrer votre titre">
	       <div class="form-group">
	         <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="" class="profile-photo-md" />
	         <textarea name="contenu" id="exampleTextarea" cols="30" rows="1" class="form-control" placeholder="Ecrivez votre contenu ici"></textarea>
	       </div>
    	</div>
    	<div class="col-md-6 col-sm-6">
    		<select name="categorie" id="categorie" class="col-md-6 col-sm-6">
    			<option value=""><c:out value="Choisir une option"/></option>
    			<c:forEach var="categ" items="${listCate }">
    			  <option value="${categ.idCategorie }"><c:out value="${categ.libelle }"/></option>
    			</c:forEach>
    			<option value="-1"><c:out value="personnaliser"/></option>
    		</select>
    		<input type="text" class="form-control" name="newCate" id="newCate" placeholder="entrer votre categorie">
    	</div>
		<div class="col-md-4 col-sm-4">
	       <div class="tools">
	       <%-- inclure un form special pour le fichier --%>
	         <ul class="publishing-tools list-inline">
	           <li><a href="${upload }"><i class="ion-images"></i></a></li>
	         </ul>
	         <button type="submit" class="btn btn-primary pull-right"><c:out value="publier"/></button>
	       </div>
    	</div>
	</div>
  </form>
</div><!-- Post Create Box End -->