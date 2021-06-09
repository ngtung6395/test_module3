package service.product;

import model.Product;
import service.IService;

import java.util.List;

public interface IProductService extends IService<Product> {
    List<Product> searchByName(String name);
}
