package tests;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "product")
    public static Object[][] getDomainName() {
        return new Object[][] {
                { "test" },
                { "mila-star.com" },
                { "best-status.com" },
                { "molinero-zone.net" },
        };
    }

    @DataProvider(name = "items")
    public static Object[][] getItemsData() {
        return new Object[][] {
                { "test","test category", "test subcategory" },
        };
    }
}
