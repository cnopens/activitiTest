package br.com.fourData.infrastructure.activiti;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class ProcessEngineCreator implements ComponentFactory<ProcessEngine> {

	public ProcessEngine getInstance() {
		return ProcessEngines.getDefaultProcessEngine();
	}
	
	@PostConstruct
	public void init() {
		ProcessEngines.init();
	}
	
	@PreDestroy
	public void destroy() {
		ProcessEngines.destroy();
	}
	
	

}
