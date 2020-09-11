package com.member.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class SMemberDAOImpl implements SMemberDAO {
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
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<SMemberDTO> arr = new ArrayList<>();

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM MEMBER";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                SMemberDTO md = SMemberDTO.builder()
                        .userid(rs.getString("USERID"))
//                        .pwd(rs.getString("PWD"))
                        .admin(rs.getInt("ADMIN"))
                        .email(rs.getString("EMAIL"))
                        .name(rs.getString("NAME"))
                        .phone(rs.getString("PHONE"))
                        .build();

                arr.add(md);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, rs);
        }

        return arr;
    }

    @Override
    public int memberUpdate(SMemberDTO memberDTO) {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            con = getConnection();
            String sql = "UPDATE MEMBER SET NAME=?, PWD=?, EMAIL=?, PHONE=?, ADMIN=? WHERE USERID='" + memberDTO.getUserid() + "'";
            System.out.println("memberUpdate -> " + sql);
            System.out.println("NAME : " + memberDTO.getName());
            System.out.println("PWD : " + memberDTO.getPwd());
            System.out.println("EMAIL : " + memberDTO.getEmail());
            System.out.println("PHONE : " + memberDTO.getPhone());
            System.out.println("ADMIN : " + memberDTO.getAdmin());
            ps = con.prepareStatement(sql);
            ps.setString(1, memberDTO.getName());
            ps.setString(2, memberDTO.getPwd());
            ps.setString(3, memberDTO.getEmail());
            ps.setString(4, memberDTO.getPhone());
            ps.setInt(5, memberDTO.getAdmin());

            result = ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, ps, null, null);
        }

        return result;
    }

    @Override
    public SMemberDTO findById(String userid) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        SMemberDTO md = null;

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM MEMBER WHERE USERID='" + userid + "'";
            System.out.println("findById -> " + sql);
            rs = st.executeQuery(sql);

            if (rs.next()) {
                md = SMemberDTO.builder()
                        .userid(rs.getString("USERID"))
                        .admin(rs.getInt("ADMIN"))
                        .pwd(rs.getString("PWD"))
                        .email(rs.getString("EMAIL"))
                        .name(rs.getString("NAME"))
                        .phone(rs.getString("PHONE"))
                        .build();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, rs);
        }

        return md;
    }

    @Override
    public void memberDelete(String userid) {
        Connection con = null;
        Statement st = null;

        try {
            con = getConnection();
            st = con.createStatement();

//            String sql = "DELETE FROM MEMBER WHERE USERID='" + userid + "' AND ADMIN<>1";
            String sql = "DELETE FROM MEMBER WHERE USERID='" + userid + "'";
            System.out.println("memberDelete -> " + sql);
            st.executeQuery(sql);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, null);
        }
    }

    @Override
    public int memberCount() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int result = 0;

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "SELECT count(*) FROM MEMBER";
            rs = st.executeQuery(sql);

            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, rs);
        }

        return result;
    }

    @Override
    public String memberIdCheck(String userid) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String result = "yes";

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM MEMBER WHERE USERID='" + userid + "'";
            System.out.println("memberIdCheck -> " + sql);
            rs = st.executeQuery(sql);

            if (rs.next()) {
                result = "no";
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, rs);
        }

        return result;
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
            System.out.println("memberLoginCheck -> " + sql);

            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                if (rs.getString("PWD").equals(pwd)) {

                    member.setAdmin(rs.getInt("ADMIN"));
                    member.setEmail(rs.getString("EMAIL"));
                    member.setPhone(rs.getString("PHONE"));
                    member.setName(rs.getString("NAME"));
                    member.setUserid(rs.getString("USERID"));

                } else {
                    member.setAdmin(-2);
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
