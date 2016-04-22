package cartridge;

import java.util.*;
import flca.mda.api.util.*;
import mda.template.type.*;
import flca.mda.codegen.data.*;

public class TemplateDefinition
{
  protected static String nl;
  public static synchronized TemplateDefinition create(String lineSeparator)
  {
    nl = lineSeparator;
    TemplateDefinition result = new TemplateDefinition();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t" + NL + "Copy/past the following lines in respectively the Tid class, and the class with Template definitions." + NL + "\t" + NL + "\t";
  protected final String TEXT_3 = "," + NL + "\t" + NL + "\tresult.add(makeTemplate_";
  protected final String TEXT_4 = "());" + NL + "\t" + NL + "\tprivate ITemplate makeTemplate_";
  protected final String TEXT_5 = "() {" + NL + "\t\tTemplate r = new Template();" + NL + "\t\tr.setName(Tid.";
  protected final String TEXT_6 = ".name());" + NL + "\t\tr.setPackage(\"";
  protected final String TEXT_7 = "\");" + NL + "\t\tr.setClassname(\"";
  protected final String TEXT_8 = "\");" + NL + "\t\tr.setTargetDir(\"";
  protected final String TEXT_9 = "\");" + NL + "\t\tr.setFileExtension(\"";
  protected final String TEXT_10 = "\");" + NL + "\t\tr.setGeneratorFqn(backend.Entity.class.getName());" + NL + "\t\tr.setJetPath(\"";
  protected final String TEXT_11 = "\");" + NL + "\t\tr.setMergeStrategy(TemplateMergeStrategy.";
  protected final String TEXT_12 = ");" + NL + "\t\tr.setCartridgeName(CARTRIDGE_NAME);" + NL + "\t\tr.setApplyToClasses(new Class<?> [] {";
  protected final String TEXT_13 = "});" + NL + "\t\tr.setRank(";
  protected final String TEXT_14 = ");" + NL + "\t\treturn r;" + NL + "\t}" + NL + "\t" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     	// here we parse the input argument(s) and create the object JetArgument:arg and Object[]:args
	JetArgument arg = null;
	Object args[] = null;

	if (argument != null) { 
		if (argument instanceof JetArgument) {
			arg = (JetArgument) argument;
		} else if (argument.getClass().isArray()) { 
			args = (Object[]) argument;
			if (args[0] instanceof JetArgument) {
				arg = (JetArgument) args[0];
			}
		}
	} 

    
	Object obj = arg.getElement(); 

	String enumName = null;
	String targetClassname = null;
	String targetPackage = null;
	String targetFileExt = null;
	String targetDir = null;
	String jetPackage = null;
	String jetClassname = null;
	String jetExtension = null;
	int  rank = 5;
	TemplateMergeStrategy mergeStrategy = null;
	String appliesTo = null;

	if (obj instanceof ICartridgeTemplateType) {
		ICartridgeTemplateType carttype = (ICartridgeTemplateType) arg.getElement(); 
		enumName = carttype.getEnumName();
		targetClassname = carttype.getTargetClassname();
		targetPackage = carttype.getTargetPackage();
		targetFileExt = carttype.getTargetFileExtenstion();
		targetDir = carttype.getTargetDir();
		jetPackage = carttype.getJetPackage();
		jetClassname = carttype.getJetClassname();
		jetExtension = carttype.getJetExtension();
		rank = carttype.getRank();
		mergeStrategy = carttype.getMergeStrategy();
		appliesTo = carttype.getAppliesTo();
	} else {
		System.out.println("arg.element is not of the right type: " + obj);
	}

    stringBuffer.append(TEXT_1);
     	String jetPath = "/" + jetPackage + "/" + jetClassname + jetExtension;
	String s1 = "todo"; 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(targetPackage);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(targetClassname);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(targetDir);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(targetFileExt);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(jetPath);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(mergeStrategy);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(appliesTo);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(rank);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
