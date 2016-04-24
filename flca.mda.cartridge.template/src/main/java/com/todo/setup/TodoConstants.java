package com.todo.setup;

import java.util.ArrayList;
import java.util.List;

import com.todo.itype.ITodo1;

import flca.mda.codegen.data.ITemplate;
import flca.mda.codegen.data.Template;
import flca.mda.codegen.data.TemplateMergeStrategy;
import todo.Todo1;

public class TodoConstants {

	public static final String TODO_CARTRIDGE_NAME = "todo-cartridge";
	public static final String TODO_BRANCH_NAME = "todo";

	public static final String TODO_BACKEND = "Backend"; 
	private static final String SRCGEN = "<%=Backend%>/src-gen";
//	private static final String TSTGEN = "<%=Backend%>/src-gen-test";

	private static List<ITemplate> allTemplates;

	public TodoConstants() {
		super();
		if (allTemplates == null) {
			allTemplates = makeTemplates();
		}
	}

	public List<ITemplate> getAllTemplates() {
		return allTemplates;
	}
	
	public List<ITemplate> makeTemplates() {
		List<ITemplate> result = new ArrayList<ITemplate>();
		
		result.add(makeTemplateMappers());
		
		return result;
	}



	private ITemplate makeTemplateMappers() {
		Template r = new Template();
		r.setName(TidTodoEnum.TODO_1.name());
		r.setPackage("<%=PACKAGE%>");
		r.setClassname("<%=CLASSNAME%>");
		r.setTargetDir(SRCGEN);
		r.setFileExtension(".java");
		r.setGeneratorFqn(Todo1.class.getName());
		r.setJetPath("/Todo1.jet");
		r.setMergeStrategy(TemplateMergeStrategy.SKIP);
		r.setCartridgeName(TODO_CARTRIDGE_NAME);
		r.setBranchName(TODO_BRANCH_NAME);
		r.setApplyToClasses(new Class<?> [] {ITodo1.class});
		r.setRank(5);
		return r;
	}


	public static ITemplate getTemplate(TidTodoEnum aTid) {
		if (allTemplates == null) {
			new TodoConstants(); 
		}

		for (ITemplate t : allTemplates) {
			if (t.getName().equals(aTid.name())) {
				return t;
			}
		}
		return null;
	}

}
