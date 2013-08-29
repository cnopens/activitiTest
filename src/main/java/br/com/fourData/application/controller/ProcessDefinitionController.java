package br.com.fourData.application.controller;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ProcessDefinitionController {

	private final RepositoryService repositoryService;
	private final Result result;

	public ProcessDefinitionController(RepositoryService repositoryService, Result result) {
		this.repositoryService = repositoryService;
		this.result = result;
	}

	@Get("/processDefinition")
	public void list() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().active().list();
		result.include("processDefinitions", list);
	}
	
}
