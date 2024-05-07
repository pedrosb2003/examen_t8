package model.dao;

import datasource.DataSource;

public class DAOFactory {
    public static ProductoDao createTiendaDao(){
        return new ProductoDaoImpl(DataSource.getConnection());
    }
}