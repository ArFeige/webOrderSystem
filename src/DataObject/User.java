package DataObject;

/**
 * Created by ldy on 2016/11/19.
 */
public class User {
    private String name;
    private String password;
    private String profile;
    private String email;
    private int issuper;
    private int userid;
    private  String address;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", profile='" + profile + '\'' +
                ", email='" + email + '\'' +
                ", issuper=" + issuper +
                ", userid=" + userid +
                ", address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIssuper() {
        return issuper;
    }

    public void setIssuper(int issuper) {
        this.issuper = issuper;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
