class ExceptionA extends Exception{}
class ExceptionB extends ExceptionA{}
class ExceptionC extends ExceptionB{}

public class Ch11Ex16 {
    public static void main(String[] args) {
        try{
            throw new ExceptionC();
        }
        catch (ExceptionA exception1){
            System.err.println("First Exception");
        }

        try{
            throw new ExceptionB();
        }
        catch (ExceptionA exception2){
            System.err.println("Second Exception");
        }
    }
}
