package Controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.hibernate.Transaction;
public class EventServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            String click = request.getParameter("click");
            HttpSession hs = request.getSession(false);
            Model.User u = (Model.User) hs.getAttribute("thisUser");
            Model.Event e;
            Model.Participant p;
            ArrayList<Model.Participant> pl;
            ArrayList<Model.Venue> vl;
            SessionFactory factory = (new Configuration()).configure("Hibernate/hibernate.cfg.xml").buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            RequestDispatcher rd;
            switch(click) {
                case "Add New Event":   e = new Model.Event();
                                        e.seteventName("");
                                        e.seteventType("");
                                        e.seteventDesc("");
                                        e.setisPublic(true);
                                        hs.setAttribute("thisEvent", e);
                                        p = new Model.Participant();
                                        p.seteventId(e.geteventId());
                                        p.setuserEmail(u.getuserEmail());
                                        p.setrole("Organizer");
                                        pl = new ArrayList<>();
                                        pl.add(p);
                                        request.setAttribute("myParticipants", pl);
                                        vl = new ArrayList<>();
                                        for(Object o:session.createQuery("from Venue as v").list())
                                            vl.add((Model.Venue) o);
                                        request.setAttribute("myVenues", vl);
                                        rd = request.getRequestDispatcher("AddNewEvent.jsp");
                                        break;
                case "Book Event":      e = (Model.Event) hs.getAttribute("thisEvent");
                                        e.seteventName((String) request.getParameter("eventName"));
                                        e.seteventType((String) request.getParameter("eventType"));
                                        e.seteventDesc((String) request.getParameter("eventDesc"));
                                        e.seteventDate((String) request.getParameter("eventDate"));
                                        e.setvenueName((String) request.getParameter("venueName"));
                                        e.setisPublic(request.getParameter("isPublic").equals("yes"));
                                        Model.Booking b;
                                        if((b = (Model.Booking) hs.getAttribute("thisBooking")) != null)
                                            session.delete(b);
                                        b = new Model.Booking();
                                        b.setvenueName(e.getvenueName());
                                        b.setbookingDate(e.geteventDate());
                                        b.setbookingId(b.getvenueName() + b.getbookingDate());
                                        session.save(e);
                                        session.save(b);
                                        tx.commit();
                                        hs.setAttribute("thisEvent", e);
                                        p = new Model.Participant();
                                        p.seteventId(e.geteventId());
                                        p.setuserEmail(u.getuserEmail());
                                        p.setrole("Organizer");
                                        pl = new ArrayList<>();
                                        pl.add(p);
                                        request.setAttribute("myParticipants", pl);
                                        vl = new ArrayList<>();
                                        for(Object o:session.createQuery("from Venue as v").list())
                                            vl.add((Model.Venue) o);
                                        request.setAttribute("myVenues", vl);
                                        rd = request.getRequestDispatcher("AddNewEvent.jsp");
                                        break;
                case "Add Participant": e = (Model.Event) hs.getAttribute("thisEvent");
                                        p = new Model.Participant();
                                        p.seteventId(e.geteventId());
                                        p.setuserEmail(u.getuserEmail());
                                        p.setrole((String) request.getParameter("role"));
                                        p.setparticipantId(p.geteventId() + p.getuserEmail());
                                        session.save(p);
                                        tx.commit();
                                        hs.setAttribute("thisEvent", e);
                                        p = new Model.Participant();
                                        p.seteventId(e.geteventId());
                                        p.setuserEmail(u.getuserEmail());
                                        p.setrole("Organizer");
                                        pl = new ArrayList<>();
                                        pl.add(p);
                                        request.setAttribute("myParticipants", pl);
                                        vl = new ArrayList<>();
                                        for(Object o:session.createQuery("from Venue as v").list())
                                            vl.add((Model.Venue) o);
                                        request.setAttribute("myVenues", vl);
                                        rd = request.getRequestDispatcher("AddNewEvent.jsp");
                                        break;
                default:                rd = request.getRequestDispatcher("Home.jsp");
            }
            session.close();
            factory.close();
            rd.include(request, response);
        } catch(Exception ex) {}
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
           PrintWriter out = response.getWriter();
           String selecteddate = request.getParameter("selectedDate");
           Service.BookingService bookingObj = new Service.BookingService();           
           ArrayList<String> availableVenues = bookingObj.getVenues(selecteddate);
           System.out.println(" availableVenues : "+availableVenues);
           response.setContentType("text/html;charset=UTF-8");
           response.getWriter().write(availableVenues+"");
        }catch(Exception e){}
    
     
    }
}