package com.sam;

import java.util.*;

import com.myspace.loan.*;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.runtime.rule.FactHandle;
import org.drools.compiler.lang.dsl.DSLMapParser.mapping_file_return;
import org.drools.core.util.Drools;
import org.jbpm.workflow.instance.WorkflowProcessInstance;

public class RunProcess {
	
	public RunProcess() {
		
	}
	
	public static void main(String[] args) {
		Applicant applicant = new Applicant();
		applicant.setTaxScore(600);
		applicant.setAmount(5100.0);
		applicant.setSalary(50000.00);
		applicant.setAge(35);
		
		String groupID = "com.myspace";
		String artifactId = "Loan";
		String version = "1.0.2-SNAPSHOT";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicant", applicant);
		
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId(groupID, artifactId, version);
		KieContainer kContainer = ks.newKieContainer(releaseId);
		KieSession kSession = kContainer.newKieSession();
		KieRuntime kRuntime = (KieRuntime) kSession;
		ProcessInstance processInstance = kRuntime.startProcess("Loan.loanProcess", params);
		System.out.println("status: " + applicant.getApproved());
		System.out.println(kRuntime.getQueryResults("test").size());
	}
	
	public void runLoan(Applicant a) {
		String groupID = "com.myspace";
		String artifactId = "Loan";
		String version = "1.0.2-SNAPSHOT";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicant",  a);
		
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId(groupID, artifactId, version);
		KieContainer kContainer = ks.newKieContainer(releaseId);
		KieSession kSession = kContainer.newKieSession();
		KieRuntime kRuntime = (KieRuntime) kSession;
		ProcessInstance processInstance = kRuntime.startProcess("Loan.loanProcess", params);
	}

}
