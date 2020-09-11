package com.product.model;

import com.board.model.BoardDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class ProductDAO {
    static ProductDAO instance;

    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }

    private ProductDAO() {

    }

    private Connection getConnection() throws NamingException, SQLException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/ecommer");
        return ds.getConnection();
    }

    public void productInsert(ProductDTO bd) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String sql = "INSERT INTO PRODUCT (ID, NAME, PRICE, DETAIL, CATEGORY, MANUFACTURER, STOCK, CONDITION, FILENAME) " +
                    "VALUES(PRODUCT_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, bd.getName());
            ps.setLong(2, bd.getPrice());
            ps.setString(3, bd.getDetail());
            ps.setString(4, bd.getCategory());
            ps.setString(5, bd.getManufacturer());
            ps.setLong(6, bd.getStock());
            ps.setString(7, bd.getCondition());
            ps.setString(8, bd.getFilename());

            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, ps, null);
        }
    }

    private void closeConnection(Connection con, Statement st, PreparedStatement ps, ResultSet rs) {
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
