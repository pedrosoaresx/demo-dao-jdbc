package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Test 1. Department FindById ===");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("\n=== Test 2. Department FindAll ===");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        for (Department obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3. Department Insert ===");
        Department newDep = new Department(null, "Tech");
        departmentDao.insert(newDep);
        System.out.println("Inserted! new Id: " + newDep.getId());

        System.out.println("\n=== Test 4. Department Update ===");
        dep = departmentDao.findById(1);
        dep.setName("Computers");
        departmentDao.update(dep);
        System.out.println("Updated completed!");

        System.out.println("\n=== Test 5. Department Delete ===");
        System.out.println("Enter id for delete test: ");
        int id = scanner.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deleted!");
        scanner.close();
    }
}
