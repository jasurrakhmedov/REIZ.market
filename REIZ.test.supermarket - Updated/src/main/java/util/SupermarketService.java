package util;

import model.SupermarketBase;

import java.math.BigDecimal;
import java.util.List;

public interface SupermarketService {


    void printCashList(List<SupermarketBase> cashlist);

    void printProductList(List<SupermarketBase> products);

    List<SupermarketBase> paidCashQuantity(List<SupermarketBase> CashList, double PaidCash) throws PayNotAcceptedException;

    List<SupermarketBase> minusProductsQuantity(List<SupermarketBase> ProductsQuantity, int BoughtProduct) throws SoldOutException;

    void giveChange(double Change, List<SupermarketBase> CashList, Double y, BigDecimal x, int command) throws NotEnoughChangeException;

    void giveChangePrinter(double Change, int oneCent, int fiveCent, int Command, double y, BigDecimal x);
}
