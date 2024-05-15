/*
 * Copyright (c) 2002-2024, City of Paris
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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import fr.paris.lutece.plugins.grubusiness.business.demand.Demand;
import fr.paris.lutece.plugins.grubusiness.business.notification.Event;

/**
 * NotificationEvent class, object to log events as delivery success or failure.
 *
 */
@JsonRootName( value = "notificationEvent" )
@JsonPropertyOrder( {
        "date", "msg_id", "demand", "event"
} )
public class NotificationEvent
{
    // Variables declarations
    private int _nId;
    private Long _lNotificationDate;
    private String _strMsgId;
    private Demand _demand;
    private Event _event;

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
        _demand = demand;
    }

    /**
     * Returns the NotificationDate.
     *
     * @return The NotificationDate
     */
    @JsonProperty( "date" )
    public Long getNotificationDate( )
    {
        return _lNotificationDate;
    }

    /**
     * Sets the NotificationDate.
     *
     * @param lNotificationDate
     */
    @JsonProperty( "date" )
    public void setNotificationDate( Long lNotificationDate )
    {
        _lNotificationDate = lNotificationDate;
    }

    /**
     * get msg id
     * 
     * @return the message id
     */
    @JsonProperty( "msg_id" )
    public String getMsgId( )
    {
        return _strMsgId;
    }

    /**
     * set message Id
     * 
     * @param strMsgId
     */
    @JsonProperty( "msg_id" )
    public void setMsgId( String strMsgId )
    {
        this._strMsgId = strMsgId;
    }

    /**
     * get event
     * 
     * @return the event
     */
    @JsonProperty( "event" )
    public Event getEvent( )
    {
        return _event;
    }

    /**
     * set event
     * 
     * @param event
     */
    @JsonProperty( "event" )
    public void setEvent( Event event )
    {
        this._event = event;
    }
}
