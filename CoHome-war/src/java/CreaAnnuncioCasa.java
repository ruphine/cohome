/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.AnnuncioCasa;
import ejb.GestoreAnnunci;
import ejb.Opzione;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class CreaAnnuncioCasa extends HttpServlet {
    @EJB
    private GestoreAnnunci gestoreAnnunci;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Calendar dataGCI = new GregorianCalendar();
        Calendar dataGCF= new GregorianCalendar();
        String[] data = null;
        AnnuncioCasa annuncioCasa = new AnnuncioCasa();
        
        String informazione = request.getParameter("titolo");
        annuncioCasa.setTitolo(informazione);
        informazione = request.getParameter("indirizzo");
        annuncioCasa.setIndirizzo(informazione);
        informazione = request.getParameter("numeroPosti");
        annuncioCasa.setNumeroPosti(Integer.parseInt(informazione));
        informazione = request.getParameter("dataInizio");
        data = informazione.split("/");
        dataGCI.set(Integer.parseInt(data[0]),(Integer.parseInt(data[1]) -1),Integer.parseInt(data[2]));
        annuncioCasa.setDataInizio(dataGCI);
        informazione = request.getParameter("dataFine");
        data = informazione.split("/");
        dataGCF.set(Integer.parseInt(data[0]),(Integer.parseInt(data[1]) - 1),Integer.parseInt(data[2]));
        annuncioCasa.setDataFine(dataGCF);
        informazione = request.getParameter("descrizione");
        annuncioCasa.setDescrizione(informazione);
        informazione = request.getParameter("localita");
        annuncioCasa.setLocalita(informazione);
        annuncioCasa.setAttivo(true);
        //gestione opzioni
        informazione = request.getParameter("fumatori");
        List<Opzione> opzioni = annuncioCasa.getOpzioni();
        if (informazione!= null){
            Opzione opzione = new Opzione();
            opzione.setNome("fumatori");
            opzione.setValore("si");
            opzioni.add(opzione);
        }
        informazione = request.getParameter("animali");
        if (informazione!= null){
            Opzione opzione = new Opzione();
            opzione.setNome("animali");
            opzione.setValore("si");
            opzioni.add(opzione);
        }
        annuncioCasa.setOpzioni(opzioni);
        gestoreAnnunci.addAnnuncioCasa(annuncioCasa);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreaAnnuncioCasa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreaAnnuncioCasa at " + request.getContextPath() + "</h1>");
            out.println(informazione);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
