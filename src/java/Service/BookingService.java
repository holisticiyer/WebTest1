package Service;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class BookingService {
    public static ArrayList<String> getVenues(String bookingDate) {
        ArrayList<String> availableVenues = new ArrayList<>();
        ArrayList<Model.Venue> vl = new ArrayList<>();
        SessionFactory factory = (new Configuration()).configure("Hibernate/hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        for(Object o:session.createQuery("from Venue as v").list())
            vl.add((Model.Venue) o);
        for(Model.Venue v:vl) {
            if(session.createQuery("from Booking as b where bookingId='" + v.getvenueName() +
                    bookingDate + "'").uniqueResult() == null)
                availableVenues.add("\"" + v.getvenueName() + "\"");
        }
        return availableVenues;
    }
}