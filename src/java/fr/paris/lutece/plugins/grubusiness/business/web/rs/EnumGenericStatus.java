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
package fr.paris.lutece.plugins.grubusiness.business.web.rs;

public enum EnumGenericStatus
{
    CLOSED( 15, "notificationstore.enum.generic_status.label.closed", true ),
    PAID( 14, "notificationstore.enum.generic_status.label.paid", true ),
    TOCOMPLETE( 13, "notificationstore.enum.generic_status.label.tocomplete", false ),
    TOPAY( 12, "notificationstore.enum.generic_status.label.topay", false ),
    ONGOING( 11, "notificationstore.enum.generic_status.label.ongoing", false ),
    CANCELED( 10, "notificationstore.enum.generic_status.label.canceled", true ),
    UNDEFINED( -1, "notificationstore.enum.generic_status.label.undefined", false );

    private Integer _nStatusId;
    private String _strLabel;
    private boolean _bFinalStatus;

    /**
     * Private constructor
     * 
     * @param nStatusId
     * @param strLabelle
     */
    private EnumGenericStatus( Integer nStatusId, String strLabel, boolean isFinalStatus )
    {
        _nStatusId = nStatusId;
        _strLabel = strLabel;
        _bFinalStatus = isFinalStatus;
    }

    /**
     * @return the _nStatusId
     */
    public Integer getStatusId( )
    {
        return _nStatusId;
    }

    /**
     * @return the _strLabel
     */
    public String getLabel( )
    {
        return _strLabel;
    }

    /**
     * 
     * @return true if is final
     */
    public boolean isFinalStatus( )
    {
        return _bFinalStatus;
    }

    /**
     * Check if id status exist
     * 
     * @param nIdStatus
     * @return true if exist
     */
    public static boolean exists( Integer nIdStatus )
    {
        if ( nIdStatus != null )
        {
            for ( EnumGenericStatus status : EnumGenericStatus.values( ) )
            {
                if ( status.getStatusId( ).equals( nIdStatus ) )
                {
                    return true;
                }
            }
        }

        // default
        return false;
    }

    /**
     * Return EnumGenericStatus by id status
     * 
     * @param nIdStatus
     * @return enumGenericStatus
     */
    public static EnumGenericStatus getByStatusId( Integer nIdStatus )
    {
        for ( EnumGenericStatus status : EnumGenericStatus.values( ) )
        {
            if ( status.getStatusId( ).equals( nIdStatus ) )
            {
                return status;
            }
        }
        return null;
    }

}
