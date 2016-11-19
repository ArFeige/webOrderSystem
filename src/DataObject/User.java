package DataObject;

/**
 * Created by ldy on 2016/11/19.
 */
public class User {
    private String name;
    private String password;
    private String profile;
    private String email;
    private boolean issuper;

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

    public boolean issuper() {
        return issuper;
    }

    public void setIssuper(boolean issuper) {
        this.issuper = issuper;
    }
}
