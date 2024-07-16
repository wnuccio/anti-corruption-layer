package organizemappinglogic.smartconstructor;

public class PersonFactory {

    public Person personWithEmail(String email) {
        if (email == null)
            throw new ValidationException("Email cannot be null");

        if (isValidEmail(email))
            throw new ValidationException("Email is not valid: " + email);

        return new Person(email);
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}
