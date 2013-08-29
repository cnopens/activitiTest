package br.com.fourData.infrastructure.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class RepositoryServiceCreator implements ComponentFactory<RepositoryService> {

	private final ProcessEngine processEngine;
	
	public RepositoryServiceCreator(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

	public RepositoryService getInstance() {
		return processEngine.getRepositoryService();
	}

}
