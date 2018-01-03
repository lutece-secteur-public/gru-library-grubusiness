/*
 * Copyright (c) 2002-2017, Mairie de Paris
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

import fr.paris.lutece.plugins.grubusiness.business.demand.Demand;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Notification, default notification object.<br/>
 * Fields description<br/>
 * - demand,{@link Demand}<br/>
 * - date, timestamp of the notification<br/>
 * - backoffice, {@link BackofficeNotification}<br/>
 * - sms, {@link SMSNotification}<br/>
 * - customer_email, {@link EmailNotification}<br/>
 * - mydashboard, {@link MyDashboardNotification}<br/>
 * - email, list of {@link BroadcastNotification}
 */
@JsonRootName( value = "notification" )
@JsonPropertyOrder( {
        "date", "demand", "backoffice", "customer_email", "sms", "mydashboard", "email"
} )
public class Notification
{
    // Variables declarations
    private int _nId;
    private Demand _demand;
    private Long _lDate;
    private EmailNotification _emailNotification;
    private SMSNotification _smsNotification;
    private BackofficeNotification _backofficeNotification;
    private MyDashboardNotification _myDashboardNotification;
    private List<BroadcastNotification> _listBroadcastEmail;

    /**
     * Instantiates a new notify gru global notification.
     */
    public Notification( )
    {
        this._lDate = NotificationConstants.DEFAULT_LONG;
    }

    /**
     * Gives the notification id
     * 
     * @return the notification id
     */
    @JsonIgnore
    public int getId( )
    {
        return _nId;
    }

    /**
     * Sets the notification id
     * 
     * @param nId
     *            the id to set
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
    public Demand getDemand( )
    {
        return _demand;
    }

    /**
     * Sets the Demand.
     *
     * @param demand
     *            the Demand to set
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
    public Long getDate( )
    {
        return _lDate;
    }

    /**
     * Sets the NotificationDate.
     *
     * @param notificationDate
     *            The NotificationDate
     */
    @JsonProperty( "date" )
    public void setDate( Long notificationDate )
    {
        _lDate = notificationDate;
    }

    /**
     * Gets the user email notification.
     *
     * @return the user email
     */
    @JsonProperty( "customer_email" )
    @JsonInclude( Include.NON_NULL )
    public EmailNotification getEmailNotification( )
    {
        return _emailNotification;
    }

    /**
     * Sets the user email notification.
     *
     * @param emailNotification
     *            the new user email
     */
    @JsonProperty( "customer_email" )
    public void setEmailNotification( EmailNotification emailNotification )
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
    public SMSNotification getSmsNotification( )
    {
        return _smsNotification;
    }

    /**
     * Sets the user sms.
     *
     * @param userSMS
     *            the new user sms
     */
    @JsonProperty( "sms" )
    public void setSmsNotification( SMSNotification userSMS )
    {
        this._smsNotification = userSMS;
    }

    /**
     * Gets the _backofficeNotification.
     *
     * @return the backofficeNotification
     */
    @JsonProperty( "backoffice" )
    @JsonInclude( Include.NON_NULL )
    public BackofficeNotification getBackofficeNotification( )
    {
        return _backofficeNotification;
    }

    /**
     * Sets the _backofficeNotification.
     *
     * @param backofficeNotification
     *            the backofficeNotification
     */
    @JsonProperty( "backoffice" )
    public void setBackofficeNotification( BackofficeNotification backofficeNotification )
    {
        this._backofficeNotification = backofficeNotification;
    }

    /**
     * Gets the user guichet.
     *
     * @return the user guichet
     */
    @JsonProperty( "mydashboard" )
    @JsonInclude( Include.NON_NULL )
    public MyDashboardNotification getMyDashboardNotification( )
    {
        return _myDashboardNotification;
    }

    /**
     * Sets the user dashboard notif.
     *
     * @param userDashboard
     *            the new user dashboard notif
     */
    @JsonProperty( "mydashboard" )
    public void setMyDashboardNotification( MyDashboardNotification myDashboardNotification )
    {
        this._myDashboardNotification = myDashboardNotification;
    }

    /**
     * Gets the broadcast
     * 
     * @return the _broadcast
     */
    @JsonProperty( "broadcast_email" )
    @JsonInclude( Include.NON_NULL )
    public List<BroadcastNotification> getBroadcastEmail( )
    {
        return _listBroadcastEmail;
    }

    /**
     * Sets the broadcast
     * 
     * @param broadcast
     *            the broadcast to set
     */
    @JsonProperty( "broadcast_email" )
    public void setBroadcastEmail( List<BroadcastNotification> listBroadcastEmail )
    {
        this._listBroadcastEmail = listBroadcastEmail;
    }

    /**
     * add a broadcastEmai
     * 
     * @param broadcastEmail
     *            , the email to add
     */
    public void addBroadcastEmail( BroadcastNotification broadcastEmail )
    {
        if ( this._listBroadcastEmail == null )
        {
            this._listBroadcastEmail = new ArrayList<BroadcastNotification>( );
        }

        this._listBroadcastEmail.add( broadcastEmail );
    }
}
