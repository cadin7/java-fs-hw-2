package ro.fasttrackit.homework2.model;

public record Person(String firstName, String lastName, int age) {

    public String getFullName() {
        return firstName() + " " + lastName();
    }
}
