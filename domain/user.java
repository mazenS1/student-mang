package domain;

public class user {
    private String user_name,password,departmet;
    

    public user(String user_name, String password, String departmet) {
        this.user_name = user_name;
        this.password = password;
        this.departmet = departmet;
    }
    //set and get
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartmet() {
        return departmet;
    }

    public void setDepartmet(String departmet) {
        this.departmet = departmet;
    }
    
}
