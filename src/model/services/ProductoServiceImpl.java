package model.services;

import model.dao.DAOFactory;
import model.dao.ProductoDao;
import model.dao.ProductoService;
import model.entities.Producto;

import java.util.List;

public class ProductoServiceImpl implements ProductoService {
    private ProductoDao dao;
    public ProductoServiceImpl() {
        this.dao = DAOFactory.createTiendaDao();
    }

    @Override
    public List<Producto> findAll() {
        return null;
    }

    @Override
    public List<Producto> findByCriteria(String descripcion) {
        return null;
    }

    @Override
    public Producto findByID(int codigo) {
        return null;
    }

    @Override
    public Producto save(Producto producto) {
        return null;
    }

    @Override
    public void update(Producto producto) {

    }

    @Override
    public void delete(Producto producto) {

    }
}
