package com.board.model;

import com.member.model.SMemberDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class SBoardDAOImpl implements SBoardDAO{
    static SBoardDAOImpl instance;

    public static SBoardDAOImpl getInstance() {
        if (instance == null) {
            instance = new SBoardDAOImpl();
        }
        return instance;
    }

    private SBoardDAOImpl() {

    }

    Connection getConnection() throws NamingException, SQLException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/ecommer");
        return ds.getConnection();
    }

    public void boardReplyInsert(BoardDTO board) {
        Connection con = null; // 디비 연결하는 객체
        PreparedStatement ps = null;
        String sql = "";

        int num = board.getNum();
        int ref = board.getRef();
        int re_step = board.getRe_step();
        int re_revel = board.getRe_level();

        try {
            con = getConnection();

            sql = "UPDATE BOARD SET RE_STEP = RE_STEP + 1 WHERE REF = ? AND RE_STEP > ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ref);
            ps.setInt(2, re_step);
            ps.executeUpdate();

            re_step = re_step + 1; // 부모 re_step에서 +1
            re_revel = re_revel + 1; // 부모 re_level에서 +1

            sql = "INSERT INTO BOARD(NUM, WRITER, SUBJECT, EMAIL, CONTENT, IP, REF, RE_STEP, RE_LEVEL, PASSWD) VALUES(BOARD_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
            ps = con.prepareStatement(sql); // 쿼리 실행하는 객체(문자열을 처리할때 statment객체 보다 조금더 편리)
            ps.setString(1, board.getWriter());
            ps.setString(2, board.getSubject());
            ps.setString(3, board.getEmail());
            ps.setString(4, board.getContent());
            ps.setString(5, board.getIp());
            ps.setInt(6, ref);
            ps.setInt(7, re_step);
            ps.setInt(8, re_revel);
            ps.setString(9, board.getPasswd());
//            ps.setString(12, board.getReg_date());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, null, null);
        }
    }

    @Override
    public void boardInsert(BoardDTO boardDTO) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, EMAIL, CONTENT, IP, REF, RE_STEP, RE_LEVEL, PASSWD) " +
                    "VALUES(BOARD_SEQ.nextval, ?, ?, ?, ?, ?, BOARD_SEQ.nextval, 0, 0, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, boardDTO.getWriter());
            ps.setString(2, boardDTO.getSubject());
            ps.setString(3, boardDTO.getEmail());
            ps.setString(4, boardDTO.getContent());
            ps.setString(5, boardDTO.getIp());
            ps.setString(6, boardDTO.getPasswd());

            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, ps, null);
        }
    }

    @Override
    public ArrayList<BoardDTO> findAll() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<BoardDTO> arr = new ArrayList<>();

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM BOARD";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                BoardDTO bd = BoardDTO.builder()
                        .content(rs.getString("CONTENT"))
                        .email(rs.getString("EMAIL"))
                        .ip(rs.getString("IP"))
                        .num(rs.getInt("NUM"))
                        .passwd(rs.getString("PASSWD"))
                        .re_level(rs.getInt("RE_LEVEL"))
                        .re_step(rs.getInt("RE_STEP"))
                        .readcount(rs.getInt("READCOUNT"))
                        .ref(rs.getInt("REF"))
                        .reg_date(rs.getString("REG_DATE"))
                        .subject(rs.getString("SUBJECT"))
                        .writer(rs.getString("WRITER"))
                        .build();

                arr.add(bd);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, st, null, rs);
        }

        return arr;
    }

    @Override
    public void boardUpdate(BoardDTO board) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String sql = "UPDATE BOARD SET SUBJECT=?, EMAIL=?, CONTENT=?, IP=?, PASSWD=? WHERE NUM=" + board.getNum();
            ps = con.prepareStatement(sql);
            ps.setString(1, board.getSubject());
            ps.setString(2, board.getEmail());
            ps.setString(3, board.getContent());
            ps.setString(4, board.getIp());
            ps.setString(5, board.getPasswd());

            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, ps, null);
        }
    }

    @Override
    public void boardDelete(int num) {
        Connection con = null;
        Statement st = null;

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "DELETE FROM BOARD WHERE NUM=" + num;
            st.executeQuery(sql);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, st, null, null);
        }
    }

    @Override
    public BoardDTO findByNum(int num) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        BoardDTO bd = null;

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM BOARD WHERE NUM=" + num;
            System.out.println("Board -> findByNum -> " + sql);

            rs = st.executeQuery(sql);

            if (rs.next()) {
                 bd = BoardDTO.builder()
                        .content(rs.getString("CONTENT"))
                        .email(rs.getString("EMAIL"))
                        .ip(rs.getString("IP"))
                        .num(rs.getInt("NUM"))
                        .passwd(rs.getString("PASSWD"))
                        .re_level(rs.getInt("RE_LEVEL"))
                        .re_step(rs.getInt("RE_STEP"))
                        .readcount(rs.getInt("READCOUNT"))
                        .ref(rs.getInt("REF"))
                        .reg_date(rs.getString("REG_DATE"))
                        .subject(rs.getString("SUBJECT"))
                        .writer(rs.getString("WRITER"))
                        .build();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, st, null, rs);
        }

        return bd;
    }

    @Override
    public int getBoardCount() {
        return getBoardCount("", "");
    }

    @Override
    public ArrayList<BoardDTO> findAll(int startRow, int endRow) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<BoardDTO> arr = new ArrayList<>();

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM BOARD where ROWNUM>=" + startRow + " and ROWNUM<=" + endRow;
            System.out.println("findAll -> " + sql);
            rs = st.executeQuery(sql);

            while (rs.next()) {
                BoardDTO bd = BoardDTO.builder()
                        .content(rs.getString("CONTENT"))
                        .email(rs.getString("EMAIL"))
                        .ip(rs.getString("IP"))
                        .num(rs.getInt("NUM"))
                        .passwd(rs.getString("PASSWD"))
                        .re_level(rs.getInt("RE_LEVEL"))
                        .re_step(rs.getInt("RE_STEP"))
                        .readcount(rs.getInt("READCOUNT"))
                        .ref(rs.getInt("REF"))
                        .reg_date(rs.getString("REG_DATE"))
                        .subject(rs.getString("SUBJECT"))
                        .writer(rs.getString("WRITER"))
                        .build();

                arr.add(bd);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, st, null, rs);
        }

        return arr;
    }

    @Override
    public int getBoardCount(String field, String word) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int result = 0;

        try {
            con = getConnection();
            st = con.createStatement();

            String sql = "SELECT count(*) FROM BOARD";
            if (!field.equals("")) {
                sql += " WHERE " + field + " LIKE '%" + word + "%'";
            }

            rs = st.executeQuery(sql);

            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, st, null, rs);
        }

        return result;
    }

    @Override
    public ArrayList<CommentDTO> findAllComment() {
        return null;
    }

    public ArrayList<CommentDTO> commentList(Long pnum) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<CommentDTO> arr = new ArrayList<>();
        String sql = "";

        try {
            con = getConnection();
            sql = "SELECT * FROM PRODUCTCOMMENTBOARD WHERE PNUM=" + pnum;

            System.out.println("commentList -> " + sql);

            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                CommentDTO cd = CommentDTO.builder().build();

                cd.setCNum(rs.getInt("CNUM"));
                cd.setUserId(rs.getString("USERID"));
                cd.setEmail(rs.getString("EMAIL"));
                cd.setMsg(rs.getString("MSG"));
                cd.setRegdate(rs.getString("REGDATE"));
                cd.setPNum(pnum);

                arr.add(cd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, st, null, rs);
        }

        return arr;
    }

    public void commentInsert(CommentDTO commentDTO) {
        Connection con = null; // 디비 연결하는 객체
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String sql = "INSERT INTO PRODUCTCOMMENTBOARD VALUES(COMMENTBOARD_SEQ.NEXTVAL, ?, ?, sysdate, ?, ?)";
            ps = con.prepareStatement(sql); // 쿼리 실행하는 객체(문자열을 처리할때 statment객체 보다 조금더 편리)
            ps.setString(1, commentDTO.getUserId());
            ps.setString(2, commentDTO.getMsg());
            ps.setLong(3, commentDTO.getPNum());
            ps.setString(4, commentDTO.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, null, null);
        }
    }

    void closeConnection(Connection con, Statement st, PreparedStatement ps, ResultSet rs) {
        try {
            if (con != null) con.close();
            if (st != null) st.close();
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
