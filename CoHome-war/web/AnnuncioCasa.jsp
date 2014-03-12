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
        
        <script language="javascript" type="text/javascript" src="jquery.min.js"></script>
        <script type="text/javascript" src="jquery.ui.core.js"></script>
        <script type="text/javascript" src="jquery.ui.datepicker.js"></script>
        <!-- INCLUDERE LA SEGUENTE LINEA PER LA TRADUZIONE DEL WIDGET IN ITALIANO -->
        <script type="text/javascript" src="ui.datepicker-it.js"></script>

        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
      
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
                    
                    <td><label>Clicca sul campo per inserire la data di inizio</label></td>

                    <td id="dataInizio">
		        <input
			    name="dataInizio"
			    id="dataInizioId"
			    type="text"
			    maxlength="20"
			    size="20"
		        />
                    </td>

	            <script type="text/javascript">
		             $(document).ready(function(){
			          $('#dataInizioId').datepicker({ dateFormat: 'dd/mm/yy' });
		             });
	            </script>
                    
                </tr>
                <tr>
                    <td><label>Clicca sul campo per inserire la data di fine</label></td>
                    <!--
                    <td><input name="dataFine" type="text" size="20"/></td>
                    -->
                    <td id="dataFine">
		        <input
			    name="dataFine"
			    id="dataFineId"
			    type="text"
			    maxlength="20"
			    size="20"
		        />
                    </td>

	            <script type="text/javascript">
		             $(document).ready(function(){
			          $('#dataFineId').datepicker({ dateFormat: 'dd/mm/yy' });
		             });
	            </script>                    
                    
                    
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
        
   <!--     
	<div id="datepicker">
		<label>clicca sul campo per aprire il widget</label>
		<input
			name="datepicker"
			id="datepickerId"
			type="text"
			maxlength="10"
			size="10"
		/>
        </div>



	<script type="text/javascript">
		$(document).ready(function(){
			$('#datepickerId').datepicker({ dateFormat: 'dd/mm/yy' });
		});
	</script>
     -->   
    </body>
</html>
