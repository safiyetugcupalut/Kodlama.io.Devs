package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracs.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Java"));
		languages.add(new Language(3, "Python"));
	}

	@Override
	public void add(Language language) {
		languages.add(language);
	}

	@Override
	public void delete(int id) {
		for (Language language : languages) {
			if(language.getId() == id) {
				languages.remove(language);
			}
		}
		
	}

	@Override
	public void update(Language language) {
		for (Language language1 : languages) {
			if(language1.getId() == language1.getId()) {
				language1.setName(language.getName());
			}
		}
	}

	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languages;
	}

	@Override
	public Language getById(int id) {
		for (Language language : languages) {
			if(language.getId() == id) {
				return language;
			}
		}
		return null;
	}

}
