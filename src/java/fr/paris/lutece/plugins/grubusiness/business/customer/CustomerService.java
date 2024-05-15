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

import java.util.List;
import java.util.Map;

/**
 * Service used to find customer
 */
public class CustomerService
{
    // DAO
    private final ICustomerDAO _daoCustomer;

    /**
     * Constructor
     * 
     * @param daoCustomer
     *            the customer DAO used by this service
     */
    public CustomerService( ICustomerDAO daoCustomer )
    {
        _daoCustomer = daoCustomer;
    }

    /**
     * Find all the customers corresponding to the specified filter
     * 
     * @param mapFilter
     *            the filter
     * @return the list of customers
     */
    public List<Customer> findbyFilter( Map<String, String> mapFilter )
    {
        return _daoCustomer.selectByFilter( mapFilter );
    }

    /**
     * Find all the customers with the specified first name and last name
     * 
     * @param strFirstName
     *            the customer first name
     * @param strLastName
     *            the customer last name
     * @return the list of customers
     */
    public List<Customer> findbyName( String strFirstName, String strLastName )
    {
        return _daoCustomer.selectByName( strFirstName, strLastName );
    }

    /**
     * Find a customer by its id
     * 
     * @param strCustomerId
     *            the customer id
     * @return the customer with the specified id
     */
    public Customer findById( String strCustomerId )
    {
        return _daoCustomer.load( strCustomerId );
    }

}
