package util;

import model.SupermarketBase;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        double TotalPaidAmount = 0;
        double CashChange;
        int countText = 0;
        MathContext round = new MathContext(2, RoundingMode.HALF_UP);

        List<SupermarketBase> storageList = ProductStorage.getStorage();
        List<SupermarketBase> CashList = ProductStorage.CashList();

        while (true) {

            System.out.println("-----------------------------");
            System.out.println(countText == 0 ? "Initial product inventory" : "Updated product inventory");
            ProductStorage.printProductList(storageList);
            System.out.println(countText == 0 ? "Initial cash inventory" : "Updated cash inventory");
            ProductStorage.printCashList(CashList);
            System.out.println("----------------------------- \n ");

            countText++;

            printMenu();

            int command = scanner.nextInt();
            try {
                ProductStorage.minusProductsQuantity(storageList, command);
            } catch (SoldOutException e) {
                System.out.println("Product is sold out");
                break;
            }

            if (command == 1) {

                System.out.println("You are trying to buy SODA. You need to pay. You need to pay 2.3");
                System.out.println("Provide Bill or Coin (accepted values: 0.1, 0.5, 1, 2)");

                while (true) {
                    double CashAdded = scanner.nextDouble();
                    TotalPaidAmount += CashAdded;
                    double value = 2.3 - TotalPaidAmount;
                    BigDecimal PaidAmountTotal = new BigDecimal(value, round);

                    try {
                        ProductStorage.paidCashQuantity(CashList, CashAdded);
                    } catch (PayNotAcceptedException e) {
                        System.out.println("Non accepted bills or coins");
                        break;
                    }
                    if (TotalPaidAmount >= 2.3) {
                        CashChange = TotalPaidAmount - 2.3;
                        BigDecimal CashChangeTotal = new BigDecimal(CashChange, round);

                        try {
                            ProductStorage.giveChange(CashChange, CashList, TotalPaidAmount, CashChangeTotal, command);
                            break;
                        } catch (NotEnoughChangeException e) {
                            System.out.println("Not enough Change to complete the Transaction");
                            break;
                        }

                    }
                    System.out.println("You paid " + TotalPaidAmount + " in Total." + " You still need to pay " + PaidAmountTotal);
                }
            } else if (command == 2) {
                System.out.println("You are trying to buy WINE. You need to pay. You need to pay 2.7");
                System.out.println("Provide Bill or Coin (accepted values: 0.1, 0.5, 1, 2)");
                while (true) {
                    double CashAdded = scanner.nextDouble();

                    TotalPaidAmount += CashAdded;

                    double value = 2.7 - TotalPaidAmount;
                    BigDecimal PaidAmountTotal = new BigDecimal(value, round);

                    try {
                        ProductStorage.paidCashQuantity(CashList, CashAdded);
                    } catch (PayNotAcceptedException e) {
                        System.out.println("Non accepted bills or coins");
                        break;
                    }
                    if (TotalPaidAmount >= 2.7) {
                        CashChange = TotalPaidAmount - 2.7;
                        BigDecimal CashChangeTotal = new BigDecimal(CashChange, round);

                        try {
                            ProductStorage.giveChange(CashChange, CashList, TotalPaidAmount, CashChangeTotal, command);
                            break;
                        } catch (NotEnoughChangeException e) {
                            System.out.println("Not enough Change to complete the Transaction");
                            break;
                        }
                    }
                    System.out.println("You paid " + TotalPaidAmount + " in Total." + " You still need to pay " + PaidAmountTotal);
                }
            } else if (command == 3) {
                System.out.println("You are trying to buy BREAD. You need to pay. You need to pay 1.1");
                System.out.println("Provide Bill or Coin (accepted values: 0.1, 0.5, 1, 2)");

                while (true) {
                    double CashAdded = scanner.nextDouble();
                    TotalPaidAmount += CashAdded;

                    double value = 1.1 - TotalPaidAmount;
                    BigDecimal PaidAmountTotal = new BigDecimal(value, round);
                    try {
                        ProductStorage.paidCashQuantity(CashList, CashAdded);
                    } catch (PayNotAcceptedException e) {
                        System.out.println("Non accepted bills or coins");
                        break;
                    }

                    if (TotalPaidAmount >= 1.1) {
                        CashChange = TotalPaidAmount - 1.1;
                        BigDecimal CashChangeTotal = new BigDecimal(CashChange, round);

                        try {
                            ProductStorage.giveChange(CashChange, CashList, TotalPaidAmount, CashChangeTotal, command);
                            break;
                        } catch (NotEnoughChangeException e) {
                            System.out.println("Not enough Change to complete the Transaction");
                            break;
                        }
                    }
                    System.out.println("You paid " + TotalPaidAmount + " in Total." + " You still need to pay " + PaidAmountTotal);
                }

            } else if (command == 4) {
                System.out.println("Exit");
                break;
            }

        }
    }

    public static void printMenu() {

        System.out.println("What would you like to buy? Type in the Number of the desired product");
        System.out.println("1 - SODA (price: 2.3)");
        System.out.println("2 - WINE (price 2.7)");
        System.out.println("3 - BREAD (price: 1.1)");
        System.out.println("4 - To exit");

    }
}

