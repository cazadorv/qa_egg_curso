package com.cursoegg;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
class ApplicationTest {

    @Test
    void driverManagerFirefox() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
    }

    @Test 
    void VerificarTitutloImagen(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.wikipedia.org/");
        String titulo = driver.getTitle();
        String posibleTitulo = "Wikipedia";

        assertTrue(titulo.equals("Wikipedia"));
        assertEquals(posibleTitulo, titulo);

        // Verificar la ausencia de una imagen específica por su atributo alt
       /*  String imageAltText = "Imagen false";  // Reemplazar con el atributo alt de la imagen
        WebElement imageElement = driver.findElement(By.id("hola"));
        assertNull(imageElement); */

        driver.close();
    }

    /* Ejercicio 4: Verificar la presencia de la barra de búsqueda en Bing y que la sugerencia no aparezca inicialmente */
    @Test 
    void VerificarBarraBing(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.bing.com/");
        WebElement barraBusqueda = driver.findElement(By.id("sb_form_q"));
        assertTrue(barraBusqueda.isDisplayed());
        
        WebElement sugerenciaBusqueda = driver.findElement(By.cssSelector("div.sa_as"));
        assertFalse(sugerenciaBusqueda.isDisplayed());
        
        driver.close();
    }

    /* Ejercicio 5: Verificar la presencia del logotipo de Mozilla y el enlace de "Technology" en la barra de navegación. */
    @Test 
    void VerificarLogoMozilla(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.mozilla.org/es-AR/");
        /* WebElement barraBusqueda = driver.findElement(By.id("sb_form_q"));
        assertTrue(barraBusqueda.isDisplayed());
        
        WebElement sugerenciaBusqueda = driver.findElement(By.cssSelector("div.sa_as"));
        assertFalse(sugerenciaBusqueda.isDisplayed()); */
        
        driver.close();
    }

    /* 
    @Test
    public void Parte2Integracion1() {
         WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bing.com/?setlang=es");
        WebElement buscador=driver.findElement(id("sb_form_q"));
        assertTrue(buscador.isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement sugerenciasCerrada= driver.findElement(cssSelector("div.sa_as[style=\"display: none;\"]"));
        assertTrue(sugerenciasCerrada.isEnabled());
        buscador.sendKeys("perro",Keys.SPACE);
        WebElement sugerenciaAbierta = wait.until(ExpectedConditions.visibilityOfElementLocated
        (cssSelector("div.sa_as[style=\"display: block;\"]")));
        assertTrue(sugerenciaAbierta.isEnabled());
        driver.close(); 
}
    
    @Test
    void testTryCath() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        try {
            WebElement imageElement = driver.findElement(By.cssSelector("span.gNO89b"));
             assertNull(imageElement);
        } 
        catch ( NoSuchElementException e) {
            System.out.println("La imagen no se encontró en la página.");
        }
        catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
    @Test
        public void Parte2Integracion1() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.bing.com/?setlang=es");
            WebElement buscador=driver.findElement(id("sb_form_q"));
            assertTrue(buscador.isDisplayed());
            WebDriverWait wait = new WebDriverWait(driver, 15);
            WebElement sugerenciasCerrada= driver.findElement(cssSelector("div.sa_as[style=\"display: none;]"));
            assertFalse(sugerenciasCerrada.isEnabled());
            buscador.sendKeys("perro",Keys.SPACE);
            WebElement sugerenciaAbierta = wait.until(ExpectedConditions.visibilityOfElementLocated
            (cssSelector("div.sa_as[style=\"display: block;\"]")));
            assertTrue(sugerenciaAbierta.isEnabled());
            driver.close(); 
    }
 */
    

}
