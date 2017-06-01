package Model;
import java.io.Serializable;
import java.util.Objects;
public class User implements Serializable {
    private String userEmail, userPassword, fName, lName, phone;
    private boolean isAdmin;
    public String getuserEmail() {
        return userEmail;
    }
    public void setuserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getuserPassword() {
        return userPassword;
    }
    public void setuserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean getisAdmin() {
        return isAdmin;
    }
    public void setisAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof User) {
            User u = (User) o;
            return((u.getuserEmail().equalsIgnoreCase(userEmail)));
        }
        else
            return false;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.userEmail);
        return hash;
    }
}