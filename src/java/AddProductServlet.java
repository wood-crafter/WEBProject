/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.ProductModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phanh
 */
@MultipartConfig
public class AddProductServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ProductModel productModel = new ProductModel();

        if (session.getAttribute("admin") == null) {
            request.getRequestDispatcher("/admin").forward(request, response);
            return;
        }

        if (request.getMethod().equals("GET")) {
            request.getRequestDispatcher("product-add.jsp").forward(request, response);
            return;
        }

        String id = is2String(request.getPart("id").getInputStream());
        
        if (productModel.findById(id) != null) {
            request.setAttribute("isIdExisted", true);
                request.getRequestDispatcher("product-add.jsp").forward(request, response);
                return;
        }
        String name = is2String(request.getPart("name").getInputStream());
        int quantity = Integer.parseInt(is2String(request.getPart("quantity").getInputStream()));
        double price = Double.parseDouble(is2String(request.getPart("price").getInputStream()));
        String descriptions = is2String(request.getPart("descriptions").getInputStream());
        String cateId = is2String(request.getPart("cateId").getInputStream());
        
        
        InputStream fileStream = request.getPart("file").getInputStream();
        OutputStream os = null;
        String destPath = "C:\\Users\\phanh\\Documents\\NetBeansProjects\\JavaWeb101\\WEBProject\\web\\image\\" + id + ".png";
        
        try {
            os = new FileOutputStream(destPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileStream.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            fileStream.close();
            os.close();
        }
        
        
        productModel.insert(id, name, quantity, price, destPath, descriptions, cateId);
        
        request.getRequestDispatcher("product-add.jsp").forward(request, response);
    }

    public String is2String(InputStream is) {
        StringBuilder buffer = new StringBuilder();
        Scanner scanner = new Scanner(is);

        while (scanner.hasNext()) {
            buffer.append(scanner.nextLine());
        }

        return buffer.toString();
    }

    public static void copyFile(String from, String to) throws IOException {

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(from);
            os = new FileOutputStream(to);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
