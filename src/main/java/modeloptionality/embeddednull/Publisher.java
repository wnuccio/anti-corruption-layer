package modeloptionality.embeddednull;

import java.util.Optional;

public class Publisher {
    private final String name;

    public Publisher(String name) {
        this.name = name == null || name.trim().isEmpty() ? null : name;
    }

    public static Publisher noPublisher() {
        return new Publisher(null);
    }

    private Optional<String> name() {
        return Optional.ofNullable(name);
    }

    public String orElse(String name) {
        return name().orElse(name);
    }

    public boolean isPresent() {
        return name().isPresent();
    }

    public Publisher presentOrThrow() {
        if (isPresent()) return this;
        throw new IllegalStateException("Publisher is not present");
    }
}
