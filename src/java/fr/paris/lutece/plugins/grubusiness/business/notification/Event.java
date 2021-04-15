/*
 * Copyright (c) 2002-2021, Mairie de Paris
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


/**
 * NotificationEvent class, object to log events as delivery success or failure.
 *
 */
@JsonRootName( value = "event" )
@JsonPropertyOrder( { 
    "id", "event_date", "type", "status", "redelivry", "message"
} )
public class Event
{
    // Variables declarations
    private int _nId;
    private Long _lEventDate;
    private String _strType;
    private String _strStatus;
    private String _strMessage;
    private int _nRedelivry;

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
     * Returns the Notification Event Date.
     *
     * @return The NotificationDate
     */
    @JsonProperty( "event_date" )
    public Long getEventDate( )
    {
        return _lEventDate;
    }

    /**
     * Sets the NotificationDate.
     *
     * @param lEventDate
     */
    @JsonProperty( "event_date" )
    public void setEventDate( Long lEventDate )
    {
        _lEventDate = lEventDate;
    }

    /**
     * get type of event
     * 
     * @return the type
     */
    public String getType() {
        return _strType;
    }

    /**
     * set type 
     * 
     * @param _strType 
     */
    public void setType(String _strType) {
        this._strType = _strType;
    }

    /**
     * get the status
     * @return the status
     */
    public String getStatus() {
        return _strStatus;
    }

    /**
     * set the status
     * 
     * @param _strStatus 
     */
    public void setStatus(String _strStatus) {
        this._strStatus = _strStatus;
    }

    /**
     * get the message
     * 
     * @return the message
     */
    public String getMessage() {
        return _strMessage;
    }

    /**
     * set the message
     * 
     * @param _strMessage 
     */
    public void setMessage(String _strMessage) {
        this._strMessage = _strMessage;
    }
 
    /**
     * get the nb of times that the message has been redelivred
     * 
     * @return the redelivry number 
     */
    public int getRedelivry() {
        return _nRedelivry;
    }

    /**
     * set redelivry nb
     * 
     * @param nRedelivry 
     */
    public void setRedelivry(int nRedelivry) {
        this._nRedelivry = nRedelivry;
    }
    
}
