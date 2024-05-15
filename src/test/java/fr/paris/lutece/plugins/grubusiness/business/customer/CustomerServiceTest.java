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
package fr.paris.lutece.plugins.grubusiness.business.customer;

import junit.framework.TestCase;

import org.junit.Test;

import fr.paris.lutece.plugins.grubusiness.business.customer.Customer;
import fr.paris.lutece.plugins.grubusiness.business.mock.MockCustomerDAO;

/**
 *
 */
public class CustomerServiceTest extends TestCase
{
    private MockCustomerDAO _customerDAO;

    /**
     * init des services et objet
     */
    public CustomerServiceTest( )
    {
        super( );
        _customerDAO = new MockCustomerDAO( );
    }

    @Test
    public void testCustomerService( )
    {
        CustomerService serviceTest = new CustomerService( _customerDAO );
        // Ici on a besoin que des infos pour les DAOs
        // Customer.id
        // Customer.firstName
        // Customer.lastName

        Customer customer1 = new Customer( );
        customer1.setId( "cust_1" );
        customer1.setFirstname( "first_1" );
        customer1.setLastname( "last_1" );

        Customer customer2 = new Customer( );
        customer2.setId( "cust_2" );
        customer2.setFirstname( "first_2" );
        customer2.setLastname( "last_2" );

        Customer customer3 = new Customer( );
        customer3.setId( "cust_3" );
        customer3.setFirstname( "first_1" );
        customer3.setLastname( "last_1" );

        // creation customer1
        _customerDAO.store( customer1 );
        assertNotNull( serviceTest.findById( customer1.getId( ) ) );
        assertNull( serviceTest.findById( customer2.getId( ) ) );
        assertEquals( serviceTest.findbyName( customer1.getFirstname( ), customer1.getLastname( ) ).size( ), 1 );
        assertEquals( serviceTest.findbyName( customer2.getFirstname( ), customer2.getLastname( ) ).size( ), 0 );

        // creation customer2
        _customerDAO.store( customer2 );
        assertNotNull( serviceTest.findById( customer1.getId( ) ) );
        assertNotNull( serviceTest.findById( customer2.getId( ) ) );
        assertEquals( serviceTest.findbyName( customer1.getFirstname( ), customer1.getLastname( ) ).size( ), 1 );
        assertEquals( serviceTest.findbyName( customer2.getFirstname( ), customer2.getLastname( ) ).size( ), 1 );

        // creation customer3
        _customerDAO.store( customer3 );
        assertNotNull( serviceTest.findById( customer1.getId( ) ) );
        assertNotNull( serviceTest.findById( customer2.getId( ) ) );
        assertEquals( serviceTest.findbyName( customer1.getFirstname( ), customer1.getLastname( ) ).size( ), 2 );
        assertEquals( serviceTest.findbyName( customer2.getFirstname( ), customer2.getLastname( ) ).size( ), 1 );
    }

}
