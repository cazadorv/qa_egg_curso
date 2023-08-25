package com.drivesandwaits;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

class ApplicationTest {

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void introImplicitWait() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com"); 
        // Establecer la espera implícita de 10 segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Use explicit wait to wait until an element is visible
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); DEPRECATED desde selenium 4
        driver.close();
    }

    /* ------------------------------------------------------------------------------------------------------ */
    /* ------------------------------------------ Implicit Waits -------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------------ */

    /* 1. Esperar 15 segundos a que aparezca el cuadro de búsqueda en la página principal de Twitter. */
    @Test
    void testImplicitWait_1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.twitter.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Use explicit wait to wait until an element is visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));

        /* 
        DEPRECATED desde selenium 4
        driver.findElement(By.cssSelector("a[data-testid=\"loginButton\"]")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.className("r-30o5oe")).sendKeys("gidijop987@touchend.com",Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[data-testid=\"ocfEnterTextTextInput\"]")).sendKeys("gonzalo0682871",Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456qwerty!",Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[enterkeyhint=\"search\"]")).sendKeys("123456qwerty!",Keys.ENTER); 
        */
        
    }

    /* 2. Esperar un minuto a que se cargue el botón "Load more" en Medium y hacer clic en él. */
    @Test
    void testImplicitWait_2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://medium.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("by.b.eg.ef.cd.eh.cf.cg.ch.ci.cj.ck.cl.cm.cn.co.cp.ei.cq.cr.cs.ct.cu")));
        
        driver.close();
    }

    /* 3. Esperar 45 segundos a que se cargue la sección de comentarios de un video que quieras en YouTube y contar la cantidad de comentarios.*/
    @Test
    void testImplicitWait_3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=oKLvWm0r7vY");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        // Use explicit wait to wait until an element is visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));        
    }

    /* 4. Esperar a que se carguen los resultados de búsqueda en Amazon y obtener el precio del primer producto. */
    @Test
    void testImplicitWait_4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        // Use explicit wait to wait until an element is visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));        
    }

    /* ------------------------------------------------------------------------------------------------------ */
    /* ------------------------------------------ Explicit Waits -------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------------ */

    @Test
    void introExplicitWait() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com"); 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        // Esperar hasta 10 segundos 
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb"))); 
        // Continuar con las acciones en el elemento...
        driver.close();
    }

    /* 1- Esperar a que aparezca el cuadro de búsqueda en Google */
    @Test
    void testImplicitWait_4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        // Use explicit wait to wait until an element is visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));        
    }

    

    /* 2- Esperar a que el botón "Login" sea clickeable en GitHub */

    /* 3- Esperar a que se cargue la lista de categorías en Wikipedia */

    /* 4- Esperar a que esté disponible el menú desplegable de idioma en la página de Facebook */

    /* ------------------------------------------------------------------------------------------------------ */
    /* ------------------------------------------ Fluent Waits ---------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------------ */


    /* 1. Esperar a que aparezca el logo en la página principal de Wikipedia */
    /* 2. Esperar a que se cargue la sección de imágenes destacadas en Unsplash */ 
    /* 3. Esperar a que se cargue el banner principal en la página de tecnología de BBC */
    /* 4. Esperar a que se cargue la sección de "Top Stories" en la página de noticias de CNN 
        Estos ejercicios te ayudarán a comprender cómo aplicar Fluent Wait en situaciones reales
         sin la necesidad de interactuar con páginas que requieran inicio de sesión o creación de una cuenta.*/

}
