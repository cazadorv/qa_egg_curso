package com.cursoegg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;

class ApplicationTest {

    @Test
    void pruebaID() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.netflix.com/ar-en/login");

        //Obtenemos el input de email y completamos con un correo electronico
        WebElement inputEmail = driver.findElement(By.id("id_userLoginId"));
        inputEmail.sendKeys("prueba@prueba.com");

        //obtenemos el input de contrasenia y completamos
        WebElement inputPass = driver.findElement(By.id("id_password"));
        inputPass.sendKeys("prueba@prueba.com");

        //buscamos el boton para enviar el formulario
        WebElement btn = driver.findElement(By.cssSelector("button[type=submit]"));
        btn.click();
        
        // Ejemplo: Espera hasta que un elemento con el ID "elementId" esté visible en la página
        WebDriverWait wait = new WebDriverWait(driver, 10); // Espera hasta 10 segundos máximo
        WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("reset your password.")));
         

        //Thread.sleep(5000);
        //buscamos el boton para enviar el formulario
        //WebElement texto = driver.findElement(By.linkText("reset your password."));

        assertEquals("reset your password", texto.getText());
        


        /* driver.manage().window().maximize();
        driver.get("https://openai.com/");
        Point p = driver.manage().window().getPosition();
        Dimension d = driver.manage().window().getSize();
        driver.manage().window().setPosition(new Point(((d.getHeight())/50-p.getX()), ((d.getWidth()/50)-p.getY())));
        centerWindow(driver); */

        /*
            Práctica Integradora
            El objetivo del ejercicio es: 
            1. Abrir el navegador y navegar a la página de inicio de Google. 
            2. Maximizar la ventana del navegador. 
            3. Navegar a la página de inicio de OpenAI. 
            4. Reducir la ventana del navegador a la mitad de su tamaño y centrarla en la pantalla. 
            5. Navegar a la página de inicio de Wikipedia. 
            6. Cambiar el tamaño de la ventana del navegador a su tamaño original 
            7. Cerrar el navegador

         */


        /* 
            Ejerciico para volver a una pagina anterior

            driver.navigate().to("https://www.google.com/");
            driver.navigate().to("https://openai.com/");
            driver.navigate().back();
         */


        /*
            Ejercicio de minizar y maximizar

            Point p = driver.manage().window().getPosition();
            Dimension d = driver.manage().window().getSize();
            driver.manage().window().setPosition(new Point((d.getHeight()-p.getX()), (d.getWidth()-p.getY())));
            
            driver.manage().window().maximize();
        */
        /* Keys.ENTER */
        Thread.sleep(5000);
        //driver.quit();

    }

    @Test
    void pruebaWikiLinText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://es.wikipedia.org/wiki/Wiki");

        // Ejemplo: Espera hasta que un elemento con el ID "elementId" esté visible en la página
        WebDriverWait wait = new WebDriverWait(driver, 10); // Espera hasta 10 segundos máximo
        WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("nombre")));

        assertEquals("nombre", texto.getText());
      
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    void pruebaWikiName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

        // Ejemplo: Espera hasta que un elemento con el ID "elementId" esté visible en la página
        WebDriverWait wait = new WebDriverWait(driver, 10); // Espera hasta 10 segundos máximo
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
        input.click();
        input.sendKeys("Hola mundo!",Keys.ENTER);
      
        Thread.sleep(5000);
        //driver.quit();
    }

    @Test
    void pruebaClassName2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.thisisfeliznavidad.com/productos/invader-sweater/");

        //Obtenemos el input de email y completamos con un correo electronico
        int cantImagenes = driver.findElements(By.className("product-slider-image")).size();
        
        System.out.println("Cantidad de imagenes en la pagina: "+ cantImagenes);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    void pruebaClassName3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.thisisfeliznavidad.com/por-producto/retro-sweaters/?mpage=5");

        //Obtenemos el input de email y completamos con un correo electronico
        List<WebElement> listaProductos = driver.findElements(By.className("js-item-name"));
        int cantidad = 0;
        for (WebElement elemento : listaProductos) {
            // Accede al elemento actual
            String texto = elemento.getText();
            //System.out.println(texto);
            String textobuscado = "Star Wars";
            if(texto.contains(textobuscado)){
                ++cantidad;
            }
        }
        System.out.println("cantidad de productoscon la palabra STAR WARS: "+ cantidad);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    void pruebaTagName1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wizardingworld.com/");

        //Obtenemos el elemento h2
        int cantH2 = driver.findElements(By.tagName("h2")).size();

        System.out.println("Cantidad de H2 en la pagina: "+ cantH2);
        Thread.sleep(5000);
        //driver.quit();
    }

    @Test
    void driverManagerChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.twitter.com");
        driver.findElement(By.cssSelector("a[data-testid=\"loginButton\"]")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.className("r-30o5oe")).sendKeys("gidijop987@touchend.com",Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[data-testid=\"ocfEnterTextTextInput\"]")).sendKeys("gonzalo0682871",Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456qwerty!",Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[enterkeyhint=\"search\"]")).sendKeys("123456qwerty!",Keys.ENTER);
    }


    @Test
    @DisplayName("Prueba de entrar a git gub")
    void testEsperarLoginGithub () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/");
       
        WebDriverWait wait = new WebDriverWait(driver, 10); 
        WebElement btnSingIn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        btnSingIn.click();
        
        //System.out.println("Elemento encontrado"+ btnSingIn.getAttribute("href"));
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    void googleImplicitWaitGoogle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.ar/");
        WebElement buscador=driver.findElement(By.id("APjFqb"));
        buscador.sendKeys("Perro");
        buscador.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*driver.findElement(cssSelector("h3.LC20lb"));*/
        driver.findElement(By.className("yuRUbf")).click();
    }
    @Test
    void googleExplicitWaitGoogle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.cssSelector("a.focusIndicatorRemove[href=\"/mundo/topics/cyx5krnw38vt\"]")));
        elemento.click();

        WebElement btCookie = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.cssSelector("button[data-cookie-banner=\"accept\"]")));
        btCookie.click();


        WebElement sgtPagina = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.cssSelector("a.focusIndicatorOutlineBlack[aria-labelledby=\"pagination-next-page\"]")));
        sgtPagina.click();    
     }

     WebDriver driver = new ChromeDriver();
     @Test
     void googleFluentWait(){
       /*  WebDriverManager.chromedriver().setup();
        driver.get("https://es.wikipedia.org/w/index.php?search=&title=Especial%3ABuscar"); 
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) .withTimeout(Duration.ofSeconds(10)) 
        // Tiempo máximo de espera 
        .pollingEvery(Duration.ofMillis(500)) 
        // Frecuencia de verificación 
        .ignoring(NoSuchElementException.class); 
        // Ignorar esta excepción durante la espera 
        WebElement inputSearch = wait.until(new Function<WebDriver, WebElement>() { 
                 WebElement apply(WebDriver driver) { return driver.findElement(By.id("ooui-php-1")); // Condición de espera 
            } });

        inputSearch.sendKeys("inteligencia artificial", Keys.ENTER);  */
        //driver.quit();
     }

     @Test
    void testGoogleHomePageLoaded() {
      
        // Verificar que el logo de Google esté visible
        WebElement googleLogo = driver.findElement(By.id("hplogo"));
        assertTrue(googleLogo.isDisplayed(), "El logo de Google no está visible");

        // Verificar que la caja de búsqueda esté habilitada
        WebElement searchBox = driver.findElement(By.name("q"));
        assertTrue(searchBox.isEnabled(), "La caja de búsqueda no está habilitada");

        // Verificar que el botón "Buscar con Google" esté habilitado
        WebElement searchButton = driver.findElement(By.name("btnK"));
        assertTrue(searchButton.isEnabled(), "El botón 'Buscar con Google' no está habilitado");

        // Verificar que el botón "Voy a tener suerte" esté habilitado
        WebElement luckyButton = driver.findElement(By.name("btnI"));
        assertTrue(luckyButton.isEnabled(), "El botón 'Voy a tener suerte' no está habilitado");

        // Verificar el tamaño de la caja de búsqueda
        assertEquals(1, searchBox.getSize().getHeight(), "El tamaño de la caja de búsqueda es incorrecto");  
    }

    @Test
       void VerificarElementoInexistente(){
         WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
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
    void VerificarImgSinAtributo(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://github.com/");
            WebElement img= driver.findElement(By.cssSelector( "img[src=\"https://github.githubassets.com/images/modules/site/home-campaign/hero-drone.webp\"]"));
            assertNull(img.getAttribute("alt1"));
            driver.close();
        
    }

    /** Integración Assertions I */

     @Test 
        void VerificarInputNulo(){
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.get("https://github.com/");
            WebElement inputBuscar= driver.findElement(By.id("APjFqb"));
            String textoInput = inputBuscar.getText();
            assertNull("texto",textoInput);
            //driver.close();
        
    }

    // Esperar hasta 10 segundos WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unElemento"))); // Continuar con las acciones en el elemento...
    // Función para centrar la ventana del navegador
    /* public static void centerWindow(WebDriver driver) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = driver.manage().window().getSize();
        int x = (int) ((screenSize.getWidth() - windowSize.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - windowSize.getHeight()) / 2);
        Point newPosition = new Point(x, y);
        driver.manage().window().setPosition(newPosition);
    } */

    /*
    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void driverManagerChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    void driverManagerFirefox() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
    }
    */

    
    // Esperar hasta 10 segundos WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unElemento"))); // Continuar con las acciones en el elemento...
    // Función para centrar la ventana del navegador
    /* public static void centerWindow(WebDriver driver) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = driver.manage().window().getSize();
        int x = (int) ((screenSize.getWidth() - windowSize.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - windowSize.getHeight()) / 2);
        Point newPosition = new Point(x, y);
        driver.manage().window().setPosition(newPosition);
    } */

    /*
    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void driverManagerChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    void driverManagerFirefox() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
    }
    */
}