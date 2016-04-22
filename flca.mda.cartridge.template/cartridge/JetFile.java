package cartridge;

import java.util.*;
import flca.mda.api.util.*;
import mda.template.type.*;
import mda.template.*;
import flca.mda.codegen.data.*;
import cartridge.*;

public class JetFile
{
  protected static String nl;
  public static synchronized JetFile create(String lineSeparator)
  {
    nl = lineSeparator;
    JetFile result = new JetFile();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

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

     TypeUtils tu = new TypeUtils(); 
     Template template = CartridgeTemplateConstants.getJetTargetTemplate(); 
	template.setName(enumName);
	template.setPackage(jetPackage);
	template.setClassname(jetClassname);
	template.setTargetDir("src-gen");
	template.setFileExtension(jetExtension);

     tu.generate(arg.getElementClass(), template, arg); 
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
