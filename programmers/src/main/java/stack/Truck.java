package stack;

public class Truck {
    int weight;
    int position;

    public Truck(int weight) {
        this.weight = weight;
        this.position = 1;
    }

    public void moving() {
        position++;
    }

    public int weight() {
        return weight;
    }

    public int position() {
        return position;
    }
}
