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

import java.util.List;
import java.util.Optional;

/**
 * IDemandTypeDAO Interface
 */
public interface IDemandTypeDAO
{
    /**
     * Insert a new record in the table.
     * 
     * @param demandType
     *            instance of the DemandType object to insert
     */
    void insert( DemandType demandType );

    /**
     * Update the record in the table
     * 
     * @param demandType
     *            the reference of the DemandType
     */
    void store( DemandType demandType );

    /**
     * Delete a record from the table
     * 
     * @param nKey
     *            The identifier of the DemandType to delete
     */
    void delete( int nKey );

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Load the data from the table
     * 
     * @param nKey
     *            The identifier of the demandType
     * @return The instance of the demandType
     */
    Optional<DemandType> load( int nKey );

    /**
     * Load the data from the table by type_id
     * 
     * @param sKey
     *            The type_id of the demandType
     * @return The instance of the demandType
     */
    Optional<DemandType> selectByTypeId( String sKey );

    /**
     * Load the data of all the demandType objects and returns them as a list
     * 
     * @return The list which contains the data of all the demandType objects
     */
    List<DemandType> selectDemandTypesList( );

    /**
     * Load the id of all the demandType objects and returns them as a list
     * 
     * @return The list which contains the id of all the demandType objects
     */
    List<Integer> selectIdDemandTypesList( );

    /**
     * Load the data of all the avant objects and returns them as a list
     * 
     * @param listIds
     *            liste of ids
     * @return The list which contains the data of all the avant objects
     */
    List<DemandType> selectDemandTypesListByIds( List<Integer> listIds );
}
