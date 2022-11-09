package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdLanguagesResponse;

public interface LanguageService {
	
		void add(CreateLanguageRequest createLanguageRequest) throws Exception;
		
		void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;
		
		void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
		
		List<GetAllLanguagesResponse> getAll();
		
		GetByIdLanguagesResponse getById(int id);
}
