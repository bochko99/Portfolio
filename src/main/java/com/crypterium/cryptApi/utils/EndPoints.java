package com.crypterium.cryptApi.utils;

public class EndPoints {

    //MOBILE
    //bankwithdrawals
    public static final String bankwithdrawals_offers_rubank = "/bankwithdrawals/offers/rubank";
    public static final String bankwithdrawals_transfers_rubank = "bankwithdrawals_transfers_rubank";
    public static final String bankwithdrawals_banks = "/bankwithdrawals/banks";
    public static final String bankwithdrawals_limits_rubank = "/bankwithdrawals/limits/rubank";
    public static final String bankwithdrawals_limits_countries = "/bankwithdrawals/limits/countries";
    public static final String bankwithdrawals_rates_rubank = "/bankwithdrawals/rates/rubank";

    //chat
    public static final String chat_messages = "/chat/messages";

    //currencies
    public static final String currencies = "/currencies";
    public static final String rates_currency = "/rates/{currency}";
    public static final String rates_currencyFrom_currencyTo = "/rates/{currencyFrom}/{currencyTo}";

    //currencyexchange
    public static final String currencyexchange_directions = "/currency-exchange/directions";
    public static final String currencyexchange_offers = "/currency-exchange/offers";
    public static final String currencyexchange_transfers = "/currency-exchange/transfers";

    //favorites
    public static final String favorites_invoices = "/favorites/invoices";
    public static final String favorites_invoices_invoiceId = "/favorites/invoices/{invoiceId}";
    public static final String favorites_quotes = "/favorites/quotes";
    public static final String favorites_quotes_currency = "/favorites/quotes/{currency}";

    //fundsWallets
    public static final String fundswallets = "/fundswallets";
    public static final String fundswallets_id = "/fundswallets/{id}";
    public static final String fundswallets_id_invoice = "/fundswallets/{id}/invoice";
    public static final String fundswallets_currency_invoice = "/fundswallets/{currency}/invoice";
    public static final String fundswallets_invoices_id_pdf = "/fundswallets/invoices/{id}/pdf";
    public static final String fundswallets_invoices_id_send = "/fundswallets/invoices/{id}/send";

    //depositFromCard
    public static final String depositfromcard_transfers = "/depositfromcard/transfers";
    public static final String depositfromcard_offers = "/depositfromcard/offers";
    public static final String depositfromcard_limits = "/depositfromcard/limits";
    public static final String depositfromcard_success = "/depositfromcard/success";
    public static final String depositfromcard_failed = "/depositfromcard/failed";
    public static final String depositfromcard_redirect_id = "/depositfromcard/redirect/{id}";

    //hotels
    public static final String hotels_search = "/hotels/search";

    //invoices
    public static final String invoices_iban = "/invoices/iban";
    public static final String invoices_iban_banks_iban = "/invoices/iban/banks/{iban}";
    public static final String invoices_iban_rates = "/invoices/iban/rates";
    public static final String invoices_bpay = "/invoices/bpay";
    public static final String invoices_bpay_billers_code = "/invoices/bpay/billers/{code}";
    public static final String invoices_bsb = "/invoices/bsb";
    public static final String invoices_bsb_banks_code = "/invoices/bsb/banks/{code}";
    public static final String invoices_mobile = "/invoices/mobile";
    public static final String invoices_mobile_codes = "/invoices/mobile/codes";
    public static final String invoices_mobile_country_providers = "/invoices/mobile/{country}/providers";
    public static final String invoices_voucher_services = "/invoices/voucher/services";
    public static final String invoices_voucher_service = "/invoices/voucher/{service}";
    public static final String invoices_commissions = "/invoices/commissions";
    public static final String invoices_withdraw = "/invoices/withdraw";
    public static final String invoices_withdrawals_check = "/invoices/withdrawals/check";
    public static final String invoices_exchange = "/invoices/exchange";
    public static final String invoices_exchanges_rates = "/invoices/exchanges/rates";
    public static final String invoices_id_checkout = "/invoices/{id}/checkout";
    public static final String invoices_id_continue = "/invoices/{id}/continue";
    public static final String invoices_id = "/invoices/{id}";
    public static final String invoices_id_changescreen = "/invoices/{id}/changescreen";
    public static final String invoices_id_payments = "/invoices/{id}/payments";


    //locations
    public static final String countries = "/countries";

