package Tablas;

import Tablas.Articulos;
import Tablas.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-05-04T16:02:35")
@StaticMetamodel(Carrito.class)
public class Carrito_ { 

    public static volatile SingularAttribute<Carrito, Articulos> prendaId;
    public static volatile SingularAttribute<Carrito, Integer> id;
    public static volatile SingularAttribute<Carrito, Integer> cantidad;
    public static volatile SingularAttribute<Carrito, Usuarios> usuarioId;

}