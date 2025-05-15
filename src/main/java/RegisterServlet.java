import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RegisterServlet extends HttpServlet {
    List<User> usersList = new ArrayList<User>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        usersList.add(user);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Registration Successful</h2>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("<a href='register'>View registered users</a>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Registered Users</h2>");
        if (usersList.isEmpty()){
            out.println("<p>No users registered yet.</p>");
        }else{
            out.println("<ui>");
            for (User user:usersList){
                out.println("<li>"+user.getName()+"-"+user.getEmail()+"</li>");
            }
            out.println("</ui>");
        }
        out.println("<a href='index.html'>Go Back</a>");
    }
}

class User{
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
