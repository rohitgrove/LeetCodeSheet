public class Main {
    public static void main(String[] args) {
        Fancy fancy = new Fancy();
        fancy.append(2);
        fancy.addAll(3);
        fancy.append(7);
        fancy.multAll(2);
        System.out.println(fancy.getIndex(0));
        fancy.addAll(3);
        fancy.append(10);
        fancy.multAll(2);
        System.out.println(fancy.getIndex(0));
        System.out.println(fancy.getIndex(1));
        System.out.println(fancy.getIndex(2));
    }
}
