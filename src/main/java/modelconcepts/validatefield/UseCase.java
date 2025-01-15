package modelconcepts.validatefield;

public class UseCase {

    public void changePassword(RawPassword rawPassword) {
        if (rawPassword.hasNoSpecialCharacters()) {
            // some alternative behavior
            return;
        }

        if (rawPassword.isTooShort()) {
            // some alternative behavior
            return;
        }

        Password password = rawPassword.validate();
        // proceed with the use case
    }
}
