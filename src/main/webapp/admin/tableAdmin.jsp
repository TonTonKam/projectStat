<c:import url="/admin/nav/headerAdmin.jsp"/>	
	
<c:import url="/admin/nav/menuPrincipaleAdmin.jsp"/>

<div class="page-wrapper">
	<div class="page-content">
	<h6 class="mb-0 text-uppercase"><c:out value="Utilisateur"/></h6>
		<div class="card">
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered" style="width:100%">
						<thead>
							<tr>
								<th><c:out value="Id user"/></th>
								<th><c:out value="Nom"/></th>
								<th><c:out value="Prenom"/></th>
								<th><c:out value="Age"/></th>
								<th><c:out value="Civilite"/></th>
								<th><c:out value="Email"/></th>
								<th><c:out value="Date d'inscription"/></th>
								<th><c:out value="Status"/></th>
								<th><c:out value="Supprimer"/></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="user" items="${listUser }">
						  <tr>
						    <form action="tableAdmin" method="post">
								<td><input type="text" name="inputIdUserAdmin" value="${user.idUser }" readonly="readonly"> </td>
								<td><input type="text" name="inputUserNomAdmin" value="${user.nom }" readonly="readonly"> </td>
								<td><input type="text" name="inputUserPrenomAdmin" value="${user.prenom }" readonly="readonly"></td>
								<td><input type="text" name="inputUserAgeAdmin" value="${user.age }" readonly="readonly"></td>
								<td><input type="text" name="inputUserCivAdmin" value="${user.civilite }" readonly="readonly"></td>
								<td><input type="text" name="inputUserEmailAdmin" value="${user.email }" readonly="readonly"></td>
								<td><input type="text" name="inputUserDateInscriptionAdmin" value="${user.dateInscription }" readonly="readonly"></td>
								<td><input type="text" name="inputIdStatusUserAdmin" value="${user.idStatus }" readonly="readonly"></td>
								<td><button type="submit" class="btn btn-primary pull-right"><c:out value="Supprimer"/></button></td>
						    </form>
						  </tr>
						</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th><c:out value="Id user"/></th>
								<th><c:out value="Nom"/></th>
								<th><c:out value="Prenom"/></th>
								<th><c:out value="Age"/></th>
								<th><c:out value="Civilite"/></th>
								<th><c:out value="Email"/></th>
								<th><c:out value="Date d'inscription"/></th>
								<th><c:out value="Status"/></th>
								<th><c:out value="Supprimer"/></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<h6 class="mb-0 text-uppercase"><c:out value="Article"/></h6><hr>
		<div class="card">
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered" style="width:100%">
						<thead>
							<tr>
								<th><c:out value="Id article"/></th>
								<th><c:out value="Titre"/></th>
								<th><c:out value="Contenu"/></th>
								<th><c:out value="Resume"/></th>
								<th><c:out value="Image"/></th>
								<th><c:out value="Id utilisateur"/></th>
								<th><c:out value="Nom utilisateur"/></th>
								<th><c:out value="Id categorie"/></th>
								<th><c:out value="Nom categorie"/></th>
								<th><c:out value="Id vue"/></th>
								<th><c:out value="Id signe"/></th>
								<th><c:out value="Visible"/></th>
								<th><c:out value="Supprimer"/></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="articleAd" items="${listArticleAd }">
						  <tr>
							<form action="tableAdmin" method="post">
								<td><input type="text" name="inputIdArticleAdmin" value="${articleAd.idArticle }" readonly="readonly"> </td>
								<td><input type="text" name="inputArtTitreAdmin" value="${articleAd.titre }" readonly="readonly"> </td>
								<td><input type="text" name="inputArtContenuAdmin" value="${articleAd.contenu }" readonly="readonly"></td>
								<td><input type="text" name="inputArtResumeAdmin" value="${articleAd.resume }" readonly="readonly"></td>
								<td><input type="text" name="inputArtImageAdmin" value="${articleAd.image }" readonly="readonly"></td>
								<td><input type="text" name="inputArtIdUserAdmin" value="${articleAd.idUser }" readonly="readonly"></td>
								<td><input type="text" name="inputArtAuteurAdmin" value="${articleAd.auteur }" readonly="readonly"></td>
								<td><input type="text" name="inputArtIdCateAdmin" value="${articleAd.idCategorie }" readonly="readonly"></td>
								<td><input type="text" name="inputArtLibelleAdmin" value="${articleAd.libelle }" readonly="readonly"></td>
								<td><input type="text" name="inputArtVueAdmin" value="${articleAd.idVue }" readonly="readonly"></td>
								<td><input type="text" name="inputArtSignePosiAdmin" value="${articleAd.idSigne }" readonly="readonly"></td>
								<td><input type="text" name="inputArtExisteAdmin"value="${articleAd.existe }" readonly="readonly"></td>
								<td><button type="submit" class="btn btn-primary pull-right"><c:out value="Supprimer"/></button></td>
							</form>
						  </tr>
						</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th><c:out value="Id article"/></th>
								<th><c:out value="Titre"/></th>
								<th><c:out value="Contenu"/></th>
								<th><c:out value="Resume"/></th>
								<th><c:out value="Image"/></th>
								<th><c:out value="Id utilisateur"/></th>
								<th><c:out value="Nom utilisateur"/></th>
								<th><c:out value="Id categorie"/></th>
								<th><c:out value="Nom categorie"/></th>
								<th><c:out value="Id vue"/></th>
								<th><c:out value="Id signe"/></th>
								<th><c:out value="Visible"/></th>
								<th><c:out value="Supprimer"/></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<h6 class="mb-0 text-uppercase"><c:out value="Commentaire"/></h6><hr>
		<div class="card">
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered" style="width:100%">
						<thead>
							<tr>
								<th><c:out value="Id commentaire"/></th>
								<th><c:out value="Contenu"/></th>
								<th><c:out value="date"/></th>
								<th><c:out value="Id utilisateur"/></th>
								<th><c:out value="Nom utilisateur"/></th>
								<th><c:out value="Id article"/></th>
								<th><c:out value="titre article"/></th>
								<th><c:out value="Visible"/></th>
								<th><c:out value="Supprimer"/></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="commentAd" items="${listCommentAd }">
						  <tr>
							<form action="tableAdmin" method="post">
								<td><input type="text" name="inputIdCommentAdmin" value="${commentAd.idComment }" readonly="readonly"> </td>
								<td><input type="text" name="inputCommentContenuAdmin" value="${commentAd.contenu }" readonly="readonly"> </td>
								<td><input type="text" name="inputCommentDateAdmin" value="${commentAd.date }" readonly="readonly"></td>
								<td><input type="text" name="inputCommentIdUserAdmin" value="${commentAd.idUser }" readonly="readonly"></td>
								<td><input type="text" name="inputCommentAuteurAdmin" value="${commentAd.auteur }" readonly="readonly"></td>
								<td><input type="text" name="inputCommentIdArticleAdmin" value="${commentAd.idArticle }" readonly="readonly"></td>
								<td><input type="text" name="inputCommentTitreAdmin" value="${commentAd.titre }" readonly="readonly"></td>
								<td><input type="text" name="inputCommentExisteAdmin" value="${commentAd.existe }" readonly="readonly"></td>
								<td><button type="submit" class="btn btn-primary pull-right"><c:out value="Supprimer"/></button></td>
							</form>
						  </tr>
						</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th><c:out value="Id commentaire"/></th>
								<th><c:out value="Contenu"/></th>
								<th><c:out value="date"/></th>
								<th><c:out value="Id utilisateur"/></th>
								<th><c:out value="Nom utilisateur"/></th>
								<th><c:out value="Id article"/></th>
								<th><c:out value="titre article"/></th>
								<th><c:out value="Visible"/></th>
								<th><c:out value="Supprimer"/></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<%-- probleme sur les modications d'id de la categorie --%>
	<%-- 	<h6 class="mb-0 text-uppercase"><c:out value="Categorie"/></h6><hr>
		<div class="card">
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered" style="width:100%">
						<thead>
							<tr>
								<th><c:out value="Id categorie"/></th>
								<th><c:out value="libelle"/></th>
								<th><c:out value="Modifier"/></th>
								<th><c:out value="Supprimer"/></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="categorieAd" items="${listCategorie }">
						  <tr>
							<form action="tableAdmin" method="post">
								<td><input type="text" name="inputIdCategorieAdmin" value="${categorieAd.idCategorie }" readonly="readonly"> </td>
								<td><input id="libelleCommentAdmin" type="text" name="inputCateLibelleAdmin" value="${categorieAd.libelle }" > </td>
								<td><button id="btnModifCate" class="btn btn-primary pull-right"><c:out value="Modifier"/></button></td>
								<td><button id="btnDeleteCate" class="btn btn-primary pull-right"><c:out value="supprimer"/></button></td>
							</form>
						  </tr>
						</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th><c:out value="Id categorie"/></th>
								<th><c:out value="libelle"/></th>
								<th><c:out value="Modifier"/></th>
								<th><c:out value="Supprimer"/></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div> --%>
	</div>
</div>

<c:import url="/admin/nav/footerAdmin.jsp"/>