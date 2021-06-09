package controller;

import model.Category;
import model.Product;
import service.category.CategoryService;
import service.category.ICategoryService;
import service.product.IProductService;
import service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.search;

@WebServlet(name = "ProductServlet", value = "/Products")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(req,resp);
                break;
            case "edit":
                showFormEdit(req,resp);
                break;
            case "delete":
                delteProduct(req,resp);
                break;

            default:
                showAllProduct(req,resp);
                break;
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Product> productList = productService.searchByName(name);
        req.setAttribute("productList",productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/search.jsp");
        dispatcher.forward(req,resp);

    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        List<Category> categories = categoryService.findAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/edit.jsp");
        req.setAttribute("categories",categories);
        req.setAttribute("product",product);
        dispatcher.forward(req,resp);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories",categories);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/create.jsp");
        dispatcher.forward(req,resp);
    }

    private void showAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/list.jsp");
        req.setAttribute("productList",productList);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(req,resp);
                break;
            case "search":
                search(req,resp);
                break;
            case "edit":
                Edit(req,resp);
                break;

        }
    }

    private void delteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        resp.sendRedirect("/Products");
    }

    private void Edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        Category category = new Category(category_id);
        Product product = new Product(name,price,color,quantity,description,category);
        productService.edit(id,product);
        resp.sendRedirect("/Products");
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        Category category = new Category(category_id);
        Product product = new Product(name,price,color,quantity,description,category);
        productService.save(product);
        resp.sendRedirect("/Products");
    }

}
