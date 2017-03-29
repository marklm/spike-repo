package at.markl.spikes.re.drools.service;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.LoggerFactory;

import at.markl.spikes.re.drools.data.ControllActionTyp;
import at.markl.spikes.re.drools.data.TempMeasurement;
import at.markl.spikes.re.drools.handler.ActionHandler;

/**
 * https://www.tutorialspoint.com/drools/drools_quick_guide.htm
 * https://docs.jboss.org/drools/release/6.5.0.Final/drools-docs/html_single/index.html
 * https://docs.jboss.org/drools/release/6.5.0.Final/drools-docs/html_single/index.html#d0e5038
 * https://ezegrande.wordpress.com/2014/11/19/drools-basic-rules-example/
 * https://www.tutorialspoint.com/drools/drools_rule_syntax.htm
 * 
 * @author mexx
 *
 */
public class SimpleHeatingRuleService {

	public SimpleHeatingRuleService() {
		// TODO Auto-generated constructor stub
	}

	public ControllActionTyp evaluateTemparature(TempMeasurement measurement) {

		try {
			KieSession session = getSession();
			
			session.insert(measurement);
			session.fireAllRules();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return measurement.getEvaluatedAction();
	}

	private static KieSession getSession() throws Exception {

		KieServices kieServices = KieServices.Factory.get();
		KieContainer kContainer = kieServices.getKieClasspathContainer();
		
		KieSession session = kContainer.newKieSession();
		
		session.setGlobal("logger", LoggerFactory.getLogger("MyLogger"));
		session.setGlobal("actionHandler", new ActionHandler());
		
		return session;
	}

}
