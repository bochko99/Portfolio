package pojos.preordercard;

public class CardPreorderModel {
    private Long queueNumber;
    private CardPreorderStatus status;

    public Long getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(Long queueNumber) {
        this.queueNumber = queueNumber;
    }

    public CardPreorderStatus getStatus() {
        return status;
    }

    public void setStatus(CardPreorderStatus status) {
        this.status = status;
    }


    public enum CardPreorderStatus {
        PREORDERED("Preordered"),
        NONE("None");

        private String value;

        CardPreorderStatus(String value) {

        }

        public String getValue() {
            return value;
        }
    }
}
