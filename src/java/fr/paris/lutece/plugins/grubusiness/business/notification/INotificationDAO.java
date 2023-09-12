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

import java.util.List;
import java.util.Optional;

/**
 * This interface represents a data access object for Notification object
 *
 */
public interface INotificationDAO
{

    /**
     * Finds notifications associated to the id
     * 
     * @param strId
     * @return the notification coresponding to given id.
     */
	Optional<Notification> loadById( int id );

    /**
     * Finds notifications associated to the specified demand id and demand type id. The notifications must be sorted by date descending
     * 
     * @param strDemandId
     *            the demand id
     * @param strDemandTypeId
     *            the demand type id
     * @return the notifications. An empty list is returned if no notification has been found.
     */
    List<Notification> loadByDemand( String strDemandId, String strDemandTypeId );

    /**
     * Get notification by demand ids and notification date
     * 
     * @param strDemandId
     * @param strDemandTypeId
     * @param lDate
     * @return the notification
     */
    List<Notification> loadByDemandAndDate( String strDemandId, String strDemandTypeId, long lDate );

    /**
     * Finds and populate notification according to the filter
     * 
     * @param notificationFilter
     *            the filter
     * @return the notifications. An empty list is returned if no notification has been found.
     */
    List<Notification> loadByFilter( NotificationFilter notificationFilter );
    
    /**
     * Finds and populate notification by demand id, type id, customer id
     * 
     * @param strDemandId 
     * @param strDemandTypeId
     * @param strCustomerId
     * @return the notifications. An empty list is returned if no notification has been found.
     */
    List<Notification> loadByDemandIdTypeIdCustomerId( String strDemandId, String strDemandTypeId, String strCustomerId );

    /**
     * Inserts a notification
     * 
     * @param notification
     *            the notification to insert
     * @return the inserted notification
     */
    Notification insert( Notification notification );

    /**
     * Deletes notifications associated to the specified demand id and demand type id
     * 
     * @param strDemandId
     *            the demand id
     * @param strDemandTypeId
     *            the demand type id
     */
    void deleteByDemand( String strDemandId, String strDemandTypeId );

    /**
     * Load the ids of the notification by filter
     * 
     * @param notificationFilter
     *            The notification filter
     * @return The list of notifications ids
     */
    List<Integer> loadIdsByFilter( NotificationFilter notificationFilter );
    
    /**
     * load distinct demand type ids
     * 
     * @return the id list 
     */
    List<String> loadDistinctDemandTypeIds( );

    /**
     * Loads list by  Ids
     * 
     * @param listIds
     * @return list of Notification
     */
	List<Notification> loadByIds(List<Integer> listIds);

	/**
	 * delete notification
	 * 
     * @param id
	 */
	void delete(int id);
}
