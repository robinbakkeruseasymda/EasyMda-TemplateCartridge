package cartridge;

import java.util.*;
import flca.mda.api.util.*;
import mda.template.type.*;
import flca.mda.codegen.data.*;

public class JetTargetFile
{
  protected static String nl;
  public static synchronized JetTargetFile create(String lineSeparator)
  {
    nl = lineSeparator;
    JetTargetFile result = new JetTargetFile();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "\t" + NL + "\ttodo add you code ..." + NL + "\t";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL;

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
     	
	String rb = "%" + ">";
	String s1 = "<%@ jet package=\"" + jetPackage + "\" ";  
	String s2 = "imports=\"java.util.* java.lang.reflect.* mda.type.* flca.mda.api.util.*  flca.mda.codegen.helpers.* webapp.* \" ";
	String s3 = "class=\"" + jetClassname + "\" ";
	String s4 = "<%@ include file=" + "\"java-class-init.jetinc\"" + rb;
	String s5 = "<%@ include file=" + "\"java-start-class.jetinc\"" + rb;
	String s6 = "<% importStringBuffer.insert(importInsertionPoint,  impu.computeSortedImports());" + rb ;	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(s1 );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(s2 );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(s3 );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(s4 );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(s5 );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(s6 );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
