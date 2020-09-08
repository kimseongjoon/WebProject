package com.member.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class SMemberDAOImpl implements SMemberDAO{
    private static SMemberDAOImpl instance = null;
    public static SMemberDAOImpl getInstance() {
        if (instance == null) {
            instance = new SMemberDAOImpl();
        }
        return instance;
    }

    private SMemberDAOImpl() {
    }

    private Connection getConnection() throws NamingException, SQLException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/ecommer");
        return ds.getConnection();
    }
    @Override
    public void memberJoin(SMemberDTO memberDTO) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, memberDTO.getName());
            ps.setString(2, memberDTO.getUserid());
            ps.setString(3, memberDTO.getPwd());
            ps.setString(4, memberDTO.getEmail());
            ps.setString(5, memberDTO.getPhone());
            ps.setInt(6, memberDTO.getAdmin());

            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection(con, ps, null, null);
    }

    @Override
    public ArrayList<SMemberDTO> getMember() {
        return null;
    }

    @Override
    public int memberUpdate(SMemberDTO memberDTO) {
        return 0;
    }

    @Override
    public SMemberDTO findById(String userid) {
        return null;
    }

    @Override
    public void memberDelete(String userid) {

    }

    @Override
    public int memberCount() {
        return 0;
    }

    @Override
    public String memberIdCheck(String userid) {
        return null;
    }

    @Override
    public SMemberDTO memberLoginCheck(String userid, String pwd) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
//        int flag = -1;
        SMemberDTO member = SMemberDTO.builder().admin(-1).build();

        try {
            con = getConnection();
            String sql = "SELECT * FROM MEMBER WHERE USERID='" + userid + "'";

            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                if (rs.getString("PWD").equals(pwd)) {
                    member = SMemberDTO.builder()
                    .admin(rs.getInt("ADMIN"))
                    .name(rs.getString("NAME"))
                    .userid(rs.getString("USERID"))
                    .phone(rs.getString("PHONE"))
                    .email(rs.getString("EMAIL")).build();

                } else {
                    member = SMemberDTO.builder().admin(2).build();
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, rs);
        }

        return member;
    }

    private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
        try {
            if (con != null) con.close();
            if (ps != null) ps.close();
            if (st != null) st.close();
            if (rs != null) rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
