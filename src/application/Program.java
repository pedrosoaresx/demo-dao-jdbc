package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {


        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===Test 1: Seller FindById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n===Test 2: Seller FindByDepartmentId ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller obj : list)
            System.out.println(obj);

        System.out.println("\n===Test 3: Seller FindByAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list)
            System.out.println(obj);

        System.out.println("\n===Test 4: Seller Insert ===");
        Seller newSeller = new Seller(null,"Greg", "greg@gmail.com", new Date(), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n===Test 5: Seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Marta Waine");
        sellerDao.update(seller);
        System.out.println("Updated complete");
    }
}
