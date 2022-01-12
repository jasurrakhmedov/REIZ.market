package model;

public class SupermarketBase {

    private String NameProduct;
    private double PriceProduct;
    private int QuantityProduct;

    private String CashName;
    private int CashQuantity;


    public SupermarketBase(String nameProduct, double priceProduct, int quantityProduct) {
        NameProduct = nameProduct;
       PriceProduct = priceProduct;
        QuantityProduct = quantityProduct;
    }

    public SupermarketBase(String cashName, int cashQuantity) {
        CashName = cashName;
        CashQuantity = cashQuantity;
    }


    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return PriceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        PriceProduct = priceProduct;
    }

    public int getQuantityProduct() {
        return QuantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        QuantityProduct = quantityProduct;
    }

    public String getCashName() {
        return CashName;
    }

    public void setCashName(String cashName) {
        CashName = cashName;
    }

    public int getCashQuantity() {
        return CashQuantity;
    }

    public void setCashQuantity(int cashQuantity) {
        CashQuantity = cashQuantity;
    }
}
