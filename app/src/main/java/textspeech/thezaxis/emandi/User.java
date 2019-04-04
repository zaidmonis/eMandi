package textspeech.thezaxis.emandi;

public class User {
    private String userName, key, id;

    public User(String userName, String key) {
        this.userName = userName;
        this.key = key;
    }


    public User() {
    }

    public User(String userName, String key, String id) {
        this.userName = userName;
        this.key = key;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }
}
