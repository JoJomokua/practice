package ADT;
import java.util.ArrayList;

public class MySet<T> {
    private ArrayList<T> elements;

    public MySet() {
        elements = new ArrayList<>();
    }
//adding function
    public boolean add(T item) {
        if (!elements.contains(item)) {
            elements.add(item);
            return true;
        }
        return false;
    }
    //removing fn

    public boolean remove(T item) {
        return elements.remove(item);
    }
    //checking  if a value exists

    public boolean contains(T item) {
        return elements.contains(item);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void clear() {
        elements.clear();
    }

    public MySet<T> union(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();

        for (T item : this.elements) {
            result.add(item);
        }

        for (T item : otherSet.elements) {
            result.add(item);
        }

        return result;
    }

    public MySet<T> intersection(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();

        for (T item : this.elements) {
            if (otherSet.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public MySet<T> difference(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();

        for (T item : this.elements) {
            if (!otherSet.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    public static void main(String[] args) {

        //creating a new set
        MySet<Integer> setA = new MySet<>();
        //adding elements
        setA.add(1);
        setA.add(2);
        setA.add(3);

        MySet<Integer> setB = new MySet<>();
        setB.add(3);
        setB.add(4);
        setB.add(5);

        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        System.out.println("Union: " + setA.union(setB));
        System.out.println("Intersection: " + setA.intersection(setB));
        System.out.println("Difference (A - B): " + setA.difference(setB));
    }
}
