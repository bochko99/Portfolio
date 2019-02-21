
package com.crypterium.cryptApi.pojos.invoices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class InvoiceModel {

    @Expose
    private String addAmount;
    @Expose
    private String addAmountPurpose;
    @Expose
    private String addAmountPurposeTitle;
    @Expose
    private String addAmountTitle;
    @Expose
    private Object amount;
    @Expose
    private Double amountBalance;
    @Expose
    private String amountRequired;
    @Expose
    private List<Object> bankCards;
    @Expose
    private String bankCode;
    @Expose
    private String bankName;
    @Expose
    private String bankNameTitle;
    @Expose
    private String billDate;
    @Expose
    private String billDateTitle;
    @Expose
    private String billNumber;
    @Expose
    private String billNumberTitle;
    @Expose
    private String billRulingNumber;
    @Expose
    private String billRulingNumberTitle;
    @Expose
    private String birthDate;
    @Expose
    private String birthDateTitle;
    @Expose
    private Object bonus;
    @Expose
    private Long bonusBalance;
    @Expose
    private String budgetReceiverAccount;
    @Expose
    private String budgetReceiverAccountTitle;
    @Expose
    private List<Object> cart;
    @Expose
    private String cartDescription;
    @Expose
    private String cartImageUrl;
    @Expose
    private String cartModifiedDate;
    @Expose
    private String category;
    @Expose
    private String categoryCode;
    @Expose
    private String categoryTitle;
    @Expose
    private List<Object> charges;
    @Expose
    private List<Object> children;
    @Expose
    private String compilerStatus;
    @Expose
    private String compilerStatusTitle;
    @Expose
    private String contactEmail;
    @Expose
    private String contactEmailRequired;
    @Expose
    private String contactMobilePhone;
    @Expose
    private String contactMobilePhoneRequired;
    @Expose
    private String contractNumber;
    @Expose
    private String contractNumberTitle;
    @Expose
    private String correspAcc;
    @Expose
    private String correspAccTitle;
    @Expose
    private String createdDate;
    @Expose
    private String currency;
    @Expose
    private CustomData customData;
    @Expose
    private String customVerificationCode;
    @Expose
    private String customerAddress;
    @Expose
    private String customerAddressRequired;
    @Expose
    private String customerFirstName;
    @Expose
    private String customerFirstNameRequired;
    @Expose
    private String customerInn;
    @Expose
    private String customerInnRequired;
    @Expose
    private String customerLastName;
    @Expose
    private String customerLastNameRequired;
    @Expose
    private String customerMiddleName;
    @Expose
    private String customerMiddleNameRequired;
    @Expose
    private String customerNumber;
    @Expose
    private String deletedDate;
    @Expose
    private String deliveryCaseRequired;
    @Expose
    private List<Object> deliveryCases;
    @Expose
    private Object deliveryCasesSelectedId;
    @Expose
    private String deliveryCasesUpdatingDate;
    @Expose
    private DeliveryLocation deliveryLocation;
    @Expose
    private Object deliveryLocationId;
    @Expose
    private String deliveryLocationRequired;
    @Expose
    private String deviceName;
    @Expose
    private String deviceNameTitle;
    @Expose
    private String deviceNumber;
    @Expose
    private String deviceNumberTitle;
    @Expose
    private String deviceValue;
    @Expose
    private String deviceValueTitle;
    @Expose
    private String documentDate;
    @Expose
    private String documentDateTitle;
    @Expose
    private String documentNumber;
    @Expose
    private String documentNumberTitle;
    @Expose
    private String executoryNumber;
    @Expose
    private String executoryNumberTitle;
    @Expose
    private Fee fee;
    @Expose
    private String flatNumber;
    @Expose
    private String flatNumberTitle;
    @Expose
    private Long giftAmountBalance;
    @Expose
    private String groupNumber;
    @Expose
    private String groupNumberTitle;
    @Expose
    private String id;
    @Expose
    private String institutionNumber;
    @Expose
    private String institutionNumberTitle;
    @Expose
    private Boolean isChecked;
    @Expose
    private Boolean isFraud;
    @Expose
    private Boolean isLiveMode;
    @Expose
    private String kbk;
    @Expose
    private String kbkTitle;
    @Expose
    private Object message;
    @Expose
    private String modifiedDate;
    @Expose
    private String name;
    @Expose
    private String nameTitle;
    @Expose
    private Boolean needPasswordOnPay;
    @Expose
    private Boolean needVerify;
    @Expose
    private Notifications notifications;
    @Expose
    private Long number;
    @Expose
    private String oktmo;
    @Expose
    private String oktmoTitle;
    @Expose
    private String orderCheckoutedDate;
    @Expose
    private String orderCheckoutingDate;
    @Expose
    private String orderCreatedDate;
    @Expose
    private String orderCreatingDate;
    @Expose
    private String orderNumber;
    @Expose
    private String orderNumberRequired;
    @Expose
    private String paidDate;
    @Expose
    private Object paidMessage;
    @Expose
    private String paidWaitDate;
    @Expose
    private String payerDocumentNumber;
    @Expose
    private String payerDocumentNumberTitle;
    @Expose
    private String payerDocumentType;
    @Expose
    private String payerDocumentTypeTitle;
    @Expose
    private String payerIdentifier;
    @Expose
    private String payerIdentifierTitle;
    @Expose
    private String payerNumber;
    @Expose
    private String payerNumberTitle;
    @Expose
    private String paymPeriod;
    @Expose
    private String paymPeriodTitle;
    @Expose
    private String paymTerm;
    @Expose
    private String paymTermTitle;
    @Expose
    private String paymentDocumentIndex;
    @Expose
    private String paymentDocumentIndexTitle;
    @Expose
    private String paymentPeriod;
    @Expose
    private String paymentPeriodTitle;
    @Expose
    private String paymentPurpose;
    @Expose
    private String paymentPurposeRequired;
    @Expose
    private String paymentTerm;
    @Expose
    private String paymentTermTitle;
    @Expose
    private String paymentType;
    @Expose
    private String paymentTypeCode;
    @Expose
    private String paymentTypeCodeTitle;
    @Expose
    private String paymentTypeName;
    @Expose
    private String paymentTypeNameTitle;
    @Expose
    private String paymentTypeTitle;
    @Expose
    private String persAcc;
    @Expose
    private String persAccTitle;
    @Expose
    private String phoneNumber;
    @Expose
    private String phoneNumberTitle;
    @Expose
    private String pickPointRequired;
    @Expose
    private List<Object> pickPoints;
    @Expose
    private String pickPointsCityName;
    @Expose
    private Object pickPointsSelectedId;
    @Expose
    private String pickPointsUpdatingDate;
    @Expose
    private List<Object> poll;
    @Expose
    private List<Object> pollSelected;
    @Expose
    private String promoCardArticle;
    @Expose
    private String promoCardDetails;
    @Expose
    private String promoCardNumber;
    @Expose
    private String promoCardRequired;
    @Expose
    private String promoCodeArticle;
    @Expose
    private String promoCodeDetails;
    @Expose
    private String promoCodeNumber;
    @Expose
    private String promoCodeRequired;
    @Expose
    private Object receiverAccount;
    @Expose
    private String receiverAccountNumber;
    @Expose
    private String receiverAccountNumberTitle;
    @Expose
    private String receiverBic;
    @Expose
    private String receiverBicTitle;
    @Expose
    private String receiverCompanyName;
    @Expose
    private String receiverFirstName;
    @Expose
    private String receiverInn;
    @Expose
    private String receiverInnTitle;
    @Expose
    private String receiverKpp;
    @Expose
    private String receiverKppTitle;
    @Expose
    private String receiverLastName;
    @Expose
    private String receiverName;
    @Expose
    private String receiverTitle;
    @Expose
    private String receiverType;
    @Expose
    private String scenarioName;
    @Expose
    private String servicerName;
    @Expose
    private String servicerNameTitle;
    @Expose
    private String shopLogoUrl;
    @Expose
    private String shopName;
    @Expose
    private String status;
    @Expose
    private String statusDescription;
    @Expose
    private String studentName;
    @Expose
    private String studentNameTitle;
    @Expose
    private String taxPaymentReason;
    @Expose
    private String taxPaymentReasonTitle;
    @Expose
    private String taxPeriod;
    @Expose
    private String taxPeriodTitle;
    @Expose
    private String techCode;
    @Expose
    private String techCodeTitle;
    @Expose
    private Double totalAmount;
    @Expose
    private String typeName;
    @Expose
    private String uin;
    @Expose
    private String uinRequired;
    @Expose
    private String uinTitle;
    @Expose
    private List<Object> upSell;
    @Expose
    private Long validityInMinutes;
    @Expose
    private List<Object> wallets;
    @Expose
    private String warning;

    public String getAddAmount() {
        return addAmount;
    }

    public void setAddAmount(String addAmount) {
        this.addAmount = addAmount;
    }

    public String getAddAmountPurpose() {
        return addAmountPurpose;
    }

    public void setAddAmountPurpose(String addAmountPurpose) {
        this.addAmountPurpose = addAmountPurpose;
    }

    public String getAddAmountPurposeTitle() {
        return addAmountPurposeTitle;
    }

    public void setAddAmountPurposeTitle(String addAmountPurposeTitle) {
        this.addAmountPurposeTitle = addAmountPurposeTitle;
    }

    public String getAddAmountTitle() {
        return addAmountTitle;
    }

    public void setAddAmountTitle(String addAmountTitle) {
        this.addAmountTitle = addAmountTitle;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public Double getAmountBalance() {
        return amountBalance;
    }

    public void setAmountBalance(Double amountBalance) {
        this.amountBalance = amountBalance;
    }

    public String getAmountRequired() {
        return amountRequired;
    }

    public void setAmountRequired(String amountRequired) {
        this.amountRequired = amountRequired;
    }

    public List<Object> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<Object> bankCards) {
        this.bankCards = bankCards;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNameTitle() {
        return bankNameTitle;
    }

    public void setBankNameTitle(String bankNameTitle) {
        this.bankNameTitle = bankNameTitle;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillDateTitle() {
        return billDateTitle;
    }

    public void setBillDateTitle(String billDateTitle) {
        this.billDateTitle = billDateTitle;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getBillNumberTitle() {
        return billNumberTitle;
    }

    public void setBillNumberTitle(String billNumberTitle) {
        this.billNumberTitle = billNumberTitle;
    }

    public String getBillRulingNumber() {
        return billRulingNumber;
    }

    public void setBillRulingNumber(String billRulingNumber) {
        this.billRulingNumber = billRulingNumber;
    }

    public String getBillRulingNumberTitle() {
        return billRulingNumberTitle;
    }

    public void setBillRulingNumberTitle(String billRulingNumberTitle) {
        this.billRulingNumberTitle = billRulingNumberTitle;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDateTitle() {
        return birthDateTitle;
    }

    public void setBirthDateTitle(String birthDateTitle) {
        this.birthDateTitle = birthDateTitle;
    }

    public Object getBonus() {
        return bonus;
    }

    public void setBonus(Object bonus) {
        this.bonus = bonus;
    }

    public Long getBonusBalance() {
        return bonusBalance;
    }

    public void setBonusBalance(Long bonusBalance) {
        this.bonusBalance = bonusBalance;
    }

    public String getBudgetReceiverAccount() {
        return budgetReceiverAccount;
    }

    public void setBudgetReceiverAccount(String budgetReceiverAccount) {
        this.budgetReceiverAccount = budgetReceiverAccount;
    }

    public String getBudgetReceiverAccountTitle() {
        return budgetReceiverAccountTitle;
    }

    public void setBudgetReceiverAccountTitle(String budgetReceiverAccountTitle) {
        this.budgetReceiverAccountTitle = budgetReceiverAccountTitle;
    }

    public List<Object> getCart() {
        return cart;
    }

    public void setCart(List<Object> cart) {
        this.cart = cart;
    }

    public String getCartDescription() {
        return cartDescription;
    }

    public void setCartDescription(String cartDescription) {
        this.cartDescription = cartDescription;
    }

    public String getCartImageUrl() {
        return cartImageUrl;
    }

    public void setCartImageUrl(String cartImageUrl) {
        this.cartImageUrl = cartImageUrl;
    }

    public String getCartModifiedDate() {
        return cartModifiedDate;
    }

    public void setCartModifiedDate(String cartModifiedDate) {
        this.cartModifiedDate = cartModifiedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<Object> getCharges() {
        return charges;
    }

    public void setCharges(List<Object> charges) {
        this.charges = charges;
    }

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }

    public String getCompilerStatus() {
        return compilerStatus;
    }

    public void setCompilerStatus(String compilerStatus) {
        this.compilerStatus = compilerStatus;
    }

    public String getCompilerStatusTitle() {
        return compilerStatusTitle;
    }

    public void setCompilerStatusTitle(String compilerStatusTitle) {
        this.compilerStatusTitle = compilerStatusTitle;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactEmailRequired() {
        return contactEmailRequired;
    }

    public void setContactEmailRequired(String contactEmailRequired) {
        this.contactEmailRequired = contactEmailRequired;
    }

    public String getContactMobilePhone() {
        return contactMobilePhone;
    }

    public void setContactMobilePhone(String contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
    }

    public String getContactMobilePhoneRequired() {
        return contactMobilePhoneRequired;
    }

    public void setContactMobilePhoneRequired(String contactMobilePhoneRequired) {
        this.contactMobilePhoneRequired = contactMobilePhoneRequired;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractNumberTitle() {
        return contractNumberTitle;
    }

    public void setContractNumberTitle(String contractNumberTitle) {
        this.contractNumberTitle = contractNumberTitle;
    }

    public String getCorrespAcc() {
        return correspAcc;
    }

    public void setCorrespAcc(String correspAcc) {
        this.correspAcc = correspAcc;
    }

    public String getCorrespAccTitle() {
        return correspAccTitle;
    }

    public void setCorrespAccTitle(String correspAccTitle) {
        this.correspAccTitle = correspAccTitle;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public CustomData getCustomData() {
        return customData;
    }

    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    public String getCustomVerificationCode() {
        return customVerificationCode;
    }

    public void setCustomVerificationCode(String customVerificationCode) {
        this.customVerificationCode = customVerificationCode;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAddressRequired() {
        return customerAddressRequired;
    }

    public void setCustomerAddressRequired(String customerAddressRequired) {
        this.customerAddressRequired = customerAddressRequired;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerFirstNameRequired() {
        return customerFirstNameRequired;
    }

    public void setCustomerFirstNameRequired(String customerFirstNameRequired) {
        this.customerFirstNameRequired = customerFirstNameRequired;
    }

    public String getCustomerInn() {
        return customerInn;
    }

    public void setCustomerInn(String customerInn) {
        this.customerInn = customerInn;
    }

    public String getCustomerInnRequired() {
        return customerInnRequired;
    }

    public void setCustomerInnRequired(String customerInnRequired) {
        this.customerInnRequired = customerInnRequired;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerLastNameRequired() {
        return customerLastNameRequired;
    }

    public void setCustomerLastNameRequired(String customerLastNameRequired) {
        this.customerLastNameRequired = customerLastNameRequired;
    }

    public String getCustomerMiddleName() {
        return customerMiddleName;
    }

    public void setCustomerMiddleName(String customerMiddleName) {
        this.customerMiddleName = customerMiddleName;
    }

    public String getCustomerMiddleNameRequired() {
        return customerMiddleNameRequired;
    }

    public void setCustomerMiddleNameRequired(String customerMiddleNameRequired) {
        this.customerMiddleNameRequired = customerMiddleNameRequired;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeliveryCaseRequired() {
        return deliveryCaseRequired;
    }

    public void setDeliveryCaseRequired(String deliveryCaseRequired) {
        this.deliveryCaseRequired = deliveryCaseRequired;
    }

    public List<Object> getDeliveryCases() {
        return deliveryCases;
    }

    public void setDeliveryCases(List<Object> deliveryCases) {
        this.deliveryCases = deliveryCases;
    }

    public Object getDeliveryCasesSelectedId() {
        return deliveryCasesSelectedId;
    }

    public void setDeliveryCasesSelectedId(Object deliveryCasesSelectedId) {
        this.deliveryCasesSelectedId = deliveryCasesSelectedId;
    }

    public String getDeliveryCasesUpdatingDate() {
        return deliveryCasesUpdatingDate;
    }

    public void setDeliveryCasesUpdatingDate(String deliveryCasesUpdatingDate) {
        this.deliveryCasesUpdatingDate = deliveryCasesUpdatingDate;
    }

    public DeliveryLocation getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(DeliveryLocation deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Object getDeliveryLocationId() {
        return deliveryLocationId;
    }

    public void setDeliveryLocationId(Object deliveryLocationId) {
        this.deliveryLocationId = deliveryLocationId;
    }

    public String getDeliveryLocationRequired() {
        return deliveryLocationRequired;
    }

    public void setDeliveryLocationRequired(String deliveryLocationRequired) {
        this.deliveryLocationRequired = deliveryLocationRequired;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNameTitle() {
        return deviceNameTitle;
    }

    public void setDeviceNameTitle(String deviceNameTitle) {
        this.deviceNameTitle = deviceNameTitle;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceNumberTitle() {
        return deviceNumberTitle;
    }

    public void setDeviceNumberTitle(String deviceNumberTitle) {
        this.deviceNumberTitle = deviceNumberTitle;
    }

    public String getDeviceValue() {
        return deviceValue;
    }

    public void setDeviceValue(String deviceValue) {
        this.deviceValue = deviceValue;
    }

    public String getDeviceValueTitle() {
        return deviceValueTitle;
    }

    public void setDeviceValueTitle(String deviceValueTitle) {
        this.deviceValueTitle = deviceValueTitle;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getDocumentDateTitle() {
        return documentDateTitle;
    }

    public void setDocumentDateTitle(String documentDateTitle) {
        this.documentDateTitle = documentDateTitle;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumberTitle() {
        return documentNumberTitle;
    }

    public void setDocumentNumberTitle(String documentNumberTitle) {
        this.documentNumberTitle = documentNumberTitle;
    }

    public String getExecutoryNumber() {
        return executoryNumber;
    }

    public void setExecutoryNumber(String executoryNumber) {
        this.executoryNumber = executoryNumber;
    }

    public String getExecutoryNumberTitle() {
        return executoryNumberTitle;
    }

    public void setExecutoryNumberTitle(String executoryNumberTitle) {
        this.executoryNumberTitle = executoryNumberTitle;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getFlatNumberTitle() {
        return flatNumberTitle;
    }

    public void setFlatNumberTitle(String flatNumberTitle) {
        this.flatNumberTitle = flatNumberTitle;
    }

    public Long getGiftAmountBalance() {
        return giftAmountBalance;
    }

    public void setGiftAmountBalance(Long giftAmountBalance) {
        this.giftAmountBalance = giftAmountBalance;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getGroupNumberTitle() {
        return groupNumberTitle;
    }

    public void setGroupNumberTitle(String groupNumberTitle) {
        this.groupNumberTitle = groupNumberTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstitutionNumber() {
        return institutionNumber;
    }

    public void setInstitutionNumber(String institutionNumber) {
        this.institutionNumber = institutionNumber;
    }

    public String getInstitutionNumberTitle() {
        return institutionNumberTitle;
    }

    public void setInstitutionNumberTitle(String institutionNumberTitle) {
        this.institutionNumberTitle = institutionNumberTitle;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Boolean getIsFraud() {
        return isFraud;
    }

    public void setIsFraud(Boolean isFraud) {
        this.isFraud = isFraud;
    }

    public Boolean getIsLiveMode() {
        return isLiveMode;
    }

    public void setIsLiveMode(Boolean isLiveMode) {
        this.isLiveMode = isLiveMode;
    }

    public String getKbk() {
        return kbk;
    }

    public void setKbk(String kbk) {
        this.kbk = kbk;
    }

    public String getKbkTitle() {
        return kbkTitle;
    }

    public void setKbkTitle(String kbkTitle) {
        this.kbkTitle = kbkTitle;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public Boolean getNeedPasswordOnPay() {
        return needPasswordOnPay;
    }

    public void setNeedPasswordOnPay(Boolean needPasswordOnPay) {
        this.needPasswordOnPay = needPasswordOnPay;
    }

    public Boolean getNeedVerify() {
        return needVerify;
    }

    public void setNeedVerify(Boolean needVerify) {
        this.needVerify = needVerify;
    }

    public Notifications getNotifications() {
        return notifications;
    }

    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getOktmo() {
        return oktmo;
    }

    public void setOktmo(String oktmo) {
        this.oktmo = oktmo;
    }

    public String getOktmoTitle() {
        return oktmoTitle;
    }

    public void setOktmoTitle(String oktmoTitle) {
        this.oktmoTitle = oktmoTitle;
    }

    public String getOrderCheckoutedDate() {
        return orderCheckoutedDate;
    }

    public void setOrderCheckoutedDate(String orderCheckoutedDate) {
        this.orderCheckoutedDate = orderCheckoutedDate;
    }

    public String getOrderCheckoutingDate() {
        return orderCheckoutingDate;
    }

    public void setOrderCheckoutingDate(String orderCheckoutingDate) {
        this.orderCheckoutingDate = orderCheckoutingDate;
    }

    public String getOrderCreatedDate() {
        return orderCreatedDate;
    }

    public void setOrderCreatedDate(String orderCreatedDate) {
        this.orderCreatedDate = orderCreatedDate;
    }

    public String getOrderCreatingDate() {
        return orderCreatingDate;
    }

    public void setOrderCreatingDate(String orderCreatingDate) {
        this.orderCreatingDate = orderCreatingDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumberRequired() {
        return orderNumberRequired;
    }

    public void setOrderNumberRequired(String orderNumberRequired) {
        this.orderNumberRequired = orderNumberRequired;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public Object getPaidMessage() {
        return paidMessage;
    }

    public void setPaidMessage(Object paidMessage) {
        this.paidMessage = paidMessage;
    }

    public String getPaidWaitDate() {
        return paidWaitDate;
    }

    public void setPaidWaitDate(String paidWaitDate) {
        this.paidWaitDate = paidWaitDate;
    }

    public String getPayerDocumentNumber() {
        return payerDocumentNumber;
    }

    public void setPayerDocumentNumber(String payerDocumentNumber) {
        this.payerDocumentNumber = payerDocumentNumber;
    }

    public String getPayerDocumentNumberTitle() {
        return payerDocumentNumberTitle;
    }

    public void setPayerDocumentNumberTitle(String payerDocumentNumberTitle) {
        this.payerDocumentNumberTitle = payerDocumentNumberTitle;
    }

    public String getPayerDocumentType() {
        return payerDocumentType;
    }

    public void setPayerDocumentType(String payerDocumentType) {
        this.payerDocumentType = payerDocumentType;
    }

    public String getPayerDocumentTypeTitle() {
        return payerDocumentTypeTitle;
    }

    public void setPayerDocumentTypeTitle(String payerDocumentTypeTitle) {
        this.payerDocumentTypeTitle = payerDocumentTypeTitle;
    }

    public String getPayerIdentifier() {
        return payerIdentifier;
    }

    public void setPayerIdentifier(String payerIdentifier) {
        this.payerIdentifier = payerIdentifier;
    }

    public String getPayerIdentifierTitle() {
        return payerIdentifierTitle;
    }

    public void setPayerIdentifierTitle(String payerIdentifierTitle) {
        this.payerIdentifierTitle = payerIdentifierTitle;
    }

    public String getPayerNumber() {
        return payerNumber;
    }

    public void setPayerNumber(String payerNumber) {
        this.payerNumber = payerNumber;
    }

    public String getPayerNumberTitle() {
        return payerNumberTitle;
    }

    public void setPayerNumberTitle(String payerNumberTitle) {
        this.payerNumberTitle = payerNumberTitle;
    }

    public String getPaymPeriod() {
        return paymPeriod;
    }

    public void setPaymPeriod(String paymPeriod) {
        this.paymPeriod = paymPeriod;
    }

    public String getPaymPeriodTitle() {
        return paymPeriodTitle;
    }

    public void setPaymPeriodTitle(String paymPeriodTitle) {
        this.paymPeriodTitle = paymPeriodTitle;
    }

    public String getPaymTerm() {
        return paymTerm;
    }

    public void setPaymTerm(String paymTerm) {
        this.paymTerm = paymTerm;
    }

    public String getPaymTermTitle() {
        return paymTermTitle;
    }

    public void setPaymTermTitle(String paymTermTitle) {
        this.paymTermTitle = paymTermTitle;
    }

    public String getPaymentDocumentIndex() {
        return paymentDocumentIndex;
    }

    public void setPaymentDocumentIndex(String paymentDocumentIndex) {
        this.paymentDocumentIndex = paymentDocumentIndex;
    }

    public String getPaymentDocumentIndexTitle() {
        return paymentDocumentIndexTitle;
    }

    public void setPaymentDocumentIndexTitle(String paymentDocumentIndexTitle) {
        this.paymentDocumentIndexTitle = paymentDocumentIndexTitle;
    }

    public String getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(String paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public String getPaymentPeriodTitle() {
        return paymentPeriodTitle;
    }

    public void setPaymentPeriodTitle(String paymentPeriodTitle) {
        this.paymentPeriodTitle = paymentPeriodTitle;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public String getPaymentPurposeRequired() {
        return paymentPurposeRequired;
    }

    public void setPaymentPurposeRequired(String paymentPurposeRequired) {
        this.paymentPurposeRequired = paymentPurposeRequired;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public String getPaymentTermTitle() {
        return paymentTermTitle;
    }

    public void setPaymentTermTitle(String paymentTermTitle) {
        this.paymentTermTitle = paymentTermTitle;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public String getPaymentTypeCodeTitle() {
        return paymentTypeCodeTitle;
    }

    public void setPaymentTypeCodeTitle(String paymentTypeCodeTitle) {
        this.paymentTypeCodeTitle = paymentTypeCodeTitle;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getPaymentTypeNameTitle() {
        return paymentTypeNameTitle;
    }

    public void setPaymentTypeNameTitle(String paymentTypeNameTitle) {
        this.paymentTypeNameTitle = paymentTypeNameTitle;
    }

    public String getPaymentTypeTitle() {
        return paymentTypeTitle;
    }

    public void setPaymentTypeTitle(String paymentTypeTitle) {
        this.paymentTypeTitle = paymentTypeTitle;
    }

    public String getPersAcc() {
        return persAcc;
    }

    public void setPersAcc(String persAcc) {
        this.persAcc = persAcc;
    }

    public String getPersAccTitle() {
        return persAccTitle;
    }

    public void setPersAccTitle(String persAccTitle) {
        this.persAccTitle = persAccTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumberTitle() {
        return phoneNumberTitle;
    }

    public void setPhoneNumberTitle(String phoneNumberTitle) {
        this.phoneNumberTitle = phoneNumberTitle;
    }

    public String getPickPointRequired() {
        return pickPointRequired;
    }

    public void setPickPointRequired(String pickPointRequired) {
        this.pickPointRequired = pickPointRequired;
    }

    public List<Object> getPickPoints() {
        return pickPoints;
    }

    public void setPickPoints(List<Object> pickPoints) {
        this.pickPoints = pickPoints;
    }

    public String getPickPointsCityName() {
        return pickPointsCityName;
    }

    public void setPickPointsCityName(String pickPointsCityName) {
        this.pickPointsCityName = pickPointsCityName;
    }

    public Object getPickPointsSelectedId() {
        return pickPointsSelectedId;
    }

    public void setPickPointsSelectedId(Object pickPointsSelectedId) {
        this.pickPointsSelectedId = pickPointsSelectedId;
    }

    public String getPickPointsUpdatingDate() {
        return pickPointsUpdatingDate;
    }

    public void setPickPointsUpdatingDate(String pickPointsUpdatingDate) {
        this.pickPointsUpdatingDate = pickPointsUpdatingDate;
    }

    public List<Object> getPoll() {
        return poll;
    }

    public void setPoll(List<Object> poll) {
        this.poll = poll;
    }

    public List<Object> getPollSelected() {
        return pollSelected;
    }

    public void setPollSelected(List<Object> pollSelected) {
        this.pollSelected = pollSelected;
    }

    public String getPromoCardArticle() {
        return promoCardArticle;
    }

    public void setPromoCardArticle(String promoCardArticle) {
        this.promoCardArticle = promoCardArticle;
    }

    public String getPromoCardDetails() {
        return promoCardDetails;
    }

    public void setPromoCardDetails(String promoCardDetails) {
        this.promoCardDetails = promoCardDetails;
    }

    public String getPromoCardNumber() {
        return promoCardNumber;
    }

    public void setPromoCardNumber(String promoCardNumber) {
        this.promoCardNumber = promoCardNumber;
    }

    public String getPromoCardRequired() {
        return promoCardRequired;
    }

    public void setPromoCardRequired(String promoCardRequired) {
        this.promoCardRequired = promoCardRequired;
    }

    public String getPromoCodeArticle() {
        return promoCodeArticle;
    }

    public void setPromoCodeArticle(String promoCodeArticle) {
        this.promoCodeArticle = promoCodeArticle;
    }

    public String getPromoCodeDetails() {
        return promoCodeDetails;
    }

    public void setPromoCodeDetails(String promoCodeDetails) {
        this.promoCodeDetails = promoCodeDetails;
    }

    public String getPromoCodeNumber() {
        return promoCodeNumber;
    }

    public void setPromoCodeNumber(String promoCodeNumber) {
        this.promoCodeNumber = promoCodeNumber;
    }

    public String getPromoCodeRequired() {
        return promoCodeRequired;
    }

    public void setPromoCodeRequired(String promoCodeRequired) {
        this.promoCodeRequired = promoCodeRequired;
    }

    public Object getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Object receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public String getReceiverAccountNumberTitle() {
        return receiverAccountNumberTitle;
    }

    public void setReceiverAccountNumberTitle(String receiverAccountNumberTitle) {
        this.receiverAccountNumberTitle = receiverAccountNumberTitle;
    }

    public String getReceiverBic() {
        return receiverBic;
    }

    public void setReceiverBic(String receiverBic) {
        this.receiverBic = receiverBic;
    }

    public String getReceiverBicTitle() {
        return receiverBicTitle;
    }

    public void setReceiverBicTitle(String receiverBicTitle) {
        this.receiverBicTitle = receiverBicTitle;
    }

    public String getReceiverCompanyName() {
        return receiverCompanyName;
    }

    public void setReceiverCompanyName(String receiverCompanyName) {
        this.receiverCompanyName = receiverCompanyName;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverInn() {
        return receiverInn;
    }

    public void setReceiverInn(String receiverInn) {
        this.receiverInn = receiverInn;
    }

    public String getReceiverInnTitle() {
        return receiverInnTitle;
    }

    public void setReceiverInnTitle(String receiverInnTitle) {
        this.receiverInnTitle = receiverInnTitle;
    }

    public String getReceiverKpp() {
        return receiverKpp;
    }

    public void setReceiverKpp(String receiverKpp) {
        this.receiverKpp = receiverKpp;
    }

    public String getReceiverKppTitle() {
        return receiverKppTitle;
    }

    public void setReceiverKppTitle(String receiverKppTitle) {
        this.receiverKppTitle = receiverKppTitle;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverTitle() {
        return receiverTitle;
    }

    public void setReceiverTitle(String receiverTitle) {
        this.receiverTitle = receiverTitle;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public String getServicerName() {
        return servicerName;
    }

    public void setServicerName(String servicerName) {
        this.servicerName = servicerName;
    }

    public String getServicerNameTitle() {
        return servicerNameTitle;
    }

    public void setServicerNameTitle(String servicerNameTitle) {
        this.servicerNameTitle = servicerNameTitle;
    }

    public String getShopLogoUrl() {
        return shopLogoUrl;
    }

    public void setShopLogoUrl(String shopLogoUrl) {
        this.shopLogoUrl = shopLogoUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNameTitle() {
        return studentNameTitle;
    }

    public void setStudentNameTitle(String studentNameTitle) {
        this.studentNameTitle = studentNameTitle;
    }

    public String getTaxPaymentReason() {
        return taxPaymentReason;
    }

    public void setTaxPaymentReason(String taxPaymentReason) {
        this.taxPaymentReason = taxPaymentReason;
    }

    public String getTaxPaymentReasonTitle() {
        return taxPaymentReasonTitle;
    }

    public void setTaxPaymentReasonTitle(String taxPaymentReasonTitle) {
        this.taxPaymentReasonTitle = taxPaymentReasonTitle;
    }

    public String getTaxPeriod() {
        return taxPeriod;
    }

    public void setTaxPeriod(String taxPeriod) {
        this.taxPeriod = taxPeriod;
    }

    public String getTaxPeriodTitle() {
        return taxPeriodTitle;
    }

    public void setTaxPeriodTitle(String taxPeriodTitle) {
        this.taxPeriodTitle = taxPeriodTitle;
    }

    public String getTechCode() {
        return techCode;
    }

    public void setTechCode(String techCode) {
        this.techCode = techCode;
    }

    public String getTechCodeTitle() {
        return techCodeTitle;
    }

    public void setTechCodeTitle(String techCodeTitle) {
        this.techCodeTitle = techCodeTitle;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public String getUinRequired() {
        return uinRequired;
    }

    public void setUinRequired(String uinRequired) {
        this.uinRequired = uinRequired;
    }

    public String getUinTitle() {
        return uinTitle;
    }

    public void setUinTitle(String uinTitle) {
        this.uinTitle = uinTitle;
    }

    public List<Object> getUpSell() {
        return upSell;
    }

    public void setUpSell(List<Object> upSell) {
        this.upSell = upSell;
    }

    public Long getValidityInMinutes() {
        return validityInMinutes;
    }

    public void setValidityInMinutes(Long validityInMinutes) {
        this.validityInMinutes = validityInMinutes;
    }

    public List<Object> getWallets() {
        return wallets;
    }

    public void setWallets(List<Object> wallets) {
        this.wallets = wallets;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

}
