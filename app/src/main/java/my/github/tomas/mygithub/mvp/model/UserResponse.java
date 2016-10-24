package my.github.tomas.mygithub.mvp.model;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by Tomas on 24/10/2016.
 */

public class UserResponse {

    @Expose
    private long id;

    @Expose
    private String name;

    @Expose
    private String url;

    @Expose
    private int stargazers_count;

    @Expose
    private int forks_count;


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public int getForks_count() {
        return forks_count;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }
}
