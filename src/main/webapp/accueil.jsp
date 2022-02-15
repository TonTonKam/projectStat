<c:import url="nav/headerClient.jsp"/>

<c:if test="${!empty user }">
  <c:import url="nav/menuPrincipaleClient.jsp"/>
</c:if>
<c:if test="${empty user }">
<div class="container">
  <!-- Timeline
  ================================================= -->
  <div class="timeline">
  <div class="timeline-cover"></div>
	<div id="page-contents"> <!-- Begin page contents -->
	  <div class="row"><!-- Begin Row -->
		<div class="col-md-3"></div>
		  <div class="col-md-8"><!-- Begin col-md-8 -->
</c:if>
<ul class="filter-navigation">
  <li class="filter current" ><a href="${index }" class="profile-link"><c:out value="Toutes les categories"/></a></li>
  <c:forEach var="cate" items="${listCate }">
	<li><a href="${index }?cate=${cate.idCategorie }" class="profile-link"><c:out value="${cate.libelle }"/></a><li>
  </c:forEach>
</ul>

<div id="page-contents">
	<div class="container">
		<div class="row">
			<div class="col-md-8">
			<!-- creation d'article -->
			<c:import url="creationArticle.jsp"/>

            <!-- Media
            ================================================= -->
            <div class="media">
           	  <div class="row js-masonry" data-masonry='{ "itemSelector": ".grid-item", "columnWidth": ".grid-sizer", "percentPosition": true }'>
                <div class="grid-sizer col-md-6 col-sm-6"></div>
            <c:forEach var="art" items="${listArt }">
                <div class="grid-item col-md-6 col-sm-6">
        		  <div class="media-grid">
                    <div class="img-wrapper" data-toggle="modal" data-target=".modal${art.idArticle }">
                      <img src="https://previews.123rf.com/images/clairev/clairev1202/clairev120200036/12482818-%E5%8F%A4%E3%81%84%E6%9B%B8%E7%B1%8D%E3%81%AE%E3%83%86%E3%83%BC%E3%83%9E%E7%94%BB%E5%83%8F-1-%E3%83%99%E3%82%AF%E3%83%88%E3%83%AB-%E3%82%A4%E3%83%A9%E3%82%B9%E3%83%88%E3%80%82.jpg" alt="" class="img-responsive post-image" />
                    </div>
                    <div class="media-info">
                      <div class="reaction">
                        <a class="btn text-green"><i class="fa fa-thumbs-up"></i> <c:out value="0"/></a>
                        <a class="btn text-red"><i class="fa fa-thumbs-down"></i> <c:out value="0"/></a>
                      </div>
                      <div class="user-info">
                        <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="" class="profile-photo-sm pull-left" />
                        <div class="user">
                          <h6><a href="${profil }?id=${art.idUser }" class="profile-link"><c:out value="${art.auteur }"/></a></h6>
                        </div>
                        <div class="user">
                          <h6><c:out value="${art.titre }"/></h6>
                          <c:out value="${art.libelle }"/>
                        </div>
                      </div>
                    </div>

                    <!--Popup-->
                    <div class="modal fade modal${art.idArticle }" tabindex="-1" role="dialog" aria-hidden="true">
                      <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                          <div class="post-content">
                            <img src="https://previews.123rf.com/images/clairev/clairev1202/clairev120200036/12482818-%E5%8F%A4%E3%81%84%E6%9B%B8%E7%B1%8D%E3%81%AE%E3%83%86%E3%83%BC%E3%83%9E%E7%94%BB%E5%83%8F-1-%E3%83%99%E3%82%AF%E3%83%88%E3%83%AB-%E3%82%A4%E3%83%A9%E3%82%B9%E3%83%88%E3%80%82.jpg" alt="post-image" class="img-responsive post-image" />
                            <div class="post-container">
                              <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="user" class="profile-photo-md pull-left" />
                              <div class="post-detail">
                                <div class="user-info">
                                  <h5><a href="${profil }?id=${art.idUser }" class="profile-link"><c:out value="${art.auteur }"/></a> </h5>
                                  <p class="text-muted"><c:out value="${art.date }"/></p>
                                </div>
                                <div class="reaction">
                                  <a class="btn text-green"><i class="icon ion-thumbsup"></i><c:out value="0"/></a>
                                  <a class="btn text-red"><i class="fa fa-thumbs-down"></i><c:out value="0"/></a>
                                </div>
                                <div class="line-divider"></div>
                                <div class="post-text">
                               	  <h6><c:out value="${art.titre }"/></h6>
                               	</div>
                                <div class="line-divider"></div>
                                <div class="post-text">
                                  <p><c:out value="${art.contenu }"/></p>
                                </div>
                                <div class="line-divider"></div>
                                <c:forEach var="comment" items="${listCom}">
                                <c:if test="${art.idArticle == comment.idArticle }">
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
                                <form action="index?idArt=${art.idArticle }" method="post">
	                                <div class="post-comment">
			                            <img src="https://st3.depositphotos.com/1007566/12803/v/950/depositphotos_128034552-stock-illustration-user-figure-avatar-isolated-icon.jpg" alt="" class="profile-photo-sm" />
										<input type="text" class="form-control" name="comment" placeholder="Post a comment"><button type="submit" class="btn btn-primary pull-right"><c:out value="publier"/></button>
	                                </div>
                                </form>
                                </c:if>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div><!--Popup End-->

                  </div>
            	</div>
            	</c:forEach>
                
               </div>
             </div>
           </div>
         </div>
       </div>
   	</div>
  </div>
</div>
    
<c:import url="nav/footerClient.jsp"/>