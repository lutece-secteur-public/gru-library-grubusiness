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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;


/**
 * The Class BroadcastNotification for broadcast notification.<br/>
 * Fields description :<br/>
 * - message, content of the notification<br/>
 * - recipient, list of emailAddress for the broadcast
 * - bcc, list of emailAddress for blind carbon copy<br/>
 * - subject, subject of the email<br/>
 * - sender_email, sender email address<br/>
 * - sender_name, sender name<br/>
 * - cc, list of emailAddress for carbon copy
 */
@JsonRootName( value = "broadcast_email" )
@JsonPropertyOrder( {"message",
    "bcc",
    "subject",
    "sender_email",
    "sender_name",
    "recipient",
    "cc"
} )
public class BroadcastNotification
{
    // Variables declarations
    private String _strSenderName;
    private String _strSenderEmail;
    private List<EmailAddress> _lstRecipient;
    private String _strSubject;
    private String _strMessage;
    private List<EmailAddress> _lstCc;
    private List<EmailAddress> _lstBcc;

    /**
     * Returns the SenderName.
     *
     * @return The SenderName
     */
    @JsonProperty( "sender_name" )
    public String getSenderName(  )
    {
        return _strSenderName;
    }

    /**
     * Sets the SenderName.
     *
     * @param strSenderName The SenderName
     */
    @JsonProperty( "sender_name" )
    public void setSenderName( String strSenderName )
    {
        _strSenderName = strSenderName;
    }

    /**
     * Returns the SenderEmail.
     *
     * @return The SenderEmail
     */
    @JsonProperty( "sender_email" )
    public String getSenderEmail(  )
    {
        return _strSenderEmail;
    }

    /**
     * Sets the SenderEmail.
     *
     * @param strSenderEmail The SenderEmail
     */
    @JsonProperty( "sender_email" )
    public void setSenderEmail( String strSenderEmail )
    {
        _strSenderEmail = strSenderEmail;
    }

    /**
     * Returns Recipients.
     *
     * @return Recipients
     */
    @JsonProperty( "recipient" )
    public List<EmailAddress> getRecipient(  )
    {
        return _lstRecipient;
    }

    /**
     * Sets Recipients.
     *
     * @param lstRecipient all Recipients
     */
    @JsonProperty( "recipient" )
    public void setRecipient( List<EmailAddress> lstRecipient )
    {
    	_lstRecipient = lstRecipient;
    }
    
    public void addRecipient( EmailAddress recipient )
    {
    	if( this._lstRecipient == null )
    	{
    		this._lstRecipient = new ArrayList<EmailAddress>(  );
    	}
    	this._lstRecipient.add( recipient );
    }

    /**
     * Returns the Subject.
     *
     * @return The Subject
     */
    @JsonProperty( "subject" )
    public String getSubject(  )
    {
        return _strSubject;
    }

    /**
     * Sets the Subject.
     *
     * @param strSubject The Subject
     */
    @JsonProperty( "subject" )
    public void setSubject( String strSubject )
    {
        _strSubject = strSubject;
    }

    /**
     * Returns the Message.
     *
     * @return The Message
     */
    @JsonProperty( "message" )
    public String getMessage(  )
    {
        return _strMessage;
    }

    /**
     * Sets the Message.
     *
     * @param strMessage The Message
     */
    @JsonProperty( "message" )
    public void setMessage( String strMessage )
    {
        _strMessage = strMessage;
    }

    /**
     * Gets cc addresses.
     *
     * @return cc addresses
     */
    @JsonProperty( "cc" )
    @JsonInclude( Include.NON_NULL )
    public List<EmailAddress> getCc(  )
    {
        return _lstCc;
    }

    /**
     * Sets cc addresses.
     *
     * @param lstCc cc addresses
     */
    @JsonProperty( "cc" )
    public void setCc( List<EmailAddress> lstCc )
    {
        _lstCc = lstCc;
    }
    
    public void addCc( EmailAddress recipient )
    {
    	if( this._lstCc == null )
    	{
    		this._lstCc = new ArrayList<EmailAddress>(  );
    	}
    	this._lstCc.add( recipient );
    }

    /**
     * Gets bcc addresses.
     *
     * @return bbc addresses
     */
    @JsonProperty( "bcc" )
    @JsonInclude( Include.NON_NULL )
    public List<EmailAddress> getBcc(  )
    {
        return _lstBcc;
    }

    /**
     * Sets bcc addresses.
     *
     * @param lstBcc bcc addresses
     */
    @JsonProperty( "bcc" )
    public void setBcc( List<EmailAddress> lstBcc )
    {
        _lstBcc = lstBcc;
    }
    
    public void addBcc( EmailAddress recipient )
    {
    	if( this._lstBcc == null )
    	{
    		this._lstBcc = new ArrayList<EmailAddress>(  );
    	}
    	this._lstBcc.add( recipient );
    }
}
