package com.member.action;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;
import com.member.util.SHA256;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/join")
public class JoinAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("join.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        SMemberDAO dao = SMemberDAOImpl.getInstance();

        int admin=0;
        String isAdmin = req.getParameter("admin");
        if (isAdmin != null) {
            admin = Integer.parseInt(isAdmin);
        }
        
        String userid = req.getParameter("userid");
        String encPwd = SHA256.getEncrypt(req.getParameter("pwd"), userid);

        SMemberDTO md = SMemberDTO.builder()
                .name(req.getParameter("name"))
                .userid(userid)
                .pwd(encPwd)
//                .pwd(req.getParameter("pwd"))
                .email(req.getParameter("email"))
                .phone(req.getParameter("phone"))
                .admin(admin)
                .build();

        dao.memberJoin(md);

        resp.sendRedirect("login");
    }
}
