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

/**
 * NotificationFilter for DAO A base notificationFilter return all notifications without details on sub object
 */
public class NotificationFilter
{
    // filter on id
    private String _strId;

    // filter on demand
    private String _strDemandId;
    private String _strDemandTypeId;
    
    // filter on date
    private long _lStartDate;
    private long _lEndDate;

    // filter on sub notif
    private Boolean _bHasCustomerEmailNotification;
    private Boolean _bHasSmsNotification;
    private Boolean _bHasBackofficeNotification;
    private Boolean _bHasMyDashboardNotification;
    private Boolean _bHasBroadcastEmailNotification;

    /**
     * Check if this filter contains a id
     *
     * @return true if the filter contain an id
     */
    public boolean containsId( )
    {
        return ( _strId != null );
    }

    /**
     * Get the id
     * 
     * @return the id
     */
    public String getId( )
    {
        return _strId;
    }

    /**
     * The id
     * 
     * @param strId
     *            the id
     */
    public void setId( String strId )
    {
        _strId = strId;
    }

    /**
     * Check if this filter contains a demandId
     *
     * @return true if the filter contain an id of demand
     */
    public boolean containsDemandId( )
    {
        return ( _strDemandId != null );
    }

    /**
     * @return the demandId
     */
    public String getDemandId( )
    {
        return _strDemandId;
    }

    /**
     * @param strDemandId
     *            the demandId to set
     */
    public void setDemandId( String strDemandId )
    {
        this._strDemandId = strDemandId;
    }

    /**
     * Check if this filter contains a demandTypeId
     *
     * @return true if the filter contain an id of demandType
     */
    public boolean containsDemandTypeId( )
    {
        return ( _strDemandTypeId != null );
    }

    /**
     * @return the demandTypeId
     */
    public String getDemandTypeId( )
    {
        return _strDemandTypeId;
    }

    /**
     * @param strDemandTypeId
     *            the demandTypeId to set
     */
    public void setDemandTypeId( String strDemandTypeId )
    {
        this._strDemandTypeId = strDemandTypeId;
    }

    /**
     * Check if this filter contains a hasCustomerEmailNotification
     *
     * @return true if the filter contain a hasCustomerEmailNotification
     */
    public boolean containsHasCustomerEmailNotification( )
    {
        return ( _bHasCustomerEmailNotification != null );
    }

    /**
     * @return the HasCustomerEmailNotification
     */
    public Boolean getHasCustomerEmailNotification( )
    {
        return _bHasCustomerEmailNotification;
    }

    /**
     * @param bHasCustomerEmailNotification
     *            the hasCustomerEmailNotification to set
     */
    public void setHasCustomerEmailNotification( Boolean bHasCustomerEmailNotification )
    {
        this._bHasCustomerEmailNotification = bHasCustomerEmailNotification;
    }

    /**
     * Check if this filter contains a hasSmsNotification
     *
     * @return true if the filter contain a hasSmsNotification
     */
    public boolean containsHasSmsNotification( )
    {
        return ( _bHasSmsNotification != null );
    }

    /**
     * @return the hasSmsNotification
     */
    public Boolean getHasSmsNotification( )
    {
        return _bHasSmsNotification;
    }

    /**
     * @param bHasSmsNotification
     *            the hasSmsNotification to set
     */
    public void setHasSmsNotification( Boolean bHasSmsNotification )
    {
        this._bHasSmsNotification = bHasSmsNotification;
    }

    /**
     * Check if this filter contains a hasBackofficeNotification
     *
     * @return true if the filter contain a hasBackofficeNotification
     */
    public boolean containsHasBackofficeNotification( )
    {
        return ( _bHasBackofficeNotification != null );
    }

    /**
     * @return the hasBackofficeNotification
     */
    public Boolean getHasBackofficeNotification( )
    {
        return _bHasBackofficeNotification;
    }

    /**
     * @param bHasBackofficeNotification
     *            the hasBackofficeNotification to set
     */
    public void setHasBackofficeNotification( Boolean bHasBackofficeNotification )
    {
        this._bHasBackofficeNotification = bHasBackofficeNotification;
    }

    /**
     * Check if this filter contains a hasMyDashboardNotification
     *
     * @return true if the filter contain a hasMyDashboardNotification
     */
    public boolean containsHasMyDashboardNotification( )
    {
        return ( _bHasMyDashboardNotification != null );
    }

    /**
     * @return the hasMyDashboardNotification
     */
    public Boolean getHasMyDashboardNotification( )
    {
        return _bHasMyDashboardNotification;
    }

    /**
     * @param bHasMyDashboardNotification
     *            the hasMyDashboardNotification to set
     */
    public void setHasMyDashboardNotification( Boolean bHasMyDashboardNotification )
    {
        this._bHasMyDashboardNotification = bHasMyDashboardNotification;
    }

    /**
     * Check if this filter contains a hasBroadcastEmailNotification
     *
     * @return true if the filter contain a hasBroadcastEmailNotification
     */
    public boolean containsHasBroadcastEmailNotification( )
    {
        return ( _bHasBroadcastEmailNotification != null );
    }

    /**
     * @return the hasBroadcastEmailNotification
     */
    public Boolean getHasBroadcastEmailNotification( )
    {
        return _bHasBroadcastEmailNotification;
    }

    /**
     * @param bHasBroadcastEmailNotification
     *            the hasBroadcastEmailNotification to set
     */
    public void setHasBroadcastEmailNotification( Boolean bHasBroadcastEmailNotification )
    {
        this._bHasBroadcastEmailNotification = bHasBroadcastEmailNotification;
    }

    /**
     * test if filter contains start date
     * 
     * @return true if starDate > 0
     */
    public boolean containsStartDate( )
    {
        return ( _lStartDate > 0 );
    }

    /**
     * get start date 
     * @return the start date
     */
    public long getStartDate() {
        return _lStartDate;
    }

    /**
     * set start date
     * 
     * @param _lStartDate 
     */
    public void setStartDate(long _lStartDate) {
        this._lStartDate = _lStartDate;
    }

    /**
     * test if filter contains end date
     * 
     * @return true if endDate > 0
     */
    public boolean containsEndDate( )
    {
        return ( _lEndDate > 0 );
    }
    
    /**
     * get end date
     * @return the end date
     */
    public long getEndDate() {
        return _lEndDate;
    }

    /**
     * set end date
     * 
     * @param _lEndDate 
     */
    public void setEndDate(long _lEndDate) {
        this._lEndDate = _lEndDate;
    }


}
