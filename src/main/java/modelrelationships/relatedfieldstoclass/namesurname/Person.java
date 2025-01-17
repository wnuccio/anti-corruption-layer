package modelrelationships.relatedfieldstoclass.namesurname;

public class Person {
    private String name;
    private String surname;

    public String fullName() {
        return name + " " + surname;
    }
}
