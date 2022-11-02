package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
		void add(Language language);
		void delete(int id);
		void update(Language language);
		List<Language> getAll();
		Language getById(int id);
}
