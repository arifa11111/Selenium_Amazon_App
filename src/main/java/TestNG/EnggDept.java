package TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EnggDept {

    @Test
    @Parameters({"url"})

    public void intro(String url) {
        System.out.println("Please visit " + url);
        System.out.println("This is engineering department");
    }

    @Test(dataProvider = "getData")
    public void DataProvider(String username,String password){
        System.out.println(username+">>>>>>>>"+password);
    }

    @BeforeTest(groups = {"Smoke"})
    public void end() {
        System.out.println("Engineering is done");
    }

    @DataProvider
    public Object[][] getData() {
        //1st combiantion - username password - good credit history= row
        //2nd - username password  - no crdit history
        // 3rd - fraudelent credit history
        Object[][] data = new Object[3][2];
        //1st set
        data[0][0] = "firstsetusername";
        data[0][1] = "firstpassword";
        //couloumns in the row are nothing but values for that particualar combination(row)

        //2nd set
        data[1][0] = "secondsetusername";
        data[1][1] = "secondpassword";

        //3rd set
        data[2][0] = "thirdsetusername";
        data[2][1] = "thirdpassword";
        return data;

    }
}
