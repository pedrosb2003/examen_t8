package model.dao;

import model.entities.Producto;

import java.util.List;

public interface ProductoDao {
    List<Producto> findAll();
    List<Producto> findByCriteria(String descripcion);
    Producto findByID(int codigo);
    Producto save(Producto producto);
    void update(Producto producto);
    void delete(Producto producto);
}
