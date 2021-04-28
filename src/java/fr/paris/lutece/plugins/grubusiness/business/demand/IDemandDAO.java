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
     * Finds all the demands in the table
     * 
     * @return all the demands. An empty collection is returned if no demands has been found.
     */
    Collection<Demand> loadAllDemands( );

    /**
     * Finds a demand with the specified id and type id
     * 
     * @param strDemandId
     *            the demand id
     * @param strDemandTypeId
     *            the demand type id
     * @return the demand if found, {@code null} otherwise
     */
    Demand load( String strDemandId, String strDemandTypeId );

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
     * Deletes a demand with the specified id and type id
     * 
     * @param strDemandId
     *            the demand id
     * @param strDemandTypeId
     *            the demand type id
     */
    void delete( String strDemandId, String strDemandTypeId );

    /**
     * Load the ids of the demands
     * 
     * @return The list of demand ids
     */
    List<String> loadAllIds( );

    /**
     * Finds demands associated to the id
     * 
     * @param strId
     * @return the demand coresponding to given id.
     */
    Demand loadById( String strId );
}
