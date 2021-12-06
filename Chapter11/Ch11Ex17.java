import java.io.IOException;

class ExceptionA1 extends Exception{}
class ExceptionB1 extends ExceptionA1{}

public class Ch11Ex17 {
    public static void main(String[] args) {
        try{
            throw new ExceptionA1();
        }
        catch (Exception exc1){
            System.err.println("ExceptionA");
        }

        try{
            throw new ExceptionB1();
        }
        catch (Exception exc2){
            System.err.println("ExceptionB");
        }

        try{
            throw new NullPointerException();
        }
        catch (Exception exc3){
            System.err.println("NullPointerException");
        }

        try{
            throw new IOException();
        }

        catch (Exception exc4){
            System.err.println("IOException");
        }
    }
}
