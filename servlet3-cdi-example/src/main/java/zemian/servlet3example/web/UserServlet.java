package zemian.servlet3example.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zemian.servlet3example.service.UserService;

@WebServlet("/user")
public class UserServlet extends HtmlWriterServlet {

    @Inject
    private UserService userService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> users = new ArrayList<>(userService.getUsers());
        Collections.sort(users);
        HtmlWriter html = createHtmlWriter(req, resp);
        html.header()
            .h(1, "List of Users")
            .ul(users)
            .footer();
    }
}
