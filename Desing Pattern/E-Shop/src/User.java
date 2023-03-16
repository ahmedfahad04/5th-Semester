public class User {
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Constants.User userType;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String pass, String address, String phoneNumber, String userType) {
        this.name = name;
        this.email = email;
        this.password = pass;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userType = Constants.User.valueOf(userType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isRegistered() {
        return true;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Constants.User getUserType() {
        return userType;
    }

    public void setUserType(Constants.User userType) {
        this.userType = userType;
    }
}
