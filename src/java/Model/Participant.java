package Model;
import java.util.Objects;
public class Participant {
    private String participantId;
    private int eventId;
    private String userEmail;
    private boolean isOrganizer, isParticipant, isGuest, isAttending;
    public String getparticipantId() {
        return participantId;
    }
    public void setparticipantId(String participantId) {
        this.participantId = participantId;
    }
    public int geteventId() {
        return eventId;
    }
    public void seteventId(int eventId) {
        this.eventId = eventId;
    }
    public String getuserEmail() {
        return userEmail;
    }
    public void setuserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public boolean getisOrganizer() {
        return isOrganizer;
    }
    public void setisOrganizer(boolean isOrganizer) {
        this.isOrganizer = isOrganizer;
    }
    public boolean getisParticipant() {
        return isParticipant;
    }
    public void setisParticipant(boolean isParticipant) {
        this.isParticipant = isParticipant;
    }
    public boolean getisGuest() {
        return isGuest;
    }
    public void setisGuest(boolean isGuest) {
        this.isGuest = isGuest;
    }
    public boolean getisAttending() {
        return isAttending;
    }
    public void setisAttending(boolean isAttending) {
        this.isAttending = isAttending;
    }
    public void changeStatus(int status) {
        switch(status) {
            case 1: isOrganizer = true; isParticipant = false; isGuest = false; break;
            case 2: isOrganizer = false; isParticipant = true; isGuest = false; break;
            case 3: isOrganizer = false; isParticipant = false; isGuest = true; break;
            default:isOrganizer = false; isParticipant = false; isGuest = false;
        }
    }
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Participant) {
            Participant p = (Participant) o;
            return(p.getparticipantId().equalsIgnoreCase(participantId));
        }
        else
            return false;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.participantId);
        return hash;
    }
}