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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * The Class SMSNotification for SMS notification.<br/>
 * Fields description :<br/>
 * - message, content of the notification<br/>
 * - phone_number, phone number of the user<br/>
 * - sender_name, the name of the sms sender<br/>
 */
@JsonRootName( value = "sms" )
@JsonPropertyOrder( {
        "message", "phone_number", "sender_name"
} )
public class SMSNotification
{
    // Variables declarations
    private String _strPhoneNumber;
    private String _strMessage;
    private String _strSenderName;

    /**
     * Instantiates a new notify gru sms notification.
     */
    public SMSNotification( )
    {
        this._strPhoneNumber = NotificationConstants.DEFAULT_STRING;
        this._strMessage = NotificationConstants.DEFAULT_STRING;
        this._strSenderName = NotificationConstants.DEFAULT_STRING;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    @JsonProperty( "phone_number" )
    public String getPhoneNumber( )
    {
        return _strPhoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param strPhoneNumber
     *            the new phone number
     */
    @JsonProperty( "phone_number" )
    public void setPhoneNumber( String strPhoneNumber )
    {
        _strPhoneNumber = strPhoneNumber;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    @JsonProperty( "message" )
    public String getMessage( )
    {
        return _strMessage;
    }

    /**
     * Sets the message.
     *
     * @param strMessage
     *            the new message
     */
    @JsonProperty( "message" )
    public void setMessage( String strMessage )
    {
        _strMessage = strMessage;
    }

    /**
     * Gets the sender_name.
     *
     * @return the sender_name
     */
    @JsonProperty( "sender_name" )
    public String getSenderName( )
    {
        return _strSenderName;
    }

    /**
     * Sets the sender_name.
     *
     * @param strSenderName
     *            the new sender_name
     */
    @JsonProperty( "sender_name" )
    public void setSenderName( String strSenderName )
    {
        _strSenderName = strSenderName;
    }
}
