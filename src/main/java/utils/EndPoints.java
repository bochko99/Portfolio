package utils;

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
}
