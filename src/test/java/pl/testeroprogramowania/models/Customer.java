package pl.testeroprogramowania.models;

public class Customer {

    private String firstName = "Bartek";
    private String lastName = "Testowy";
    private String companyName = "BMB";
    private String country = "Poland";
    private String street = "Testowa";
    private String flatNumber = "22";
    private String zippCode = "11111";
    private String city = "Testowe";
    private String phone = "939393923";
    private String email = "random@gmail.com";


    //dodawanie getterow i setterow alt + insert

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getZippCode() {
        return zippCode;
    }

    public void setZippCode(String zippCode) {
        this.zippCode = zippCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
