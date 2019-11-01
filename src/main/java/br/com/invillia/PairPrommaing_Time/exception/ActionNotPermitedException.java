package br.com.invillia.PairPrommaing_Time.exception;

public class ActionNotPermitedException extends RuntimeException {

    public ActionNotPermitedException(final String message) {
        super("Action not allowed!");
    }

}