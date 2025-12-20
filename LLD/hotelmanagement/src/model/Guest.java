package model;

public class Guest {
    private String guestId;
    private String name;
    private String phone;
    private String email;

    public Guest(String guestId, String name, String phone, String email) {
        this.guestId = guestId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getGuestId() {
        return guestId;
    }

    @Override
    public String toString() {
        return "Guest [id=" + guestId + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
    }
}
