package com.member.action;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/member/view")
public class ViewAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
        SMemberDAO dao = SMemberDAOImpl.getInstance();
        HttpSession session = req.getSession();
        SMemberDTO sessionUser = (SMemberDTO) session.getAttribute("user");

        /*if (dao.findById(userid) != null) {
            RequestDispatcher rd = req.getRequestDispatcher("/member/view.jsp");
            rd.forward(req, resp);
        }*/

        SMemberDTO md = dao.findById(sessionUser.getUserid());

        req.setCharacterEncoding("utf-8");
        /*req.setAttribute("userid", md.getUserid());
        req.setAttribute("email", md.getEmail());
        req.setAttribute("name", md.getName());
        req.setAttribute("phone", md.getPhone());*/
        req.setAttribute("member", md);
        RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
