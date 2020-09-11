package com.board.action;

import com.board.model.BoardDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import com.member.model.SMemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/write")
public class BoardWriteAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        SMemberDTO sessionUser = (SMemberDTO) session.getAttribute("user");

        if (sessionUser == null) {
            resp.sendRedirect("/project/member/login");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("boardWrite.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        BoardDTO board = BoardDTO.builder()
                .content(req.getParameter("content"))
                .writer(req.getParameter("writer"))
                .subject(req.getParameter("subject"))
                .passwd(req.getParameter("passwd"))
                .email(req.getParameter("email"))
                .ip(req.getRemoteAddr()).build();

        SBoardDAO dao = SBoardDAOImpl.getInstance();
        dao.boardInsert(board);

        resp.sendRedirect("list");
    }
}
