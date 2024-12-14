package com.proyecto.mangaList.entity.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.proyecto.mangaList.entity.dao.IMangaDao;
import com.proyecto.mangaList.entity.models.Manga;

@Service
public class MangaServiceImpl implements IMangaService{
	@Autowired
	private IMangaDao mangaDao;
	
	@Override
	public Manga get(long ID_Manga) {
		return mangaDao.findById(ID_Manga).get();
	}

	@Override
	public List<Manga> getAll() {	
		return (List<Manga>) mangaDao.findAll();
	}

	@Override
	public void post(Manga manga) {
		mangaDao.save(manga);
		
	}

	@Override
	public void put(Manga manga, long ID_Manga) {
		mangaDao.findById(ID_Manga).ifPresent((x)->{
			manga.setID_Manga(ID_Manga);
			mangaDao.save(manga);
		});
		
	}
	
	@Override
	public void delete(long ID_Manga) {
		mangaDao.deleteById(ID_Manga);
		
	}
	
    @Override
    public Page<Manga> getAll(Pageable pageable) {
        return mangaDao.findAll(pageable);
    }
}