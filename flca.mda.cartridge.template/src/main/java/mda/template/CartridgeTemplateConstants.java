package mda.template;

import java.util.ArrayList;
import java.util.List;

import mda.template.type.ICartridgeTemplateType;
import cartridge.JetFile;
import cartridge.JetTargetFile;
import cartridge.TemplateDefinition;
import flca.mda.codegen.data.ITemplate;
import flca.mda.codegen.data.Template;
import flca.mda.codegen.data.TemplateMergeStrategy;


public class CartridgeTemplateConstants {

	public static final String CARTRIDGE_NAME = "cartridge-template";
	
	private static List<ITemplate> allTemplates;

	public CartridgeTemplateConstants() {
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
		
		result.add(makeTemplate_JET_FILE());
		result.add(makeTemplate_JET_TARGET_FILE());
		result.add(makeTemplate_TEMPLATE_DEFINITION());
		
		return result;
	}

	private ITemplate makeTemplate_JET_FILE() {
		Template r = new Template();
		r.setName(TidCartridgeTemplate.TEMPLATE_JET_FILE.name());
		r.setPackage("<%=PACKAGE%>");
		r.setClassname("<%=CLASSNAME%>");
		r.setTargetDir("<%=Targetdir%>");
		r.setFileExtension(".jet");
		r.setGeneratorFqn(JetFile.class.getName());
		r.setJetPath("/cartridge/JetFile.jet");
		r.setMergeStrategy(TemplateMergeStrategy.OVERWRITE);
		r.setCartridgeName(CARTRIDGE_NAME);
		r.setApplyToClasses(new Class<?> [] {ICartridgeTemplateType.class,});
		r.setRank(5);
		return r;
	}

	private static ITemplate makeTemplate_JET_TARGET_FILE() {
		Template r = new Template();
		r.setName(TidCartridgeTemplate.TEMPLATE_JET_TARGET_FILE.name());
		r.setPackage(null);
		r.setClassname(null);
		r.setTargetDir(null);
		r.setFileExtension(null);
		r.setGeneratorFqn(JetTargetFile.class.getName());
		r.setJetPath("/cartridge/JetTargetFile.jet");
		r.setMergeStrategy(TemplateMergeStrategy.SKIP);
		r.setCartridgeName(CARTRIDGE_NAME);
		r.setApplyToClasses(null);
		r.setRank(5);
		return r;
	}


	private ITemplate makeTemplate_TEMPLATE_DEFINITION() {
		Template r = new Template();
		r.setName(TidCartridgeTemplate.TEMPLATE_DEFINITION.name());
		r.setPackage("<%=PACKAGE%>");
		r.setClassname("<%=CLASSNAME%>");
		r.setTargetDir("src-gen");
		r.setFileExtension(".txt");
		r.setGeneratorFqn(TemplateDefinition.class.getName());
		r.setJetPath("/JetFile.jet");
		r.setMergeStrategy(TemplateMergeStrategy.SKIP);
		r.setCartridgeName(CARTRIDGE_NAME);
		r.setApplyToClasses(new Class<?> [] {ICartridgeTemplateType.class,});
		r.setRank(5);
		return r;
	}
	
	public static Template getJetTargetTemplate() {
		return (Template) makeTemplate_JET_TARGET_FILE();
	}	
	
}
