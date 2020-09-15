package com.product.action;

import com.product.model.ProductDAO;
import com.product.model.ProductDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/productDetail")
public class productDetailAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));

        ProductDAO dao = ProductDAO.getInstance();
        ProductDTO pd = dao.findById(id);
        req.setAttribute("pd", pd);

        resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher rd = req.getRequestDispatcher("productDetail.jsp");
        rd.forward(req, resp);

    }
}
