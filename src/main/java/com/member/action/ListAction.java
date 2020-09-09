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
import java.util.ArrayList;

@WebServlet("/member/list")
public class ListAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SMemberDAO dao = SMemberDAOImpl.getInstance();
        ArrayList<SMemberDTO> arr = dao.getMember();

        HttpSession session = req.getSession();
        SMemberDTO sessionUser = (SMemberDTO) session.getAttribute("user");

        req.setAttribute("adminid", sessionUser.getUserid());
        req.setAttribute("members", arr);
        int count = dao.memberCount();
        req.setAttribute("count", count);

        RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
        rd.forward(req, resp);
    }
}
