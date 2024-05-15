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
package fr.paris.lutece.plugins.grubusiness.business.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * This class repressents a SMS object with management of an account
 */
@JsonRootName( value = "sms" )
@JsonPropertyOrder( {
        "message", "phone_number", "sender_name", "billing_account", "group"
} )
public class BillingAccountBasedSMSNotification extends SMSNotification
{
    String _strBillingAccount;
    String _strBillingGroup;

    /**
     * Get the billing account
     * 
     * @return _strBillingAccount the billing account
     */
    @JsonProperty( "billing_account" )
    public String getBillingAccount( )
    {
        return _strBillingAccount;
    }

    /**
     * Set the billing account
     * 
     * @param strBillingAccount
     *            the billing account
     */
    @JsonProperty( "billing_account" )
    public void setBillingAccount( String strBillingAccount )
    {
        _strBillingAccount = strBillingAccount;
    }

    /**
     * Get the group of the billing account
     * 
     * @return the group of the billing account
     */
    @JsonProperty( "group" )
    public String getBillingGroup( )
    {
        return _strBillingGroup;
    }

    /**
     * Set the group of the billing account
     * 
     * @param strBillingGroup
     *            the group of the billing account
     */
    @JsonProperty( "group" )
    public void setBillingGroup( String strBillingGroup )
    {
        _strBillingGroup = strBillingGroup;
    }

}
