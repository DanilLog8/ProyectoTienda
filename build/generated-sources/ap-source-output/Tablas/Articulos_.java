package Tablas;

import Tablas.Carrito;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-06-04T12:35:12")
@StaticMetamodel(Articulos.class)
public class Articulos_ { 

    public static volatile SingularAttribute<Articulos, String> descripcion;
    public static volatile SingularAttribute<Articulos, BigDecimal> precio;
    public static volatile CollectionAttribute<Articulos, Carrito> carritoCollection;
    public static volatile SingularAttribute<Articulos, String> nombreCatalogo;
    public static volatile SingularAttribute<Articulos, String> imagen;
    public static volatile SingularAttribute<Articulos, Integer> id;
    public static volatile SingularAttribute<Articulos, String> nombre;
    public static volatile SingularAttribute<Articulos, Integer> cantidadDisponible;

}