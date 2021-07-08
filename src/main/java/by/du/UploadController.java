package by.du;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@MultipartConfig
@WebServlet("/upload")
public class UploadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("uploadFile");

        try (InputStream is = file.getInputStream();
             final OutputStream os = Files.newOutputStream(Paths.get(file.getSubmittedFileName()))) {
            byte[] buffer = new byte[4096];
            int value;
            while ((value = is.read(buffer)) != -1) {
                os.write(buffer, 0, value);
            }
        }
        req.getRequestDispatcher("/WEB-INF/uploaded.jsp").forward(req, resp);
    }
}
