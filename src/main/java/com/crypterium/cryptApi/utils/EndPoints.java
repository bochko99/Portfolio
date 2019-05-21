package com.crypterium.cryptApi.utils;

public class EndPoints {

    //CALLBACK
    public static final String bitgo = "/bitgo";

    //KYC
    public static final String identity = "/identity";

    //GL (BitGo)
    public static final String account_records = "/account-records";


    //EXWAL
    public static final String token = "/token";

    //Admin
    public static final String admin_email_code = "/v1/admin/email/code";
    public static final String admin_sms_code = "/v1/admin/sms/code";

    //API ex_settings_version controller
    public static final String ex_settings_version = "/v1/settings/version";

    //API fro KYC service
    public static final String kyc_customer_profile = "/v1/kyc/customer/{customerId}/profile";
    public static final String kyc_identity = "/v1/kyc/identity";
    public static final String kyc_residence = "/v1/kyc/residence";
    public static final String kyc_identity_documents = "/v1/kyc/identity/documents";
    public static final String kyc_upload_document = "/v1/kyc/upload/document";

    //Card order operation
    public static final String card_order = "/v1/card/order";
    public static final String mobile_card_order = "/v1/mobile/card/order";

    //Catalogs
    public static final String catalog_comissions = "/v1/catalog/commissions";
    public static final String catalog_countries = "/v1/catalog/countries";
    public static final String catalog_currencies = "/v1/catalog/currencies";
    public static final String catalog_faq = "/v1/catalog/faq";
    public static final String catalogs_operations = "/v1/catalog/operations";

    //Customer customer_profile
    public static final String customer_profile = "/v1/customer/profile";
    public static final String customer_profile_loyality = "/v1/customer/profile/loyalty";

    //Exchange sx
    public static final String mobile_exchange_currencies = "/v1/mobile/exchange/currencies";
    public static final String mobile_exchange_offer = "/v1/mobile/exchange/offer";
    public static final String mobile_exchange_offer_offerId = "/v1/mobile/exchange/offer/{offerId}";

    //Payout
    public static final String payout_data = "/v1/payout/data";
    public static final String payout_offer = "/v1/payout/offer";
    public static final String payout_pay = "/v1/payout/pay";

    //Restore access operations v1
    public static final String v1_mobile_password_change = "/v1/mobile/password/change";
    public static final String v1_mobile_password_reset = "/v1/mobile/password/reset";
    public static final String v1_mobile_password_reset_confirm = "/v1/mobile/password/reset/confirm";
    public static final String v1_mobile_password_reset_confirm_code = "/v1/mobile/password/reset/confirm/code";

    //Restore access operations v2
    public static final String mobile_password_change = "/v2/mobile/password/change";
    public static final String mobile_password_reset = "/v2/mobile/password/reset";
    public static final String mobile_password_reset_confirm = "/v2/mobile/password/reset/confirm";
    public static final String mobile_password_reset_confirm_code = "/v2/mobile/password/reset/confirm/code";

    //SignUp v2
    public static final String v1_mobile_email_confirm = "/v1/mobile/email/confirm";
    public static final String v1_mobile_email_verify = "/v1/mobile/email/verify";
    public static final String v1_mobile_email_resend = "/v1/mobile/email/verify/resend";
    public static final String v1_mobile_name_add = "/v1/mobile/name/add";
    public static final String v1_mobile_phone_confirm = "/v1/mobile/phone/confirm";
    public static final String v1_mobile_phone_resend = "/v1/mobile/phone/verify/resend";
    public static final String v1_mobile_pin_setup = "/v1/mobile/pin/setup";
    public static final String v1_mobile_pwd_setup = "/v1/mobile/pwd/setup";
    public static final String v1_mobile_signup = "/v1/mobile/signup";

    //SignUp
    public static final String mobile_email_confirm = "/v2/mobile/email/confirm";
    public static final String mobile_email_add = "/v2/mobile/email/add";
    public static final String mobile_email_resend = "/v2/mobile/email/verify/resend";
    public static final String mobile_phone_confirm = "/v2/mobile/phone/confirm";
    public static final String mobile_phone_resend = "/v2/mobile/phone/verify/resend";
    public static final String mobile_pin_setup = "/v2/mobile/pin/setup";
    public static final String mobile_signup = "/v2/mobile/signup";

    //Wallet operations
    public static final String wallet_wallet_id = "/v1/wallet/{walletId}";
    public static final String wallet_address_currency = "/v1/wallet/address/{currency}";
    public static final String wallet_create = "/v1/wallet/create";
    public static final String wallet_create_currency = "/v1/wallet/create/{currency}";
    public static final String wallet_currencies = "/v1/wallet/currencies";
    public static final String wallet_list = "/v1/wallet/list";
    public static final String wallet_mobile_sx_rates = "/v1/wallet/rates";
    public static final String wallet_mobile_sx_rates_currency = "/v1/wallet/rates/{currency}";
    public static final String wallet_send = "/v1/wallet/send";
    public static final String wallet_send_fee_currency = "/v1/wallet/send/fee/{currency}";
    public static final String wallet_transaction = "/v1/wallet/transactions";
    public static final String wallet_verify_currency_address = "/v1/wallet/verify/{currency}/{address}";


    //Bank withdrawals
    public static final String banks_ru = "/banks/ru";
    public static final String banks_eu = "/banks/eu";
    
    public static final String clearJunction_callbacksk_type = "/ClearJunction/callbacksk/{type}";

    public static final String limits_countries = "/Limits/countries";
    public static final String limits_iban = "/Limits/iban";
    public static final String limits_rubank = "/Limits/rubank";

    public static final String offers_rubank = "/Offers/rubank";
    public static final String offers_iban = "/Offers/iban";
    public static final String offers_id = "/Offers/{id}";

    public static final String rates_from_to_to = "/Rates/{from}to{to}";

    public static final String withdrawals_ru_individual = "/Withdrawals/ru/individual";
    public static final String withdrawals_eu_individual = "/Withdrawals/eu/individual";
    public static final String withdrawals_eu_corporate = "/Withdrawals/eu/corporate";
    public static final String withdrawals_withdrawalId = "/Withdrawals/{withdrawalId}";

}
