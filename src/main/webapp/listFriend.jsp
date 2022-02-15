<c:import url="nav/headerClient.jsp"/>
<c:import url="nav/menuPrincipaleClient.jsp"/> 

<c:import url="creationArticle.jsp"/>

<!-- Friend List
================================================= -->
<div class="friend-list">
  <div class="row">
    <div class="col-md-6 col-sm-6">
      <div class="friend-card">
        <img src="http://placehold.it/1030x360" alt="profile-cover" class="img-responsive cover" />
        <div class="card-info">
          <img src="http://placehold.it/300x300" alt="user" class="profile-photo-lg" />
          <div class="friend-info">
            <a href="#" class="pull-right text-green">My Friend</a>
            <h5><a href="${profil }" class="profile-link"><c:out value="Sophia Lee"/></a></h5>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-sm-6">
      <div class="friend-card">
        <img src="http://placehold.it/1030x360" alt="profile-cover" class="img-responsive cover" />
        <div class="card-info">
          <img src="http://placehold.it/300x300" alt="user" class="profile-photo-lg" />
          <div class="friend-info">
            <a href="#" class="pull-right text-green">My Friend</a>
            <h5><a href="timeline.html" class="profile-link">John Doe</a></h5>
            <p>Traveler</p>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-sm-6">
      <div class="friend-card">
        <img src="http://placehold.it/1030x360" alt="profile-cover" class="img-responsive cover" />
        <div class="card-info">
          <img src="http://placehold.it/300x300" alt="user" class="profile-photo-lg" />
          <div class="friend-info">
            <a href="timeline.html" class="pull-right text-green">My Friend</a>
            <h5><a href="#" class="profile-link">Julia Cox</a></h5>
            <p>Art Designer</p>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-sm-6">
      <div class="friend-card">
        <img src="http://placehold.it/1030x360" alt="profile-cover" class="img-responsive cover" />
        <div class="card-info">
          <img src="http://placehold.it/300x300" alt="user" class="profile-photo-lg" />
          <div class="friend-info">
            <a href="#" class="pull-right text-green">My Friend</a>
            <h5><a href="${profil }" class="profile-link"><c:out value="Robert Cook"/></a></h5>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-sm-6">
      <div class="friend-card">
        <img src="http://placehold.it/1030x360" alt="profile-cover" class="img-responsive cover" />
        <div class="card-info">
          <img src="http://placehold.it/300x300" alt="user" class="profile-photo-lg" />
          <div class="friend-info">
            <a href="#" class="pull-right text-green">My Friend</a>
            <h5><a href="${profil }" class="profile-link"><c:out value="Richard Bell"/></a></h5>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<c:import url="nav/footerClient.jsp"/>