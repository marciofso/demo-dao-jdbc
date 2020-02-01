package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Department> list = new ArrayList<>();
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ====");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ====");
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: department insert ====");
		Department newDepartment = new Department(null, "Pitang");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: department update ====");
		Department dep2 = departmentDao.findById(62);
		dep2.setName("Ati");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: seller delete ====");
		System.out.println("Enter id sellerDafor delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		
		sc.close();

	}

}
