package hu.javalife.heroesofempires.hero.datamodel;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author krisztian
 */

@Entity
@Table(name ="hero")
public class HeroDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name, description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroDataModel that = (HeroDataModel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
