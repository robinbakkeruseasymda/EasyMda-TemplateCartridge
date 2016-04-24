package test.todo.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import flca.mda.codegen.data.SubsValue;
import flca.mda.codegen.helpers.ShellUtils;
import flca.test.base.AbstractTestTemplatesData;

public class TestTodoData extends AbstractTestTemplatesData 
{
	private static final String PLUGIN_DIR = "EasyMda-CoreGenerator/flca.mda.generator";
	private static final String MODEL_DIR = "flca.mda.test.template";
	private static final String CARTRIDGE_DIR = "EasyMda-TemplateCartridge/flca.mda.cartridge.template";

	@Override
	public File getPluginDir() {
		return new File(currentDir().getParentFile().getParent() + "/" + PLUGIN_DIR);
	}

	@Override
	public File getModelDir() {
		return new File(currentDir().getParent() + "/" + MODEL_DIR);
	}

	@Override
	public File getTemplateDir() {
		return new File(currentDir().getParentFile().getParent() + "/" + CARTRIDGE_DIR);
	}

	protected File currentDir() {
		String currentDir = System.getProperty("user.dir");
		return new File(currentDir);
	}

	@Override
	public List<SubsValue> getSubsvalues() {
		List<SubsValue> r = new ArrayList<SubsValue>();
		r.add(new SubsValue("App-name", "Todo"));
		if (ShellUtils.isLinux()) {
			String basedir = "/tmp/todo";
			r.add(new SubsValue("Backend" , basedir));
			
		} else {
			String basedir = "c:/temp/todo";
			r.add(new SubsValue("Backend" , basedir));
		}
		
		return r;
	}

}

