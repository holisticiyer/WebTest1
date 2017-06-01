package Controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Query;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            SessionFactory factory = (new Configuration()).configure("Hibernate/hibernate.cfg.xml").buildSessionFactory();
            Session session = factory.openSession();
            Query q = session.createQuery("from User as u where " +
                    "u.userEmail='" + request.getParameter("userEmail") + "' and " +
                    "u.userPassword='" + request.getParameter("userPassword") + "'");
            Model.User u; RequestDispatcher rd;
            if((u = (Model.User) q.uniqueResult()) != null) {
                session.close();
                factory.close();
                HttpSession hs = request.getSession();
                hs.setAttribute("thisUser", u);
                hs.setAttribute("userEmail", u.getuserEmail());
                hs.setAttribute("userPassword", u.getuserPassword());
                if(request.getParameter("doRemember") == null)
                    hs.setAttribute("doRemember", "no");
                else if(request.getParameter("doRemember").equals("yes"))
                    hs.setAttribute("doRemember", "yes");
                request.setAttribute("click", "Home");
                rd = request.getRequestDispatcher("click");
                rd.forward(request, response);
            }
            else {
                session.close();
                factory.close();
                PrintWriter out = response.getWriter();
                out.print("<font color=\"red\">Invalid Credentials.</font>");
                rd = request.getRequestDispatcher("Login.jsp");
                rd.include(request, response);
            }
        } catch(Exception ex) {}
    }
}