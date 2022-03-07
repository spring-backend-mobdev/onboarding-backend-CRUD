package cl.mobdev.onboarding.crud.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "characters")
@Entity
public class Character implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "gender")
    private String gender;

    @Column(name = "species")
    private String species;

    @Column(name = "type")
    private String type;

    @Column(name = "episode")
    private ArrayList<String> episode;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Location origin;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "url")
    private String url;

    @Column(name = "image")
    private String image;

    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;


    public Character() {
    }

    public Character(String name, String status, String gender, String species, String type, ArrayList<String> episode, Location origin, Location location, String url, String image, Date created) {
        this.name = name;
        this.status = status;
        this.gender = gender;
        this.species = species;
        this.type = type;
        this.episode = episode;
        this.origin = origin;
        this.location = location;
        this.url = url;
        this.image = image;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getEpisode() {
        return episode;
    }

    public void setEpisode(ArrayList<String> episode) {
        this.episode = episode;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}