<%-- 
    Document   : AnnuncioCasa
    Created on : 28-feb-2014, 17.43.21
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuncio casa</title>
    </head>
    <body>
        <h1>Inserisci i dati dell'annuncio della disponibilita' di una casa</h1>
        
        <form name="f1" method="POST" action="/CoHome-war/MainServlet">
            <table
                <tr>
                    <td><label>Titolo</label></td>
                    <td><input name="titolo" type="text" size="20"/></td>
                </tr>                
                <tr>
                    <td><label>Indirizzo</label></td>
                    <td><input name="indirizzo" type="text" size="20"/></td>
                </tr>
                <tr>
                    <td><label>Numero posti</label></td>
                    <td><input name="numeroPosti" type="text" size="20"/></td>
                </tr>
                <tr>
                    <td><label>Data inizio(aaaa/mm/gg)</label></td>
                    <td><input name="dataInizio" type="text" size="20"/></td>
                </tr>
                <tr>
                    <td><label>Data fine (aaaa/mm/gg)</label></td>
                    <td><input name="dataFine" type="text" size="20"/></td>
                </tr>  
                <tr>
                    <td><label>Descrizione</label></td>
                    <td><input name="descrizione" type="text" size="20"/></td>
                </tr>   
                <tr>
                    <td><label>Localita'</label></td>
                    <td><input name="localita" type="text" size="20"/></td>
                </tr>
                <tr><td>Fumatori<input type="checkbox" name="fumatori" value="fumatori"  checked=""></td></tr>
                <tr><td>Animali<input type="checkbox" name="animali" value="animali"  checked=""></td></tr>
            </table>
            <input type="submit" value="invio"/>
            <input type="hidden" name="op" value="creaAnnuncioCasa">
        </form>
    </body>
</html>
