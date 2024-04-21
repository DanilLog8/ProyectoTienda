package Tablas;

import Tablas.Articulos;
import Tablas.CodigosDescuento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-04-16T10:25:27")
@StaticMetamodel(Catalogos.class)
public class Catalogos_ { 

    public static volatile SingularAttribute<Catalogos, Integer> id;
    public static volatile CollectionAttribute<Catalogos, CodigosDescuento> codigosDescuentoCollection;
    public static volatile CollectionAttribute<Catalogos, Articulos> articulosCollection;
    public static volatile SingularAttribute<Catalogos, String> nombre;

}