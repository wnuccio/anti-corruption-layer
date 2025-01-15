package modelconcepts.validatefield;

public class RawPassword {
    private String password;

    public RawPassword(String password) {
        this.password = password;
    }

    public boolean hasNoSpecialCharacters() {
        return ! (password.contains("&") ||
                password.contains("#") ||
                password.contains("!"));
    }

    public boolean isTooShort() {
        return password.length() < 8;
    }

    public Password validate() {
        if (hasNoSpecialCharacters())
            throw new IllegalArgumentException();
        if (isTooShort())
            throw new IllegalArgumentException();

        return new Password(password);
    }
}
