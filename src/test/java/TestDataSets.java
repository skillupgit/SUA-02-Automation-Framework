import org.testng.annotations.DataProvider;
public class TestDataSets {
    @DataProvider(name = "NegativeLoginTestData")
    public  static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"invalid@gmail.com","invalidPass"},
                {"demo@koel.dev","invalidPass"},
                {"invalidEmail@demo.dev","demo"},
                {"",""},
        };
    }

}



