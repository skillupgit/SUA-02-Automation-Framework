import org.testng.annotations.DataProvider;
public class ProfileNameChangeTest {
    @DataProvider(name = "ProfileNameChangeTestSet")
    public Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"","Deep"},
                {"","ABC"},
                {"","User"},

        };
    }
}

