package ro.fasttrackit.homework2.model;

public class CategorizedPerson {
    private final Person person;
    private final String ageRange;

    public CategorizedPerson(Person person) {
        this.person = person;
        this.ageRange = setAgeRange(person.age());
    }

    public Person getPerson() {
        return person;
    }

    public String getAgeRange() {
        return ageRange;
    }

    private String setAgeRange(int age) {
        if (age <= 30) {
            return "1-30";
        } else if (age <= 50) {
            return "31-50";
        } else {
            return "51+";
        }
    }
}
