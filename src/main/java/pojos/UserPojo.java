package pojos;

import java.util.HashMap;
import java.util.Map;

public class UserPojo {

    private String email;
    private String phone;
    private String password = "1234567";
    private Map<String, String> cryptoAddress = new HashMap<>();
    private String userId;

    public String getEmail() {
        return email;
    }

    public UserPojo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserPojo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Map<String, String> getCryptoAddress() {
        return cryptoAddress;
    }

    public UserPojo setCryptoAddress(Map<String, String> cryptoAddress) {
        this.cryptoAddress = cryptoAddress;
        return this;
    }

    public UserPojo withCryptoAddress(String currency, String address) {
        this.cryptoAddress.put(currency, address);
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserPojo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserPojo setPassword(String password) {
        this.password = password;
        return this;
    }
}
