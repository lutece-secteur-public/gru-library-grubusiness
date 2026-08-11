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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DemandType
{
    public static final String DEMANDTYPE_METADATA_PUSH = "PUSH";
    public static final String DEMANDTYPE_METADATA_DEFAULT_SUBJECT = "DEFAULT_SUBJECT";
    public static final String DEMANDTYPE_METADATA_PUSH_DISABLE = "disable";

    @JsonProperty( "id" )
    private int _nId;
    
    @JsonProperty( "id_demand_type" )
    private String _strIdDemandType;

    @JsonProperty( "label" )
    private String _strLabel;

    @JsonProperty( "url" )
    private String _strUrl;

    @JsonProperty( "app_code" )
    private String _strAppCode;

    @JsonProperty( "category" )
    private String _strCategory;

    @JsonProperty( "meta_data" )
    private Map<String,String> _mapMetaData;
    
    /**
     * @return the _nId
     */
    public int getId( )
    {
        return _nId;
    }

    /**
     * @param _nId the _nId to set
     */
    public void setId( int _nId )
    {
        this._nId = _nId;
    }

    /**
     * Get the id demand type
     * 
     * @return the id demand type
     */
    @JsonProperty( "id_demand_type" )
    public String getIdDemandType( )
    {
        return _strIdDemandType;
    }

    /**
     * Set the id demand type
     * 
     * @param nIdDemandType
     *            the id deman type
     */
    @JsonProperty( "id_demand_type" )
    public void setIdDemandType( String strIdDemandType )
    {
        _strIdDemandType = strIdDemandType;
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

    /**
     * Returns the Category
     * 
     * @return The Category
     */
    @JsonProperty( "category" )
    public String getCategory( )
    {
        return _strCategory;
    }

    /**
     * Sets the Category
     * 
     * @param strCategory
     *            The Category
     */
    public void setCategory( String strCategory )
    {
        _strCategory = strCategory;
    }

    /**
     * get meta data
     * 
     * @return the data
     */
    @JsonProperty("meta_data")
    public Map<String,String> getMetaData( )
    {
        return _mapMetaData;
    }

    /**
     * set meta data
     * 
     * @param _mapMetaData
     */
    public void setMetaData( Map<String,String> _mapMetaData ) 
    {
	    this._mapMetaData = _mapMetaData;
    }
	
    /**
     * add a meta data
     * 
     * @param key
     * @param value
     */
    public void addMetaData( String key, String value )
    {
        if ( _mapMetaData == null )
        {
            _mapMetaData = new HashMap<>();
        }

        _mapMetaData.put(key, value);
    }

    @JsonIgnore
    public boolean isPushDisabled() {
        return Objects.nonNull(_mapMetaData) && DEMANDTYPE_METADATA_PUSH_DISABLE.equals(_mapMetaData.get(DEMANDTYPE_METADATA_PUSH));
    }

    @JsonIgnore
    public String getDefaultSubject() {
        if(Objects.nonNull(_mapMetaData)) {
            return _mapMetaData.get(DEMANDTYPE_METADATA_DEFAULT_SUBJECT);
        }
        return null;
    }
}
