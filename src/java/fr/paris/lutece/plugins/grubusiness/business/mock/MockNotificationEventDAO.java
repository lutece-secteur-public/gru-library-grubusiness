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
package fr.paris.lutece.plugins.grubusiness.business.mock;

import fr.paris.lutece.plugins.grubusiness.business.notification.INotificationEventDAO;
import fr.paris.lutece.plugins.grubusiness.business.notification.NotificationEvent;
import fr.paris.lutece.plugins.grubusiness.business.notification.NotificationFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class provides Data Access methods for NotificationEvent objects
 */
public final class MockNotificationEventDAO implements INotificationEventDAO
{
    List<NotificationEvent> _eventList = new ArrayList<>( );

    /**
     * {@inheritDoc }
     */
    @Override
    public NotificationEvent insert( NotificationEvent notificationEvent )
    {
        _eventList.add( notificationEvent );

        return notificationEvent;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Optional<NotificationEvent> loadById( int nKey )
    {
        for ( NotificationEvent event : _eventList )
        {
            if ( event.getId( ) == nKey )
                return Optional.of( event );
        }

        return Optional.empty( );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void delete( int nKey )
    {
        for ( NotificationEvent event : _eventList )
        {
            if ( event.getId( ) == nKey )
            {
                _eventList.remove( event );
                return;
            }
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<NotificationEvent> loadByDemand( String strDemandId, String strDemandTypeId )
    {
        List<NotificationEvent> eventDemandList = new ArrayList<>( );

        for ( NotificationEvent event : _eventList )
        {
            if ( event.getDemand( ).getId( ).equals( strDemandId ) && event.getDemand( ).getTypeId( ).equals( strDemandTypeId ) )
            {
                eventDemandList.add( event );
            }
        }

        return eventDemandList;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<NotificationEvent> loadByFilter( NotificationFilter filter )
    {
        List<NotificationEvent> eventDemandList = new ArrayList<>( );

        for ( NotificationEvent event : _eventList )
        {
            if ( filter.containsDemandTypeId( ) && event.getDemand( ).getTypeId( ).equals( filter.getDemandTypeId( ) ) )
            {
                eventDemandList.add( event );
            }
        }

        return eventDemandList;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Integer> loadIdsByFilter( NotificationFilter filter )
    {
        List<Integer> eventDemandList = new ArrayList<>( );

        for ( NotificationEvent event : _eventList )
        {
            if ( filter.containsDemandTypeId( ) && event.getDemand( ).getTypeId( ).equals( filter.getDemandTypeId( ) ) )
            {
                eventDemandList.add( event.getId( ) );
            }
        }

        return eventDemandList;
    }

    @Override
    public List<NotificationEvent> loadByNotification( String strDemandId, String strDemandTypeId, long lNotificationDate )
    {
        List<NotificationEvent> eventList = new ArrayList<>( );

        for ( NotificationEvent event : _eventList )
        {
            if ( event.getDemand( ).getId( ).equals( strDemandId ) && event.getDemand( ).getTypeId( ).equals( strDemandTypeId )
                    && event.getNotificationDate( ) == lNotificationDate )
            {
                eventList.add( event );
            }
        }

        return eventList;
    }

    @Override
    public List<NotificationEvent> loadByIds( List<Integer> listIds )
    {
        List<NotificationEvent> eventList = new ArrayList<>( );

        for ( NotificationEvent event : _eventList )
        {
            if ( listIds.contains( event.getId( ) ) )
            {
                eventList.add( event );
            }
        }

        return eventList;
    }

    @Override
    public String deleteBeforeDate( long lDate )
    {

        return "MOCK (no need to purge)";
    }

    @Override
    public void deleteByCustomerId( String strCustomerId )
    {
        // TODO Auto-generated method stub
        
    }

}
