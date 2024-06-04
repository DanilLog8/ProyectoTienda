package Tablas;

import Tablas.Articulos;
import Tablas.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-06-04T12:35:12")
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile SingularAttribute<Pedidos, String> estado;
    public static volatile SingularAttribute<Pedidos, Articulos> prendaId;
    public static volatile SingularAttribute<Pedidos, Date> fechaPedido;
    public static volatile SingularAttribute<Pedidos, Integer> id;
    public static volatile SingularAttribute<Pedidos, Integer> cantidad;
    public static volatile SingularAttribute<Pedidos, Usuarios> usuarioId;

}