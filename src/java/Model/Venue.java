package Model;
import java.util.Objects;
public class Venue {
    private String venueName, venueAddr;
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