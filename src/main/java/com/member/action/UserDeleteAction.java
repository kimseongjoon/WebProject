package com.member.action;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;
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

@WebServlet("/member/userdelete")
public class UserDeleteAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userid = req.getParameter("userid");

        SMemberDAO dao = SMemberDAOImpl.getInstance();
        dao.memberDelete(userid);

        ArrayList<SMemberDTO> arr = dao.getMember();

        JSONArray jarr = new JSONArray();

        for (SMemberDTO dto : arr) {
            JSONObject obj = new JSONObject();

            obj.put("name", dto.getName());
            obj.put("userid", dto.getUserid());
            obj.put("phone", dto.getPhone());
            obj.put("email", dto.getEmail());
            obj.put("admin", dto.getAdmin());

            jarr.add(obj);
        }

        int count = dao.memberCount();
        JSONObject mainObj = new JSONObject();
        mainObj.put("jarr", jarr);
        mainObj.put("count", count);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(mainObj);
    }
}
