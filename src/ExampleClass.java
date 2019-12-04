import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class ExampleClass {
    private String string;
    private char c;
    private int i;
    private boolean b;

    @IgnoreEquals
    public String getString() {
        return string;
    }

    public char getC() {
        return c;
    }

    public int getI() {
        return i;
    }

    public boolean isB() {
        return b;
    }


    public void setString(String string) {
        this.string = string;
    }

    public void setC(char c) {
        this.c = c;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleClass that = (ExampleClass) o;
        return c == that.c &&
                i == that.i &&
                b == that.b
                && Objects.equals(string, that.string);
    }
    public boolean equals2(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class cls = obj.getClass();
        Method[] methods = cls.getDeclaredMethods();
        boolean[] returns = {true, true, true, true};
        int i = 0;
        for (Method method:methods)
        {
            if (method.getName().contains("get") || method.getName().contains("is") )
            {
                if (method.getAnnotation(IgnoreEquals.class) != null)
                {
                    returns[i++] = true;
                }
                else
                {
                    returns[i++] = method.invoke(this) == method.invoke(obj);
                }
            }
        }
        boolean final_return = true;
        for (int j = 0; j > i; j++)
        {
            final_return = final_return && returns[j];
        }
        return final_return;
    }
    @Override
    public int hashCode() {
        return Objects.hash(string, c, i, b);
    }
}
