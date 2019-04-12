
package com.crypterium.cryptApi.pojos.dexpa;


@SuppressWarnings("unused")
public class DexpaExchangePairsModel {

    private String base;
    private long baseDecimals;
    private Boolean collectData;
    private String counter;
    private long counterDecimals;
    private String exchangeClassId;
    private String id;
    private String mapping;
    private long minQuantityBase;
    private double minQuantityCounter;
    private long processingModifier;
    private long quantityIncrementBase;
    private Boolean storeData;
    private Boolean useInAggregation;
    private double priceIncrementCounter;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public long getBaseDecimals() {
        return baseDecimals;
    }

    public void setBaseDecimals(long baseDecimals) {
        this.baseDecimals = baseDecimals;
    }

    public Boolean getCollectData() {
        return collectData;
    }

    public void setCollectData(Boolean collectData) {
        this.collectData = collectData;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public long getCounterDecimals() {
        return counterDecimals;
    }

    public void setCounterDecimals(long counterDecimals) {
        this.counterDecimals = counterDecimals;
    }

    public String getExchangeClassId() {
        return exchangeClassId;
    }

    public void setExchangeClassId(String exchangeClassId) {
        this.exchangeClassId = exchangeClassId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public long getMinQuantityBase() {
        return minQuantityBase;
    }

    public void setMinQuantityBase(long minQuantityBase) {
        this.minQuantityBase = minQuantityBase;
    }

    public double getMinQuantityCounter() {
        return minQuantityCounter;
    }

    public void setMinQuantityCounter(double minQuantityCounter) {
        this.minQuantityCounter = minQuantityCounter;
    }

    public long getProcessingModifier() {
        return processingModifier;
    }

    public void setProcessingModifier(long processingModifier) {
        this.processingModifier = processingModifier;
    }

    public long getQuantityIncrementBase() {
        return quantityIncrementBase;
    }

    public void setQuantityIncrementBase(long quantityIncrementBase) {
        this.quantityIncrementBase = quantityIncrementBase;
    }

    public Boolean getStoreData() {
        return storeData;
    }

    public void setStoreData(Boolean storeData) {
        this.storeData = storeData;
    }

    public Boolean getUseInAggregation() {
        return useInAggregation;
    }

    public void setUseInAggregation(Boolean useInAggregation) {
        this.useInAggregation = useInAggregation;
    }

    public double getPriceIncrementCounter() {
        return priceIncrementCounter;
    }

    public DexpaExchangePairsModel setPriceIncrementCounter(double priceIncrementCounter) {
        this.priceIncrementCounter = priceIncrementCounter;
        return this;
    }

    @Override
    public String toString() {
        return "DexpaExchangePairsModel{" +
                "base='" + base + '\'' +
                ", baseDecimals=" + baseDecimals +
                ", collectData=" + collectData +
                ", counter='" + counter + '\'' +
                ", counterDecimals=" + counterDecimals +
                ", exchangeClassId='" + exchangeClassId + '\'' +
                ", id='" + id + '\'' +
                ", mapping='" + mapping + '\'' +
                ", minQuantityBase=" + minQuantityBase +
                ", minQuantityCounter=" + minQuantityCounter +
                ", processingModifier=" + processingModifier +
                ", quantityIncrementBase=" + quantityIncrementBase +
                ", storeData=" + storeData +
                ", useInAggregation=" + useInAggregation +
                ", priceIncrementCounter=" + priceIncrementCounter +
                '}';
    }
}
