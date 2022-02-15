<div class="container">

    <!-- Timeline
    ================================================= -->
	<div class="timeline">
	  <div class="timeline-cover">

		<!-- Presentation d'une page user -->
          <!--Timeline Menu for Large Screens-->
          <div class="timeline-nav-bar hidden-sm hidden-xs">
            <div class="row">
              <div class="col-md-3">
                <div class="profile-info">
                  <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="" class="img-responsive profile-photo" />
                  <c:if test="${!empty user}">
	              	<h3><c:out value="${user.nom }"/></h3>
	              </c:if>
                </div>
              </div>
              <div class="col-md-9">
                <ul class="list-inline profile-menu">
                  <li><a href="${index }" class="active"><c:out value="Accueil"/></a></li>
                  <%-- <li><a href="${listFriend }"><c:out value="Liste d'ami(e)s"/></a></li> --%>
                </ul>
              <%--  <ul class="follow-me list-inline">
                  <li><c:out value="1,299 people following her"/></li>
                  <li><button class="btn-primary" id="addfriend"><c:out value="Ajouter en ami(e)"/></button></li>
                </ul>  --%>
              </div>
            </div>
          </div><!--Timeline Menu for Large Screens End-->

          <!--Timeline Menu for Small Screens-->
          <div class="navbar-mobile hidden-lg hidden-md">
            <div class="profile-info">
              <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="" class="img-responsive profile-photo" />
              <c:if test="${!empty user}">
              	<h4><c:out value="${user.nom }"/></h4>
              </c:if>
            </div>
            <div class="mobile-menu">
              <ul class="list-inline">
                <li><a href="${index }" class="active"><c:out value="Accueil"/></a></li>
                <c:if test="${!empty user}">
                	<li><a href="${listFriend }"><c:out value="liste d'amis"/></a></li>
                </c:if>
              </ul>
              <c:if test="${request }">
              <button class="btn-primary"><c:out value="Ajouter en ami(e)"/></button>
              </c:if>
            </div>
          </div><!--Timeline Menu for Small Screens End-->

	</div><!-- END Timeline -->
	<div id="page-contents"> <!-- Begin page contents -->
		<div class="row"><!-- Begin Row -->
			<div class="col-md-3">
			    <!--Edit Profile Menu-->
			    <c:if test="${!empty user}">
					<ul class="edit-menu">
						<li><i class="icon ion-ios-heart-outline"></i><a href="${profil }?id=${user.idUser}"><c:out value="Vos articles"/></a></li>
						<li><i class="icon ion-ios-information-outline"></i><a href="${editProfil }?id=${user.idUser}"><c:out value="Editer profil"/></a></li>
						<li class="active"><i class="icon ion-ios-locked-outline"></i><a href="${editPassword }?id=${user.idUser}"><c:out value="Changer mot de passe"/></a></li>
					</ul>
				</c:if>
			</div>
			<div class="col-md-8"><!-- Begin col-md-8 -->
			