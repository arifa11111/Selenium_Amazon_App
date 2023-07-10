package TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class QADept {
    @AfterMethod
    public void beforeMethod(){
        System.out.println("********After Test********");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("@@@@@@@After classs@@@@@@@@");
    }

    @Test
    public void Login(){
        System.out.println("Login......QA");
    }

    @Test(dependsOnMethods={"Login"})
    public void QAintroMethod(){
        System.out.println("This is QA depatment");
//        Assert.assertFalse(true);
    }

    @AfterSuite
    public void me(){
        System.out.println("Arifa Shaik");
    }

    @Test(groups={"Smoke"})
    public void end(){
        System.out.println("QA is done");
    }
}
