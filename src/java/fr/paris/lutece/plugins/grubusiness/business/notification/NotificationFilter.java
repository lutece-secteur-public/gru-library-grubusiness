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

import java.util.ArrayList;
import java.util.List;

/**
 * NotificationFilter for DAO A base notificationFilter return all notifications without details on sub object
 */
public class NotificationFilter
{
    // filter on id
    private List<Integer> _listIds;

    // filter on demand
    private String _strDemandId;
    private String _strDemandTypeId;
    
    // filter on date
    private long _lStartDate;
    private long _lEndDate;
    
    // Notification type
    private List<EnumNotificationType> _listNotificationType = new ArrayList< >() ;

    // filter on eventStatus
    private String _strEventStatus;
    
    /**
     * Check if this filter contains a id
     *
     * @return true if the filter contain an id
     */
    public boolean containsId( )
    {
        return ( _listIds != null && !_listIds.isEmpty( ) );
    }

    /**
     * Get the id
     * 
     * @return the id
     */
    public List<Integer> getIds( )
    {
        return _listIds;
    }

    /**
     * The id
     * 
     * @param strId
     *            the id
     */
    public void setIds( List<Integer> listIds )
    {
        _listIds = listIds;
    }

    /**
     * Check if this filter contains a demandId
     *
     * @return true if the filter contain an id of demand
     */
    public boolean containsDemandId( )
    {
        return ( _strDemandId != null && !"".equals( _strDemandId.trim( ) ) );
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
        return ( _strDemandTypeId != null && !"".equals( _strDemandTypeId.trim( ) ) );
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
        return ( !_listNotificationType.isEmpty( ) && _listNotificationType.contains( EnumNotificationType.CUSTOMER_EMAIL ) );
    }


    /**
     * Check if this filter contains a hasSmsNotification
     *
     * @return true if the filter contain a hasSmsNotification
     */
    public boolean containsHasSmsNotification( )
    {
        return ( !_listNotificationType.isEmpty( ) && _listNotificationType.contains( EnumNotificationType.SMS ) );
    }

    /**
     * Check if this filter contains a hasBackofficeNotification
     *
     * @return true if the filter contain a hasBackofficeNotification
     */
    public boolean containsHasBackofficeNotification( )
    {
        return ( !_listNotificationType.isEmpty( ) && _listNotificationType.contains( EnumNotificationType.BACKOFFICE ) );
    }

    /**
     * Check if this filter contains a hasMyDashboardNotification
     *
     * @return true if the filter contain a hasMyDashboardNotification
     */
    public boolean containsHasMyDashboardNotification( )
    {
        return ( !_listNotificationType.isEmpty( ) && _listNotificationType.contains( EnumNotificationType.MYDASHBOARD ) );
    }

    /**
     * Check if this filter contains a hasBroadcastEmailNotification
     *
     * @return true if the filter contain a hasBroadcastEmailNotification
     */
    public boolean containsHasBroadcastEmailNotification( )
    {
        return ( !_listNotificationType.isEmpty( ) && _listNotificationType.contains( EnumNotificationType.BROADCAST_EMAIL ) );
    }

    /**
     * Check if this filter contains a notification type filter
     * @return true if the filter contain a notification type filter
     */
    public boolean containsNotificationTypeFilter( )
    {
        return containsHasCustomerEmailNotification( ) || containsHasSmsNotification( ) 
                || containsHasBackofficeNotification( ) || containsHasMyDashboardNotification( ) || containsHasBroadcastEmailNotification( );
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

    /**
     * get event status
     * @return the status filter
     */
    public String getEventStatus() {
        return _strEventStatus;
    }

    /**
     * set event status
     * 
     * @param strEventStatus 
     */
    public void setEventStatus(String strEventStatus) {
        this._strEventStatus = strEventStatus;
    }

    /**
     * @return the _listNotificationType
     */
    public List<EnumNotificationType> getListNotificationType( )
    {
        return _listNotificationType;
    }

    /**
     * @param listNotificationType the _listNotificationType to set
     */
    public void setListNotificationType( List<EnumNotificationType> listNotificationType )
    {
        this._listNotificationType = listNotificationType;
    }

}
