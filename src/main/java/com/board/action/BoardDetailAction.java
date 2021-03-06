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

@WebServlet("/board/detail")
public class BoardDetailAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int num = Integer.parseInt(req.getParameter("num"));

        SBoardDAO dao = SBoardDAOImpl.getInstance();
        BoardDTO bd = dao.findByNum(num);

        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("board", bd);
        RequestDispatcher rd = req.getRequestDispatcher("boardView.jsp");
        rd.forward(req, resp);
    }
}
