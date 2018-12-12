package utils;

public class EndPoints {

    //MOBILE

    //chat
    public static final String chat_messages = "/chat/messages";

    //currencies
    public static final String currencies = "/currencies";
    public static final String rates_currency = "/rates/{currency}";
    public static final String rates_currencyFrom_currencyTo = "/rates/{currencyFrom}/{currencyTo}";

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

    //transactions
    public static final String transactions_history = "/transactions/history";

    //transfers
    public static final String transfers_frequent = "/transfers/frequent";

    // users
    public static final String login = "/users/login";
    public static final String login_verify = "/users/login/verify";


    //MANAGEMENT
    public static final String testers_mobile = "/testers/mobile";

}
