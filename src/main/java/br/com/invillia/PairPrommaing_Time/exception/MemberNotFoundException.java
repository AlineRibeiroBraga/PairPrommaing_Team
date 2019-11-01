package br.com.invillia.PairPrommaing_Time.exception;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException (final String message) {
        super("Member not found, ID: " + message);
    }
}
