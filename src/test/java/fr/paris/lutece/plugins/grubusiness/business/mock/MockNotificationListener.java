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
import java.util.List;

import fr.paris.lutece.plugins.grubusiness.business.notification.INotificationListener;
import fr.paris.lutece.plugins.grubusiness.business.notification.Notification;

/**
 *
 */
public class MockNotificationListener implements INotificationListener
{
    List<String> _listLogAction = new ArrayList<String>( );

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreateNotification( Notification notification )
    {
        _listLogAction.add( MockActionListenerEnum.CREATE.name( ) + "|" + notification.getId( ) );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpdateNotification( Notification notification )
    {
        _listLogAction.add( MockActionListenerEnum.UPDATE.name( ) + "|" + notification.getId( ) );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDeleteDemand( String strDemandId, String strDemandTypeId )
    {
        _listLogAction.add( MockActionListenerEnum.DELETE.name( ) + "|" + strDemandTypeId + "|" + strDemandId );
    }

    public synchronized boolean listenAndConsume( MockActionListenerEnum actionListener, Notification notification )
    {
        String strCompareLog = actionListener.name( ) + "|";
        if ( actionListener == MockActionListenerEnum.DELETE )
        {
            if ( notification.getDemand( ) != null )
            {
                strCompareLog = strCompareLog + notification.getDemand( ).getTypeId( ) + "|" + notification.getDemand( ).getId( );
            }
        }
        else
        {
            strCompareLog = strCompareLog + notification.getId( );
        }

        int nIndexConsume = -1;
        for ( int nIndex = 0; nIndex < _listLogAction.size( ); nIndex++ )
        {

            if ( _listLogAction.get( nIndex ).equals( strCompareLog ) )
            {
                nIndexConsume = nIndex;
                break;
            }
        }
        if ( nIndexConsume > -1 )
        {
            _listLogAction.remove( nIndexConsume );
            return true;
        }
        else
        {
            return false;
        }
    }
}
