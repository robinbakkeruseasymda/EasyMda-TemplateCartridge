package com.todo.setup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import flca.mda.codegen.data.ITemplate;
import flca.mda.codegen.data.SubsValue;
import flca.mda.codegen.data.SubsValueType;
import flca.mda.codegen.data.TemplatesBranch;
import flca.mda.common.api.helpers.RegisterTemplatesHelper;
import mda.type.IRegisterTemplates;

public class RegisterTodoTemplates implements IRegisterTemplates {

	private final static SubsValueType FOLDER = SubsValueType.FOLDER;

	@Override
	public String getName() {
		return TodoConstants.TODO_BACKEND;
	}

	@Override
	public String getDescription() {
		return "Todo description";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public Collection<TemplatesBranch> getTemplateBranches() {
		List<TemplatesBranch> result = new ArrayList<TemplatesBranch>();

		result.add(makeBranch(TodoConstants.TODO_BRANCH_NAME, getDescription()));

		return result;	
	}

	private TemplatesBranch makeBranch(String aName, String aDescr) {
		TemplatesBranch result = new TemplatesBranch();
		result.setName(aName);
		result.setDescription(aDescr);

		for (ITemplate template : new TodoConstants().getAllTemplates()) {
			result.addTemplate(template);
		}

		return result;
	}
	
	@Override
	public Collection<SubsValue> getSubstituteValues() {
		Collection<SubsValue> result = new ArrayList<SubsValue>();
		result.add(makeSubsValue(TodoConstants.TODO_BACKEND, FOLDER, "target directory ", 3, null ));
		return result;
	}

	private SubsValue makeSubsValue(String name, SubsValueType type, String help, 
			int rank, String aDefaultValue) {
		return RegisterTemplatesHelper.makeSubsValue(name, type, name, help, rank, aDefaultValue, 
				new String[] {TodoConstants.TODO_CARTRIDGE_NAME});
	}
	

	@Override
	public void doBefore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doAfter() {
		// TODO Auto-generated method stub
		
	}

}
