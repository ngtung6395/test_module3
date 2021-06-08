package service.category;

import config.ConnectionJDBC;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {
    public static final String SELECT_CATEGORY_WHERE_ID = "select *from category where id = ?;";
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_WHERE_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                int category_id = rs.getInt("id");
                String name = rs.getString("name");
                category = new Category(category_id,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return category;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Category category) {

    }
}
