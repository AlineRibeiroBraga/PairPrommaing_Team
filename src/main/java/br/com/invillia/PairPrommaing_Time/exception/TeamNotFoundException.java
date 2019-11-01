package br.com.invillia.PairPrommaing_Time.exception;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(final String message) {
        super("Team not found, ID: " + message);
    }

}
