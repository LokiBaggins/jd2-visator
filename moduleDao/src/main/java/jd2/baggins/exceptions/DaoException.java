package jd2.baggins.exceptions;

public class DaoException extends RuntimeException {
    public DaoException() {
        super("Something is wrong at DataLayer");
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Exception e) {
        super(e.getMessage());
    }

}
