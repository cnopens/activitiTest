package br.com.fourData.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fourData.domain.model.activiti.form.Property;

@Resource
public class ProcessDefinitionController {

	private final Result result;
	private final RepositoryService repositoryService;
	private final RuntimeService runtimeService;
	private final FormService formService;

	public ProcessDefinitionController(Result result, RepositoryService repositoryService, RuntimeService runtimeService, FormService formService) {
		this.result = result;
		this.repositoryService = repositoryService;
		this.runtimeService = runtimeService;
		this.formService = formService;
	}

	@Get("/processDefinition")
	public void list() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().active().list();
		result.include("processDefinitions", list);
	}
	
	@Post("/processDefinition/{id}/start")
	public void start(String id, List<Property> properties) {
		if(properties != null && properties.size() > 0) {
			runtimeService.startProcessInstanceById(id, propertiesToMap(properties));
		} else {
			runtimeService.startProcessInstanceById(id);
		}
		
		result.redirectTo(this).list();
	}
	
	@Get("/processDefinition/{id}/form")
	public void form(String id) {
		result.include("id", id);
		result.include("formData", formService.getStartFormData(id));
	}
	
	private Map<String, Object> propertiesToMap(List<Property> properties) {
		Map<String, Object> propertiesMap = new HashMap<>();
		for(Property property : properties) {
			propertiesMap.put(property.getId(), property.getValue());
		}
		
		return propertiesMap;
	}
	
}
