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
    public static final String admin_email_code = "/admin/email/code";
    public static final String admin_sms_code = "/admin/sms/code";

    //API ex_settings_version controller
    public static final String ex_settings_version = "/settings/version";

    //API fro KYC service
    public static final String kyc_customer_profile = "/kyc/customer/{customerId}/profile";
    public static final String kyc_identity = "/kyc/identity";
    public static final String kyc_residence = "/kyc/residence";
    public static final String kyc_identity_documents = "/kyc/identity/documents";
    public static final String kyc_upload_document = "/kyc/upload/document";

    //Card order operation
    public static final String card_order = "/card/order";
    public static final String mobile_card_order = "/mobile/card/order";

    //Catalogs
    public static final String catalog_comissions = "/catalog/commissions";
    public static final String catalog_countries = "/catalog/countries";
    public static final String catalog_currencies = "/catalog/currencies";
    public static final String catalog_faq = "/catalog/faq";
    public static final String catalogs_operations = "/catalog/operations";

    //Customer customer_profile
    public static final String customer_profile = "/customer/profile";
    public static final String customer_profile_loyality = "/customer/profile/loyalty";

    //Exchange sx
    public static final String mobile_exchange_currencies = "/mobile/exchange/currencies";
    public static final String mobile_exchange_offer = "/mobile/exchange/offer";
    public static final String mobile_exchange_offer_offerId = "/mobile/exchange/offer/{offerId}";

    //Payout
    public static final String payout_payneteasy_data = "/payout/payneteasy/data";
    public static final String payout_payneteasy_offer = "/payout/payneteasy/offer";
    public static final String payout_payneteasy_pay = "/payout/payneteasy/pay";

    //Restore access operations
    public static final String mobile_password_change = "/mobile/password/change";
    public static final String mobile_password_reset = "/mobile/password/reset";
    public static final String mobile_password_reset_confirm = "/mobile/password/reset/confirm";
    public static final String mobile_password_reset_confirm_code = "/mobile/password/reset/confirm/code";

    //SignUp
    public static final String mobile_email_confirm = "/mobile/email/confirm";
    public static final String mobile_email_verify = "/mobile/email/verify";
    public static final String mobile_email_resend = "/mobile/email/verify/resend";
    public static final String mobile_name_add = "/mobile/name/add";
    public static final String mobile_phone_confirm = "/mobile/phone/confirm";
    public static final String mobile_phone_resend = "/mobile/phone/verify/resend";
    public static final String mobile_pin_setup = "/mobile/pin/setup";
    public static final String mobile_pwd_setup = "/mobile/pwd/setup";
    public static final String mobile_signup = "/mobile/signup";

    //Wallet operations
    public static final String wallet_wallet_id = "/wallet/{walletId}";
    public static final String wallet_address_currency = "/wallet/address/{currency}";
    public static final String wallet_create = "/wallet/create";
    public static final String wallet_create_currency = "/wallet/create/{currency}";
    public static final String wallet_currencies = "/wallet/currencies";
    public static final String wallet_list = "/wallet/list";
    public static final String wallet_mobile_sx_rates = "/wallet/rates";
    public static final String wallet_mobile_sx_rates_currency = "/wallet/rates/{currency}";
    public static final String wallet_send = "/wallet/send";
    public static final String wallet_send_fee_currency = "/wallet/send/fee/{currency}";
    public static final String wallet_transaction = "/wallet/transactions";
    public static final String wallet_verify_currency_address = "/wallet/verify/{currency}/{address}";


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
