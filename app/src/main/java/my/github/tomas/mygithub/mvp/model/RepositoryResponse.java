package my.github.tomas.mygithub.mvp.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Tomas on 24/10/2016.
 */

public class RepositoryResponse {

    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private String language;
    @Expose
    private int id;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
