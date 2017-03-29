import java.util.concurrent.TimeUnit

import org.apache.log4j.Logger
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.scalatest.FlatSpec

class MyntraCustomTest extends FlatSpec with TestSetUp {

  val log = Logger.getLogger(this.getClass)

  "A user" should "visit on Myntra.com" in {

    driver.manage().window().maximize()
    driver.get(bASE_URL)
    val title = driver.getTitle()
    val page_source = driver.getPageSource().length
    if (driver.getCurrentUrl == bASE_URL) {
      log.info("WELCOME TO Myntra.com with title : " + title)
      log.info("the lenght of the pagesource is: " + page_source)
    } else {
      log.info("something went wrong")
    }
  }

  "user" should "logged in " in {
    val mouseHover = new Actions(driver)
    val your_account = driver.findElementByCssSelector(".desktop-userIconsContainer .myntraweb-sprite.desktop-iconUser.sprites-user")
    mouseHover.moveToElement(your_account)
    mouseHover.build().perform()
    driver.findElementByCssSelector(".desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()
    driver.findElementByCssSelector(".login-input-item .login-user-input-email.login-user-input").sendKeys(username)
    driver.findElementByCssSelector(".login-input-item .login-user-input-password.login-user-input").sendKeys(password)
    driver.findElementByCssSelector(".login-login-button-container .login-login-button").click()
    /*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)*/
    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("desktop-headerMount")))
    Thread.sleep(5000)

  }

  "user" should "search for shirts " in {

    driver.findElementByCssSelector(".desktop-bound .desktop-query .desktop-searchBar").click()
    driver.findElementByCssSelector(".desktop-bound .desktop-query .desktop-searchBar").sendKeys(search1)
    driver.findElementByCssSelector(".desktop-bound .desktop-query .desktop-submit").click()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
  }

  "user" should "select First-Product and add it to cart " in {
    driver.findElementByCssSelector(".results-base li:nth-child(6)").click()
    driver.findElementByCssSelector(".size-buttons-size-buttons button:nth-child(2)").click()
    driver.findElementByCssSelector(".pdp-action-container.pdp-fixed button:nth-child(2)").click()

  }

  "user" should "select Second-Product and add it to cart " in {
    driver.findElementByCssSelector(".desktop-bound .desktop-query .desktop-searchBar").click()
    driver.findElementByCssSelector(".desktop-bound .desktop-query .desktop-searchBar").sendKeys(search2)
    driver.findElementByCssSelector(".desktop-bound .desktop-query .desktop-submit").click()
    driver.findElementByCssSelector(".results-base li:nth-child(12)").click()
    driver.findElementByCssSelector(".pdp-action-container.pdp-fixed button:nth-child(2)").click()

  }

  "user" should "Go to cart and verify products" in {

    driver.findElementByClassName("desktop-cart").click()
    Thread.sleep(5000)
    val cart = driver.findElementByCssSelector(".mk-checkout-header-container.m-hide .checkout-bag-header.selected .mk-checkout-header .gray")
    if (cart.getText == "(2 Items)") log.info("Item added")
    else log.info("Item not added")

  }

  "user" should "Add a mailing address" in {

    driver.findElementByCssSelector("div.order-total.footer div.place-order.b-white button.btn.primary-btn.btn-continue.m-button.clickable ").click()
    driver.findElementById("pincode").sendKeys(pincode)
    driver.findElementById("locality").click()
    Thread.sleep(3000)
    driver.findElementById("locality").click()
    driver.findElementByCssSelector(".bd button:nth-child(6)").click()
    driver.findElementById("name").sendKeys(name)
    driver.findElementById("address").sendKeys(address)
    driver.findElementById("mobile").sendKeys(mobileNo)
    driver.findElementByCssSelector(".white-row.buttons .green-button.submit.clickable").click()
    Thread.sleep(3000)

  }

  "user" should "place order at mailing address" in {

    driver.findElementByCssSelector("button.btn.primary-btn.btn-continue.green-button.clickable").click()
    Thread.sleep(3000)
    driver.close()


  }

}
