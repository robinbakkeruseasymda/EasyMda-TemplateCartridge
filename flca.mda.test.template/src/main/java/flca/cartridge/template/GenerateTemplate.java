package flca.cartridge.template;

import flca.mda.codegen.data.TemplateMergeStrategy;
import mda.template.type.ICartridgeTemplateType;


public class GenerateTemplate implements ICartridgeTemplateType {

	@Override
	public String getEnumName() {
		return "SOAP_SERVICE";
	}

	@Override
	public String getTargetClassname() {
		return "<%=CLASSNAME%>";
	}

	@Override
	public String getTargetPackage() {
		return "<%=PACKAGE%>";
	}

	@Override
	public String getTargetFileExtenstion() {
		return ".java";
	}

	@Override
	public String getTargetDir() {
		return "<%=Backend%>/<%=src-gen%>";
	}

	@Override
	public String getJetPackage() {
		return "backend";
	}

	@Override
	public String getJetClassname() {
		return "SoapService";
	}

	@Override
	public String getJetExtension() {
		return ".jet";
	}

	@Override
	public int getRank() {
		return 5;
	}

	@Override
	public TemplateMergeStrategy getMergeStrategy() {
		return TemplateMergeStrategy.MERGE;
	}

	@Override
	public String getAppliesTo() {
		return "IEntityType.class";
	}

	

}
