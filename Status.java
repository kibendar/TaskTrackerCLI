public enum Status {
    TO_DO ("todo"),
    IN_PROGRESS("in-progress"),
    DONE("done");

    public final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Status{" +
                "value='" + value + '\'' +
                '}';
    }
}
