package br.com.fourData.application.controller;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ProcessDefinitionController {

	private final Result result;
	private final RepositoryService repositoryService;
	private final RuntimeService runtimeService;

	public ProcessDefinitionController(Result result, RepositoryService repositoryService, RuntimeService runtimeService) {
		this.result = result;
		this.repositoryService = repositoryService;
		this.runtimeService = runtimeService;
	}

	@Get("/processDefinition")
	public void list() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().active().list();
		result.include("processDefinitions", list);
	}
	
	@Post("/processDefinition/{id}/start")
	public void start(String id) {
		runtimeService.startProcessInstanceById(id);
		
		result.redirectTo(this).list();
	}
	
}
