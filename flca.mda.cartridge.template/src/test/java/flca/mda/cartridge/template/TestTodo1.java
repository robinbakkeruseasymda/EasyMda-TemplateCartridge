package flca.mda.cartridge.template;

import org.junit.Test;

import com.todo.setup.TidTodoEnum;
import com.todo.setup.TodoConstants;

import flca.mda.api.util.JetArgument;
import flca.mda.codegen.data.ITemplate;
import todo.Todo1;

public class TestTodo1 {

	@Test
	public void test() {
		Todo1 jetgen = new Todo1();
		JetArgument jetarg = new JetArgument(new TestModel1(), template1(), null);
		String r = jetgen.generate(jetarg);
		System.out.println(r);
	}

	private ITemplate template1() {
		return TodoConstants.getTemplate(TidTodoEnum.TODO_1);
	}
}
