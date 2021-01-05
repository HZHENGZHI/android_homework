package pojo;

public class test {
    String string;

    public test() {
    }

    public test(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "test{" +
                "string='" + string + '\'' +
                '}';
    }
}
