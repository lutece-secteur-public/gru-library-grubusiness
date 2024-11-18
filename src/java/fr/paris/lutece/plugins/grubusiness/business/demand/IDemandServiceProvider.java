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

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import fr.paris.lutece.plugins.grubusiness.business.notification.INotificationDAO;
import fr.paris.lutece.plugins.grubusiness.business.notification.INotificationEventDAO;
import fr.paris.lutece.plugins.grubusiness.business.notification.INotificationListener;
import fr.paris.lutece.plugins.grubusiness.business.notification.Notification;
import fr.paris.lutece.plugins.grubusiness.business.notification.NotificationEvent;

public interface IDemandServiceProvider
{

    /**
     * init DAO
     * 
     * @param dao
     */
    public void setDemandDao( IDemandDAO dao );

    /**
     * init DAO
     * 
     * @param dao
     */
    public void setDemandTypeDao( IDemandTypeDAO dao );

    /**
     * init DAO
     * 
     * @param dao
     */
    public void setNotificationDao( INotificationDAO dao );

    /**
     * init DAO
     * 
     * @param dao
     */
    public void setNotificationEventDao( INotificationEventDAO dao );

    /**
     * init DAO
     * 
     * @param dao
     */
    public void setStatusDao( ITemporaryStatusDAO dao );

    /**
     * Finds demands for the specified customer id
     * 
     * @param strCustomerId
     *            the customer id
     * @return the demands. An empty collection is returned if no demand has been found
     */
    public Collection<Demand> findByCustomerId( String strCustomerId );

    /**
     * Finds demands for the specified reference
     * 
     * @param strReference
     *            the reference
     * @return the demands. An empty collection is returned if no demand has been found
     */
    public Collection<Demand> findByReference( String strReference );

    /**
     * Finds a demand for the specified id and type id
     * 
     * @param strDemandId
     *            the demand id
     * @param strDemandTypeId
     *            the demand type id
     * @return the demand if found, {@code null} otherwise
     */
    public Demand findByPrimaryKey( String strDemandId, String strDemandTypeId, String strCustomerId );

    /**
     * Creates a demand
     * 
     * @param demand
     *            the demand to create
     * @return the created demand
     */
    public Demand create( Demand demand );

    /**
     * Creates a notification
     * 
     * @param notification
     *            the notification to create
     * @return the created notification
     */
    public Notification create( Notification notification );

    /**
     * Creates a notification event
     * 
     * @param notificationEvent
     * @return the created notification event
     */
    public NotificationEvent create( NotificationEvent notificationEvent );

    /**
     * Updates a demand
     * 
     * @param demand
     *            the demand to update
     * @return the updated demand
     */
    public Demand update( Demand demand );
    
    /**
     * Update status demand 
     * 
     * @param nNewStatusId
     *            the new status id
     * @param nTemporaryStatusId
     *            To find Demands that are linked to notifications that have the temporary status in parameter
     */
    public void updateDemandsStatusId( int nNewStatusId, int nTemporaryStatusId );

    /**
     * Removes a demand with the specified id and type id
     * 
     * @param strDemandId
     *            the demand id
     * @param strDemandTypeId
     *            the demand type id
     */
    public void remove( String strDemandId, String strDemandTypeId, String strCustomerId );

    /**
     * Finds events by date and demand_type_id and status
     * 
     * @param dStart
     * @param dEnd
     * @param strDemandTypeId
     * @param strStatus
     * 
     * @return the demands. An empty list is returned if no event has been found
     */
    public List<NotificationEvent> findEventsByDateAndDemandTypeIdAndStatus( long dStart, long dEnd, String strDemandTypeId, String strStatus );

    /**
     * get demand types list
     * 
     * @return the list
     */
    public List<DemandType> getDemandTypesList( );

    /**
     * get demand type
     * 
     * @param id
     * @return the demand type as optional
     */
    public Optional<DemandType> getDemandType( int id );

    /**
     * get demand Ids by customer Id and demand Type
     * 
     * @param strCustomerId
     * @param strNotificationType
     * @param strIdDemandType
     * @return the demand Id list
     */
    public List<Integer> getIdsByCustomerIdAndDemandTypeId( String strCustomerId, String strNotificationType, String strIdDemandType );

    /**
     * get status
     * 
     * @param strStatusLabel
     * @return the status
     */
    public Optional<TemporaryStatus> getStatusByLabel( String strStatusLabel );
    
    /**
     * Deletion of the demand and data related to the demand.
     * @param strCustomerId
     */
    public void deleteAllDemandByCustomerId ( String  strCustomerId );
    
}
