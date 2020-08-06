package pizza.service;

import java.util.Vector;

import pizza.parent.Pizza;

//서로다른 여러개의 피자를 핸들링하는 기능을 가지고 있는 서비스 클래스...
public class PizzaService {

	public void allMakePizza(Vector<Pizza> v) {
		for(Pizza p : v)
			p.makePizza();
			System.out.println("===========================================================");
	}
	
}
