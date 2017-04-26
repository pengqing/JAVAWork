//¹È¸èä¯ÀÀÆ÷´ò¿ªÓÊÏä²âÊÔ
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class JavaTest {
    public static void main(String[] args)throws Exception {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\Enviroment/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://mail.10086.cn/");
        //driver.get("http://mail.qq.com/");  Thread.sleep(5000);
        driver.findElement(By.id("u")).sendKeys("123024241"); //»ñÈ¡ÔªËØ
        driver.findElement(By.id("p")).sendKeys("pq3780846");
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(5000);
        driver.switchTo().frame("ifbg");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='navigate']/div/ul/li[1]/a")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();  
        driver.findElement(By.xpath("//div[@class='newdayArea'][1]//label")).click();
        driver.findElement(By.xpath("//*[text()='É¾³ý']")).click();
        Thread.sleep(5000);
        driver.close();
        
    }
}