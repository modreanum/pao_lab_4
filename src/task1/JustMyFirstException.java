package task1;

public class JustMyFirstException extends RuntimeException {

    public JustMyFirstException() {
        super("Oopsie! This is my first exception!");
    }

    public JustMyFirstException(Throwable t){

        super ("Oopsie! This is my first exception!",t);
    }




}
