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
package fr.paris.lutece.plugins.grubusiness.business.demand;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import fr.paris.lutece.plugins.grubusiness.business.customer.Customer;
import fr.paris.lutece.plugins.grubusiness.business.notification.Notification;

import java.util.ArrayList;
import java.util.List;


/**
 * Demand Class
 */
@JsonRootName( value = "demand" )
@JsonPropertyOrder( {"id",
    "type_id",
    "reference",
    "status_id",
    "max_step",
    "current_step",
    "customer"
} )
public class Demand
{
    public static final int STATUS_INPROGRESS = 0;
    public static final int STATUS_CLOSED = 1;

    // Variables declarations 
    private String _strId;
    private String _strReference;
    private String _strTypeId;
    protected int _nStatusId;
    @JsonIgnore
    private String _strTitle;
    @JsonIgnore
    private List<Notification> _listNotifications;
    @JsonIgnore
    private List<Action> _listActions = new ArrayList<Action>(  );
    @JsonIgnore
    private long _lCreationDate;
    @JsonIgnore
    private long _lClosureDate;
    private int _nMaxSteps;
    private int _nCurrentStep;
    @JsonIgnore
    private boolean _bShowDetails;
    private Customer _customer;

    /** Constructor */
    public Demand(  )
    {
    }

    /**
     * Gives the id
     *
     * @return The id
     */
    @JsonProperty( "id" )
    public String getId(  )
    {
        return _strId;
    }

    /**
     * Sets the id
     *
     * @param strId The id
     */
    @JsonProperty( "id" )
    public void setId( String strId )
    {
        _strId = strId;
    }

    /**
     * Gives the reference
     *
     * @return The reference
     */
    @JsonProperty( "reference" )
    public String getReference(  )
    {
        return _strReference;
    }

    /**
     * Sets the reference
     *
     * @param strReference The reference
     */
    @JsonProperty( "reference" )
    public void setReference( String strReference )
    {
        _strReference = strReference;
    }

    /**
     * Gives the status id
     *
     * @return The status id
     */
    @JsonProperty( "status_id" )
    public int getStatusId(  )
    {
        return _nStatusId;
    }

    /**
     * Sets the status id
     *
     * @param nStatusId The status id
     */
    @JsonProperty( "status_id" )
    public void setStatusId( int nStatusId )
    {
        _nStatusId = nStatusId;
    }

    /**
     * Sets the type id
     *
     * @param strTypeId The type id
     */
    @JsonProperty( "type_id" )
    public void setTypeId( String strTypeId )
    {
        _strTypeId = strTypeId;
    }

    /**
     * Gves the type id
     *
     * @return The type id
     */
    @JsonProperty( "type_id" )
    public String getTypeId(  )
    {
        return _strTypeId;
    }

    /**
    * Returns the Title
    * @return The Title
    */
    public String getTitle(  )
    {
        return _strTitle;
    }

    /**
     * Sets the Title
     * @param strTitle The Title
     */
    public void setTitle( String strTitle )
    {
        _strTitle = strTitle;
    }

    /**
     * Returns the Notifications
     *
     * @return The Notifications
     */
    public List<Notification> getNotifications(  )
    {
        return _listNotifications;
    }

    /**
     * Sets the Notifications
     *
     * @param listNotifications The Notifications
     */
    public void setNotifications( List<Notification> listNotifications )
    {
        _listNotifications = listNotifications;
    }

    /**
     * Returns the Actions
     *
     * @return The Actions
     */
    public List<Action> getActions(  )
    {
        return _listActions;
    }

    /**
     * Sets the Actions
     *
     * @param listActions The Actions
     */
    public void setActions( List<Action> listActions )
    {
        _listActions = listActions;
    }

    /**
     * Add an action
     * @param action the action to add
     */
    public void addAction( Action action )
    {
        _listActions.add( action );
    }

    /**
     * Gives the customer
     * @return the customer
     */
    @JsonProperty( "customer" )
    public Customer getCustomer(  )
    {
        return _customer;
    }

    /**
     * Sets the customer
     * @param customer the customer to set
     */
    @JsonProperty( "customer" )
    public void setCustomer( Customer customer )
    {
        _customer = customer;
    }

    /**
     * Gives the creation date
     * @return the creation date
     */
    public long getCreationDate(  )
    {
        return _lCreationDate;
    }

    /**
     * Sets the creation date
     * @param lCreationDate the creation date to set
     */
    public void setCreationDate( long lCreationDate )
    {
        this._lCreationDate = lCreationDate;
    }

    /**
     * Gives the closure date
     * @return the closure date
     */
    public long getClosureDate(  )
    {
        return _lClosureDate;
    }

    /**
     * Sets the closure date
     * @param lClosureDate the closure date to set
     */
    public void setClosureDate( long lClosureDate )
    {
        this._lClosureDate = lClosureDate;
    }

    /**
     * Gives the number of steps
     * @return the number of steps
     */
    @JsonProperty( "max_step" )
    public int getMaxSteps(  )
    {
        return _nMaxSteps;
    }

    /**
     * Sets the number of steps
     * @param nMaxSteps the number of steps to set
     */
    @JsonProperty( "max_step" )
    public void setMaxSteps( int nMaxSteps )
    {
        _nMaxSteps = nMaxSteps;
    }

    /**
     * Gives the current step
     * @return the current step
     */
    @JsonProperty( "current_step" )
    public int getCurrentStep(  )
    {
        return _nCurrentStep;
    }

    /**
     * Sets the current step
     * @param nCurrentStep the current step to set
     */
    @JsonProperty( "current_step" )
    public void setCurrentStep( int nCurrentStep )
    {
        _nCurrentStep = nCurrentStep;
    }

    /**
     * Set the flag to show or not details
     * @param bShowDetails the flag value
     */
    public void setShowDetails( boolean bShowDetails )
    {
        _bShowDetails = bShowDetails;
    }

    /**
     * Return true if details can be shown otherwise false.
     * @return The display details flag
     */
    public boolean getShowDetails(  )
    {
        return _bShowDetails;
    }
}
