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
import java.util.ArrayList;

@WebServlet("/board/list")
public class BoardListAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        SBoardDAO dao = SBoardDAOImpl.getInstance();
        int count = dao.getBoardCount();

        String pageNum = req.getParameter("pageNum");
        int currentPage = (pageNum == null)? 1 : Integer.parseInt(pageNum);
        int pageSize = 10;
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;

        ArrayList<BoardDTO> lists = dao.findAll(startRow, endRow);

        int totPage = count / pageSize + ((count % pageSize == 0)? 0 : 1);
        int pageBlock = 3;
        int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
        int endPage = startPage + pageBlock - 1;
        if (endPage > totPage) endPage = totPage;
        int rowNum = count - (currentPage - 1) * pageSize;

        req.setAttribute("totPage", totPage);
        req.setAttribute("pageBlock", pageBlock);
        req.setAttribute("startPage", startPage);
        req.setAttribute("endPage", endPage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("rowNo", rowNum);

        req.setAttribute("list", lists);
        req.setAttribute("count", count);

        resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher rd = req.getRequestDispatcher("boardList.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
