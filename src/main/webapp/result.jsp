<c:import url="nav/headerClient.jsp"/>

<body>
	<center>
		<h3><%=request.getAttribute("Message")%></h3>
		<a href="${index }" ><c:out value="Revenir a l'accueil"></c:out></a>
	</center>
</body>

<c:import url="nav/footerClient.jsp"/>