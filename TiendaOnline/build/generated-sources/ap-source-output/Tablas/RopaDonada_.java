package Tablas;

import DAO.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-04-16T10:25:27")
@StaticMetamodel(RopaDonada.class)
public class RopaDonada_ { 

    public static volatile SingularAttribute<RopaDonada, Integer> id;
    public static volatile SingularAttribute<RopaDonada, Integer> cantidad;
    public static volatile SingularAttribute<RopaDonada, Usuarios> usuarioId;
    public static volatile SingularAttribute<RopaDonada, Date> fechaDonacion;

}