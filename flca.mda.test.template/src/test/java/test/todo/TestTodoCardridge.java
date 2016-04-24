package test.todo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.flca.mda.codegen.helpers.LogHelper;
import com.todo.setup.TidTodoEnum;
import com.todo.setup.TodoConstants;

import flca.mda.codegen.CodegenConstants;
import flca.test.base.AbstractTestTemplates;
import test.todo.data.TestTodoData;

public class TestTodoCardridge extends AbstractTestTemplates {
	@BeforeClass
	public static void beforeOnce() {
		AbstractTestTemplates.beforeOnceBase(new TestTodoData());
		System.setProperty(CodegenConstants.OVERWRITE_WITHOUT_MERGING, "true");
	}

	@AfterClass
	public static void afterOnce() {
		if (LogHelper.getLogbackErrorCount() > startLogbackErrorCount) {
			System.err.println("errors encountered see logfile ");
		}
	}

	// @SuppressWarnings("unused")
	@Test
	public void testTemplates() {
		Class<?> classes[] = new Class<?>[] { TestModel1.class, };

		for (Class<?> c : classes) {
			 generate(c, TodoConstants.getTemplate(TidTodoEnum.TODO_1 ));
		}
	}
}
