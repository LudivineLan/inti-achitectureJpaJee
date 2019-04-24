<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--     declaration de la taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/bootstrap.css" />
</head>
<body>

<section class="container">
		<h1 id="top">Formulaire d'inscription</h1>
		
		<form action="ServletPersonne">
		
		<div class="form-group row">
			<input type="hidden" name="id" value="${id}"/>
			<label for="nom"> Nom</label> <input id="nom" 
				class="form-control" placeholder="Saisir votre nom" type="text" 
				name="nom" value="${nom}" required/>
		</div>

		<div class="form-group row">
			<label for="prenom"> Prenom</label> <input id="prenom" 
				class="form-control" placeholder="Saisir votre prénom" type="text" 
				name="prenom" value="${prenom}" required/>
		</div>

		<div class="form-group row">
			<label for="age"> Age</label> <input id="age" 
				class="form-control" placeholder="Saisir votre age" type="number" 
				name="age" value="${age}"required/>
		</div>
		
		<div class="form-group row">
			<label for="login"> Identifiant</label> <input id="login" 
				class="form-control" placeholder="Saisir votre identifiant" type="text" 
				name="login" value="${login}"required/>
		</div>
		
		<div class="form-group row">
			<label for="mdp"> Mot de passe</label> <input id="mdp" 
				class="form-control" placeholder="Saisir votre mot de passe" type="password" 
				name="mdp" value="${mdp}"required/>
		</div>


<!-- 		Liste déroulante des adresses -->
	<div class="form-group row">
		<select name="idadresse">
			<optgroup>
				<option value="0">---</option>
				<c:if test="${! empty adresses}">
				<c:forEach items="${adresses}" var="a">
					<option value="${a.idAdresse}"><c:out value="${a.numRue} ${a.nomRue} ${a.ville} ${a.cp}"></c:out></option>
				</c:forEach>
				</c:if>
			</optgroup>
		</select> 
	</div>
	
	
		<div>	
			<div class="clearfix">	
					<button type="submit" name="ajouter" value="Ajouter"class="btn btn-primary float">Ajouter</button>
						
					<button type="submit" name="modifier" value="Modifier" class="btn btn-primary float">Modifier</button>
			</div>
		</div>	
		
	
	
		
		</form>
		<div class="clearfix"></div>
	</section>
	<section class ="container">
	<h4 id="top">Liste des personnes en base de données</h4>
	<table class="table">
		<thead class="thead">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Age</th>
				<th>Identifiant</th>
				<th>Mot de passe</th>
				
				<th>Supprimer</th>
				<th>Modifier</th>
			</tr>
		</thead>
		
		<tbody>
			<!--si le tableau n'est pas vide -->
			<c:if test="${! empty personnes}">
				<c:forEach items="${personnes}" var="x">
				
					<tr>
						<td><c:out value="${x.id}"/></td>
						<td><c:out value="${x.nom}"/></td>
						<td><c:out value="${x.prenom}"/></td>
						<td><c:out value="${x.age}"/></td>
						<td><c:out value="${x.connexion.login}"/></td>
						<td><c:out value="${x.connexion.mdp}"/></td>
			
						<!-- passage de parametres par UML -->
						<td><a href="SupprimerPersonne?id=${x.id}">supprimer</a></td>
						<td><a href="ModifierPersonne?id=${x.id}">modifier</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
	</section>

</body>
</html>