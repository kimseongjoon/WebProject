package com.member.action;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/member/delete")
public class DeleteAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.setCharacterEncoding("utf-8");
        String userid = req.getParameter("userid");


        dao.memberDelete(userid);

        HttpSession session = req.getSession();
        session.invalidate();

        resp.sendRedirect("/project/member/login.jsp");*/




        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        SMemberDTO sessionUser = (SMemberDTO) session.getAttribute("user");
        String userid = sessionUser.getUserid();

        SMemberDAO dao = SMemberDAOImpl.getInstance();
        dao.memberDelete(userid);

        session.invalidate();
        resp.sendRedirect("login");
    }
}
