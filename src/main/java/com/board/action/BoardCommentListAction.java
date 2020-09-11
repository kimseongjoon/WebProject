package com.board.action;

import com.board.model.CommentDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/board/commentList")
public class BoardCommentListAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String bnum = req.getParameter("bnum");

        SBoardDAO dao = SBoardDAOImpl.getInstance();
        ArrayList<CommentDTO> commentDTOS = ((SBoardDAOImpl)dao).commentList(bnum);

        JSONArray jarr = new JSONArray();

        for (CommentDTO dto : commentDTOS) {
            JSONObject obj = new JSONObject();

            obj.put("msg", dto.getMsg());
            obj.put("userid", dto.getUserId());
            obj.put("regdate", dto.getRegdate());

            jarr.add(obj);
        }

        JSONObject mainObj = new JSONObject();
        mainObj.put("jarr", jarr);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(mainObj);
    }
}
