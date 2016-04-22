package mda.template;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mda.type.IRegisterTemplates;
import flca.mda.codegen.data.ITemplate;
import flca.mda.codegen.data.SubsValue;
import flca.mda.codegen.data.TemplatesBranch;

public class RegisterTemplates implements IRegisterTemplates {
	@Override
	public String getName() {
		return "cartridge-template";
	}

	@Override
	public String getDescription() {
		return "cartrdige to generate template for other cartridge";
	}

	@Override
	public List<TemplatesBranch> getTemplateBranches() {
		List<TemplatesBranch> result = new ArrayList<TemplatesBranch>();

		result.add(makeBranch("cartidge.template", "cartridge to generate template cartridge"));

		return result;
	}
	
	private TemplatesBranch makeBranch(String aName, String aDescr) {
		TemplatesBranch result = new TemplatesBranch();
		result.setName(aName);
		result.setDescription(aDescr);

		for (ITemplate template : new CartridgeTemplateConstants().getAllTemplates()) {
			result.addTemplate(template);
		}

		return result;
	}


	@Override
	public Collection<SubsValue> getSubstituteValues() {
		return null;
	}

	@Override
	public String getVersion() {
		return "2.0";
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
