package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracs.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
		private LanguageRepository languageRepository;
	
		
	@Autowired	
	public LanguageManager(LanguageRepository languageRepository) {
			this.languageRepository = languageRepository;
		}
	
	
	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();
		
		for (Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
		
		
	}
	
	@Override
	public GetByIdLanguagesResponse getById(int id) {
		Optional<Language> Language = languageRepository.findById(id);
		GetByIdLanguagesResponse responseItem = new GetByIdLanguagesResponse();
		responseItem.setName(Language.get().getName());
		return responseItem;
	}
	
	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception{
		
		Language language =  new Language();
		language.setName(createLanguageRequest.getName());
		this.languageRepository.save(language);
		
	}
	
	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		Language language = languageRepository.findById(updateLanguageRequest.getId()).get();
		language.setId(updateLanguageRequest.getId());
		language.setName(updateLanguageRequest.getName());	
		languageRepository.save(language);
	}
	

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest)  throws Exception {
		Language language = languageRepository.findById(deleteLanguageRequest.getId()).get();
		 languageRepository.delete(language);
	}


}
