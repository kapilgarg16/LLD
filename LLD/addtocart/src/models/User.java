package models;

public class User {
    private String id;
    private String name;
    private Cart cart;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.cart = new Cart();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }
}

