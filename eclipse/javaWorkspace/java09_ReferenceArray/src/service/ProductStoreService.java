package service;

import vo.Product;

/*
 * ProductStore에 있는 다양한 상품들을 다루는 기능을 모아놓은 서비스 클래스...
 * 이 클래스에서 다루는 기능들...
 * 1)다양한 상품들의 maker를 출력
 * 2)상품들의 총 금액을 리턴
 * 3)상품들의 평균가를 리턴
 * 4)특정금액 이상되는 상품의 정보를 출력
 * 5)특정회사 제품들을 리턴
 */
public class ProductStoreService {
	
	public void printProductMakers(Product[] pros) {
		for(Product pro : pros) {
			System.out.println(pro.getMaker());
		}
	}
	
	public int getTotalPrice(Product[] pros) {
		int total = 0;
		for(Product pro : pros) {
			total += pro.getPrice();
		}
		return total;
	}
	
	public double getAvgPrice(Product[] pros) {
/*		int total = 0;
		for(Product pro:pros) {
			total += pro.getPrice();
		}
		return total/pros.length;*/
		//위에 만들어 놨으므로 그걸 호출해서 나눠준다.
		return getTotalPrice(pros)/pros.length;
	}
	
	public void printOverPrice(Product[] pros, int price) {
		for(Product pro:pros) {
			if(pro.getPrice()>=price) {
				System.out.println(pro.getMaker()+" "+pro.getPrice());
			}
		}
	}
	
	public Product[] getCertainMaker(Product[] pros, String maker) {
		//새로운 배열을 만들어서 특정회사의 제품들을 넣는다.
		Product[] products = new Product[pros.length];
		int idx = 0;
		for(Product pro:pros) {
			if(pro.getMaker().equals(maker)) {
				/*products[idx]=pro;
				idx++;*/
				products[idx++]=pro;
			}
		}
		return products;
	}
	
	
	
}
