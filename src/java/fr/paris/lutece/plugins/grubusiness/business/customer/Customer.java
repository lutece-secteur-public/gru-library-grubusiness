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

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

// TODO: Auto-generated Javadoc
/**
 * This is the business class for the object Customer.
 */
@JsonRootName( value = "customer" )
public class Customer implements Serializable
{
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    // Variables declarations
    private String _strId;

    /** The _n id title. */
    private int _nIdTitle;

    /** The _str firstname. */
    @NotEmpty( message = "#i18n{gru.validation.customer.Firstname.notEmpty}" )
    @Size( max = 50, message = "#i18n{gru.validation.customer.Firstname.size}" )
    private String _strFirstname;

    /** The _str lastname. */
    @NotEmpty( message = "#i18n{gru.validation.customer.Lastname.notEmpty}" )
    @Size( max = 50, message = "#i18n{gru.validation.customer.Lastname.size}" )
    private String _strLastname;

    /** The _str familyname. */
    @Size( max = 50, message = "#i18n{gru.validation.customer.Familyname.size}" )
    private String _strFamilyname;

    /** The _b has account. */
    private boolean _bHasAccount;

    /** The _str account login. */
    @Size( max = 50, message = "#i18n{gru.validation.customer.AccountLogin.size}" )
    private String _strAccountLogin;

    /** The connection Id. */
    @Size( max = 56, message = "#i18n{gru.validation.customer.AccountGuid.size}" )
    private String _strConnectionId;

    /** The customer Id. */
    @Size( max = 50, message = "#i18n{gru.validation.customer.AccountCuid.size}" )
    private String _strCustomerId;

    /** The _str email. */
    @Email( message = "#i18n{portal.validation.message.email}" )
    @Size( max = 255, message = "#i18n{gru.validation.customer.Email.size}" )
    private String _strEmail;

    /** The _b is email verified. */
    private boolean _bIsEmailVerified;

    /** The _str fixe phone. */
    @Size( max = 50, message = "#i18n{gru.validation.customer.FixedPhoneNumber.size}" )
    private String _strFixedPhoneNumber;

    /** The _str mobile phone. */
    @Size( max = 50, message = "#i18n{gru.validation.customer.MobilePhone.size}" )
    private String _strMobilePhone;

    /** The _b is mobile phone verified. */
    private boolean _bIsMobilePhoneVerified;

    /** The _str extras attributes. */
    @NotEmpty( message = "#i18n{gru.validation.customer.ExtrasAttributes.notEmpty}" )
    private String _strExtrasAttributes;

    /** The _str birthdate. */
    private String _strBirthDate;

    private final Map<String, String> _mapAttributes;

    /**
     * Constructor
     */
    public Customer( )
    {
        _mapAttributes = new HashMap<>( );
    }

    /**
     * Returns the Id.
     *
     * @return The Id
     */
    @JsonProperty( "id" )
    public String getId( )
    {
        return _strId;
    }

    /**
     * Sets the Id.
     *
     * @param strId
     *            The Id
     */
    @JsonProperty( "id" )
    public void setId( String strId )
    {
        _strId = strId;
    }

    /**
     * Returns the IdTitle.
     *
     * @return The IdTitle
     */
    @JsonIgnore
    public int getIdTitle( )
    {
        return _nIdTitle;
    }

    /**
     * Sets the IdTitle.
     *
     * @param nIdTitle
     *            The IdTitle
     */
    public void setIdTitle( int nIdTitle )
    {
        _nIdTitle = nIdTitle;
    }

    /**
     * Returns the Firstname.
     *
     * @return The Firstname
     */
    public String getFirstname( )
    {
        return _strFirstname;
    }

    /**
     * Sets the Firstname.
     *
     * @param strFirstname
     *            The Firstname
     */
    public void setFirstname( String strFirstname )
    {
        _strFirstname = strFirstname;
    }

    /**
     * Returns the Lastname.
     *
     * @return The Lastname
     */
    public String getLastname( )
    {
        return _strLastname;
    }

    /**
     * Sets the Lastname.
     *
     * @param strLastname
     *            The Lastname
     */
    public void setLastname( String strLastname )
    {
        _strLastname = strLastname;
    }

    /**
     * Returns the Familyname.
     *
     * @return The Familyname
     */
    public String getFamilyname( )
    {
        return _strFamilyname;
    }

    /**
     * Sets the Familyname.
     *
     * @param strFamilyname
     *            The Familyname
     */
    public void setFamilyname( String strFamilyname )
    {
        _strFamilyname = strFamilyname;
    }

    /**
     * Returns the HasAccount.
     *
     * @return The HasAccount
     */
    @JsonIgnore
    public boolean getHasAccount( )
    {
        return _bHasAccount;
    }

    /**
     * Sets the HasAccount.
     *
     * @param bHasAccount
     *            The HasAccount
     */
    public void setHasAccount( boolean bHasAccount )
    {
        _bHasAccount = bHasAccount;
    }

    /**
     * Returns the AccountLogin.
     *
     * @return The AccountLogin
     */
    @JsonIgnore
    public String getAccountLogin( )
    {
        return _strAccountLogin;
    }

