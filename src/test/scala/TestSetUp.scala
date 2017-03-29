import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.WebDriverWait

trait TestSetUp {

  val bASE_URL = "http://www.myntra.com/"
  val username = "nitin40.garg@gmail.com"
  val password = "Nitin123"
  val search1="Shirts"
  val search2="band"
  val pincode="122001"
  val name="Nitin Aggarwal"
  val address="520/5,Patel Nagar,Gurugram"
  val mobileNo="9999950386"
  System.setProperty("webdriver.chrome.driver", "/home/knoldus/Downloads/chromedriver")
  val capabilities = DesiredCapabilities.chrome()
  val driver = new ChromeDriver(capabilities)
  val webdriverwait = new WebDriverWait(driver, 10)

}
