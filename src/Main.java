import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ExampleClass e1 = new ExampleClass();
        ExampleClass e2 = new ExampleClass();
        e1.setB(true);
        e1.setC('a');
        e1.setString("aaaaa");
        e1.setI(10);
        e2.setB(true);
        e2.setC('a');
        e2.setString("bbbbb");
        e2.setI(10);

        if (!e1.equals(e2))
        {
            System.out.println("Metoda bez annotation zwrocila ze sa rozne");
        }

        if (e1.equals2(e2))
        {
            System.out.println("Metoda z annotation zwrocila ze sa takie same");
        }
    }
}
