/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entity.Customer;
import Entity.ProductInCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phanh
 */
@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutServlet extends HttpServlet {

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
        Customer user = (Customer) session.getAttribute("user");

        ArrayList<ProductInCart> productsInCart = (ArrayList<ProductInCart>) session.getAttribute("productsInCart");
        if (request.getParameter("id").equals("checkoutAll")) {
            double total = 0;
            for (int i = 0; i < productsInCart.size(); i++) {
                total += productsInCart.get(i).getTotal();
            }
            
            productsInCart.get(0).createBill(total, user.getUsername(), user.getAddress(), user.getPhone(), user.getId());
            for (int i = 0; i < productsInCart.size(); i++) {
                productsInCart.get(i).createBillDetail();
            }
            for (int i = 0; i < productsInCart.size(); i++) {
                productsInCart.remove(i);
            }
            
            session.setAttribute("productsInCart", null);
            request.getRequestDispatcher("show-cart.jsp").forward(request, response);
        }
        for (int i = 0; i < productsInCart.size(); i++) {
            if (productsInCart.get(i).getId().equals(id)) {
                productsInCart.get(i).createBill(productsInCart.get(i).getTotal(), user.getUsername(), user.getAddress(), user.getPhone(), user.getId());
                productsInCart.get(i).createBillDetail();
                productsInCart.remove(i);
                session.setAttribute("productsInCart", productsInCart);
                request.getRequestDispatcher("show-cart.jsp").forward(request, response);
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
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
