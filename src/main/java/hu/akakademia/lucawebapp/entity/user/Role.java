package hu.akakademia.lucawebapp.entity.user;

public enum Role {
    VISITOR("Látogató"),
    USER("Önkéntes"),
    ADMIN("Admin"),
    SYSTEM_ADMIN("Rendszer Admnisztrátor");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}