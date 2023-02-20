<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"  %>

<body>
       <form method="get" action="enregistrementUtilisateur">
           <fieldset>
               <legend>Nouvel utilisateur</legend>
               <label for="nom">Nom</label>
               <input type="text" id="nom" name="nom"/>
               <br />
               <label for="age">Age</span></label>
               <input type="text" id="age" name="age" />
               <br />
               <input type="submit" value="Valider" />
               <br />
           </fieldset>
           <p>Pas encore de compte ? <a href="inscription">Créez en un !</a></p>
       </form>
</body>
</html>