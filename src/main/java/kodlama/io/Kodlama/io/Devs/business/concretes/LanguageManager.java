package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
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
	public void add(Language language) {
		try {
			if(isLanguageExist(language)) throw new Exception("İsimler tekrar edilemez.");
			if(isLanguageEmpty(language)) throw new Exception("Programlama dili boş geçilemez!");

			languageRepository.add(language);
		} catch (Exception exception) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 languageRepository.delete(id);
	}

	@Override
	public void update(Language language) {
		for (Language languages : languageRepository.getAll()) {
			if(languages.getName().equals(language.getName())) {
				System.out.println("İsimler tekrar edilemez.");
			}
			if(languages.getName().isEmpty()) {
				System.out.println("Programlama dili boş geçilemez!");
			}
		}
		languageRepository.update(language);
	}

	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) {
		return languageRepository.getById(id);
	}
	
	private boolean isLanguageExist(Language language){
        for (Language languages : this.languageRepository.getAll()){
            if (languages.getName().equals(language.getName())){
                return true;
            }
        }
        return false;
    }

    private boolean isLanguageEmpty(Language language){
    	return language.getName().isEmpty();
    }


}
