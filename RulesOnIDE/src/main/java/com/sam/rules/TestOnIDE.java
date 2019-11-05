package com.sam.rules;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import com.sam.Loan.*;

public class TestOnIDE {
	
	public static void main(String[] args) {
		try {
			ApplicantInfo aInfo = new ApplicantInfo();
			aInfo.setOfAge(true);
			Person person= new Person();
			LoanInfo lInfo = new LoanInfo();
			lInfo.setAmount(500.0);
			lInfo.setLength(12);
			person.setAge(30);
			person.setTaxScore(610);
			person.setlInfo(lInfo);
			person.setSalary(100000.00);
			aInfo.setPerson(person);
			
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");
			FactHandle aiFactHandle;
			aiFactHandle = kSession.insert(aInfo);
			kSession.fireAllRules();
			kSession.getAgenda().getAgendaGroup("approve").setFocus(); /*This is  how you can get a  specific ruleflow group to fire in a ksession without setting focus in drools*/
			kSession.fireAllRules();
			System.out.println("Rules fired!!!");
		}
		catch (Throwable t) {
			// TODO: handle exception
			t.printStackTrace();
		}
	}

}
