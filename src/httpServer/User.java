package httpServer;

public class User {
    private String id;
    private String nickName;
    private String mail;
    private String password;

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        String[] numb = id.split("=");
        this.id = numb[1];
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
