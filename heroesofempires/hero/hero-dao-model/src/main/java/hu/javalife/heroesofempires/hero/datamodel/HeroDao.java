package hu.javalife.heroesofempires.hero.datamodel;

import java.util.List;

public interface HeroDao {

    public List<HeroDataModel> getAllHero();
    public HeroDataModel getById(long id);
    public boolean isAviable(String name);
    public HeroDataModel getByName(String name);
    public HeroDataModel modify(long id,HeroDataModel h);
    public void delete(long id);
    public HeroDataModel add(HeroDataModel h);
    public long getItemCount();
}
