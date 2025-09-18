package se.jensen.linea.DiceForSlice;

public class Player {
    private String firstName;
    private String lastName;
    private int score;

    public Player(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException{
       if (firstName == null || firstName.trim().isEmpty()) {
           throw new IllegalArgumentException("You need to enter first name.");
       } else {this.firstName = firstName;}

    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("You need to enter last name.");
        } else {this.lastName = lastName;}
    }
}
