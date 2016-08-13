package uk.prudentialwarnew.CustomerListMain.adapter.models;

/**
 * Created by user on 8/10/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("last")
    @Expose
    private String last;
    @SerializedName("first")
    @Expose
    private String first;

    /**
     *
     * @return
     * The last
     */
    public String getLast() {
        return last;
    }

    /**
     *
     * @param last
     * The last
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     *
     * @return
     * The first
     */
    public String getFirst() {
        return first;
    }

    /**
     *
     * @param first
     * The first
     */
    public void setFirst(String first) {
        this.first = first;
    }

}
