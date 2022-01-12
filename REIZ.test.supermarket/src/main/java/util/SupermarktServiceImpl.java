package util;

final class SupermarktServiceImpl implements SupermarketService {

    private static SupermarktServiceImpl instance;

    private SupermarktServiceImpl() {
    }

    public static SupermarktServiceImpl getInstance() {
        if (instance == null) {
            instance = new SupermarktServiceImpl();
        }
        return instance;

    }
}
