package com.product.action;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.product.model.ProductDAO;
import com.product.model.ProductDTO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/addProduct")
public class AddProductAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String savePath = "upload"; // 저장될 파일의 위치(폴더)
        int uploadFileSizeLimit = 5 * 1024 * 1024; // 최대 업로드 5mb로 제한
        String encType = "utf-8";
        ServletContext context = getServletContext();
        String uploadFilePath = context.getRealPath(savePath);
        System.out.println("서버상의 실제 디렉토리:" + uploadFilePath);

        MultipartRequest multi = new MultipartRequest(
                req, //request 객체
                uploadFilePath, // 서버상의 실제 디렉토리
                uploadFileSizeLimit, // 최대 업로드 파일 크기
                encType, // 인코딩 방법
                new DefaultFileRenamePolicy()
        );

        // 업로드된 파일 이름얻기
       /* String fileName = multi.getFilesystemName("uploadFile");
        System.out.println(fileName);
        if (fileName == null) {
            System.out.println("파일 업로드 안됨");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.print("글쓴이:" + multi.getParameter("name"));
            out.print("<br>제목:" + multi.getParameter("title"));
            out.print("<br>파일명:" + fileName);
        }*/


         String fileName = multi.getFilesystemName("filename");
        System.out.println(fileName);

        System.out.println("name:" + multi.getParameter("name"));
        ProductDAO dao = ProductDAO.getInstance();
        ProductDTO pd = ProductDTO.builder()
                .code(multi.getParameter("code"))
                .name(multi.getParameter("name"))
                .price(Long.parseLong(multi.getParameter("price")))
                .detail(multi.getParameter("detail"))
                .category(multi.getParameter("category"))
                .manufacturer(multi.getParameter("manufacturer"))
                .stock(Long.parseLong(multi.getParameter("stock")))
                .condition(multi.getParameter("condition"))
                .filename(fileName)
                .build();
        dao.productInsert(pd);

//        resp.sendRedirect("/project/product/productList.jsp");
        resp.sendRedirect("productList");
    }
}
