<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="project stats licence pro" />
	<meta name="keywords" content="Social Network, Social Media, Profile Page" />
	<meta name="robots" content="index" />
	<title>Comme Unie Qu'On</title>
	
	   <!-- Stylesheets
	  ================================================= -->
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/ionicons.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link href="css/emoji.css" rel="stylesheet">

	<!--Favicon-->
	<link rel="shortcut icon" type="image/png" href="images/fav.png"/>
</head>
<body>

<c:url value="/index" var="index" scope="request"/>
<c:url value="/accueil" var="accueil" scope="request"/>
<c:url value="/editProfil" var="editProfil" scope="request"/>
<c:url value="/editPassword" var="editPassword" scope="request"/>
<c:url value="/profil" var="profil" scope="request"/>
<c:url value="/listFriend" var="listFriend" scope="request"/>
<c:url value="/sendMail" var="sendMail" scope="request"/>
<c:url value="/emailSendingServlet" var="envoiMail" scope="request"/>
<c:url value="/delArt" var="delArt" scope="request"/>
<c:url value="/upload" var="upload" scope="request"/>

<!-- Header
================================================= -->
<header id="header">
    <nav class="navbar navbar-default navbar-fixed-top menu">
      <div class="container">
 
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${index }"><img src="images/logo-test.png" alt="logo" /></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right main-menu">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Votre actualite <span><img src="images/down-arrow.png" alt="" /></span></a>
              <ul class="dropdown-menu newsfeed-home">
                <li><a href="${index }"><c:out value="Accueil"/></a></li>
                <!-- <li><a href="#">Images</a></li> -->
              </ul>
            </li>
            <c:if test="${!empty user }">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Votre profil <span><img src="images/down-arrow.png" alt="" /></span></a>
              <ul class="dropdown-menu login">
                <li><a href="${profil }?id=${user.idUser}"><c:out value="Voir vos articles"/></a></li>
                <li><a href="${listFriend }?id=${user.idUser}"><c:out value="Liste d'ami(e)s"></c:out></a></li>
                <!-- <li><a href="#">Chatroom</a></li> -->
                <li><a href="${editProfil }?id=${user.idUser}"><c:out value="Editer vos informations"/></a></li>
                <li><a href="${editPassword }?id=${user.idUser}"><c:out value="Changer votre mot de passe"/></a></li>
              </ul>
            </li>
            </c:if>
            <li class="dropdown"><a href="contact.html">Contact</a></li>
            <c:if test="${empty user }">
            	<li class="dropdown"><a href="#" data-toggle="modal" data-target=".modal-connect"><c:out value="Connection / Inscription"/></a></li>
            </c:if>
            <c:if test="${!empty user }">
            	<li class="dropdown"><a href="delete"><c:out value="Deconnection"/></a></li>
            </c:if>
          </ul>
          <form class="navbar-form navbar-right hidden-sm">
            <div class="form-group">
              <i class="icon ion-android-search"></i>
              <input type="text" class="form-control" placeholder="Recherche categories, articles">
            </div>
          </form>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>
    
    <!-- Landing Page Contents
    ================================================= -->
    <div class="modal fade modal-connect" tabindex="-1" role="dialog" aria-hidden="true">
     <div class="modal-dialog modal-lg">
       <div class="modal-content">
		    <div id="lp-register">
		      <div class="container wrapper">
		        <div class="row">
		          <div class="col-sm-6 col-sm-offset-1">
		            <div class="reg-form-container"> 
		            
		              <!-- Register/Login Tabs-->
		              <div class="reg-options">
		                <ul class="nav nav-tabs">
		                  <li class="active"><a href="#register" data-toggle="tab"><c:out value="Register"/></a></li>
		                  <li><a href="#login" data-toggle="tab"><c:out value="Login"/></a></li>
		                </ul><!--Tabs End-->
		              </div>
		              
		              <!--Registration Form Contents-->
		              <div class="tab-content">
		                <div class="tab-pane active" id="register">
		                  <h3><c:out value="Inscrivez vous maintenant !!!"/></h3>
		                  <p class="text-muted"><c:out value="Soyez simple et rejoignez la communaute."/></p>
		                  
		                  <!--Register Form-->
		                  <form name="registration_form" id='registration_form' class="form-inline" method="post" action="headerClient">
		                    <div class="row">
		                      <div class="form-group col-xs-6">
		                        <label for="prenom" class="sr-only"><c:out value="Prenom"/></label>
		                        <input id="prenom" class="form-control input-group-lg" type="text" name="prenom" title="Enter first name" placeholder="Prenom"/>
		                      </div>
		                      <div class="form-group col-xs-6">
		                        <label for="nom" class="sr-only"><c:out value="Nom"/></label>
		                        <input id="nom" class="form-control input-group-lg" type="text" name="nom" title="Enter last name" placeholder="Nom"/>
		                      </div>
		                    </div>
		                    <%-- <div class="row">
		                      <div class="form-group col-xs-6">
		                        <label for="age" class="sr-only"><c:out value="Age"/></label>
		                        <input id="age" class="form-control input-group-lg" type="text" name="age" title="Enter last name" placeholder="Age"/>
		                      </div>
		                    </div> --%>
		                    <div class="row">
		                      <div class="form-group col-xs-12">
		                        <label for="email" class="sr-only"><c:out value="E-mail"/></label>
		                        <input id="email" class="form-control input-group-lg" type="text" name="email" title="Enter Email" placeholder="Votre Email"/>
		                      </div>
		                    </div>
		                    <div class="row">
		                      <div class="form-group col-xs-12">
		                        <label for="password" class="sr-only"><c:out value="Mot de passe"/></label>
		                        <input id="password" class="form-control input-group-lg" type="password" name="password" title="Enter password" placeholder="Password"/>
		                      </div>
		                    </div>
		                    
		                    <%-- <div class="form-group gender">
		                      <label class="radio-inline">
		                        <input type="radio" name="optradio">Homme
		                      </label>
		                      <label class="radio-inline">
		                        <input type="radio" name="optradio">Femme
		                      </label>
		                      <label class="radio-inline">
		                        <input type="radio" name="optradio">Autre
		                      </label>
		                    </div> --%>
			                <div class="row">
			                  <button class="btn btn-primary" type="submit"><c:out value="Inscrivez-vous"/></button>
			                </div>
		                  </form><!--Register Now Form Ends-->
		                </div><!--Registration Form Contents Ends-->
		                
		                <!--Login-->
		                <div class="tab-pane" id="login">
		                  <h3><c:out value="Connection"/></h3>
		                  <p class="text-muted"><c:out value="Connectez-vous pour profitez de bons moments avec la communaute"/></p>
		                  
		                  <!--Login Form-->
		                  <form name="Login_form" id='Login_form' method="post" action="headerClient">
		                     <div class="row">
		                      <div class="form-group col-xs-12">
		                        <label for="my-email" class="sr-only"><c:out value="E-mail"/></label>
		                        <input id="my-email" class="form-control input-group-lg" type="text" name="loginEmail" title="Enter Email" placeholder="Votre Email"/>
		                      </div>
		                    </div>
		                    <div class="row">
		                      <div class="form-group col-xs-12">
		                        <label for="my-password" class="sr-only"><c:out value="Mot de passe"/></label>
		                        <input id="my-password" class="form-control input-group-lg" type="password" name="loginPassword" title="Enter password" placeholder="Password"/>
		                      </div>
		                    </div>
		                  <div class="row">
		                  <p><a href="${envoiMail }"><c:out value="Vous avez oublie votre mot de passe?"/></a></p>
			                  <button class="btn btn-primary" type="submit"><c:out value="Connectez-vous"/></button>
		                  </div>
		                  </form><!--Login Form Ends--> 
		                </div>
		              </div>
		            </div>
		          </div>
		        </div>
		        <div class="row">
		          <div class="col-sm-6 col-sm-offset-6">
		          
		            <!--Social Icons-->
		            <ul class="list-inline social-icons">
		              <li><a href="#"><i class="icon ion-social-facebook"></i></a></li>
		              <li><a href="#"><i class="icon ion-social-twitter"></i></a></li>
		              <li><a href="#"><i class="icon ion-social-googleplus"></i></a></li>
		              <li><a href="#"><i class="icon ion-social-pinterest"></i></a></li>
		              <li><a href="#"><i class="icon ion-social-linkedin"></i></a></li>
		            </ul>
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
		    
    
</header>
<!--Header End-->