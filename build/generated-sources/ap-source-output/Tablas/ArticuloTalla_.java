package Tablas;

import Tablas.Articulos;
import Tablas.Tallas;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-06-04T12:35:12")
@StaticMetamodel(ArticuloTalla.class)
public class ArticuloTalla_ { 

    public static volatile SingularAttribute<ArticuloTalla, Articulos> idArticulo;
    public static volatile SingularAttribute<ArticuloTalla, Tallas> idTalla;
    public static volatile SingularAttribute<ArticuloTalla, Integer> id;
    public static volatile SingularAttribute<ArticuloTalla, Integer> cantidadDisponible;

}