    //map
    public static final String map_points = "/map/points";

    //news
    public static final String news = "/news";

    //operations

    public static final String operations = "/operations";
    public static final String operations_id_comment = "/operations/{id}/comment";
    public static final String operations_read = "/operations/read";

    //quotes
    public static final String quotes = "/quotes";
    public static final String quotes_currency = "/quotes/{currency}";

    //settings
    public static final String settings = "/settings";
    public static final String settings_operations = "/settings/operations";
    public static final String settings_kyc = "/settings/kyc";
    public static final String settings_receipts = "/settings/receipts";
    public static final String settings_receipts_countries = "/settings/receipts/countries";
    public static final String settings_lending = "/settings/lending";
    public static final String settings_deposits = "/settings/deposits";
    public static final String settings_onboarding = "/settings/onboarding";
    public static final String settings_version = "/settings/version";

    //transactions
    public static final String transactions_history = "/transactions/history";

    //transfers
    public static final String transfers_frequent = "/transfers/frequent";
    public static final String transfers_recent = "/transfers/recent";

    //preorderedcard
    public static final String card_preorders_PhoneNumber = "/api/v1.0/card-preorders/{PhoneNumber}";

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

    public static final String users_login = "/users/login";
    public static final String users_login_verify = "/users/login/verify";


    //MANAGEMENT
    public static final String testers_mobile = "/testers/mobile";
    public static final String testers_email = "/testers/email";

    //CALLBACK
    public static final String bitgo = "/bitgo";

    //KYC
    public static final String identity = "kyc/identity";

    //GL (BitGo)
    public static final String account_records = "/account-records";


    //EXWAL
    public static final String token = "/token";

    //API version controller
    public static final String version = "/settings/version";

    //API fro KYC service
    public static final String kyc_profile = "/kyc/customer/{customerId}/profile";
    public static final String identity_ex = "/kyc/identity";
    public static final String upload_document = "/kyc/upload/document";

    //Card order operation
    public static final String create_card_web = "/card/order";
    public static final String create_card_auth_user = "/mobile/card/order";

    //Catalogs
    public static final String comissions = "/catalog/commissions";
    public static final String countries_ex = "/catalog/countries";
    public static final String catalog_currencies = "/catalog/currencies";
    public static final String faq = "/catalog/faq";
    public static final String operations_ex = "/catalog/operations";

    //Customer profile
    public static final String profile = "/customer/profile";
    public static final String loyality = "/customer/profile/loyalty";

    //Exchange sx
    public static final String exchange = "/mobile/sx/exchange";
    public static final String exchange_rate = "/mobile/sx/exchange/rate";
    public static final String rate_transactionid = "/mobile/sx/exchange/rate/{transactionId}";
    public static final String rates = "/mobile/sx/rates";

    //Restore access operations
    public static final String password_change = "/mobile/password/change";
    public static final String password_reset = "/mobile/password/reset";
    public static final String set_new_password = "/mobile/password/reset/confirm";
    public static final String code_reset_pass = "/mobile/password/reset/confirm/code";

    //SignUp
    public static final String email_confirm = "/mobile/email/confirm";
    public static final String email_verify = "/mobile/email/verify";
    public static final String email_resend = "/mobile/email/verify/resend";
    public static final String name_add = "/mobile/name/add";
    public static final String phone_confirm = "/mobile/phone/confirm";
    public static final String phone_resend = "/mobile/phone/verify/resend";
    public static final String pin_setup = "/mobile/pin/setup";
    public static final String password_setup = "/mobile/pwd/setup";
    public static final String signup = "/mobile/signup";

    //Wallet operations
    public static final String wallet_id = "/wallet/{walletId}";
    public static final String wallet_address = "/wallet/address/{currency}";
    public static final String wallet_create = "/wallet/create";
    public static final String wallet_create_provider = "/wallet/create/{currency}";
    public static final String wallet_currencies_ex = "/wallet/currencies";
    public static final String wallet_list = "/wallet/list";
    public static final String wallet_rates = "/wallet/rates";
    public static final String wallet_rates_currencies = "/wallet/rates/{currency}";
    public static final String wallet_send = "/wallet/send";
    public static final String wallet_fee = "/wallet/send/fee/{currency}";
    public static final String wallet_transaction_ex = "/wallet/transactions";
    public static final String wallet_verify = "/wallet/verify/{currency}/{address}";
}
