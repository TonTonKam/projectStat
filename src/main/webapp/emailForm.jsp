<c:import url="nav/headerClient.jsp"/>

<body>
	<form action="emailSendingServlet" method="post">
		<table border="0" width="35%" align="center">
			<caption><h2><c:out value="Vous pourrez creer votre nouveau mot de passe via l'email que vous allez recevoir. Cordialement de la part de la direction"/></h2></caption>
			<tr>
				<td width="50%">Entrez votre adresse e-mail </td>
				<td><input type="text" name="recipient" size="50"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Send"/></td>
			</tr>
		</table>
		
	</form>
</body>

<c:import url="nav/footerClient.jsp"/>