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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fr.paris.lutece.plugins.grubusiness.business.demand.Demand;
import fr.paris.lutece.plugins.grubusiness.business.demand.IDemandDAO;
import fr.paris.lutece.plugins.grubusiness.business.notification.NotificationFilter;

import java.util.List;

/**
 * This class is a mock implementation of {@link IDemandDAO}
 */
public class MockDemandDAO implements IDemandDAO
{
    private final Map<String, Demand> _mapMockDemand = new HashMap<String, Demand>( );

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Demand> loadByCustomerId( String strCustomerId )
    {
        Collection<Demand> listResult = new ArrayList<Demand>( );
        for ( Demand demand : _mapMockDemand.values( ) )
        {
            if ( demand.getCustomer( ) != null && demand.getCustomer( ).getId( ).equals( strCustomerId ) )
            {
                listResult.add( demand );
            }
        }
        return listResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Demand> loadByReference( String strReference )
    {
        Collection<Demand> listResult = new ArrayList<Demand>( );
        for ( Demand demand : _mapMockDemand.values( ) )
        {
            if ( demand.getReference( ).equals( strReference ) )
            {
                listResult.add( demand );
            }
        }
        return listResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Demand load( String strDemandId, String strDemandTypeId )
    {
        return _mapMockDemand.get( strDemandTypeId + "|" + strDemandId );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Demand insert( Demand demand )
    {
        _mapMockDemand.put( demand.getTypeId( ) + "|" + demand.getId( ), demand );
        return demand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Demand store( Demand demand )
    {
        _mapMockDemand.put( demand.getTypeId( ) + "|" + demand.getId( ), demand );
        return demand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete( String strDemandId, String strDemandTypeId )
    {
        _mapMockDemand.remove( strDemandTypeId + "|" + strDemandId );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> loadAllIds( )
    {
        return new ArrayList<>( _mapMockDemand.keySet( ) );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Demand loadById( String strId )
    {
        return null;
    }

    @Override
    public Collection<Demand> loadByFilter(NotificationFilter filter) 
    {
        return _mapMockDemand.values( );
    }

	@Override
	public List<Integer> loadIdsByFilter(NotificationFilter filter) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Demand> loadByIds(List<Integer> listIds) 
	{
		List<Demand> listDemands = new ArrayList<>();
		listDemands.addAll( _mapMockDemand.values( ) );
		
		return listDemands;
	}

    @Override
    public List<Integer> loadIdsByCustomerIdAndIdDemandType( String strCustomerId, String strNotificationType, String strIdDemandType )
    {
        return null;
    }

    @Override
    public List<Integer> loadIdsByStatus( String strCustomerId, List<String> listStatus, String strNotificationType, String strIdDemandType )
    {
        return null;
    }

}