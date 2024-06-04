package Tablas;

import Tablas.ArticuloTalla;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-06-04T12:35:12")
@StaticMetamodel(Tallas.class)
public class Tallas_ { 

    public static volatile SingularAttribute<Tallas, String> descripcion;
    public static volatile CollectionAttribute<Tallas, ArticuloTalla> articuloTallaCollection;
    public static volatile SingularAttribute<Tallas, Integer> id;
    public static volatile SingularAttribute<Tallas, String> nombre;

}