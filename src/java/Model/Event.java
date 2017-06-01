package Model;
import java.util.ArrayList;
public class Event {
    private int eventId;
    private String eventName, eventType, eventDesc;
    private boolean isPublic;
    private ArrayList<Participant> participantList;
    private ArrayList<Venue> venueList;
    public int geteventId() {
        return eventId;
    }
    public void seteventId(int eventId) {
        this.eventId = eventId;
    }
    public String geteventName() {
        return eventName;
    }
    public void seteventName(String eventName) {
        this.eventName = eventName;
    }
    public String geteventType() {
        return eventType;
    }
    public void seteventType(String eventType) {
        this.eventType = eventType;
    }
    public String geteventDesc() {
        return eventDesc;
    }
    public void seteventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
    public boolean getisPublic() {
        return isPublic;
    }
    public void setisPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }
    public ArrayList<Participant> getparticipantList() {
        return participantList;
    }
    public ArrayList<Venue> getvenueList() {
        return venueList;
    }
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Event) {
            Event e = (Event) o;
            return((e.geteventId() == eventId));
        }
        else
            return false;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.eventId;
        return hash;
    }
}