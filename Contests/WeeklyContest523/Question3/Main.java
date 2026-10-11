public class Main {
    public static void main(String[] args) {
        BusBooking bus = new BusBooking(20);

        bus.toggle("B3");
        bus.toggle("A3");

        System.out.println(bus.getTotalTime());
        System.out.println(bus.getMinTime());

        bus.toggle("C3");
        bus.toggle("D3");

        System.out.println(bus.getTotalTime());
        System.out.println(bus.getMinTime());

        BusBooking bus2 = new BusBooking(10);

        bus2.toggle("C7");
        bus2.toggle("D7");

        System.out.println(bus2.getTotalTime());

        bus2.toggle("D7");
        bus2.toggle("C7");

        System.out.println(bus2.getTotalTime());

        bus2.toggle("D7");

        System.out.println(bus2.getTotalTime());
        System.out.println(bus2.getMinTime());
    }
}
