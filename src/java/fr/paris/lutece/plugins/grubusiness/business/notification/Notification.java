/*
 * Copyright (c) 2002-2016, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.grubusiness.business.notification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.paris.lutece.plugins.grubusiness.business.customer.Customer;
import fr.paris.lutece.plugins.grubusiness.business.demand.Demand;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class Notification, default notification object.<br/>
 * Fields description<br/>
 *  - crm_status_id, single CRM status id<br/>
 *  - demand_max_step, maximum step of the demand<br/>
 *  - demand_id_type, single request type id associated with 'Guichet' services<br/>
 *  - demand_id, request ID for the current user<br/>
 *  - email, user email<br/>
 *  - notification_type, typ of the notification<br/>
 *  - demand_user_current_step, current step of the demand<br/>
 *  - backoffice_logging, {@link BackofficeNotification}<br/>
 *  - user_guid, user id to create a new request<br/>
 *  - user_sms, {@link SMSNotification}<br/>
 *  - user_email, {@link EmailNotification}<br/>
 *  - user_dashboard, {@link MyDashboardNotification}
 *
 */
@JsonRootName( value = "notification" )
@JsonPropertyOrder( {"date",
    "demand",
    "backoffice",
    "customer_email",
    "sms",
    "mydashboard",
    "email"
} )
public class Notification
{
    // Variables declarations
    @JsonIgnore
    private int _nId;
    private Demand _demand;
    private Long _notificationDate;
    private EmailNotification _emailNotification;
    private SMSNotification _userSMS;
    private BackofficeNotification _backofficeLogging;
    private MyDashboardNotification _userDashboard;
    private List<BroadcastNotification> _lstBroadcastEmail;

    /**
     * Instantiates a new notify gru global notification.
     */
    public Notification(  )
    {
        this._notificationDate = NotificationConstants.DEFAULT_LONG;
    }

    /**
     * Gives the notification id
     * @return the notification id
     */
    public int getId(  )
    {
        return _nId;
    }

    /**
     * Sets the notification id
     * @param nId the id to set
     */
    public void setId( int nId )
    {
        _nId = nId;
    }

    /**
     * Returns the Demand
     *
         * @return the Demand
         */
    @JsonProperty( "demand" )
    public Demand getDemand(  )
    {
        return _demand;
    }

    /**
     * Sets the Demand.
     *
     * @param demand the Demand to set
     */
    @JsonProperty( "demand" )
    public void setDemand( Demand demand )
    {
        this._demand = demand;
    }

    /**
     * Returns the NotificationDate.
     *
     * @return The NotificationDate
     */
    @JsonProperty( "date" )
    public Long getNotificationDate(  )
    {
        return _notificationDate;
    }

    /**
     * Sets the NotificationDate.
     *
     * @param notificationDate The NotificationDate
     */
    @JsonProperty( "date" )
    public void setNotificationDate( Long notificationDate )
    {
        _notificationDate = notificationDate;
    }

    /**
     * Gets the user email notification.
     *
     * @return the user email
     */
    @JsonProperty( "customer_email" )
    @JsonInclude( Include.NON_NULL )
    public EmailNotification getUserEmail(  )
    {
        return _emailNotification;
    }

    /**
     * Sets the user email notification.
     *
     * @param emailNotification the new user email
     */
    @JsonProperty( "customer_email" )
    public void setUserEmail( EmailNotification emailNotification )
    {
        this._emailNotification = emailNotification;
    }

    /**
     * Gets the user sms.
     *
     * @return the user sms
     */
    @JsonProperty( "sms" )
    @JsonSerialize( include = JsonSerialize.Inclusion.NON_NULL )
    public SMSNotification getUserSMS(  )
    {
        return _userSMS;
    }

    /**
     * Sets the user sms.
     *
     * @param userSMS the new user sms
     */
    @JsonProperty( "sms" )
    public void setUserSMS( SMSNotification userSMS )
    {
        this._userSMS = userSMS;
    }

    /**
     * Gets the user agent.
     *
     * @return the user agent
     */
    @JsonProperty( "backoffice" )
    @JsonInclude( Include.NON_NULL )
    public BackofficeNotification getBackofficeLogging(  )
    {
        return _backofficeLogging;
    }

    /**
     * Sets the user agent.
     *
     * @param userAgent the new user agent
     */
    @JsonProperty( "backoffice" )
    public void setBackofficeLogging( BackofficeNotification backofficeLogging )
    {
        this._backofficeLogging = backofficeLogging;
    }

    /**
     * Gets the user guichet.
     *
     * @return the user guichet
     */
    @JsonProperty( "mydashboard" )
    @JsonInclude( Include.NON_NULL )
    public MyDashboardNotification getUserDashboard(  )
    {
        return _userDashboard;
    }

    /**
     * Sets the user dashboard notif.
     *
     * @param userDashboard the new user dashboard notif
     */
    @JsonProperty( "mydashboard" )
    public void setUserDashboard( MyDashboardNotification userDashboard )
    {
        this._userDashboard = userDashboard;
    }

    /**
     * Gets the broadcast
     * @return the _broadcast
     */
    @JsonProperty( "broadcast_email" )
    @JsonInclude( Include.NON_NULL )
    public List<BroadcastNotification> getBroadcastEmail(  )
    {
        return _lstBroadcastEmail;
    }

    /**
     * Sets the broadcast
     * @param broadcast the broadcast to set
     */
    @JsonProperty( "broadcast_email" )
    public void setBroadcastEmail( List<BroadcastNotification> lstBroadcastEmail )
    {
        this._lstBroadcastEmail = lstBroadcastEmail;
    }

    /**
     * add a broadcastEmai
     * @param broadcastEmail, the email to add
     */
    public void addBroadcastEmail( BroadcastNotification broadcastEmail )
    {
        if ( this._lstBroadcastEmail == null )
        {
            this._lstBroadcastEmail = new ArrayList<BroadcastNotification>(  );
        }

        this._lstBroadcastEmail.add( broadcastEmail );
    }
}
