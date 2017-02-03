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

import java.util.ArrayList;
import java.util.Collection;

import fr.paris.lutece.plugins.grubusiness.business.customer.Customer;

/**
 * This class is a DAO mock for Demand object
 *
 */
public class MockDemandDAO implements IDemandDAO
{
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Demand> loadByCustomerId( String strCustomerId )
    {
        return new ArrayList<Demand>( );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Demand> loadByReference( String strReference )
    {
        return new ArrayList<Demand>( );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Demand load( String strDemandId, String strDemandTypeId )
    {
        Demand demand = new Demand( );
        Customer customer = new Customer( );

        demand.setId( strDemandId );
        demand.setTypeId( strDemandTypeId );
        demand.setCustomer( customer );

        return demand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Demand insert( Demand demand )
    {
        return demand;
    }

    @Override
    public Demand store( Demand demand )
    {
        return demand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete( String strDemandId, String strDemandTypeId )
    {
        // Nothing to do
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Demand> loadAllDemands( )
    {
        return null;
    }
}
