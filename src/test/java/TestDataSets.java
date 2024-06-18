public class TestDataSets {
    public  static object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"invalid@gmail.com","invalidPass"},
                {"demo@koel.dev","invalidPass"},
                {"invalidEmail@demo.dev","demo"},
                {"",""},
        };
    }
}
