/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entity.Bill;
import Model.ProductModel;
import Entity.BillDetail;
import Entity.Product;
import Model.BillDetailModel;
import Model.BillModel;
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
public class BillDetailServlet extends HttpServlet {

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

        BillDetailModel billDetailModel = new BillDetailModel();

        if (session.getAttribute("admin") == null) {
            request.getRequestDispatcher("/admin").forward(request, response);
        } else {
            if (request.getParameter("isDone") == null) {
                int billId = Integer.parseInt(request.getParameter("id"));
                boolean status = Boolean.getBoolean(request.getParameter("status"));
                request.setAttribute("status", status);
                request.setAttribute("id", billId);
                request.setAttribute("passedServlet", true);
                ArrayList<BillDetail> billDetails = billDetailModel.findById(billId);
                ProductModel productModel = new ProductModel();
                for(int i = 0; i < billDetails.size(); i++){
                    billDetails.get(i).setProductName(productModel.findById(billDetails.get(i).getProductID()).getProductName());
                }
                
                double totalPrice = 0;
                for(int i = 0; i < billDetails.size(); i++){
                    totalPrice += billDetails.get(i).getPrice();
                }
                request.setAttribute("billDetails", billDetails);
                request.setAttribute("totalPrice", totalPrice);
                request.getRequestDispatcher("bill-detail.jsp").forward(request, response);
            } else {
                int billId = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("passedServlet", true);
                BillModel billModel = new BillModel();
                billModel.updateStatus(billId, true);
                ArrayList<BillDetail> billDetails = billDetailModel.findById(billId);
                request.setAttribute("billDetails", billDetails);
                request.getRequestDispatcher("bill-detail.jsp").forward(request, response);
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
            Logger.getLogger(BillDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BillDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
