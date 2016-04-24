package flca.mda.cartridge.template;

import com.todo.itype.ITodo1;

public class TestModel1 implements ITodo1 {
	

	@Override
	public String sayHello() {
		return "Hello Todo template" ;
	}
	String name;
	int count;
}
