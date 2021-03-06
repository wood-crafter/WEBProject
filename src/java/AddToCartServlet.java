/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entity.ProductInCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phanh
 */
public class AddToCartServlet extends HttpServlet {

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
        String id = request.getParameter("id");
//No product in cart yet
        if (session.getAttribute("productsInCart") == null) {
            ProductInCart nextProduct = new ProductInCart(id);
            nextProduct.addOne();

            ArrayList<ProductInCart> productsInCart = new ArrayList<>();
            productsInCart.add(nextProduct);
            session.setAttribute("productsInCart", productsInCart);
            request.getRequestDispatcher("home.jsp").forward(request, response);
//Cart contain products
        } else {
//Already have product with this request id in cart -> Add one
            boolean isContained = false;
            ArrayList<ProductInCart> productsInCart = (ArrayList<ProductInCart>) session.getAttribute("productsInCart");
            for (int i = 0; i < productsInCart.size(); i++) {
                if (productsInCart.get(i).getId().equals(id)) {
                    productsInCart.get(i).addOne();
                    session.setAttribute("productsInCart", productsInCart);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                    isContained = true;
                }
            }
//No product with request id in cart yet
            if (!isContained) {
                ProductInCart nextProduct = new ProductInCart(id);
                nextProduct.addOne();
                productsInCart.add(nextProduct);
                session.setAttribute("productsInCart", productsInCart);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
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
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
