package observer;

public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl2();

        observable.subscribe(o1);
        observable.subscribe(o2);

        // Anonymous object
        observable.subscribe(obs -> {
            if (obs instanceof ObservableImpl o) {
                System.out.println("\n### OBS Impl 3 ###");
                System.out.printf("Res = %.2f%n", o.getState() * Math.cos(o.getState()));
                System.out.println("##################");
            }
        });

        observable.setState(60);
        observable.setState(50);

        observable.unsubscribe(o2);
        observable.setState(40);
    }
}