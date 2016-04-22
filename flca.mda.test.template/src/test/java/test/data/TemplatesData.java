package test.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import flca.mda.codegen.CodegenConstants;
import flca.mda.codegen.data.SubsValue;
import flca.test.base.AbstractTestTemplatesData;

public class TemplatesData extends AbstractTestTemplatesData implements TestConstants 
{
	@Override
	public File getPluginDir() {
//		return new File(getProjectDir() + "/" + PLUGIN_DIR);
		return new File(getProjectDir() + "/" + TEMPLATES_MODEL_DIR + "/bin");
	}

	@Override
	public File getModelDir() {
		return new File(getProjectDir() + "/" + TEMPLATES_MODEL_DIR);
	}

	@Override
	public File getTemplateDir() {
		return new File(getProjectDir() + "/" + TEMPLATES_CARTRIDGE_DIR);
	}

	@Override
	public List<SubsValue> getSubsvalues() {
		List<SubsValue> r = new ArrayList<SubsValue>();
		r.add(new SubsValue(CodegenConstants.APP_NAME, "Demo"));
		r.add(new SubsValue(CodegenConstants.APP_PACKAGE, "nl.mycomp.app"));
//		r.add(new SubsValue(WebappConstants.BACKEND, BACKEND_SRC_GEN));
		return r;
	}
}

