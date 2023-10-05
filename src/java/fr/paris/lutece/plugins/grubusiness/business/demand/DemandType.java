/*
 * Copyright (c) 2002-2018, Mairie de Paris
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

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemandType
{
    @JsonProperty( "id_demand_type" )
    private int _nIdDemandType;
    @JsonProperty( "label" )
    private String _strLabel;
    @JsonProperty( "url" )
    private String _strUrl;
    @JsonProperty( "app_code" )
    private String _strAppCode;

    /**
     * Get the id demand type
     * 
     * @return the id demand type
     */
    @JsonProperty( "id_demand_type" )
    public int getIdDemandType( )
    {
        return _nIdDemandType;
    }

    /**
     * Set the id demand type
     * 
     * @param nIdDemandType
     *            the id deman type
     */
    @JsonProperty( "id_demand_type" )
    public void setIdDemandType( int nIdDemandType )
    {
        _nIdDemandType = nIdDemandType;
    }

    /**
     * Get the label
     * 
     * @return the label
     */
    @JsonProperty( "label" )
    public String getLabel( )
    {
        return _strLabel;
    }

    /**
     * Set the label
     * 
     * @param strLabel
     *            the label
     */
    public void setLabel( String strLabel )
    {
        _strLabel = strLabel;
    }

    /**
     * Get the url of the resource
     * 
     * @return the url of the resource
     */

    @JsonProperty( "url" )
    public String getUrl( )
    {
        return _strUrl;
    }

    /**
     * Set the url of the form
     * 
     * @param strUrl
     *            the url of the form
     */
    public void setUrl( String strUrl )
    {
        _strUrl = strUrl;
    }

    /**
     * Get the app code
     * 
     * @return the app code
     */

    @JsonProperty( "app_code" )
    public String getAppCode( )
    {
        return _strAppCode;
    }

    /**
     * Set the app code
     * 
     * @param strUrl
     *            the app code
     */
    public void setAppCode( String strAppCode )
    {
        _strAppCode = strAppCode;
    }
    
}
