package Tablas;

import Tablas.Catalogos;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-04-16T10:25:27")
@StaticMetamodel(CodigosDescuento.class)
public class CodigosDescuento_ { 

    public static volatile SingularAttribute<CodigosDescuento, Catalogos> catalogoId;
    public static volatile SingularAttribute<CodigosDescuento, String> codigo;
    public static volatile SingularAttribute<CodigosDescuento, BigDecimal> porcentajeDescuento;
    public static volatile SingularAttribute<CodigosDescuento, Integer> id;

}