package pizza.test;

import java.util.Vector;

import pizza.child.BulgogiPizza;
import pizza.child.EggPizza;
import pizza.child.PotatoPizza;
import pizza.parent.Pizza;
import pizza.service.PizzaService;

public class PizzaServiceTest {

	public static void main(String[] args) {
		
		PizzaService service = new PizzaService();
		Vector<Pizza> v = new Vector<>(); //10칸짜리 만들어진다.
		
		v.add(new PotatoPizza(14000, "Pizza Hut"));
		v.add(new BulgogiPizza(16000, "Domino Pizza"));
		v.add(new EggPizza(11000, "미스터피자"));
		v.add(new PotatoPizza(5900, "오구피자"));
		
		System.out.println("Vector안에 저장된 피자의 수: "+ v.size()); //저장된 데이터 갯수
		System.out.println("Vector의 Capacity: "+ v.capacity()); //백터의 용량
		System.out.println("pizza Information :"+v); //객체정보...
		
		service.allMakePizza(v);

	}

}
