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

import fr.paris.lutece.plugins.grubusiness.business.notification.INotificationDAO;
import fr.paris.lutece.plugins.grubusiness.business.notification.Notification;

import java.util.Collection;


/**
 * This class manages demands
 *
 */
public class DemandService
{
    private IDemandDAO _demandDao;
    private INotificationDAO _notificationDao;

    /**
     * Constructor
     * @param demandDAO the DAO for the demands
     * @param notificationDAO the DAO for the notifications
     */
    public DemandService( IDemandDAO demandDAO, INotificationDAO notificationDAO )
    {
        _demandDao = demandDAO;
        _notificationDao = notificationDAO;
    }

    /**
     * Finds demands for the specified customer id
     * @param strCustomerId the customer id
     * @return the demands. An empty collection is returned if no demand has been found
     */
    public Collection<Demand> findByCustomerId( String strCustomerId )
    {
        return _demandDao.loadByCustomerId( strCustomerId );
    }

    /**
     * Finds a demand for the specified id and type id
     * @param strDemandId the demand id
     * @param strDemandTypeId the demand type id
     * @return the demand if found, {@code null} otherwise
     */
    public Demand findByPrimaryKey( String strDemandId, String strDemandTypeId )
    {
        Demand demand = _demandDao.load( strDemandId, strDemandTypeId );

        if ( demand != null )
        {
            demand.setNotifications( _notificationDao.loadByDemand( strDemandId, strDemandTypeId ) );
        }

        return demand;
    }

    /**
     * Creates a demand
     * @param demand the demand to create
     * @return the created demand
     */
    public Demand create( Demand demand )
    {
        return _demandDao.insert( demand );
    }

    /**
     * Creates a notification
     * @param notification the notification to create
     * @return the created notification
     */
    public Notification create( Notification notification )
    {
        return _notificationDao.insert( notification );
    }

    /**
     * Updates a demand
     * @param demand the demand to update
     * @return the updated demand
     */
    public Demand update( Demand demand )
    {
        return _demandDao.store( demand );
    }

    /**
     * Removes a demand with the specified id and type id
     * @param strDemandId the demand id
     * @param strDemandTypeId the demand type id
     */
    public void remove( String strDemandId, String strDemandTypeId )
    {
        _notificationDao.deleteByDemand( strDemandId, strDemandTypeId );
        _demandDao.delete( strDemandId, strDemandTypeId );
    }
}
