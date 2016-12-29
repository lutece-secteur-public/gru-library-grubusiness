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

import fr.paris.lutece.plugins.grubusiness.business.notification.NotifyGruGlobalNotification;

import java.util.ArrayList;
import java.util.List;


/**
 * Demand Class
 */
public class Demand extends BaseDemand
{
    public static final int STATUS_INPROGRESS = 0;
    public static final int STATUS_CLOSED = 1;

    // Variables declarations 
    private String _strTitle;
    private List<NotifyGruGlobalNotification> _listNotifications;
    private List<Action> _listActions = new ArrayList<Action>(  );
    private String _strCustomerId;
    private long _lCreationDate;
    private long _lClosureDate;
    private int _nMaxSteps;
    private int _nCurrentStep;
    private boolean _bShowDetails;

    /** Constructor */
    public Demand(  )
    {
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
    public List<NotifyGruGlobalNotification> getNotifications(  )
    {
        return _listNotifications;
    }

    /**
     * Sets the Notifications
     *
     * @param listNotifications The Notifications
     */
    public void setNotifications( List<NotifyGruGlobalNotification> listNotifications )
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
     * Gives the customer id
     * @return the customer id
     */
    public String getCustomerId(  )
    {
        return _strCustomerId;
    }

    /**
     * Sets the customer id
     * @param strCustomerId the customer id to set
     */
    public void setCustomerId( String strCustomerId )
    {
        _strCustomerId = strCustomerId;
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
    public int getMaxSteps(  )
    {
        return _nMaxSteps;
    }

    /**
     * Sets the number of steps
     * @param nMaxSteps the number of steps to set
     */
    public void setMaxSteps( int nMaxSteps )
    {
        _nMaxSteps = nMaxSteps;
    }

    /**
     * Gives the current step
     * @return the current step
     */
    public int getCurrentStep(  )
    {
        return _nCurrentStep;
    }

    /**
     * Sets the current step
     * @param nCurrentStep the current step to set
     */
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
