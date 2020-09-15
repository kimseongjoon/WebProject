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
import java.util.ArrayList;

@WebServlet("/product/productList")
public class ProductListAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        ProductDAO dao = ProductDAO.getInstance();
        ArrayList<ProductDTO> arr = dao.getProducts();
        req.setAttribute("arr", arr);

        resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher rd = req.getRequestDispatcher("productList.jsp");
        rd.forward(req, resp);
    }
}
