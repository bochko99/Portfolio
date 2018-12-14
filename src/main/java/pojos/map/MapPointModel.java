
package pojos.map;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MapPointModel {

    @Expose
    private String category;
    @Expose
    private List<String> comments;
    @Expose
    private String id;
    @Expose
    private Long lat;
    @Expose
    private Long lon;
    @Expose
    private String name;
    @Expose
    private Long rating;

    public String getCategory() {
        return category;
    }

    public MapPointModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public List<String> getComments() {
        return comments;
    }

    public MapPointModel setComments(List<String> comments) {
        this.comments = comments;
        return this;
    }

    public String getId() {
        return id;
    }

    public MapPointModel setId(String id) {
        this.id = id;
        return this;
    }

    public Long getLat() {
        return lat;
    }

    public MapPointModel setLat(Long lat) {
        this.lat = lat;
        return this;
    }

    public Long getLon() {
        return lon;
    }

    public MapPointModel setLon(Long lon) {
        this.lon = lon;
        return this;
    }

    public String getName() {
        return name;
    }

    public MapPointModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getRating() {
        return rating;
    }

    public MapPointModel setRating(Long rating) {
        this.rating = rating;
        return this;
    }
}
