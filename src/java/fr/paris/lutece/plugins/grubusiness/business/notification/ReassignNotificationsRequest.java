package fr.paris.lutece.plugins.grubusiness.business.notification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName( value = "reassign_notifications" )
@JsonPropertyOrder( {
        "old_customer_id", "new_customer_id"
} )
public class ReassignNotificationsRequest
{
    private String oldCustomerId;
    private String newCustomerId;

    @JsonProperty( "old_customer_id" )
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public String getOldCustomerId()
    {
        return oldCustomerId;
    }

    @JsonProperty( "old_customer_id" )
    public void setOldCustomerId(String oldCustomerId)
    {
        this.oldCustomerId = oldCustomerId;
    }

    @JsonProperty( "new_customer_id" )
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public String getNewCustomerId()
    {
        return newCustomerId;
    }

    @JsonProperty( "new_customer_id" )
    public void setNewCustomerId(String newCustomerId)
    {
        this.newCustomerId = newCustomerId;
    }
}
