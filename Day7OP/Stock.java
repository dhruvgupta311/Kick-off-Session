import java.util.ArrayList;
import java.util.List;

class Stocks{
    String name;
    int numberOfShares;
    double sharePrice;

    public Stocks(String name, int numberOfShares, double sharePrice) {
        this.name = name;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double getValue() {
        return numberOfShares * sharePrice;
    }
}

class StockPortfolio {
    List<Stocks> stocks = new ArrayList<>();

    public void addStock(Stocks stock) { 
        stocks.add(stock);
    }

    public void Report() {
        double totalValue = 0;
        for (Stocks stock : stocks) {
            double value = stock.getValue();
            totalValue += value;
            System.out.println("Stock: " + stock.name + ", Value: $" + value);
        }
        System.out.println("Total Portfolio Value: $" + totalValue);
    }
}

public class Stock {
    public static void main(String[] args) {
        StockPortfolio portfolio = new StockPortfolio();
        Stocks obj1=new Stocks("Apple", 10, 150.0);
        Stocks obj2=new Stocks("Tesla", 5, 200.0);
        portfolio.addStock(obj1);
        portfolio.addStock(obj2);
        portfolio.Report();
    }
}
