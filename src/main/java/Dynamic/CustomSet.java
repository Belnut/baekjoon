package Dynamic;

public class CustomSet {
    private int data;
    private int size;

    public CustomSet() {
        size = 20;
        data = 0;
    }

    public void add(int x) {
        data |= (1 << x);
    }

    public void remove(int x) {
        data &= ~(1 << x);
    }

    public int check(int x) {
        int findValue = (1 << x);
        return (data&(findValue)) == (findValue) ? 1 : 0;
    }

    public void toggle(int x) {
        data ^= (1 << x);
    }

    public void all() {
        data = (1 << 21)-1;
    }

    public void empty() {
        data = 0;
    }
}
