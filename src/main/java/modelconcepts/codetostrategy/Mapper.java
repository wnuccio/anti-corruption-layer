package modelconcepts.codetostrategy;

public class Mapper {

    Genre genreDtoToGenre(String genre) {
        switch (genre) {
            case "comedy":
                return new Comedy();
            case "thriller":
                return new Thriller();
            case "fantasy":
            case "horror":
                return new Fiction();
            default:
                throw new IllegalArgumentException("Invalid genre: " + genre);
        }
    }
}
