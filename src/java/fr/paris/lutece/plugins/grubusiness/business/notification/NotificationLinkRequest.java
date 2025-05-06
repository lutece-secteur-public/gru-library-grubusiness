package fr.paris.lutece.plugins.grubusiness.business.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder( {
        "notification_link"
} )
public class NotificationLinkRequest
{
    NotificationLink notificationLink;

    public NotificationLinkRequest(NotificationLink notificationLink)
    {
        this.notificationLink = notificationLink;
    }

    @JsonProperty( "notification_link" )
    public NotificationLink getNotificationLink()
    {
        return notificationLink;
    }

    @JsonProperty( "notification_link" )
    public void setNotificationLink(NotificationLink notificationLink)
    {
        this.notificationLink = notificationLink;
    }
}
