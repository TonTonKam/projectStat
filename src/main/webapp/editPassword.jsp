<c:import url="nav/headerClient.jsp"/>
<c:import url="nav/menuPrincipaleClient.jsp"/> 

<!-- Change Password
================================================= -->
<div class="edit-profile-container">
  <div class="block-title">
    <h4 class="grey"><i class="icon ion-ios-locked-outline"></i><c:out value="Changez de  mot de passe"/></h4>
    <div class="line"></div>
    <p><c:out value="Pour plus de securite, vous pouvez changer votre mot de passe a tout moment, en toute simplicite."/> </p>
    <div class="line"></div>
  </div>
  <div class="edit-block">
    <form name="update-pass" id="education" class="form-inline" action="editPassword" method="post">
      <div class="row">
        <div class="form-group col-xs-6">
          <label><c:out value="Nouveau mot de passe"/></label>
          <input class="form-control input-group-lg" type="password" name="passwordEdit" title="Entrer password" placeholder="Nouveau password"/>
        </div>
        <div class="form-group col-xs-6">
          <label><c:out value="Confirmer le nouveau mot de passe"/></label>
          <input class="form-control input-group-lg" type="password" name="passwordConfEdit" title="Entrer confirmation password" placeholder="Confirmer password"/>
        </div>
      </div>
      <button type="submit" class="btn btn-primary"><c:out value="Sauvegardez le nouveau mot de passe"/></button>
    </form>
  </div>
</div>
            
<c:import url="nav/footerClient.jsp"/>   