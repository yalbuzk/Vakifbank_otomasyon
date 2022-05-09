package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Kredi_Steps {
    private WebDriver driver;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("www.vakifbank.com.tr sitesine giris yapilir.")
    public void www_vakifbank_com_tr_sitesine_giris_yapilir() {
        driver.get("https://www.vakifbank.com.tr/");
    }

    @When("Bireysel tabanina tiklanir.")
    public void bireysel_tabanina_tiklanir() {
        driver.findElement(By.xpath("//a[@id=\"ctl00_ctl06_ctl00_rptMenu_ctl00_hypLink\"]")).click();
    }
    @And("Hesaplama araclarinda kredi taksitleri butonuna tiklanir.")
    public void hesaplama_araclarinda_kredi_taksitleri_butonuna_tiklanir() {
        driver.findElement(By.xpath("//a[@href=\"/kredi-hesaplama-araci.aspx?pageID=1333\"]")).click();
    }

    @And("Kredi Combobox'indan KONUT KREDISI ADK secenegi tiklanir.")
    public void krediComboboxIndanKONUTKREDISIADKSecenegiTiklanir() {
        driver.findElement(By.xpath("//option[@value=\"6000004326-55500113\"]")).click();
    }

    @And("Vade olarak oniki ay yazilir.")
    public void vade_olarak_oniki_ay_yazilir() {
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl10_ctl00_txtVade\"]")).sendKeys("12");
       /* JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement a = driver.findElement(By.xpath("//div[@id=\"ctl00_ctl10_ctl00_ajaxPanel\"]/div[2]/div[2]/div[1]/div[1]/div[1]"));
        js.executeScript("arguments[0].setAttribute('style', 'left: 12%;')",a); */
    }

    @And("Tutar olarak onbin tl girilir.")
    public void tutar_olarak_onbin_tl_girilir() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement a = driver.findElement(By.xpath("//div[@id=\"ctl00_ctl10_ctl00_ajaxPanel\"]/div[3]/div[2]/div[1]/div[1]/div[1]"));
        js.executeScript("arguments[0].setAttribute('style', 'left: 0%;')",a);

    }

    @And("Hesapla butonuna basilir.")
    public void hesapla_butonuna_basilir() {
        driver.findElement(By.xpath("//a[@id=\"ctl00_ctl10_ctl00_btnHesapla\"]")).click();
    }

    @And("Gelen Kredi Bilgileri alaninda kredi tipinin “KONUT KREDİSİ ADK” yazili oldugu kontrol edilir.")
    public void gelen_kredi_bilgileri_alaninda_kredi_tipinin_konut_kredisi_adk_yazili_oldugu_kontrol_edilir() {
        WebElement Kredi_Steps_ADK = driver.findElement(By.xpath("//table[@class=\"hesap-table\"]/tbody/tr[1]/td[4]"));
        Assert.assertEquals(Kredi_Steps_ADK.getText(), "KONUT KREDISI ADK");
    }

    @And("Kredi Miktarinin onbin TL olarak yazili oldugu kontrol edilir.")
    public void kredi_miktarinin_onbin_tl_olarak_yazili_oldugu_kontrol_edilir() {
        WebElement Kredi_Steps_Tutar = driver.findElement(By.xpath("//table[@class=\"hesap-table\"]/tbody/tr[1]/td[2]"));
        Assert.assertEquals(Kredi_Steps_Tutar.getText(), "10.000,00TL");
    }

    @And("Odeme planina tiklanir.")
    public void odeme_planina_tiklanir() {
        driver.findElement(By.xpath("//a[@href=\"javascript:;\"]")).click();
    }

    @Then("Acilan ekranda Ana para bakiye kolonunun ilk elemaninin onbin TL yazili oldugu kontrol edilir.")
    public void acilan_ekranda_ana_para_bakiye_kolonunun_ilk_elemaninin_onbin_tl_yazili_oldugu_kontrol_edilir() {
        WebElement Kredi_Steps_Tutar = driver.findElement(By.xpath("//table[@class=\"SariGrid\"]/tbody/tr[2]/td[6]"));
        Assert.assertEquals(Kredi_Steps_Tutar.getText(), "10.000,00TL");
    }

}
