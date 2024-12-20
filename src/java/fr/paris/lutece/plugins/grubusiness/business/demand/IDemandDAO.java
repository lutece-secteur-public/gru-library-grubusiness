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

import fr.paris.lutece.plugins.grubusiness.business.notification.NotificationFilter;

import java.util.Collection;
import java.util.List;

/**
 * This interface represents a data access object for Demand object
 *
 */
public interface IDemandDAO
{
    /**
     * Finds the demands associated to the specified customer id
     * 
     * @param strCustomerId
     *            the customer id
     * @return the demands. An empty collection is returned if no demands has been found.
     */
    Collection<Demand> loadByCustomerId( String strCustomerId );

    /**
     * Finds the demands associated to the specified reference
     * 
     * @param strReference
     *            the reference
     * @return the demands. An empty collection is returned if no demands has been found.
     */
    Collection<Demand> loadByReference( String strReference );

    /**
     * Search demands by filter
     * 
     * @param filter
     * @return the demands list
     */
    Collection<Demand> loadByFilter( NotificationFilter filter );

    /**
     * Search demands by filter
     * 
     * @param filter
     * @return the demands list
     */
    List<Integer> loadIdsByFilter( NotificationFilter filter );

    /**
     * load demands corresponding to the id list
     * 
     * @param listIds
     * @return the demands
     */
    List<Demand> loadByIds( List<Integer> listIds );

    /**
     * Finds a demand with the specified id and type id
     * 
     * @param strDemandId
     *            the demand id
     * @param strDemandTypeId
     *            the demand type id
     * @return the demand if found, {@code null} otherwise
     */
    Demand load( int nId );

    /**
     * Insert a demand
     * 
     * @param demand
     *            the demand to insert
     * @return the inserted demand
     */
    Demand insert( Demand demand );

    /**
     * Stores a demand
     * 
     * @param demand
     *            the demand to store
     * @return the stored demand
     */
    Demand store( Demand demand );
    
    /**
     * Update demands status id
     * 
     * @param nStatusId
     *            the new status id
     * @param nTemporaryStatusId
     *            To find Demands that are linked to notifications that have the temporary status in parameter
     */
    void updateDemandsStatusId( int nStatusId, int nTemporaryStatusId );

    /**
     * Deletes a demand with the specified id and type id
     * 
     * @param strDemandId
     *            the demand id
     * @param strDemandTypeId
     *            the demand type id
     * @param strCustomerId 
     */
    void delete( String strDemandId, String strDemandTypeId, String strCustomerId );


    /**
     * Deletes a demand with the specified uid
     * 
     * @param nUid
     *            the uid
     */
    void deleteByUid( int nUid );
    
    /**
     * Load the ids of the demands
     * 
     * @return The list of demand ids
     */
    List<String> loadAllIds( );

    /**
     * Finds demands associated to the demand id
     * 
     * @param strDemandId
     * @return the demand coresponding to given demand id.
     */
    Demand loadByDemandId( String strDemandId );
    
    /**
     * Finds demands associated to the demand id and type id
     * 
     * @param strDemandId
     * @return the demand coresponding to given demand id.
     */
    Demand loadByDemandIdAndTypeIdAndCustomerId( String strDemandId, String strDemandTypeId, String strCustomerId);

    /**
     * Load demand ids ordered by date notification
     * 
     * @param strCustomerId
     * @param strNotificationType
     * @param strIdDemandType
     *            (Optional can be null)
     * @return The list of demand ids
     */
    List<Integer> loadIdsByCustomerIdAndIdDemandType( String strCustomerId, String strNotificationType, String strIdDemandType );

    /**
     * Load demand ids by status
     * 
     * @param strCustomerId
     * @param listStatus
     * @param strNotificationType
     * @param strIdDemandType
     *            (Optional can be null)
     * @return The list of demand ids
     */
    List<Integer> loadIdsByStatus( String strCustomerId, List<String> listStatus, String strNotificationType, String strIdDemandType );

}
