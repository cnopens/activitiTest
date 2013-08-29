package br.com.fourData.infrastructure.activiti;

import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class FormServiceCreator implements ComponentFactory<FormService> {
	
	private final FormService formService;

	public FormServiceCreator(ProcessEngine processEngine) {
		formService = processEngine.getFormService();
	}
	
	@Override
	public FormService getInstance() {
		return formService;
	}

}
