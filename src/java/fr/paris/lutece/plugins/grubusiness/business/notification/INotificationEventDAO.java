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
public interface INotificationEventDAO
{

    /**
     * Finds notifications associated to the id
     * 
     * @param nId
     * @return the notification corresponding to given id.
     */
	Optional<NotificationEvent>  loadById( int nId );

    /**
     * Finds notification events associated to the specified demand id and demand type id. 
     * 
     * @param strDemandId
     *            the demand id
     * @param strDemandTypeId
     *            the demand type id
     * @return the notification event list
     */
    List<NotificationEvent> loadByDemand( String strDemandId, String strDemandTypeId );

    /**
     * Finds notification events associated to the specified notification 
     * 
     * @param strDemandId
     * @param strDemandTypeId
     * @param lNotificationDate
     * @return the notification event list
     */
    public List<NotificationEvent> loadByNotification( String strDemandId, String strDemandTypeId, long lNotificationDate);

    /**
     * Finds and populate notification according to the filter
     * 
     * @param notificationFilter
     *            the filter
     * @return the notification events. An empty list is returned if no notificationevent has been found.
     */
    List<NotificationEvent> loadByFilter( NotificationFilter notificationFilter );

    /**
     * Inserts a notification event
     * 
     * @param notificationEvent
     *            the notification  event to insert
     * @return the inserted notification event
     */
    NotificationEvent insert( NotificationEvent notificationEvent );

    /**
     * delete a notification event
     * 
     * @param nId
     */
    void delete( int nId );

    /**
     * Load the ids of the notification events by filter
     * 
     * @param notificationFilter
     *            The notification filter
     * @return The list of notification event ids
     */
    List<Integer> loadIdsByFilter( NotificationFilter notificationFilter );

	/**
	 * load the events for an id list
	 * 
	 * @return The list of notification events
	 */
	List<NotificationEvent> loadByIds(List<Integer> listIds);

	/**
	 * purge the events after N days
	 * 
	 * @param nbDays
	 * @return
	 */
	String deleteBeforeDate( long lDate );
}
