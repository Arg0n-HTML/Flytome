<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"  %>

<body>
       <form method="post" action="inscription">
           <fieldset>
               <legend>Nouvel utilisateur</legend>
               <label for="name">Nom</label>
               <input type="text" id="nom" name="name"/>
               <br />
               <label for="competence1">Compétence numéro 1</label>
               <select name="competence1" id="competence1">
    				<option value="1">Incendie</option>
    				<option value="2">Accident routier</option>
    				<option value="3">Accident fluvial</option>
    				<option value="4">Eboulement</option>
    				<option value="5">Invasion de serpent</option>
    				<option value="6"> Fuite de gaz</option>
    				<option value="7">Manifestation</option>
    				<option value="8"> Braquage</option>
    				<option value="9">Evasion d’un prisonnier</option>
				</select>
				<br />
				<label for="competence2">Compétence numéro 2</label>
               <select name="competence2" id="competence2">
               		<option value="10">Aucune</option>
    				<option value="1">Incendie</option>
    				<option value="2">Accident routier</option>
    				<option value="3">Accident fluvial</option>
    				<option value="4">Eboulement</option>
    				<option value="5">Invasion de serpent</option>
    				<option value="6"> Fuite de gaz</option>
    				<option value="7">Manifestation</option>
    				<option value="8"> Braquage</option>
    				<option value="9">Evasion d’un prisonnier</option>
				</select>
				<br />
				<label for="competence3">Compétence numéro 3</label>
               <select name="competence3" id="competence3">
               		<option value="10">Aucune</option>
    				<option value="1">Incendie</option>
    				<option value="2">Accident routier</option>
    				<option value="3">Accident fluvial</option>
    				<option value="4">Eboulement</option>
    				<option value="5">Invasion de serpent</option>
    				<option value="6"> Fuite de gaz</option>
    				<option value="7">Manifestation</option>
    				<option value="8"> Braquage</option>
    				<option value="9">Evasion d’un prisonnier</option>
				</select>
				<br />
               <label for="email">Email</label>
               <input type="Email" id="Email" name="email" />
               <br />
               <label for="password">Mot de passe</label>
               <input type="password" id="Password" name="password" />
               <br>
               <label for="telephone">Numéro de Téléphone</label>
               <input type="text" id="Password" name="telephone" />
               <br>
               <label for="location">Adresse</label>
               <input type="text" id="habitation" name="habitation" />
               <br>
               <input type="submit" value="Valider" />
               <br />
           </fieldset>
           <!-- <p>Vous avez déjà un compte ? <a href="connexion">Connectez-vous !</a></p> -->
       </form>
</body>
</html>