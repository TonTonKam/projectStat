<c:import url="nav/headerClient.jsp"/>
<c:import url="nav/menuPrincipaleClient.jsp"/> 

<c:import url="creationArticle.jsp"/>

 <!-- Post Content
 ================================================= -->
 <div class="borderLand">
  <c:forEach var ="artUser" items="${listArtUser}">
   <img src="https://previews.123rf.com/images/clairev/clairev1202/clairev120200036/12482818-%E5%8F%A4%E3%81%84%E6%9B%B8%E7%B1%8D%E3%81%AE%E3%83%86%E3%83%BC%E3%83%9E%E7%94%BB%E5%83%8F-1-%E3%83%99%E3%82%AF%E3%83%88%E3%83%AB-%E3%82%A4%E3%83%A9%E3%82%B9%E3%83%88%E3%80%82.jpg" alt="post-image" class="img-responsive post-image" />
   <div class="post-container">
     <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="user" class="profile-photo-md pull-left" />
     <div class="post-detail">
       <div class="user-info">
         <h5><c:out value="${artUser.auteur }"/></h5>
         <p class="text-muted"><c:out value="${artUser.date }"/></p>
       </div>
       <div class="reaction">
         <a class="btn text-green"><i class="icon ion-thumbsup"></i> <c:out value="0"/></a>
         <a class="btn text-red"><i class="fa fa-thumbs-down"></i> <c:out value="0"/></a>
         <%-- Verification entre le l'auteur et l'article --%>
         <c:if test="${user.idUser == artUser.idUser }">
		   <a class="btn text-orange" data-toggle="modal" data-target=".modal-edit-art${artUser.idArticle }"><i class="ion-compose"></i></a> 
		   <a class="btn text-grey" data-toggle="modal" data-target=".modal-delete-art${artUser.idArticle }"><i class="ion-close"></i></a> 
         </c:if>
       </div>
       <div class="line-divider"></div>
       <div class="post-text">
         <p>${artUser.titre }</p>
       </div>
       <div class="line-divider"></div>
       <div class="post-text">
         <p>${artUser.contenu }</p>
       </div>
       <div class="line-divider"></div>
        <c:forEach var="comment" items="${listCom}">
          <%-- possibilite optimiser le code en mettant une fonction qui execute une requete par l'idArticle
          on verifie que le commentaire est bien asssocie a l'article --%>
          <c:if test="${artUser.idArticle == comment.idArticle }">
	          <div class="post-comment">
	             <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="" class="profile-photo-sm" />
	             <p><a href="${profil }?id=${comment.idUser }" class="profile-link"><c:out value="${comment.auteur }"/></a>
	             <div class="margin-comment">
	               <c:out value="${comment.contenu }"/>
	             </div>
	             </p>
	          </div>
           </c:if>
         </c:forEach>
       <c:if test="${!empty user }">
       <form action="index?idArt=${artUser.idArticle }" method="post">
         <div class="post-comment">
           <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="" class="profile-photo-sm" />
  		   <input type="text" class="form-control" name="comment" placeholder="Post a comment"><button type="submit" class="btn btn-primary pull-right"><c:out value="publier"/></button>
         </div>
       </form>
       </c:if>
     </div>
   </div>
<!-- ================================== MODAL EDIT ============================================ -->
<div class="modal fade modal-edit-art${artUser.idArticle }" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <form action="profil" method="post">
          <div class="create-post">
			<div class="row">
			  <div class="col-md-6 col-sm-6">
			    <div class="post-text">
		         <p><c:out value="Ancien titre : ${artUser.titre }"/></p>
		        </div>
		        <input type="text" class="form-control" name="inpTitre" placeholder="entrer votre titre">
			    <%-- parametre idArticle envoyer a la servlet coter post --%>
			    <input type="text" class="hidden" name="inpIdArticle" value="${artUser.idArticle }">
		      </div>
			  <div class="post-text">
	            <p><c:out value="Ancien contenu : ${artUser.contenu }"/></p>
	          </div>
		      <div class="form-group">
		        <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="" class="profile-photo-md" />
		        <textarea name="inpCont" id="exampleTextarea" cols="30" rows="1" class="form-control" placeholder="Ecrivez votre contenu ici"></textarea>
		      </div>
		      <div class="col-md-6 col-sm-6">
		        <div class="post-text">
		         <p><c:out value="Ancienne categorie : ${artUser.libelle }"/></p>
		        </div>
		    	<select name="selectCategorie" id="categorie" class="col-md-6 col-sm-6">
		    		<option value=""><c:out value="Choisir une option"/></option>
		    		<c:forEach var="inpIdCategorie" items="${listCate }">
		    			<option value="${inpIdCategorie.idCategorie }"><c:out value="${inpIdCategorie.libelle }"/></option>
		    		</c:forEach>
		    		<option value="-1"><c:out value="personnaliser"/></option>
		    	  </select>
		    	  <input type="text" class="form-control" name="newCate" placeholder="entrer votre categorie">
		    	</div>
				<div class="col-md-4 col-sm-4">
			       <div class="tools">
			         <ul class="publishing-tools list-inline">
			           <li><a href="#"><i class="ion-images"></i></a></li>
			         </ul>
			         <button type="submit" class="btn btn-primary pull-right"><c:out value="publier"/></button>
			       </div>
		    	</div>
			</div>
		  </div>
        </form>
      </div>
  </div>
</div>

<!-- ================================== MODAL Delete ============================================ -->
<div class="modal fade modal-delete-art${artUser.idArticle }" tabindex="-1" role="dialog" aria-hidden="true">
   <div class="modal-dialog modal-lg">
      <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<c:out value="Voulez-vous vraiment Supprimer l'article?"/>
	        <b><c:out value="${artUser.idArticle  } ${artUser.titre }" /></b> ?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"><c:out value="Non"/></button>
	        <a href="${delArt}?idArt=${artUser.idArticle }">
	        	<button type="button" class="btn btn-success"><c:out value="Oui, je confirme"/></button>
	        </a>
	      </div>
	   </div>
  </div>
</div>
 </c:forEach>
 </div>

       
<c:import url="nav/footerClient.jsp"/>