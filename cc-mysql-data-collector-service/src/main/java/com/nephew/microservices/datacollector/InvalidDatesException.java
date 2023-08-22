package com.nephew.microservices.datacollector;

public class InvalidDatesException extends Exception {
    
	private static final long serialVersionUID = -4864148103047317111L;

	public InvalidDatesException() {
        super();
    }

    public InvalidDatesException(String message) {
        super(message);
    }

    public InvalidDatesException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDatesException(Throwable cause) {
        super(cause);
    }
}
