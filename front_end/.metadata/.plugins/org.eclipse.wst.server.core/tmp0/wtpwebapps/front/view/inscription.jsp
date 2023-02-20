<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"  %>

<body>
       <form method="post" action="inscription">
           <fieldset>
               <legend>Nouvel utilisateur</legend>
               <label for="Name">Nom</label>
               <input type="text" id="nom" name="Name"/>
               <br />
               <label for="Email">Email</span></label>
               <input type="Email" id="Email" name="Email" />
               <br />
               <label for="Password">Mot de passe</span></label>
               <input type="password" id="Password" name="Password" />
               <br>
               <input type="submit" value="Valider" />
               <br />
           </fieldset>
           <p>Vous avez déjà un compte ? <a href="connexion">Connectez-vous !</a></p>
       </form>
</body>
</html>