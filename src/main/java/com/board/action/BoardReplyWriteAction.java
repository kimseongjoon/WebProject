package com.board.action;

import com.board.model.BoardDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/replywrite")
public class BoardReplyWriteAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        SBoardDAO dao = SBoardDAOImpl.getInstance();

        BoardDTO bd = BoardDTO.builder()
                .num(Integer.parseInt(req.getParameter("num")))
                .ref(Integer.parseInt(req.getParameter("ref")))
                .re_level(Integer.parseInt(req.getParameter("re_level")))
                .re_step(Integer.parseInt(req.getParameter("re_step")))
                .build();

        req.setAttribute("bean", bd);

        resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher rd = req.getRequestDispatcher("boardReplyWrite.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        BoardDTO bd = BoardDTO.builder()
                .subject(req.getParameter("subject"))
                .content(req.getParameter("content"))
                .email(req.getParameter("email"))
                .passwd(req.getParameter("passwd"))
                .ref(Integer.parseInt(req.getParameter("ref")))
                .re_level(Integer.parseInt(req.getParameter("re_level")))
                .re_step(Integer.parseInt(req.getParameter("re_step")))
                .ip(req.getRemoteAddr()).build();

        SBoardDAO dao = SBoardDAOImpl.getInstance();
        ((SBoardDAOImpl) dao).boardReplyInsert(bd);

        resp.sendRedirect("list");

    }
}
