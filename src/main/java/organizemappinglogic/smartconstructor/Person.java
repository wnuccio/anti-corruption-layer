package organizemappinglogic.smartconstructor;

public class Person {
    String email;

    public Person(String email) {
        if (email == null)
            throw new ValidationException("Email cannot be null");

        if (isValidEmail(email))
            throw new ValidationException("Email is not valid: " + email);

        this.email = email.toLowerCase();
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}
