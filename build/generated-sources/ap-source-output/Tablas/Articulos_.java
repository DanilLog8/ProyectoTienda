package Tablas;

import Tablas.Carrito;
import Tablas.Catalogos;
import Tablas.Pedidos;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-05-04T16:02:35")
@StaticMetamodel(Articulos.class)
public class Articulos_ { 

    public static volatile SingularAttribute<Articulos, String> descripcion;
    public static volatile SingularAttribute<Articulos, Catalogos> catalogoId;
    public static volatile SingularAttribute<Articulos, BigDecimal> precio;
    public static volatile CollectionAttribute<Articulos, Carrito> carritoCollection;
    public static volatile SingularAttribute<Articulos, Integer> id;
    public static volatile SingularAttribute<Articulos, String> nombre;
    public static volatile CollectionAttribute<Articulos, Pedidos> pedidosCollection;

}