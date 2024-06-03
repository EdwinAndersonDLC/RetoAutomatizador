package com.project.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.project.ClaseBase.Base;
import com.project.step.AgregarProductoStep;


public class AgregarProductoStepdefinition {

    public Base base = new Base();
    public static AgregarProductoStep agregarProductoStep = new AgregarProductoStep();

    @Given("ingreso a la web de Exito")
    public void ingreso_a_la_web_de_Exito() throws InterruptedException {
        base.get("https://www.exito.com/");
        agregarProductoStep.ingreso_a_la_web_de_Exito(base.driver());

    }

    @When("preciono el boton Menu")
    public void preciono_el_boton_Menu(){
        agregarProductoStep.preciono_el_boton_Menu();

    }
    @And("selecciono la categoria {string}")
    public void selecciono_la_categoria(String categoria) {
        agregarProductoStep.selecciono_la_categoria(categoria);

    }

    @And  ("selecciono la subcategoria {string}")
    public void selecciono_la_subcategoria(String subcategoria){
        agregarProductoStep.selecciono_la_subcategoria(subcategoria);
    }

    @And  ("selecciono los productos")
    public void selecciono_los_productos() throws InterruptedException {
        agregarProductoStep.selecciono_los_productos();
    }

    @Then("valido nombre de los productos en el carrito")
    public void valido_nombre_de_los_productos_en_el_carrito() throws InterruptedException {
        agregarProductoStep.valido_nombre_de_los_productos_en_el_carrito();
    }
    @Then("valido el total de los precios de los productos")
            public void valido_el_total_de_los_precios_de_los_productos()throws InterruptedException{
            agregarProductoStep.valido_el_total_de_los_precios_de_los_productos();
    }
    @Then("valido cantidades de los productos agregados")
    public void valido_cantidades_de_los_productos_agregados() throws InterruptedException{
        agregarProductoStep.valido_cantidades_de_los_productos_agregados();
    }
      @Then("valido el número de productos agregados")
    public void valido_el_número_de_productos_agregados() throws InterruptedException{
      agregarProductoStep.valido_el_número_de_productos_agregados();
    }
}
