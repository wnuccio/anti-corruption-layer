package ch4stringtoenum;

public class Book {
    String title;
    String author;
    Genre genre;

    interface Genre {
        double discountPercentage();
    }

    class Comedy implements Genre {
        @Override
        public double discountPercentage() {
            // some complex logic
            return 0.10;
        }
    }

    class Thriller implements Genre {
        @Override
        public double discountPercentage() {
            // some complex logic
            return 0.20;
        }
    }

    class Unknown implements Genre {
        @Override
        public double discountPercentage() {
            return 0.50; // a default value
        }
    }

}


