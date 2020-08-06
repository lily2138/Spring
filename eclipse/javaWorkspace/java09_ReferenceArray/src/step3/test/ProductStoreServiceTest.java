package step3.test;

import service.ProductStoreService;
import vo.Product;

public class ProductStoreServiceTest {
	public static void main(String[] args) {
		ProductStoreService service = new ProductStoreService();
		
		Product[] pros = {
				new Product("HP", 120000, 2),
				new Product("SAMSUNG", 230000, 3),
				new Product("LG", 500000, 13),
				new Product("LG", 490000, 16)
		};
		
		System.out.println("1.모든 상품의 maker를 출력합니다");
		service.printProductMakers(pros);
		
		System.out.println("2.모든 상품의 총가격을 출력합니다");
		System.out.println(service.getTotalPrice(pros));
		
		System.out.println("3.상품들의 평균가를 출력합니다");
		System.out.println(service.getAvgPrice(pros));
		
		System.out.println("4.특정금액 이상되는 상품의 정보를 출력합니다");
		service.printOverPrice(pros,160000);
		
		System.out.println("5.특정회사 제품들의 정보를 출력합니다");
		Product[] products=service.getCertainMaker(pros, "LG");
		for(Product p:products) {
			if(p==null)
				continue;
			System.out.println(p.getMaker()+" "+p.getPrice());
		}
			
		
	}

}
