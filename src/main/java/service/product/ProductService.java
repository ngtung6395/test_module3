package service.product;

import config.ConnectionJDBC;
import model.Category;
import model.Product;
import service.category.CategoryService;
import service.category.ICategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    public static final String GET_ALL_PRODUCT = "select *from product";
    public static final String GET_PRODUCT_BY_ID = "select*from product where id = ?;";
    public static final String CREATE_PRODUCT = "INSERT INTO PRODUCT(name, price, quantity, color, description, category_id)\n" +
            "VALUES (?,?,?,?,?,?);";
    public static final String DELETE_PRODUCT_BY_ID = "delete from product where id = ?;";
    public static final String EDIT_PRODUCT = "update product set name = ?, price = ?, quantity = ?, color = ?, description = ?, category_id = ? where id = ?;";
    public static final String SEARCH_PRODUCT_BY_NAME = "select * from product where name like ?;";
    Connection connection = ConnectionJDBC.getConnection();
    ICategoryService categoryService = new CategoryService();
    @Override
    public List findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_PRODUCT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int category_id = rs.getInt("category_id");
                Category category = categoryService.findById(category_id);
                Product product = new Product(id,name,price,color,quantity,description,category);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                int product_id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int category_id = rs.getInt("category_id");
                Category category = categoryService.findById(category_id);
                product = new Product(product_id,name,price,color,quantity,description,category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void save(Product p) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_PRODUCT);
            statement.setString(1,p.getName());
            statement.setDouble(2,p.getPrice());
            statement.setInt(3,p.getQuantity());
            statement.setString(4,p.getColor());
            statement.setString(5,p.getDescription());
            statement.setInt(6,p.getCategory().getId());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void edit(int id, Product p) {
        try {
            PreparedStatement statement = connection.prepareStatement(EDIT_PRODUCT);
            statement.setString(1,p.getName());
            statement.setDouble(2,p.getPrice());
            statement.setInt(3,p.getQuantity());
            statement.setString(4,p.getColor());
            statement.setString(5,p.getDescription());
            statement.setInt(6,p.getCategory().getId());
            statement.setInt(7,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Product> searchByName(String name){
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SEARCH_PRODUCT_BY_NAME);
            statement.setString(1,"%"+name+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String product_name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String decription = rs.getString("description");
                int category_id = rs.getInt("category_id");
                Category category = categoryService.findById(category_id);
                Product product = new Product(id,product_name,price,color,quantity,decription,category);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }
}
