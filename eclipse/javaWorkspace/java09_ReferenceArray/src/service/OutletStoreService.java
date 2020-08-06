 package service;

import vo.Customer;
import vo.Product;

/*
 * 상품을 구입하는 고객, 상점에 입점된 상품에 대한 기능들을 다루는 서비스 클래스...
 */
public class OutletStoreService {
/*
 * getAllProductMaker()---> 특정한 사람의 모든상품의 모든정보를 리턴
 * getAllCustomer()--->모든 고객의 모든정보를 리턴
 * getACustomer() --->특정한 고객의 모든정보를 리턴
 * maxPriceProduct() --->최고가 상품의 가격을 받아오기
 * moreAvgProduct() --->평균가 이상의 상품들 출력 (특정한 고객이 구입한 상품들 중에서 평균가 이상되는 상품)
 */
	
	int prosize = 4;
	int custsize = 3;
	
	public String[] getAllProductMaker(Customer vo) {
		String[] temp = new String[prosize];
		Product[] pros = vo.getProducts();
		int idx = 0;
		for(Product pro:pros) {
			temp[idx++]=pro.getMaker();
		}
		return temp;
	}
	
	public Customer[] getAllCustomer(Customer[] custs) {
		Customer[] customers = new Customer[custsize];
		int idx = 0;
		for(Customer cus:custs) {
			customers[idx++]=cus;
		}
		return customers;
	}
	
	public Customer getACustomer(Customer[] custs, int ssn) {
		Customer customer = null;
		for(Customer cust:custs) {
			if(cust.getSsn()==ssn) {
				customer = cust;
			}
		}
		return customer;
	}
	
	public int maxPriceProduct(Customer c) {
		int max = 0;
		System.out.println(c.getName()+"님이 구매하신 최고가 상품은....");
		Product[ ] pros = c.getProducts();
		for(Product p : pros) {
			if(p.getPrice()>max) max = p.getPrice();
		}
		return max;
		
	}

	//추가
		public int avgPrice(Customer c) {
			int total = 0;		
			Product[ ] pros = c.getProducts();
			for(Product p : pros) {
				total += p.getPrice();
			}
			return total/pros.length;
		}
		public Product[ ] getMoreAvgProduct(Customer c) {
			Product[ ] temp = new Product[prosize];
			Product[ ] pros=c.getProducts();
			int cnt = 0;
			for(Product p : pros) {
				if(p.getPrice()>=avgPrice(c)) 
					temp[cnt++] = p;			
			}
			return temp;
		}
	
	
	
}
