import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNGAnotations {

    @Test
    public void test1(){
        System.out.println("Test 1 executed");
        Assert.assertTrue(2==2);
    }

    @Test
    public void test2(){
        System.out.println("Test 2 executed");
        SoftAssert s = new SoftAssert();
        s.fail("fail softly ");
        s.assertEquals(2,5);
        Assert.assertTrue(2==2);

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}
