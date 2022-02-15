<c:import url="nav/headerClient.jsp"/>


<body>
	<center>
		<h3><% String msg = (String)request.getAttribute("message");
		   out.println(msg);
		%></h3>
		<a href="${upload }" ><c:out value="Revenir pour ajouter votre photo"></c:out></a>
	</center>
</body>



<c:import url="nav/footerClient.jsp"/>