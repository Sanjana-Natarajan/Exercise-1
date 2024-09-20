
package observerpatterndemo;

/**
 *
 * @author sanjana
 */
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float price);
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(float price) {
        System.out.println(name + " received update: Stock price is now $" + price);
    }
}

class Stock {
    private List<Observer> observers = new ArrayList<>();
    private float price;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Investor investor1 = new Investor("A");
        Investor investor2 = new Investor("B");

        stock.addObserver(investor1);
        stock.addObserver(investor2);

        stock.setPrice(100.50f); // Both investors receive the update
        stock.setPrice(102.75f); // Both investors receive the update
    }
}
