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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;

/**
 * The Class NotifyGruResponse.
 */
@JsonRootName( value = "acknowledge" )
@JsonPropertyOrder( {
    "status", "errors", "warnings"
} )
public class NotifyGruResponse
{
    public static final String STATUS_RECEIVED = "received";
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_WARNING = "warning";
    private String _strStatus;
    private List<Event> _warnings;
    private List<Event> _errors;

    /**
     * @return the _strStatus
     */
    @JsonProperty( "status" )
    public String getStatus( )
    {
        return _strStatus;
    }

    /**
     * @param strStatus
     *            the strStatus to set
     */
    @JsonProperty( "status" )
    public void setStatus( String strStatus )
    {
        this._strStatus = strStatus;
    }

    /**
     * get warnings
     * 
     * @return the list
     */
    @JsonProperty( "warnings" )
    public List<Event> getWarnings() {
        return _warnings;
    }

    /**
     * set warnings
     * 
     * @param warnings 
     */
    @JsonProperty( "warnings" )
    public void setWarnings(List<Event> warnings) {
        this._warnings = warnings;
    }

    /**
     * get errors
     * 
     * @return the list
     */
    @JsonProperty( "errors" )
    public List<Event> getErrors() {
        return _errors;
    }

    /**
     * set errors
     * 
     * @param errors 
     */
    @JsonProperty( "errors" )
    public void setErrors(List<Event> errors) {
        this._errors = errors;
    }
    
    
}
