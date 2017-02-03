/*
 * Copyright (c) 2002-2016, Mairie de Paris
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import fr.paris.lutece.plugins.grubusiness.business.customer.Customer;
import fr.paris.lutece.plugins.grubusiness.business.demand.Demand;

import junit.framework.TestCase;

import org.junit.Test;

import java.io.IOException;

/**
 * Test for json parsing, no controls are done !
 */
public class NotifyGruGlobalNotificationTest extends TestCase
{
    @Test
    public void testUnserialize( ) throws JsonParseException, JsonMappingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper( );
        mapper.enable( DeserializationFeature.UNWRAP_ROOT_VALUE );
        mapper.enable( SerializationFeature.WRAP_ROOT_VALUE );
        mapper.enable( SerializationFeature.INDENT_OUTPUT );

        Notification notification = mapper.readValue( getClass( ).getResourceAsStream( "/notification.json" ), Notification.class );
        String jsonNotif = mapper.writeValueAsString( notification );

        // Uncomment for console checking
        // System.out.println( jsonNotif );
    }

    @Test
    public void testSerialize( ) throws JsonParseException, JsonMappingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper( );
        mapper.enable( DeserializationFeature.UNWRAP_ROOT_VALUE );
        mapper.enable( SerializationFeature.WRAP_ROOT_VALUE );
        mapper.enable( SerializationFeature.INDENT_OUTPUT );

        Notification notification = new Notification( );
        int nCount = 0;
        long lCount = 0L;

        notification.setDate( lCount++ );

        Demand demandNotif = new Demand( );
        demandNotif.setId( "strDemandId" );
        demandNotif.setTypeId( "strTypeId" );
        demandNotif.setReference( "strDemandReference" );
        demandNotif.setStatusId( nCount );
        demandNotif.setMaxSteps( nCount );
        demandNotif.setCurrentStep( nCount );

        Customer customerNotif = new Customer( );
        customerNotif.setId( "strCustomerId" );
        customerNotif.setConnectionId( "strAccountGuid" );
        customerNotif.setEmail( "strEmail" );
        demandNotif.setCustomer( customerNotif );

        BackofficeNotification backNotif = new BackofficeNotification( );
        backNotif.setMessage( "strMessage" );
        backNotif.setStatusText( "strStatusText" );
        notification.setBackofficeNotification( backNotif );

        EmailNotification emailNotif = new EmailNotification( );
        emailNotif.setBcc( "strBcc" );
        emailNotif.setCc( "strCc" );
        emailNotif.setMessage( "strMessage" );
        emailNotif.setRecipient( "strRecipient" );
        emailNotif.setSenderEmail( "strSenderEmail" );
        emailNotif.setSenderName( "strSenderName" );
        emailNotif.setSubject( "strSubject" );
        notification.setEmailNotification( emailNotif );

        SMSNotification smsNotif = new SMSNotification( );
        smsNotif.setMessage( "strMessage" );
        smsNotif.setPhoneNumber( "strPhoneNumber" );
        notification.setSmsNotification( smsNotif );

        BroadcastNotification broadcastNotif = new BroadcastNotification( );
        broadcastNotif.setBcc( EmailAddress.buildEmailAddresses( new String [ ] {
                "strBcc", "strBcc2"
        } ) );
        broadcastNotif.setCc( EmailAddress.buildEmailAddresses( new String [ ] {
                "strCc", "strCc2"
        } ) );
        broadcastNotif.setMessage( "strMessage" );
        broadcastNotif.setRecipient( EmailAddress.buildEmailAddresses( new String [ ] {
            "strRecipient"
        } ) );
        broadcastNotif.setSenderEmail( "strSenderEmail" );
        broadcastNotif.setSenderName( "strSenderName" );
        broadcastNotif.setSubject( "strSubject" );
        notification.addBroadcastEmail( broadcastNotif );

        broadcastNotif = new BroadcastNotification( );
        broadcastNotif.setBcc( null );
        broadcastNotif.setCc( null );
        broadcastNotif.setMessage( "strMessage" );
        broadcastNotif.setRecipient( EmailAddress.buildEmailAddresses( new String [ ] {
            "strRecipient"
        } ) );
        broadcastNotif.setSenderEmail( "strSenderEmail" );
        broadcastNotif.setSenderName( "strSenderName" );
        broadcastNotif.setSubject( "strSubject" );
        notification.addBroadcastEmail( broadcastNotif );

        MyDashboardNotification crmDashboardNotif = new MyDashboardNotification( );
        crmDashboardNotif.setStatusId( 1 );

        String jsonNotif = mapper.writeValueAsString( notification );

        // Uncomment for console checking
        // System.out.println( jsonNotif );
        Notification notificationFromString = mapper.readValue( jsonNotif, Notification.class );
    }
}
