package com.crypterium.cryptApi.pojos.services.kyc;

public class KycIdentityRequestModel {

    private Type type;
    private String frontside;
    private String backside;
    private String selfie;

    public Type getType() {
        return type;
    }

    public KycIdentityRequestModel setType(Type type) {
        this.type = type;
        return this;
    }

    public String getFrontside() {
        return frontside;
    }

    public KycIdentityRequestModel setFrontside(String frontside) {
        this.frontside = frontside;
        return this;
    }

    public String getBackside() {
        return backside;
    }

    public KycIdentityRequestModel setBackside(String backside) {
        this.backside = backside;
        return this;
    }

    public String getSelfie() {
        return selfie;
    }

    public KycIdentityRequestModel setSelfie(String selfie) {
        this.selfie = selfie;
        return this;
    }

    public enum Type {

        UNDEFINED("UNDEFINED"),
        ID_CARD("ID_CARD"),
        PASSPORT("PASSPORT"),
        DRIVER_LICENSE("DRIVER_LICENSE");

        private String value;

        Type(String value) {
            this.value = value;
        }

        /**
         * Returns the name of this enum constant, as contained in the
         * declaration.  This method may be overridden, though it typically
         * isn't necessary or desirable.  An enum type should override this
         * method when a more "programmer-friendly" string form exists.
         *
         * @return the name of this enum constant
         */
        @Override
        public String toString() {
            return this.value;
        }

    }

}
