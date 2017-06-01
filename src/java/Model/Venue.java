package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
public class Venue {
    private String venueName, venueAddr;
    private ArrayList<Date> dateBooked;
    private ArrayList<Integer> eventBooked;
    public String getvenueName() {
        return venueName;
    }
    public void setvenueName(String venueName) {
        this.venueName = venueName;
    }
    public String getvenueAddr() {
        return venueAddr;
    }
    public void setvenueAddr(String venueAddr) {
        this.venueAddr = venueAddr;
    }
    public ArrayList<Date> getDates(int eventId) {
        if(eventBooked != null && dateBooked != null) {
            ArrayList<Date> listOfDates = new ArrayList<>();
            Iterator i = eventBooked.iterator();
            Iterator j = dateBooked.iterator();
            while(i.hasNext() && j.hasNext()) {
                if((int) i.next() == eventId)
                    listOfDates.add((Date) j.next());
                else
                    j.next();
            }
            return listOfDates;
        }
        else
            return null;
    }
    public ArrayList<Integer> getEventIds(Date d) {
        if(dateBooked != null && eventBooked != null) {
            ArrayList<Integer> listOfEvents = new ArrayList<>();
            Iterator i = dateBooked.iterator();
            Iterator j = eventBooked.iterator();
            while(i.hasNext() && j.hasNext()) {
                if(((Date) i.next()).equals(d))
                    listOfEvents.add((int) j.next());
                else
                    j.next();
            }
            return listOfEvents;
        }
        else
            return null;
    }
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Venue) {
            Venue v = (Venue) o;
            return(v.getvenueName().equalsIgnoreCase(venueName));
        }
        else
            return false;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.venueName);
        return hash;
    }
}