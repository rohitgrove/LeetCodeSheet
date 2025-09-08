public class Main {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1); // set = [1]
        myHashSet.add(2); // set = [1, 2]
        myHashSet.printHashSet();
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2); // set = [1, 2]
        myHashSet.printHashSet();
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2); // set = [1]
        myHashSet.printHashSet();
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}
