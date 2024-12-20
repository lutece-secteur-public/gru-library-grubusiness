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
package fr.paris.lutece.plugins.grubusiness.business.demand;

import javax.validation.constraints.NotEmpty;

import fr.paris.lutece.plugins.grubusiness.business.web.rs.EnumGenericStatus;

import java.io.Serializable;

/**
 * This is the business class for the object TemporaryStatus
 */
public class TemporaryStatus implements Serializable
{
    private static final long serialVersionUID = 1L;

    // Variables declarations
    private int _nTemporayStatusId;

    @NotEmpty( message = "#i18n{notificationstore.validation.status.Status.notEmpty}" )
    private String _strStatus;

    private EnumGenericStatus _genericStatus;

    /**
     * Returns the Id
     * 
     * @return The Id
     */
    public int getId( )
    {
        return _nTemporayStatusId;
    }

    /**
     * Sets the Id
     * 
     * @param nId
     *            The Id
     */
    public void setId( int nId )
    {
        _nTemporayStatusId = nId;
    }

    /**
     * @return the _strStatus
     */
    public String getStatus( )
    {
        return _strStatus;
    }

    /**
     * @param strStatus
     *            the _strStatus to set
     */
    public void setStatus( String strStatus )
    {
        this._strStatus = strStatus;
    }

    /**
     * @return the _genericStatus
     */
    public EnumGenericStatus getGenericStatus( )
    {
        return _genericStatus;
    }

    /**
     * @param genericStatus
     *            : the genericStatus to set
     */
    public void setGenericStatus( EnumGenericStatus genericStatus )
    {
        this._genericStatus = genericStatus;
    }

}
