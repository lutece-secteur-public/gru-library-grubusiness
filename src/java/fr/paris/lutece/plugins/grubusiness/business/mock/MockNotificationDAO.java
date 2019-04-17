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
package fr.paris.lutece.plugins.grubusiness.business.mock;

import java.util.ArrayList;
import java.util.List;

import fr.paris.lutece.plugins.grubusiness.business.notification.INotificationDAO;
import fr.paris.lutece.plugins.grubusiness.business.notification.Notification;
import fr.paris.lutece.plugins.grubusiness.business.notification.NotificationFilter;

/**
 * This class is a mock implementation of {@link INotificationDAO}
 */
public class MockNotificationDAO implements INotificationDAO
{

    private final List<Notification> _listMockNotification = new ArrayList<Notification>( );
    private int _lastId;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Notification> loadByDemand( String strDemandId, String strDemandTypeId )
    {
        List<Notification> listResult = new ArrayList<Notification>( );
        for ( Notification notification : _listMockNotification )
        {
            if ( notification.getDemand( ) != null && notification.getDemand( ).getId( ).equals( strDemandId )
                    && notification.getDemand( ).getTypeId( ).equals( strDemandTypeId ) )
            {
                listResult.add( notification );
            }
        }
        return listResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Notification> loadByFilter( NotificationFilter notificationFilter )
    {
        List<Notification> listResult = new ArrayList<Notification>( );
        for ( Notification notification : _listMockNotification )
        {
            boolean bAddNotif = true;
            if ( notificationFilter.containsDemandId( ) )
            {
                bAddNotif = notification.getDemand( ) != null && notificationFilter.getDemandId( ).equals( notification.getDemand( ).getId( ) );
            }
            if ( bAddNotif && notificationFilter.containsDemandTypeId( ) )
            {
                bAddNotif = notification.getDemand( ) != null && notificationFilter.getDemandTypeId( ).equals( notification.getDemand( ).getTypeId( ) );
            }
            if ( bAddNotif && notificationFilter.containsHasBackofficeNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasBackofficeNotification( ) && notification.getBackofficeNotification( ) != null )
                        || ( !notificationFilter.getHasBackofficeNotification( ) && notification.getBackofficeNotification( ) == null );
            }
            if ( bAddNotif && notificationFilter.containsHasBroadcastEmailNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasBroadcastEmailNotification( ) && notification.getBroadcastEmail( ) != null && notification
                        .getBroadcastEmail( ).size( ) > 0 )
                        || ( !notificationFilter.getHasBroadcastEmailNotification( ) && ( notification.getBroadcastEmail( ) == null || notification
                                .getBroadcastEmail( ).size( ) == 0 ) );
            }
            if ( bAddNotif && notificationFilter.containsHasCustomerEmailNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasCustomerEmailNotification( ) && notification.getEmailNotification( ) != null )
                        || ( !notificationFilter.getHasCustomerEmailNotification( ) && notification.getEmailNotification( ) == null );
            }
            if ( bAddNotif && notificationFilter.containsHasMyDashboardNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasMyDashboardNotification( ) && notification.getMyDashboardNotification( ) != null )
                        || ( !notificationFilter.getHasMyDashboardNotification( ) && notification.getMyDashboardNotification( ) == null );
            }
            if ( bAddNotif && notificationFilter.containsHasSmsNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasSmsNotification( ) && notification.getSmsNotification( ) != null )
                        || ( !notificationFilter.getHasSmsNotification( ) && notification.getSmsNotification( ) == null );
            }
            if ( bAddNotif )
            {
                listResult.add( notification );
            }
        }
        return listResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Notification insert( Notification notification )
    {
        notification.setId( _lastId++ );
        _listMockNotification.add( notification );
        return notification;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteByDemand( String strDemandId, String strDemandTypeId )
    {
        int nIndexDelete = -1;
        for ( int nIndex = 0; nIndex < _listMockNotification.size( ); nIndex++ )
        {
            Notification notification = _listMockNotification.get( nIndex );
            if ( notification.getDemand( ) != null && notification.getDemand( ).getId( ).equals( strDemandId )
                    && notification.getDemand( ).getTypeId( ).equals( strDemandTypeId ) )
            {
                nIndexDelete = nIndex;
                break;
            }
        }
        if ( nIndexDelete > -1 )
        {
            _listMockNotification.remove( nIndexDelete );
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> loadIdsByFilter( NotificationFilter notificationFilter )
    {
        List<String> listResult = new ArrayList<>( );
        for ( Notification notification : _listMockNotification )
        {
            boolean bAddNotif = true;
            if ( notificationFilter.containsDemandId( ) )
            {
                bAddNotif = notification.getDemand( ) != null && notificationFilter.getDemandId( ).equals( notification.getDemand( ).getId( ) );
            }
            if ( bAddNotif && notificationFilter.containsDemandTypeId( ) )
            {
                bAddNotif = notification.getDemand( ) != null && notificationFilter.getDemandTypeId( ).equals( notification.getDemand( ).getTypeId( ) );
            }
            if ( bAddNotif && notificationFilter.containsHasBackofficeNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasBackofficeNotification( ) && notification.getBackofficeNotification( ) != null )
                        || ( !notificationFilter.getHasBackofficeNotification( ) && notification.getBackofficeNotification( ) == null );
            }
            if ( bAddNotif && notificationFilter.containsHasBroadcastEmailNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasBroadcastEmailNotification( ) && notification.getBroadcastEmail( ) != null && notification
                        .getBroadcastEmail( ).size( ) > 0 )
                        || ( !notificationFilter.getHasBroadcastEmailNotification( ) && ( notification.getBroadcastEmail( ) == null || notification
                                .getBroadcastEmail( ).size( ) == 0 ) );
            }
            if ( bAddNotif && notificationFilter.containsHasCustomerEmailNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasCustomerEmailNotification( ) && notification.getEmailNotification( ) != null )
                        || ( !notificationFilter.getHasCustomerEmailNotification( ) && notification.getEmailNotification( ) == null );
            }
            if ( bAddNotif && notificationFilter.containsHasMyDashboardNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasMyDashboardNotification( ) && notification.getMyDashboardNotification( ) != null )
                        || ( !notificationFilter.getHasMyDashboardNotification( ) && notification.getMyDashboardNotification( ) == null );
            }
            if ( bAddNotif && notificationFilter.containsHasSmsNotification( ) )
            {
                bAddNotif = ( notificationFilter.getHasSmsNotification( ) && notification.getSmsNotification( ) != null )
                        || ( !notificationFilter.getHasSmsNotification( ) && notification.getSmsNotification( ) == null );
            }
            if ( bAddNotif )
            {
                listResult.add( String.valueOf( notification.getId( ) ) );
            }
        }
        return listResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Notification loadById( String strId )
    {
        int nId = Integer.parseInt( strId );

        for ( Notification notification : _listMockNotification )
        {
            if ( notification.getDemand( ) != null && notification.getId( ) == nId )
            {
                return notification;
            }
        }
        return null;
    }
}
