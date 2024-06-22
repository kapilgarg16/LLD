package entity;

public class User {
    private int userId;
    private Card card;
    public User(int userId, Card card) {
        this.userId = userId;
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
}
