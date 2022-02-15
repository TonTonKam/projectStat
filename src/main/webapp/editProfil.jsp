<c:import url="nav/headerClient.jsp"/>
<c:import url="nav/menuPrincipaleClient.jsp"/> 

 <!-- Basic Information
 ================================================= -->
<div class="edit-profile-container">
	<div class="block-title">
	  <h4 class="grey"><i class="icon ion-android-checkmark-circle"></i><c:out value="Editer vos informations"/></h4>
	  <div class="line"></div>
	  <p><c:out value="Modifier vos informations simplement, mettez a jour votre profil en toute simplicite."/></p>
	  <div class="line"></div>
	</div>
	<div class="edit-block">
		<form name="basic-info" id="basic-info" class="form-inline" action="editProfil" method="post">
		  <div class="row">
		    <div class="form-group col-xs-6">
		      <label for="prenom"><c:out value="Prenom"/></label>
		      <input id="prenom" class="form-control input-group-lg" type="text" name="prenomEdit" title="Entrer prenom" placeholder="prenom" value="${userProfil.prenom }" />
		    </div>
		    <div class="form-group col-xs-6">
		      <label for="Nom" class=""><c:out value="Nom"/></label>
		      <input id="Nom" class="form-control input-group-lg" type="text" name="nomEdit" title="Entrer nom" placeholder="Nom" value="${userProfil.nom }" />
		    </div>
		    <%-- <div class="form-group col-xs-6">
		      <label for="Age" class=""><c:out value="Age"/></label>
		      <input id="Age" class="form-control input-group-lg" type="text" name="Age" title="Entrer Age" placeholder="Nom" value="25" />
		    </div> --%>
		  </div>
		  <div class="row">
		    <div class="form-group col-xs-12">
		      <label for="email"><c:out value="Mon email"/></label>
		      <input id="email" class="form-control input-group-lg" type="text" name="emailEdit" title="Entrer Email" placeholder="Mon Email" value="${userProfil.email }"/>
		    </div>
		  </div>
		  <%-- <div class="form-group gender">
		    <span class="custom-label"><strong><c:out value="Je suis"/> : </strong></span>
		    <label class="radio-inline">
		      <input type="radio" name="optradio" checked><c:out value="Homme"/>
		    </label>
		    <label class="radio-inline">
		      <input type="radio" name="optradio"><c:out value="Femme"/>
		    </label>
		    <label class="radio-inline">
		      <input type="radio" name="optradio"><c:out value="Autre"/>
		    </label>
		  </div> --%>
		  <button type="submit" class="btn btn-primary"><c:out value="Sauvegardez les changements"/></button>
		</form>
	</div>
</div>


<c:import url="nav/footerClient.jsp"/>