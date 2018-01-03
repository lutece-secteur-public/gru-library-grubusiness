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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.paris.lutece.plugins.grubusiness.business.customer.Customer;
import fr.paris.lutece.plugins.grubusiness.business.customer.ICustomerDAO;

/**
 * This class is a mock implementation of {@link ICustomerDAO}
 */
public class MockCustomerDAO implements ICustomerDAO
{
    private static final String FIELD_FIRSTNAME = "firstname";
    private static final String FIELD_LASTNAME = "lastname";

    private final Map<String, Customer> _mapMockCustomer = new HashMap<String, Customer>( );

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> selectByFilter( Map<String, String> mapFilter )
    {
        String strFirstName = mapFilter.get( FIELD_FIRSTNAME );
        String strLastName = mapFilter.get( FIELD_LASTNAME );

        return selectByName( strFirstName, strLastName );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> selectByName( String strFirstName, String strLastName )
    {
        List<Customer> listResult = new ArrayList<Customer>( );
        for ( Customer customer : _mapMockCustomer.values( ) )
        {
            if ( customer.getFirstname( ).equals( strFirstName ) && customer.getLastname( ).equals( strLastName ) )
            {
                listResult.add( customer );
            }
        }
        return listResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer load( String strCustomerId )
    {
        return _mapMockCustomer.get( strCustomerId );
    }

    /**
     * Stores a customer
     * 
     * @param customer
     *            the customer to store
     */
    public void store( Customer customer )
    {
        _mapMockCustomer.put( customer.getId( ), customer );
    }
}
