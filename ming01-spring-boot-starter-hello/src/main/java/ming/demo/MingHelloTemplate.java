package ming.demo;

public class MingHelloTemplate {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String greeting(String username) {
        return message + ", " + username;
    }
}
