/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.GestoreAnnunci;
import ejb.GestoreCommenti;
import ejb.GestoreUtenti;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author marco
 */
@WebServlet(urlPatterns = {"/MainServlet"})
//aggiunto
@MultipartConfig
public class MainServlet extends HttpServlet {
    @EJB
    private GestoreCommenti gestoreCommenti;
    @EJB
    private GestoreAnnunci gestoreAnnunci;
    @EJB
    private GestoreUtenti gestoreUtenti;
    

    private static String getFilename(Part part) {
       for (String cd : part.getHeader("content-disposition").split(";")) {
          if (cd.trim().startsWith("filename")) {
             String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
             return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
          }
       }
       return null;
    }    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action= request.getParameter("op");
        String str = "";
        RequestDispatcher rd;
        if(action.equals("inserisci")){
            str = request.getParameter("userComponent");
            gestoreUtenti.addModeratore(str);
            gestoreUtenti.addRegistered(str);
            gestoreUtenti.addGuest(str);
            gestoreAnnunci.addAnnuncioCasa(str);
            gestoreCommenti.addModeratoreCommenti(str);
            
        }
        
        if(action.equals("InserisciAnnuncioCasa")){
            rd = getServletContext().getRequestDispatcher("/AnnuncioCasa.jsp");
            rd.forward(request,response);
        }
  
        if(action.equals("creaAnnuncioCasa")){
            rd = getServletContext().getRequestDispatcher("/CreaAnnuncioCasa");
            rd.forward(request,response);
        }
        
        if(action.equals("uploadFoto")){
            Part filePart = request.getPart("nomeFile");
            
             //String nomeFile = getFilename(filePart);
            FileWriter fileWriter = new FileWriter("C:/immagini/prova.txt");
            BufferedWriter bufferedWriter=new BufferedWriter (fileWriter);
            bufferedWriter.write("viva arlecchina");
            
            BufferedReader readerBuffered = new BufferedReader(new InputStreamReader(filePart.getInputStream()));
            String line = null;
            while ((line = readerBuffered.readLine()) != null){
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.flush();
            }

        }
        //http://lancill.blogspot.it/2012/09/upload-di-un-file-in-java-con-le.html
        if(action.equals("uploadFoto2")){
            Part filePart = request.getPart("nomeFile");
            String nomeFile = getFilename(filePart);
            //System.out.println(nomeFile);
            InputStream inputStream = null;
            FileOutputStream outputStream = null;
            try{
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream("C:/immagini/" + nomeFile);
                int c;
                while ((c = inputStream.read()) != -1) { 
                    outputStream.write(c);
            }
            }finally{
                if(inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();  
                }
            }
        }               
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainServlet at " + request.getContextPath() + "</h1>");
            out.println(str);
            out.println(action);
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
