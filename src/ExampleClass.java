import java.util.Objects;

public class ExampleClass {
    String string;
    char c;
    int i;
    boolean b;

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
                b == that.b;
                //&& Objects.equals(string, that.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, c, i, b);
    }

    @Override
        @IgnoreEquals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleClass that = (ExampleClass) o;
        return c == that.c &&
                i == that.i &&
                b == that.b &&
                Objects.equals(string, that.string);
    }*/
}
