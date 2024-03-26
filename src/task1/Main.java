package task1;

public class Main {
    public static void main(String[] args) {

        test2();
    }
    public static void test1(){
        throw new JustMyFirstException();

    }
    public static void test2(){

        throw new JustMyFirstException(new Throwable("abc"));

    }


}
