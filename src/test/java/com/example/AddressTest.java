package com.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.address.entity.Address;
import com.example.address.repository.AddressRepository;
import com.example.util.CityData;
import com.example.util.EhtData;
import com.example.util.FhqData;
import com.example.util.KjyData;
import com.example.util.ZhongChuangData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {

	@Autowired
	AddressRepository repository;

	@Test
	public void get(){
		
		System.out.println(repository.findAll());
		
	}
	
	Address[] addresses = {
			new Address(2,"province", "北京"),
            new Address(3,"province", "安徽"),
            new Address(4,"province", "福建"),
            new Address(5,"province", "甘肃"),
            new Address(6,"province", "广东"),
            new Address(7,"province", "广西"),
            new Address(8,"province", "贵州"),
            new Address(9,"province", "海南"),
            new Address(10,"province", "河北"),
            new Address(11,"province", "河南"),
            new Address(12,"province", "黑龙江"),
            new Address(13,"province", "湖北"),
            new Address(14,"province", "湖南"),
            new Address(15,"province", "吉林"),
            new Address(16,"province", "江苏"),
            new Address(17,"province", "江西"),
            new Address(18,"province", "辽宁"),
            new Address(19,"province", "内蒙古"),
            new Address(20,"province", "宁夏"),
            new Address(21,"province", "青海"),
            new Address(22, "province","山东"),
            new Address(23,"province", "山西"),
            new Address(24, "province","陕西"),
            new Address(25,"province", "上海"),
            new Address(26, "province","四川"),
            new Address(27,"province", "天津"),
            new Address(28,"province", "西藏"),
            new Address(29, "province","新疆"),
            new Address(30, "province","云南"),
            new Address(31, "province","浙江"),
            new Address(32,"province", "重庆"),
            new Address(35, "province","新疆建设兵团"),
            new Address(34, "province","非大陆及港澳台地区")
            
            
            
	};
	
	/**
	 * 
	 * 添加省份直辖市
	 * 
	 */
	@Test
	public void add () {
		
		for (Address address : addresses) {
			repository.save(address);
		}
		
	}
	
	/**
	 * 
	 * 添加市
	 * 
	 */
	@Test
	public  void saveCity () throws InterruptedException {
		
		for (Address address : addresses) {
			
			List<Address> list  = CityData.getByPId(address.getId());
			
			for (Address address2 : list) {
				address2.setType("city");
				repository.save(address2);
				
			}
			
			Thread.sleep(2000);
			System.out.println(address.getName() + "	end");
			
		}
		
	}
	
	/**
	 * 
	 * 添加高新区
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void saveEht () throws InterruptedException {
		
		
		for (Address address : addresses) {
			
			
			
			if (address.getId() < 29) {
				  continue;
			}
			
			List<Address> list = repository.findByPid(address.getId());

			for (Address address2 : list) {
				
				
				List<Address> list2 = EhtData.get( address2.getId(),address2.getPid());
				System.out.println(address2.getId() + "---" + address2.getPid() + " = " + list2);
				Thread.sleep(2000);

				
				for (Address address3 : list2) {
					
					address3.setPid(address2.getId());
					address3.setName(address3.getRemark());
					address3.setType("eht");
					
					repository.save(address3);
					System.out.println("success");
					
				}
			}
			
			
			//EhtData.get( sid,address.getId());
			
			
		}
		
		

		
	}
	
	/**
	 * 
	 * 添加孵化器
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void saveFhq () throws InterruptedException {
		
		
	for (Address address : addresses) {
			
			List<Address> list = repository.findByPid(address.getId());
			Thread.sleep(1000);

			for (Address address2 : list) {
				
				List<Address> list2 = FhqData.get( address2.getId(),address2.getPid());
				System.out.println(address2.getId() + "---" + address2.getPid() + " = " + list2);
				Thread.sleep(1000);
				
				for (Address address3 : list2) {
					
					address3.setPid(address2.getId());
					address3.setName(address3.getRemark());
					address3.setType("fhq");
					
					repository.save(address3);
					System.out.println("success");
					
				}				
			}
			
			
			//EhtData.get( sid,address.getId());
			
			
		}		
		
		
	}
	
	
	/**
	 * 
	 * 添加科技园
	 * @throws InterruptedException 
	 * 
	 */
	@Test	
	public void saveKjy () throws InterruptedException {
		
		for (Address address : addresses) {
			
		
			if (address.getId() < 12) {
				  continue;
			}
		
		
			List<Address> list = repository.findByPid(address.getId());
			Thread.sleep(1000);

			for (Address address2 : list) {
				
				List<Address> list2 = KjyData.get( address2.getId(),address2.getPid());
				System.out.println(address2.getId() + "---" + address2.getPid() + " = " + list2);
				Thread.sleep(1000);
				
				for (Address address3 : list2) {
					
					address3.setPid(address2.getId());
					address3.setName(address3.getRemark());
					address3.setType("kjy");
					
					repository.save(address3);
					System.out.println("success");
					
				}				
			}
			
			
			//EhtData.get( sid,address.getId());
			
			
		}				
	}
	
	@Test
	public void saveZhongChuang () throws InterruptedException {
		
		for (Address address : addresses) {
			
			ZhongChuangData.get(address.getId());
			Thread.sleep(1000);
		}
		
	}
}
