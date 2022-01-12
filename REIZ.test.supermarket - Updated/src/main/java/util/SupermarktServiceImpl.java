package util;

import model.SupermarketBase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SupermarktServiceImpl implements SupermarketService {

    private static SupermarktServiceImpl instance;

    private SupermarktServiceImpl() {
    }

    public static SupermarktServiceImpl getInstance() {
        if (instance == null) {
            instance = new SupermarktServiceImpl();
        }
        return instance;

    }

    public static List<SupermarketBase> getStorage() {

        List<SupermarketBase> ProductList = new ArrayList<>();
        ProductList.add(new SupermarketBase("SODA", 2.3, 10));
        ProductList.add(new SupermarketBase("BREAD", 1.1, 10));
        ProductList.add(new SupermarketBase("WINE", 2.7, 10));

        return ProductList;
    }

    public static List<SupermarketBase> CashList() {

        List<SupermarketBase> CashList = new ArrayList<>();
        CashList.add(new SupermarketBase("2", 10));
        CashList.add(new SupermarketBase("1", 10));
        CashList.add(new SupermarketBase("0.5", 10));
        CashList.add(new SupermarketBase("0.1", 10));

        return CashList;
    }

    @Override
    public void printCashList(List<SupermarketBase> cashlist) {

        cashlist.stream().forEach(e ->
                System.out.println("Value: " + e.getCashName() + ", Quantity: " + e.getCashQuantity()));
    }

    @Override
    public void printProductList(List<SupermarketBase> products) {

        products.stream().forEach(e ->
                System.out.println(e.getNameProduct() + ", Quantity: " + e.getQuantityProduct()));

    }

    @Override
    public List<SupermarketBase> paidCashQuantity(List<SupermarketBase> CashList, double PaidCash) throws PayNotAcceptedException {
        if (PaidCash == 2) {
            CashList.get(0).setCashQuantity(CashList.get(0).getCashQuantity() + 1);
        } else if (PaidCash == 1) {
            CashList.get(1).setCashQuantity(CashList.get(1).getCashQuantity() + 1);
        } else if (PaidCash == 0.5) {
            CashList.get(2).setCashQuantity(CashList.get(2).getCashQuantity() + 1);
        } else if (PaidCash == 0.1) {
            CashList.get(3).setCashQuantity(CashList.get(3).getCashQuantity() + 1);
        } else {
            throw new PayNotAcceptedException();
        }
        return CashList;


    }

    @Override
    public List<SupermarketBase> minusProductsQuantity(List<SupermarketBase> ProductsQuantity, int BoughtProduct) throws SoldOutException {
        if (ProductsQuantity.get(0).getQuantityProduct() <= 0 ||
                ProductsQuantity.get(1).getQuantityProduct() <= 0 ||
                ProductsQuantity.get(2).getQuantityProduct() <= 0
        ) {
            throw new SoldOutException();
        }
        if (BoughtProduct == 1) {
            ProductsQuantity.get(0).setQuantityProduct(ProductsQuantity.get(0).getQuantityProduct() - 1);
        } else if (BoughtProduct == 3) {
            ProductsQuantity.get(1).setQuantityProduct(ProductsQuantity.get(1).getQuantityProduct() - 1);
        } else if (BoughtProduct == 2) {
            ProductsQuantity.get(2).setQuantityProduct(ProductsQuantity.get(2).getQuantityProduct() - 1);

        }

        return ProductsQuantity;

    }
    @Override
    public void giveChange(double Change, List<SupermarketBase> CashList, Double y, BigDecimal x, int command) throws NotEnoughChangeException {
        int OneCentQuantity;
        int FiveCentQuantity;
        BigDecimal u = x;

        if (Change % 0.5 != 0 && Change > 0.5) {

            OneCentQuantity = (int) Math.round((Change % 0.5) * 10);
            FiveCentQuantity = (int) Math.round((Change - (Change % 0.5)) / 0.5);

            if (OneCentQuantity > CashList.get(3).getCashQuantity() ||
                    FiveCentQuantity > CashList.get(2).getCashQuantity()
            ) {
                throw new NotEnoughChangeException();
            }
            SupermarktServiceImpl r = new SupermarktServiceImpl();
            r.giveChangePrinter(Change, OneCentQuantity, FiveCentQuantity, command, y, u);
            CashList.get(2).setCashQuantity(CashList.get(2).getCashQuantity() - FiveCentQuantity);
            CashList.get(3).setCashQuantity(CashList.get(3).getCashQuantity() - OneCentQuantity);

        } else if (Change % 0.5 == 0) {

            FiveCentQuantity = (int) (Change / 0.5);
            CashList.get(2).setCashQuantity(CashList.get(2).getCashQuantity() - FiveCentQuantity);
            System.out.println("Value: " + "0.5" + ", Quantity: " + FiveCentQuantity);

        }

    }
    @Override
    public void giveChangePrinter(double Change, int oneCent, int fiveCent, int Command, double y, BigDecimal x) {
        if (Change != 0) {

            System.out.println("You paid " + y + " in Total." + " Your change will be: " + x);
            System.out.println("Here is your Change: ");
        }

        System.out.println("Value: " + "0.1" + ", Quantity: " + oneCent+"\n"
                +"Value: " + "0.5" + ", Quantity: " + fiveCent);
        System.out.println(Command == 1 ? "Here is your Product: SODA" : (Command == 2 ? "Here is your Product: WINE" : "Here is your Product: BREAD"));
    }
}
class NotEnoughChangeException extends Exception {

    public NotEnoughChangeException() {

        super();

    }
}

class SoldOutException extends Exception {

    public SoldOutException() {

        super();

    }
}

class PayNotAcceptedException extends Exception {

    public PayNotAcceptedException() {

        super();

    }
}
