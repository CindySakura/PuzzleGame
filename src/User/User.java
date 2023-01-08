package User;

public class User {
    private String uname;
    private String pw;
    public User(){}

    public User(String uname, String pw){
        this.uname = uname;
        this.pw = pw;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
