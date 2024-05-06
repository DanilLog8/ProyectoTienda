package Tablas;

import Tablas.Carrito;
import Tablas.Pedidos;
import Tablas.RopaDonada;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-05-04T16:02:35")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> direccion;
    public static volatile CollectionAttribute<Usuarios, Carrito> carritoCollection;
    public static volatile SingularAttribute<Usuarios, String> contrasena;
    public static volatile SingularAttribute<Usuarios, String> tipoUsuario;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, String> telefono;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile CollectionAttribute<Usuarios, RopaDonada> ropaDonadaCollection;
    public static volatile SingularAttribute<Usuarios, BigDecimal> hucha;
    public static volatile CollectionAttribute<Usuarios, Pedidos> pedidosCollection;

}