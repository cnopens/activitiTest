package br.com.fourData.infrastructure.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class RuntimeServiceCreator implements ComponentFactory<RuntimeService> {

	private final RuntimeService runtimeService;
	
	public RuntimeServiceCreator(ProcessEngine processEngine) {
		runtimeService = processEngine.getRuntimeService();
	}

	@Override
	public RuntimeService getInstance() {
		return runtimeService;
	}
	
}
