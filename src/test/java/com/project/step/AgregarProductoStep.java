package com.project.step;
import com.project.page.AgregarProductoPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class AgregarProductoStep {

    private static AgregarProductoPage agregarProductoPage = new AgregarProductoPage();


    WebDriver driver;

    public void ingreso_a_la_web_de_Exito(WebDriver driver) throws InterruptedException {
        agregarProductoPage.ingreso_a_la_web_de_Exito(driver);
    }

    public void  preciono_el_boton_Menu(){
        agregarProductoPage.preciono_el_boton_Menu();
    }

    public void selecciono_la_categoria(String categoria) {
        agregarProductoPage.selecciono_la_categoria(categoria);
    }

    public void  selecciono_la_subcategoria(String subcategoria){
        agregarProductoPage.selecciono_la_subcategoria(subcategoria);
    }
    public void   selecciono_los_productos() throws InterruptedException {
        agregarProductoPage.selecciono_los_productos();
    }
    public void   valido_nombre_de_los_productos_en_el_carrito() throws InterruptedException {
        agregarProductoPage.valido_nombre_de_los_productos_en_el_carrito();
    }
    public void valido_el_total_de_los_precios_de_los_productos()throws InterruptedException{
        agregarProductoPage.valido_el_total_de_los_precios_de_los_productos();
    }
    public void valido_cantidades_de_los_productos_agregados() throws InterruptedException{
        agregarProductoPage.valido_cantidades_de_los_productos_agregados();
    }
    public void valido_el_número_de_productos_agregados() throws InterruptedException{
        agregarProductoPage.valido_el_número_de_productos_agregados();
    }
}
