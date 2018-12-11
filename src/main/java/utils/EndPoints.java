package utils;

public class EndPoints {

    //MOBILE

    //invoices
    public static final String invoices_iban = "/invoices/iban";
    public static final String invoices_bpay = "/invoices/bpay";
    public static final String invoices_withdraw = "/invoices/withdraw";

    // users
    public static final String users_profile = "/users/profile";
    public static final String users_profile_terms_agree = "/users/profile/terms/agree";
    public static final String users_profile_terms_iban_agree = "/users/profile/terms/iban/agree";
    public static final String users_profile_loyalty = "/users/profile/loyalty";
    public static final String users_number = "/users/{number}";
    public static final String users_profile_check = "/users/profile/check";
    public static final String users_logins = "/users/logins";
    public static final String users_profile_password_verify = "/users/profile/password/verify";
    public static final String users_profile_pin_verify = "/users/profile/pin/verify";
    public static final String users_profile_email_confirm = "/users/profile/email/confirm";
    public static final String users_profile_mobile_confirm = "/users/profile/mobile/confirm";
    public static final String users_profile_password_recover = "/users/profile/password/recover";
    public static final String users_profile_password_recover_confirm = "/users/profile/password/recover/confirm";
    public static final String devices_current = "/devices/current";
    public static final String users_profile_devices_current = "/users/profile/devices/current";
    public static final String users_profile_kyc0 = "/users/profile/kyc0";
    public static final String users_profile_kyc0_email_confirm = "/users/profile/kyc0/email/confirm";
    public static final String users_profile_kyc0_mobile_confirm = "/users/profile/kyc0/mobile/confirm";
    public static final String users_profile_kyc1 = "/users/profile/kyc1";
    public static final String users_profile_kyc1_verify = "/users/profile/kyc1/verify";
    public static final String users_profile_kyc2 = "/users/profile/kyc2";
    public static final String users_profile_kyc2_verify = "/users/profile/kyc2/verify";
    
    public static final String users_login = "/users/users_login";
    public static final String users_login_verify = "/users/users_login/verify";

    //MANAGEMENT
    public static final String testers_mobile = "/testers/mobile";

}
