package vgc.com.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie<S> implements Serializable {

    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;

    @Column(name = "movie_name")
    private String movie_name;
    @Column(name = "movie_description")
    private String movie_desc;
    @Column(name = "movie_trailer")
    private String movie_trailer;
    @Column(name = "movie_cens")
    private String movie_cens;
    @Column(name = "movie_genres")
    private String movie_genr;
    @Column(name = "movie_release")
    private String movie_rele;
    @Column(name = "movie_lenght")
    private String movie_leng;
    @Column(name = "movie_format")
    private String movie_form;
    @Column(name ="movie_poster")
    private String movie_poster;


    public Movie() {
    }

    public Movie(int movie_id, String movie_name, String movie_desc, String movie_trailer, String movie_cens, String movie_genr, String movie_rele, String movie_leng, String movie_form, String movie_poster) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_desc = movie_desc;
        this.movie_trailer = movie_trailer;
        this.movie_cens = movie_cens;
        this.movie_genr = movie_genr;
        this.movie_rele = movie_rele;
        this.movie_leng = movie_leng;
        this.movie_form = movie_form;
        this.movie_poster = movie_poster;
    }

    public String getMovie_trailer() {
        return movie_trailer;
    }

    public void setMovie_trailer(String movie_trailer) {
        this.movie_trailer = movie_trailer;
    }

    public String getMovie_poster() {
        return movie_poster;
    }

    public void setMovie_poster(String movie_poster) {
        this.movie_poster = movie_poster;
    }

    public String getMovie_genr() {
        return movie_genr;
    }

    public void setMovie_genr(String movie_genr) {
        this.movie_genr = movie_genr;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_desc() {
        return movie_desc;
    }

    public void setMovie_desc(String movie_desc) {
        this.movie_desc = movie_desc;
    }

    public String getMovie_cens() {
        return movie_cens;
    }

    public void setMovie_cens(String movie_cens) {
        this.movie_cens = movie_cens;
    }

    public String getMovie_rele() {
        return movie_rele;
    }

    public void setMovie_rele(String movie_rele) {
        this.movie_rele = movie_rele;
    }

    public String getMovie_leng() {
        return movie_leng;
    }

    public void setMovie_leng(String movie_leng) {
        this.movie_leng = movie_leng;
    }

    public String getMovie_form() {
        return movie_form;
    }

    public void setMovie_form(String movie_form) {
        this.movie_form = movie_form;
    }

}
