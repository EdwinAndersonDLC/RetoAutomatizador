package com.project.page;
import org.openqa.selenium.*;
import java.util.*;

public class AgregarProductoPage {

    WebDriver driver;
    Random random = new Random();
    ArrayList<String> productlist = new ArrayList<>();
    int cantcar, cantran = 0;
    double totalr =0;

    public void ingreso_a_la_web_de_Exito(WebDriver driver) throws InterruptedException{
        System.out.println(driver);
        this.driver = driver;
        Thread.sleep(3000);
    }
    public void  preciono_el_boton_Menu(){
        driver.findElement(By.xpath("//header/section[1]/div[1]/div[1]/button[1]")).click();

    }

    public void selecciono_la_categoria(String categoria) {

        try {
            driver.findElement(By.xpath("//p[contains(text(),'"+categoria+"')]")).click();

        }catch (Exception e){

            System.out.println("No se pudo encontrar el elemento con el XPath proporcionado: "+ categoria);
            driver.quit();

        }
    }


    public void selecciono_la_subcategoria(String subcategoria){
        try{

            driver.findElement(By.xpath("//a[contains(text(),'"+subcategoria+"')]")).click();
        }catch (Exception e){

            System.out.println("No se pudo encontrar el elemento con el XPath proporcionado: "+ subcategoria);
            driver.quit();

        }
    }

    public void selecciono_los_productos()throws InterruptedException{
        Thread.sleep(3000);
        int i=1;

        while (i<= 5){
            int cant_pag = driver.findElements(By.xpath("//ul[@class=\"Pagination_containerLinkPaginationList__KkQul\"]/li")).size();
            int pag = random.nextInt(cant_pag) + 1;
            if (pag != 1) {
                WebElement btncontainer = driver.findElement(By.xpath("//ul[@class=\"Pagination_containerLinkPaginationList__KkQul\"]/li[" + pag + "]//button"));
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", btncontainer);
            }
            Thread.sleep(2000);
            List<WebElement> product = driver.findElements(By.xpath("//ul[@data-fs-product-grid-type]/li"));
            int list_prod = product.size();

            int p = random.nextInt(list_prod) + 1;
            int c = random.nextInt(10) + 1;
            cantran= cantran + c;


            Thread.sleep(4000);
            String nomprod = driver.findElement(By.xpath("//ul[@data-fs-product-grid=\"true\"]/li[" + p + "]//a[@class=\"link_fs-link__J1sGD\"][@title]")).getText();
            productlist.add(nomprod);

            Thread.sleep(1000);
            String mt= driver.findElement(By.xpath("//ul[@data-fs-product-grid=\"true\"]/li[" + p + "]//p[@class=\"ProductPrice_container__price__XmMWA\"]")).getText();

            StringBuilder num = new StringBuilder();

            for (char cn : mt.toCharArray()) {
                if (Character.isDigit(cn)) {
                    num.append(cn);
                }
            }
            double t= Double.parseDouble(String.valueOf(num)) * c;
            totalr = totalr + t;

            WebElement btnproducto = driver.findElement(By.xpath("//ul[@data-fs-product-grid=\"true\"]/li[" + p + "]//button[@class=\"DefaultStyle_default__jW12W  \"]"));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", btnproducto);
            Thread.sleep(3000);
            WebElement cantproducto = driver.findElement(By.xpath("//ul[@data-fs-product-grid=\"true\"]/li["+ p +"]//button[@class=\"QuantitySelectorDefault_plus__1LAkq\"]"));
            JavascriptExecutor executor2 = (JavascriptExecutor)driver;
            int j=1;
            while (j <= c){
                Thread.sleep(200);
                executor2.executeScript("arguments[0].click();", cantproducto);
                j=j+1;
            }
            i=i+1;
        }
        Thread.sleep(1000);
        WebElement e = driver.findElement(By.xpath("//div[@data-fs-cart-quantity=\"true\"]/span"));
        cantcar= Integer.parseInt(e.getText());
    }

    public void   valido_nombre_de_los_productos_en_el_carrito() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> carlist = new ArrayList<>();
        driver.findElement(By.xpath("//header/section[1]/div[1]/div[2]/div[2]/button[1]")).click();
        Thread.sleep(5000);
        int c=driver.findElements(By.xpath("//div[@class=\"exito-checkout-io-0-x-sellerListContainer\"]/div")).size();

        int i=1;
        while (i <= c) {
            String lista = driver.findElement(By.xpath("//div[@class=\"exito-checkout-io-0-x-sellerListContainer\"]/div["+ i +"]//span[@data-molecule-product-detail-name-span=\"true\"]")).getText();
            carlist.add(lista);
            i= i+1;
        }
        Collections.sort(carlist);
        Collections.sort(productlist);
        if (productlist.equals(carlist)){
            System.out.println("El nombre de los productos agregados son iguales al carrito");
        }else
            System.out.println("El nombre de los productos agregados son diferentes al carrito");
    }
    public void valido_el_total_de_los_precios_de_los_productos()throws InterruptedException {
        String st = driver.findElement(By.xpath("//div[@class=\"exito-checkout-io-0-x-summarySubTotal\"]//span[@data-molecule-summary-item-value=\"true\"]")).getText();
        StringBuilder num = new StringBuilder();
        for (char cn : st.toCharArray()) {
            if (Character.isDigit(cn)) {
                num.append(cn);
            }
        }
        double totalc= Double.parseDouble(String.valueOf(num));
        if ( totalr== totalc){
            System.out.println("el monto de los productos agregados es igual que en el carrito");
        }
        else System.out.println("el monto de los productos agregados NO es igual que en el carrito");
             System.out.println("No está disponible la cantidad deseada para el producto");

    }
    public void valido_cantidades_de_los_productos_agregados() throws InterruptedException {

        if (cantcar == cantran){
            System.out.println("La cantidad de los productos agregados es igual que en el carrito");
        }else
            System.out.println("La cantidad de los productos agregados NO es igual que en el carrito");
            System.out.println("No está disponible la cantidad deseada para el producto");

    }
    public void valido_el_número_de_productos_agregados() throws InterruptedException{
        int c=driver.findElements(By.xpath("//div[@class=\"exito-checkout-io-0-x-sellerListContainer\"]/div")).size();
        if (c == 5){
            System.out.println("El numero de los productos agregados es igual que en el carrito");
        }
        else
            System.out.println("El numero de los productos agregados NO es igual que en el carrito");


    }


}




