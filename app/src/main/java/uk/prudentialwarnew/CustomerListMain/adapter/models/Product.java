package uk.prudentialwarnew.CustomerListMain.adapter.models;

/**
 * Created by user on 8/10/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("joiningDate")
    @Expose
    private String joiningDate;
    @SerializedName("accountBalance")
    @Expose
    private String accountBalance;
    @SerializedName("maturityDate")
    @Expose
    private String maturityDate;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     *
     * @return
     * The joiningDate
     */
    public String getJoiningDate() {
        return joiningDate;
    }

    /**
     *
     * @param joiningDate
     * The joiningDate
     */
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     *
     * @return
     * The accountBalance
     */
    public String getAccountBalance() {
        return accountBalance;
    }

    /**
     *
     * @param accountBalance
     * The accountBalance
     */
    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     *
     * @return
     * The maturityDate
     */
    public String getMaturityDate() {
        return maturityDate;
    }

    /**
     *
     * @param maturityDate
     * The maturityDate
     */
    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

}
