package com.product.model;

import com.board.model.BoardDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

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

            String sql = "INSERT INTO PRODUCT (ID, NAME, PRICE, DETAIL, CATEGORY, MANUFACTURER, STOCK, CONDITION, FILENAME, CODE) " +
                    "VALUES(PRODUCT_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, bd.getName());
            ps.setLong(2, bd.getPrice());
            ps.setString(3, bd.getDetail());
            ps.setString(4, bd.getCategory());
            ps.setString(5, bd.getManufacturer());
            ps.setLong(6, bd.getStock());
            ps.setString(7, bd.getCondition());
            ps.setString(8, bd.getFilename());
            ps.setString(9, bd.getCode());

            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, ps, null);
        }
    }


    public ArrayList<ProductDTO> getProducts() {
        ArrayList<ProductDTO> arr = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM PRODUCT";
            System.out.println("getProducts -> " + sql);
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ProductDTO pd = ProductDTO.builder()
                        .id(rs.getLong("ID"))
                        .name(rs.getString("NAME"))
                        .price(rs.getLong("PRICE"))
                        .detail(rs.getString("DETAIL"))
                        .category(rs.getString("CATEGORY"))
                        .manufacturer(rs.getString("MANUFACTURER"))
                        .stock(rs.getLong("STOCK"))
                        .condition(rs.getString("CONDITION"))
                        .filename(rs.getString("FILENAME"))
                        .code(rs.getString("CODE"))
                        .build();

                arr.add(pd);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return arr;
    }

    public ProductDTO findById(int id) {
        ArrayList<ProductDTO> arr = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ProductDTO pd = null;

        try {
            con = getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM PRODUCT WHERE ID=" + id;
            System.out.println("findById -> " + sql);
            rs = st.executeQuery(sql);

            if (rs.next()) {
                pd = ProductDTO.builder()
                        .id(rs.getLong("ID"))
                        .name(rs.getString("NAME"))
                        .price(rs.getLong("PRICE"))
                        .detail(rs.getString("DETAIL"))
                        .category(rs.getString("CATEGORY"))
                        .manufacturer(rs.getString("MANUFACTURER"))
                        .stock(rs.getLong("STOCK"))
                        .condition(rs.getString("CONDITION"))
                        .filename(rs.getString("FILENAME"))
                        .code(rs.getString("CODE"))
                        .build();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pd;
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
