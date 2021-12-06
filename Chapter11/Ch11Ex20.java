
public class Ch11Ex20 {
    static void someMethod() throws Throwable {
        try{
            someMethod2();
        }
        catch (Exception exc){
            throw exc;
        }
    }

    static void someMethod2() throws Exception {
        throw new Exception("throw from method2");
    }

    public static void main(String[] args) throws Throwable {
        try {
            someMethod();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
