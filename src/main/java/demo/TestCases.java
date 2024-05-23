package demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class TestCases {
    ChromeDriver driver;
    Wrapper actions;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().browserVersion("124.0.6367.208").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Wrapper(driver);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01(){
        System.out.println("Start Test case: testCase01");
        actions.openUrl("https://forms.gle/wjPkzeSEk1CM7KgGA");
        System.out.println("End Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {

        System.out.println("Start Test Case: testCase02");
        By input = By.xpath("//input[@type='text']");
        WebElement inp = actions.findElement(input);
        Thread.sleep(2000);
        String message = "Sowmathy C M";
        actions.sendkeys(input, message);
        System.out.println("End Test Case: testCase02");
    }

    public void testCase03() throws InterruptedException {

        System.out.println("Start Test Case: testCase03");
        By textarea = By.xpath("//textarea[@class='KHxj8b tL9Q4c']");
        WebElement text = actions.findElement(textarea);
        Date currentdate = new Date();
        long epochtimeinmillisec = currentdate.getTime();
        long epochtimeinsec = epochtimeinmillisec / 1000;
        String textmessage = "I want to be the best QA Engineer!" + epochtimeinsec;
        Thread.sleep(2000);
        actions.sendkeys(textarea, textmessage);
        System.out.println("End Test Case: testCase03");
    }

    public void testCase04()  {

        System.out.println("Start Test Case: testCase04");
        By radiobutton = By.xpath("//div[@class='nWQGrd zwllIb']//div[@id='i13']");
        actions.clickElement(radiobutton);
        System.out.println("End Test Case: testCase04");
    }

    public void testCase05()  {
        System.out.println("Start Test Case: testCase05");
        By javacheckbox = By.xpath(" //div[@class='eBFwI']//div[@id='i30']");
        actions.clickElement(javacheckbox);
        By seleniumcheckbox = By.xpath("//div[@class='eBFwI']//div[@id='i33']");
        actions.clickElement(seleniumcheckbox);
        By testngcheckbox = By.xpath("//div[@class='eBFwI']//div[@id='i39']");
        actions.clickElement(testngcheckbox);
        System.out.println("End Test Case: testCase05");

    }

    public void testCase06() throws InterruptedException {

        System.out.println("Start Test Case: testCase06");
        By dropdown = By.xpath("//div[@role='listbox']//div[@class='ry3kXd']//span[text()='Choose']");
        actions.clickElement(dropdown);
        By option = By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']//span[text()='Ms']");
        actions.clickElement(option);
        Thread.sleep(2000);
        System.out.println("End Test Case: testCase06");

    }

    public void testCase07() {

        System.out.println("Start Test Case: testCase07");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        Date sevendays = calendar.getTime();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        String formatteddate = dateformat.format(sevendays);
        By date = By.xpath("//input[@type='date']");
        actions.sendkeys(date, formatteddate);
        System.out.println("End Test Case: testCase07");
    }

    public void testCase08() {

        System.out.println("Start Test Case: testCase08");
        Date currentTime = new Date();
        SimpleDateFormat hour = new SimpleDateFormat("hh");
        SimpleDateFormat min = new SimpleDateFormat("mm");
        String formattedhour = hour.format(currentTime);
        String formattedmin = min.format(currentTime);
        By hr = By.xpath("//div[@jsname='MKaSrf']//input[@type='number']");
        By mm = By.xpath("//div[@jsname='QbtXXe']//input[@type='number']");
        actions.sendkeys(hr, formattedhour);
        actions.sendkeys(mm, formattedmin);
       System.out.println("End Test Case: testCase08");

    }

    public void testCase09(){

        System.out.println("Start Test Case: testCase09");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location.href = 'https://www.amazon.in'");
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();

        } catch (NoAlertPresentException e) {
            System.out.println("No alert is present");
        }
        System.out.println("End Test Case: testCase09");

    }

    public void testCase10(){

        System.out.println("Start Test Case: testCase10");
        By submit = By.xpath("//div[@role='button']//span[text()='Submit']");
        actions.clickElement(submit);
        System.out.println("End Test Case: testCase10");

    }

    public void testCase11(){
       
        System.out.println("Start Test Case: testCase11");
        By text = By.xpath("//div[text()='Thanks for your response, Automation Wizard!']");
        WebElement msg = actions.findElement(text);
        String message = msg.getText();
        System.out.println(message);
        System.out.println("End Test Case: testCase11");


    }
}
