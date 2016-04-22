package test;

import mda.type.IEntityType;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import test.data.TemplatesData;
import test.data.TestConstants;

import com.flca.mda.codegen.helpers.LogHelper;

import flca.mda.codegen.data.ITemplate;
import flca.mda.codegen.data.Template;
import flca.mda.codegen.data.TemplateMergeStrategy;
import flca.test.base.AbstractTestTemplates;

public class TestTestTemplates extends AbstractTestTemplates implements TestConstants {
	@BeforeClass
	public static void beforeOnce() {
		AbstractTestTemplates.beforeOnceBase(new TemplatesData());
	}

	@AfterClass
	public static void afterOnce() {
		if (LogHelper.getLogbackErrorCount() > startLogbackErrorCount) {
			System.err.println("errors encountered see logfile ");
		}
	}


	private ITemplate makeTestTemplate() {
		String jetfile = "/backend/TestTemplate.jet";
		String targetdir = "/tmp";
		String classname = "<%=CLASSNAME%>";
		String pck = "<%=PACKAGE%>";
		String ext = ".java";
		String insertTag = null;
		String genFqn = "backend.TestTemplate";
		Class<?> appliesto[] = { IEntityType.class };
		TemplateMergeStrategy strategy = TemplateMergeStrategy.SKIP;
		int rank = 0;
		
		return new Template("TestTemplate", jetfile, genFqn, targetdir, 
				pck, classname, ext, insertTag,
				appliesto, strategy, rank, null);	
	}
}
