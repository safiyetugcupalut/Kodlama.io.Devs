package kodlama.io.Kodlama.io.Devs.wepApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) throws Exception {
		this.languageService = languageService;
	}
	
	@GetMapping("/add")
	public void add(Language language){
			 languageService.add(language);		
	}
	
	@GetMapping("/delete")
	public void delete(int id){
		 languageService.delete(id);		
	}
	
	@GetMapping("/update")
	public void update(Language language) throws Exception {
		 languageService.update(language);		
	}
	
	@GetMapping("/getAll")
	public List<Language> getAll(){
		return languageService.getAll();		
	}
	
	@GetMapping("/getById")
	public Language getById(int id){
		return languageService.getById(id);		
	}
		
}
