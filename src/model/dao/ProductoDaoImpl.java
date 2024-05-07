package model.dao;

import datasource.DataSource;
import datasource.DataSourceException;
import model.entities.Producto;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImpl extends BaseDao implements ProductoDao {

    private Connection connection;

    public ProductoDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Producto> findAll() {

        List<Producto> productos = new ArrayList<Producto>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from producto";
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while(rs.next()){
                Producto producto = new Producto();
                producto.getCodigo(rs.getInt("cod"));
                producto.getDescripcion(rs.getString("descripcion"));
                producto.getPrecio(rs.getDouble("precio"));
                producto.getStock(rs.getInt("stock"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DataSource.closeStatement(ps);
            DataSource.closeResultSet(rs);
        }

        return productos;
    }

    @Override
    public List<Producto> findByCriteria(String descripcion) {
        List<Producto> productos = new ArrayList<Producto>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from producto where desc = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, descripcion);

            rs = ps.executeQuery();

            while(rs.next()){
                Producto producto = new Producto();
                producto.getCodigo(rs.getInt("cod"));
                producto.getDescripcion(rs.getString("descripcion"));
                producto.getPrecio(rs.getDouble("precio"));
                producto.getStock(rs.getInt("stock"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DataSource.closeStatement(ps);
            DataSource.closeResultSet(rs);
        }

        return productos;
    }

    @Override
    public Producto findByID(int codigo) {
        List<Producto> productos = new ArrayList<Producto>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from cod = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            if(rs.next()){
                Producto producto = new Producto();
                producto.getCodigo(rs.getInt("cod"));
                producto.getDescripcion(rs.getString("descripcion"));
                producto.getPrecio(rs.getDouble("precio"));
                producto.getStock(rs.getInt("stock"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DataSource.closeStatement(ps);
            DataSource.closeResultSet(rs);
        }

        return Producto;
    }

    @Override
    public Producto save(Producto producto) {

        PreparedStatement ps = null;

        try {
            String sql = "insert into producto (codigo, descripcion, precio, stock) values (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getDescripcion();
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());

            int fila = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DataSource.closeStatement(ps);
        }

        return producto;
    }

    @Override
    public void update(Producto producto) {

        PreparedStatement ps = null;

        try {
            String sql = "insert into producto (codigo, descripcion, precio, stock) values (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getDescripcion();
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());

            int fila = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DataSource.closeStatement(ps);
        }


    }

    @Override
    public void delete(Producto producto) {

    }
}