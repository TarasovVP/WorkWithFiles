
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;


@MultipartConfig
@WebServlet(
       name = "UploadServlet",
        urlPatterns = { "/"},
        loadOnStartup = 1
)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("upload.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("upload.jsp").forward(req, resp);
        req.setCharacterEncoding("UTF-8");

        Part filePart = null;
        String fileName = "";
        InputStream fileContent = null;

        try {
            filePart = req.getPart("file");
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            fileContent = filePart.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        DataBase db = new DataBase();
        db.insertName(name, surname);
        db.insertFile(fileName, fileContent);


    }
}