    /**
     * Sets the AccountLogin.
     *
     * @param strAccountLogin
     *            The AccountLogin
     */
    public void setAccountLogin( String strAccountLogin )
    {
        _strAccountLogin = strAccountLogin;
    }

    /**
     * Returns the connection Id.
     *
     * @return The connection Id
     */
    @JsonProperty( "connection_id" )
    public String getConnectionId( )
    {
        return _strConnectionId;
    }

    /**
     * Sets the connection id.
     *
     * @param strConnectionId
     *            The Connection Id
     */
    @JsonProperty( "connection_id" )
    public void setConnectionId( String strConnectionId )
    {
        _strConnectionId = strConnectionId;
    }

    /**
     * Returns the Customer Id.
     *
     * @return The Customer Id
     */
    @JsonProperty( "customer_id" )
    public String getCustomerId( )
    {
        return _strCustomerId;
    }

    /**
     * Sets the Customer id.
     *
     * @param strCustomerId
     *            The Customer Id
     */
    @JsonProperty( "customer_id" )
    public void setCustomerId( String strCustomerId )
    {
        _strCustomerId = strCustomerId;
    }

    /**
     * Returns the Email.
     *
     * @return The Email
     */
    @JsonProperty( "email" )
    public String getEmail( )
    {
        return _strEmail;
    }

    /**
     * Sets the Email.
     *
     * @param strEmail
     *            The Email
     */
    @JsonProperty( "email" )
    public void setEmail( String strEmail )
    {
        _strEmail = strEmail;
    }

    /**
     * Returns the IsEmailVerified.
     *
     * @return The IsEmailVerified
     */
    @JsonIgnore
    public boolean getIsEmailVerified( )
    {
        return _bIsEmailVerified;
    }

    /**
     * Sets the IsEmailVerified.
     *
     * @param bIsEmailVerified
     *            The IsEmailVerified
     */
    public void setIsEmailVerified( boolean bIsEmailVerified )
    {
        _bIsEmailVerified = bIsEmailVerified;
    }

    /**
     * Returns the MobilePhone.
     *
     * @return The MobilePhone
     */
    public String getMobilePhone( )
    {
        return _strMobilePhone;
    }

    /**
     * Sets the MobilePhone.
     *
     * @param strMobilePhone
     *            The MobilePhone
     */
    public void setMobilePhone( String strMobilePhone )
    {
        _strMobilePhone = strMobilePhone;
    }

    /**
     * Gets the fixe phone.
     *
     * @return the fixe phone
     */
    public String getFixedPhoneNumber( )
    {
        return _strFixedPhoneNumber;
    }

    /**
     * Sets the fixe phone.
     *
     * @param strFixedPhoneNumber
     *            the new fixe phone
     */
    public void setFixedPhoneNumber( String strFixedPhoneNumber )
    {
        _strFixedPhoneNumber = strFixedPhoneNumber;
    }

    /**
     * Returns the IsMobilePhoneVerified.
     *
     * @return The IsMobilePhoneVerified
     */
    @JsonIgnore
    public boolean getIsMobilePhoneVerified( )
    {
        return _bIsMobilePhoneVerified;
    }

    /**
     * Sets the IsMobilePhoneVerified.
     *
     * @param bIsMobilePhoneVerified
     *            The IsMobilePhoneVerified
     */
    public void setIsMobilePhoneVerified( boolean bIsMobilePhoneVerified )
    {
        _bIsMobilePhoneVerified = bIsMobilePhoneVerified;
    }

    /**
     * Returns the ExtrasAttributes.
     *
     * @return The ExtrasAttributes
     */
    @JsonIgnore
    public String getExtrasAttributes( )
    {
        return _strExtrasAttributes;
    }

    /**
     * Sets the ExtrasAttributes.
     *
     * @param strExtrasAttributes
     *            The ExtrasAttributes
     */
    public void setExtrasAttributes( String strExtrasAttributes )
    {
        _strExtrasAttributes = strExtrasAttributes;
    }

    /**
     * Returns the birthDate.
     *
     * @return The birthDate
     */
    public String getBirthDate( )
    {
        return _strBirthDate;
    }

    /**
     * Sets the birthDate.
     *
     * @param strBirthDate
     *            The birthDate
     */
    public void setBirthDate( String strBirthDate )
    {
        _strBirthDate = strBirthDate;
    }

    /**
     * Adds an attribute
     * 
     * @param strName
     *            the attribute name
     * @param strValue
     *            the attribute value
     */
    public void addAttributes( String strName, String strValue )
    {
        _mapAttributes.put( strName, strValue );
    }

    /**
     * Gives the attribute with the specified name
     * 
     * @param strName
     *            the attribute name
     * @return the attribute or {@code null} if the attribute does not exist
     */
    public String getAttribute( String strName )
    {
        return _mapAttributes.get( strName );
    }

    /**
     * Gives all the attribute names
     * 
     * @return the attributes names
     */
    public Collection<String> getAttributeNames( )
    {
        return _mapAttributes.keySet( );
    }
}
