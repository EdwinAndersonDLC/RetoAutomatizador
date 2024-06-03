  #autor: Edwin De la cruz

  Feature: Agregar productos

    @Agregarproductos
    Scenario Outline: Agregar productos aleatorios al carrito
      Given ingreso a la web de Exito
      When preciono el boton Menu
      And  selecciono la categoria "<Categoria>"
      And  selecciono la subcategoria "<Subcategoria>"
      And  selecciono los productos
      Then  valido nombre de los productos en el carrito
      Then  valido el total de los precios de los productos
      Then  valido cantidades de los productos agregados
      Then  valido el número de productos agregados



      Examples:
        | Categoria  | Subcategoria |
        | Tecnología | Portatiles   |