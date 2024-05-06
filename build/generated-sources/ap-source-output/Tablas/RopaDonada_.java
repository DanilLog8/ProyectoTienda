package Tablas;

import Tablas.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-05-04T16:02:35")
@StaticMetamodel(RopaDonada.class)
public class RopaDonada_ { 

    public static volatile SingularAttribute<RopaDonada, Integer> id;
    public static volatile SingularAttribute<RopaDonada, Integer> cantidad;
    public static volatile SingularAttribute<RopaDonada, Usuarios> usuarioId;
    public static volatile SingularAttribute<RopaDonada, Date> fechaDonacion;

}