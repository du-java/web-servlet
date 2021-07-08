package by.du;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/song")
public class SongController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("audio/mpeg");

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("song.mp3");
             ServletOutputStream os = resp.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int value;
            while ((value = is.read(buffer)) != -1) {
                os.write(buffer, 0, value);
            }
        }
    }
}
