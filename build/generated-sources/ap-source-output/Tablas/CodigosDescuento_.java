package Tablas;

import Tablas.Catalogos;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-05-04T16:02:35")
@StaticMetamodel(CodigosDescuento.class)
public class CodigosDescuento_ { 

    public static volatile SingularAttribute<CodigosDescuento, Catalogos> catalogoId;
    public static volatile SingularAttribute<CodigosDescuento, String> codigo;
    public static volatile SingularAttribute<CodigosDescuento, BigDecimal> porcentajeDescuento;
    public static volatile SingularAttribute<CodigosDescuento, Integer> id;

}