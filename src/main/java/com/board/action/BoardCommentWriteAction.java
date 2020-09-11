package com.board.action;

import com.board.model.CommentDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import com.member.model.SMemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/board/commentWrite")
public class BoardCommentWriteAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        SMemberDTO sessionUser = (SMemberDTO) session.getAttribute("user");


        if (sessionUser != null) {
            String userid = sessionUser.getUserid();
            req.setCharacterEncoding("utf-8");

            CommentDTO cd = CommentDTO.builder()
                    .userId(userid)
                    .bNum(req.getParameter("bnum"))
                    .msg(req.getParameter("comment"))
                    .build();

            SBoardDAO dao = SBoardDAOImpl.getInstance();
            ((SBoardDAOImpl)dao).commentInsert(cd);
        } else {
            PrintWriter out = resp.getWriter();
            out.print(1);
        }
    }
}
