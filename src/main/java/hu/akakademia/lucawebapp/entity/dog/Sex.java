package hu.akakademia.lucawebapp.entity.dog;

public enum Sex {
    FEMALE ("nőstény"),
    MALE ("kan");

    private final String label;

    Sex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
