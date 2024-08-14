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
package fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;



@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class ResponseStatus
{

    public static final String KEY_ATTRIBUTE_STATUS = "status";
    public static final String KEY_ATTRIBUTE_STATUS_CODE = "code";
    public static final String KEY_STATUS = "status";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_MESSAGE_KEY = "message_key";
    public static final String KEY_HTTP_CODE = "http_code";
    
    private final int httpCode;
    private final ResponseStatusType type;
    private String message;
    private String messageKey;
    

    @ConstructorProperties( {
            "httpCode", "status"
    } )
    public ResponseStatus( final int httpCode, final ResponseStatusType type )
    {
        this.httpCode = httpCode;
        this.type = type;
    }

    @JsonProperty( value = KEY_HTTP_CODE )
    public int getHttpCode( )
    {
        return httpCode;
    }

    @JsonProperty( value = KEY_STATUS )
    public ResponseStatusType getType( )
    {
        return type;
    }

    @JsonProperty( value = KEY_MESSAGE )
    public String getMessage( )
    {
        return message;
    }

    @JsonProperty( value = KEY_MESSAGE )
    public ResponseStatus setMessage( final String message )
    {
        this.message = message;
        return this;
    }

    @JsonProperty( value = KEY_MESSAGE_KEY )
    public String getMessageKey( )
    {
        return messageKey;
    }

    @JsonProperty( value = KEY_MESSAGE_KEY )
    public ResponseStatus setMessageKey( final String messageKey )
    {
        this.messageKey = messageKey;
        return this;
    }

    @Override
    public boolean equals( final Object o )
    {
        if ( !( o instanceof ResponseStatus ) )
        {
            return false;
        }
        final ResponseStatus other = (ResponseStatus) o;
        return this.httpCode == other.httpCode && this.type == other.type;
    }

    @Override
    public String toString() {
        return "ResponseStatus{" +
                "httpCode=" + httpCode +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", messageKey='" + messageKey + '\'' +
                '}';
    }
}