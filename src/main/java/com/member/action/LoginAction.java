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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/login")
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userid = req.getParameter("userid");
        String pwd = req.getParameter("pwd");

        String encPwd = SHA256.getEncrypt(pwd, userid);

        SMemberDAO dao = SMemberDAOImpl.getInstance();
        SMemberDTO member = dao.memberLoginCheck(userid, encPwd);
        int flag = member.getAdmin();
        if (flag == 0 || flag == 1) {
            HttpSession session = req.getSession();
            session.setAttribute("user", member);
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(flag);
    }
}
